package shop_items;

public class ItemImpl implements Item {
	private String name;
	private int    price;
	private int    count;

	public ItemImpl() {
	}

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
		this.count++;
		return this;
	}

	@Override
	public Item sellItem() {
		this.count--;
		return this;
	}

	public Item setName(String name) {
		this.name = name;
		return this;
	}

	public Item setPrice(int price) {
		this.price = price;
		return this;
	}

	public Item setCount(int count) {
		this.count = count;
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
}
