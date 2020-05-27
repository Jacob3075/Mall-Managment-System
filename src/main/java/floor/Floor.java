package floor;

import shops.Shop;
import utils.FloorsStream;

import java.security.InvalidParameterException;
import java.util.List;

public interface Floor {

	static FloorsStream stream(List<Floor> floors) {
		return new FloorsStream(floors.stream());
	}

	List<Shop> getShops();

	default Floor addShop(Shop shop, Floor floor) {
		if (this.getTotalUsedSpace() + shop.getShopUsedArea() > 100)
			throw new InvalidParameterException("Total area by shops exceeds floor space");
		this.getShops().add(shop);
		return this;
	}

	default Floor removeShop(Shop shop, Floor floor) {
		if (!floor.getShops().isEmpty()) {
			floor.getShops().remove(shop);
		}
		return floor;
	}

	int getFreeSpace();

	int getTotalSpace();

	int getTotalUsedSpace();

	int getRevenue();
}
