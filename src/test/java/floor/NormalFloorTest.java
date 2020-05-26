package floor;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utils.Getters;

import java.security.InvalidParameterException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class NormalFloorTest {
	private static Floor floor = new NormalFloor(Getters.shops);

	@BeforeEach
	void setUp() {
		floor = new NormalFloor(Getters.shops);
	}

	@Test
	void methodsTest() {
		assertEquals(100, floor.getTotalSpace());
		assertEquals(80, floor.getTotalUsedSpace());
		assertEquals(8000, floor.getRevenue());
		assertEquals(4, floor.getShops().size());

		floor = floor.addShop(Getters.shops.get(0), floor);

		assertEquals(5, floor.getShops().size());
		assertEquals(10000, floor.getRevenue());
		assertEquals(100, floor.getTotalUsedSpace());
		assertEquals(0, floor.getFreeSpace());

		floor = floor.removeShop(Getters.shops.get(0), floor);

		assertEquals(4, floor.getShops().size());

	}

	@Test
	void throwsExceptionTest() {
		floor = floor.addShop(Getters.shops.get(0), floor);
		assertThrows(
				InvalidParameterException.class,
				() -> floor.addShop(Getters.shops.get(1), floor)
		);
	}
}