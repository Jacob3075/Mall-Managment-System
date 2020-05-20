package floor;

import shops.Shop;

import java.util.List;

public class NormalFloor implements Floor{
	private final int totalSpace = 100;
	private List<Shop> shops;
	private int revenue;

	public NormalFloor() {

	}

	public NormalFloor(List<Shop> shops) {
		this.shops = shops;
	}

	@Override
	public List<Shop> getShops() {
		return shops;
	}


	@Override
	public NormalFloor addShop(Shop shop) {
		this.shops.add(shop);
		return this;
	}

	@Override
	public int getFreeSpace() {
		int usedSpace = shops
				.stream()
				.map(Shop::getShopFloorArea)
				.mapToInt(floorArea -> floorArea)
				.sum();
		return totalSpace - usedSpace;
	}

	@Override
	public int getTotalSpace() {
		return totalSpace;
	}

	@Override
	public int getRevenue() {
		return shops
				.stream()
				.map(Shop::getRevenue)
				.mapToInt(shopRevenue -> shopRevenue)
				.sum();
	}

	@Override
	public String toString() {
		return "\n\tNormalFloor{" +
				"totalSpace=" + totalSpace +
				", revenue=" + revenue +
				", shops=" + shops +
				'}';
	}
}
