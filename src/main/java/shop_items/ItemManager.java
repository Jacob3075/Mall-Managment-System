package shop_items;

import utils.ItemsStream;

import java.security.InvalidParameterException;
import java.util.List;
import java.util.function.IntConsumer;
import java.util.function.ToIntFunction;
import java.util.stream.Collectors;

public class ItemManager {
	private List<Item> items;

	public ItemManager(List<Item> items) {
		this.items = items;
	}

	public List<Item> getItems() {
		return items;
	}

	public ItemManager setItems(List<Item> items) {
		this.items = items;
		return this;
	}

	public ItemManager removeItem(String itemName) {
		this.stream()
		    .findItem(itemName)
		    .ifPresent(item -> this.items.remove(item));
		return this;
	}

	public ItemsStream stream() {
		return new ItemsStream(this.items.stream());
	}

	public ItemManager sellItem(String itemName, IntConsumer intConsumer) {
		return this.sellItems(itemName, 1, intConsumer);
	}

	public ItemManager sellItems(String itemName, int count, IntConsumer intConsumer) {
		this.stream()
		    .findItem(itemName)
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
		this.stream()
		    .findItem(itemName)
		    .ifPresentOrElse(
				    item -> item.addItems(count),
				    () -> this.addItem(
						    new ItemImpl(
								    itemName,
								    0,
								    1
						    )
				    )
		    );
		return this;
	}

	public void addItem(Item item) {
		if (this.stream().findItem(item.getName()).isEmpty()) this.items.add(item);
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
