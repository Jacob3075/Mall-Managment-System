import Shops.Shop;

import java.util.List;

public class Floor {
	private List<Shop> shops;

	public Floor(List<Shop> shops) {
		this.shops = shops;
	}

	public List<Shop> getShops() {
		return shops;
	}

	public Floor setShops(List<Shop> shops) {
		this.shops = shops;
		return this;
	}

	public Floor addShop(Shop shop) {
		this.shops.add(shop);
		return this;
	}
}
