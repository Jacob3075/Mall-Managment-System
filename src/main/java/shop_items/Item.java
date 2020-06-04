package shop_items;

public interface Item {

	String getName();

	int getPrice();

	int getCount();

	Item addItem();

	Item addItems(int count);

	Item sellItem();

	Item sellItems(int count);
}
