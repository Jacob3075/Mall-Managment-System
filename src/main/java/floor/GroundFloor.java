package floor;

import shops.Shop;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;

public class GroundFloor implements Floor {
	private final int             totalSpace = 120;
	private final ArrayList<Shop> shops;
	private       int             revenue;

	public GroundFloor(List<Shop> shops) {
		if (Shop.stream(shops).getTotalUsedSpace() > totalSpace)
			throw new InvalidParameterException("Total area by shops exceeds floor space");
		this.shops = new ArrayList<>(shops);
	}

	@Override
	public List<Shop> getShops() {
		return shops;
	}

	@Override
	public Floor addShop(Shop shop) {
		return this.addShop(shop, this);
	}

	@Override
	public Floor removeShop(Shop shop) {
		return this.removeShop(shop, this);
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
	public int getTotalUsedSpace() {
		return Shop.stream(shops).getTotalUsedSpace();
	}

	@Override
	public int getRevenue() {
		return revenue;
	}
}
