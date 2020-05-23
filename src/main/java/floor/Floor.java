package floor;

import shops.Shop;
import utils.FloorsStream;

import java.util.List;

public interface Floor {

	List<Shop> getShops();

	default Floor addShop(Shop shop, Floor floor) {
		this.getShops().add(shop);
		return this;
	}

	int getFreeSpace();

	int getTotalSpace();

	int getTotalUsedSpace();

	Integer getRevenue();

	static FloorsStream stream(List<Floor> floors) {
		return new FloorsStream(floors.stream());
	}
}
