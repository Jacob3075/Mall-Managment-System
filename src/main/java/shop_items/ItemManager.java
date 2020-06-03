package shop_items;

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

	public ItemManager addItem(Item item) {
		this.items.add(item);
		return this;
	}

	public ItemManager removeItem(Item item) {
		this.items.remove(item);
		return this;
	}

	@Override
	public String toString() {
		return "ItemManager{" +
				       "items=" + items +
				       '}';
	}
}
