package floor;

import shops.Shop;
import utils.FloorsStream;

import java.util.List;

public interface Floor {

	List<Shop> getShops();

	NormalFloor addShop(Shop shop);

	int getFreeSpace();

	int getTotalSpace();

	int getTotalUsedSpace();

	int getRevenue();

	static FloorsStream stream(List<Floor> floors) {
		return new FloorsStream(floors.stream());
	}
}
