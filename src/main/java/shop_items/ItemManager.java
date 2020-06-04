package shop_items;

import utils.ItemsStream;

import java.security.InvalidParameterException;
import java.util.List;

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

	public ItemManager removeItem(Item item) {
		this.items.remove(item);
		return this;
	}

	public void sellItem(String itemName) {
		this.stream()
		    .findItem(itemName)
		    .ifPresentOrElse(
				    Item::sellItem,
				    () -> {
					    throw new InvalidParameterException("Item not found");
				    }
		    );
	}

	private ItemsStream stream() {
		return new ItemsStream(this.items.stream());
	}

	public void sellItems(String itemName, int count) {
		this.stream()
		    .findItem(itemName)
		    .ifPresentOrElse(
				    item -> item.sellItems(count),
				    () -> {
					    throw new InvalidParameterException("Item not found");
				    }
		    );

	}

	public ItemManager increaseItemCount(String itemName) {
		this.stream()
		    .findItem(itemName)
		    .ifPresentOrElse(
				    Item::addItem,
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

	private void addItem(Item item) {
		this.items.add(item);
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

	@Override
	public String toString() {
		return "ItemManager{" +
				       "items=" + items +
				       '}';
	}

}
