package shop_items;

import utils.ItemsStream;

import java.security.InvalidParameterException;
import java.util.List;
import java.util.Optional;
import java.util.function.IntConsumer;
import java.util.function.ToIntFunction;
import java.util.stream.Collectors;

public class ItemManager {
	private final List<Item> items;

	public ItemManager(List<Item> items) {
		this.items = items;
	}

	public List<Item> getItems() {
		return items;
	}

	public ItemManager removeItem(String itemName) {
		this.findItem(itemName)
		    .ifPresent(this.items::remove);
		return this;
	}

	public Optional<Item> findItem(String itemName) {
		return this.stream().filter(item -> item.getName().equals(itemName)).findFirst();
	}

	public ItemsStream stream() {
		return new ItemsStream(this.items.stream());
	}

	public ItemManager sellItem(String itemName, IntConsumer intConsumer) {
		return this.sellItems(itemName, 1, intConsumer);
	}

	public ItemManager sellItems(String itemName, int count, IntConsumer intConsumer) {
		this.findItem(itemName)
		    .ifPresentOrElse(
				    item -> {
					    intConsumer.accept(item.getPrice() * count);
					    item.sellItems(count);
				    },
				    () -> {
					    throw new InvalidParameterException("Item not found");
				    }
		    );
		return this;

	}

	public ItemManager increaseItemCount(String itemName) {
		return this.increaseItemCount(itemName, 1);
	}

	public ItemManager increaseItemCount(String itemName, int count) {
		this.findItem(itemName)
		    .ifPresentOrElse(
				    item -> item.addItems(count),
				    () -> {
					    throw new InvalidParameterException(itemName + " not found");
				    }
		    );
		return this;
	}

	public ItemManager addItem(Item item) {
		if (this.findItem(item.getName()).isEmpty()) this.items.add(item);
		return this;
	}

	@Override
	public String toString() {
		return "ItemManager{" +
				       "items=" + items +
				       '}';
	}

	public List<Item> getItemsSortedBy(ToIntFunction<Item> comparingBy) {
		return this.stream()
		           .sortItemsBy(comparingBy)
		           .collect(Collectors.toList());
	}
}
