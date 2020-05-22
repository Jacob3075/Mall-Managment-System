package floor;

import shops.Shop;

import java.security.InvalidParameterException;
import java.util.List;

public class NormalFloor implements Floor {
	private final int totalSpace = 100;
	private final List<Shop> shops;
	private int revenue;

	public NormalFloor(List<Shop> shops) {
		if (Shop.stream(shops).totalUsedArea() > 100)
			throw new InvalidParameterException("Total area by shops exceeds floor space");

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
	public int getTotalUsedSpace() {
		return shops.stream()
				.map(Shop::getShopFloorArea)
				.mapToInt(floorArea -> floorArea)
				.sum();
	}

	@Override
	public int getFreeSpace() {
		return totalSpace - this.getTotalUsedSpace();
	}

	@Override
	public int getTotalSpace() {
		return totalSpace;
	}

	@Override
	public int getRevenue() {
		return shops.stream()
				.map(Shop::getRevenue)
				.mapToInt(shopRevenue -> shopRevenue)
				.sum();
	}

	@Override
	public String toString() {
		return "\n\tNormalFloor{" +
				"totalSpace=" + totalSpace +
				", revenue=" + revenue +
				", com.jacob.shops=" + shops +
				'}';
	}
}
