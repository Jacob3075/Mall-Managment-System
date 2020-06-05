package shop_items;

public class ItemImpl implements Item {
	private final String name;
	private       int    price;
	private       int    count;

	public ItemImpl(String name, int price, int count) {
		this.name = name;
		this.price = price;
		this.count = count;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public int getPrice() {
		return price;
	}

	@Override
	public int getCount() {
		return count;
	}

	@Override
	public Item addItem() {
		return this.addItems(1);
	}

	@Override
	public Item addItems(int count) {
		this.count += count;
		return this;
	}

	@Override
	public Item sellItem() {
		return this.sellItems(1);
	}

	@Override
	public Item sellItems(int count) {
		if (this.count == 0) throw new UnsupportedOperationException("No more items to sell");
		this.count -= count;
		return this;
	}

	@Override
	public String toString() {
		return "ItemImpl{" +
				       "name='" + name + '\'' +
				       ", price=" + price +
				       ", count=" + count +
				       '}';
	}

	@Override
	public ItemImpl setPrice(int price) {
		this.price = price;
		return this;
	}
}
