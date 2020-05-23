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

	public Floor addShop(Shop shop) {
		return this.addShop(shop, this);
	}

	@Override
	public int getTotalUsedSpace() {
		return Shop.stream(shops).getTotalUsedSpace();
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
	public Integer getRevenue() {
		return Shop.stream(shops).getRevenue();
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
