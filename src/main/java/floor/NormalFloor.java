package floor;

import shops.Shop;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;

public class NormalFloor implements Floor {
	private final int             totalSpace = 100;
	private final ArrayList<Shop> shops;
	private       int             revenue;

	public NormalFloor(List<Shop> shops) {
		if (Shop.stream(shops).totalUsedArea() > 100)
			throw new InvalidParameterException("Total area by shops exceeds floor space");

		this.shops = new ArrayList<>(shops);
	}

	@Override
	public List<Shop> getShops() {
		return shops;
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
		return Shop.stream(shops).getRevenue();
	}

	public Floor addShop(Shop shop) {
		return this.addShop(shop, this);
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
