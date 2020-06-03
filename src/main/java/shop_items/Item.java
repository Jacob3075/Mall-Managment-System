package shop_items;

public interface Item {

	String getName();

	int getPrice();

	int getCount();

	Item addItem();

	Item sellItem();
}
