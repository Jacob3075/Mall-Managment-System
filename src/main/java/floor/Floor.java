package floor;

import shops.Shop;
import utils.FloorsStream;

import java.util.List;
import java.util.stream.Stream;

public interface Floor {

	List<Shop> getShops();

	NormalFloor addShop(Shop shop);

	int getFreeSpace();

	int getTotalSpace();

	int getRevenue();

	static FloorsStream stream(List<Floor> floors) {
		return new FloorsStream(floors.stream());
	}

	default FloorsStream with(Floor floor) {
		return new FloorsStream(Stream.of(this, floor));
	}
}
