package mall;

import floor.NormalFloor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import shops.ClothsShop;
import shops.Shop;
import states.mallstates.ClosedMall;
import states.mallstates.MaintainMall;
import states.mallstates.OpenMall;
import states.mallstates.RenovateMall;
import utils.Getters;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class MallTest {

	private static Mall mall;

	@BeforeEach
	void setUp() {
		Getters.reset();
		Mall.Builder mallBuilder =
				new Mall.Builder(Getters.floors).setOperationCost(10000).setEmployees(Getters.mallEmployees);
		mall = mallBuilder.build();
	}

	@Test
	void methodsTest() {
		assertEquals(3, mall.getFloors().size());
		assertEquals(24000, mall.getRevenue());
		assertEquals(4, mall.getEmployeesCount());
		assertEquals(240, mall.getTotalUsedSpace());
		assertEquals(24000, mall.getRevenue());
		assertEquals(10000, mall.getOperationCost());
		assertTrue(mall.getMallState() instanceof OpenMall);
	}

	@Test
	void openMallTests() {
		assertTrue(mall.getMallState() instanceof OpenMall);

		mall.addShop(newShop(), 0);
		assertEquals(12, mall.getShops().size());

		mall.addFloor(new NormalFloor(Getters.shops));
		assertEquals(3, mall.getFloors().size());
	}

	private Shop newShop() {
		return new ClothsShop(
				"Name",
				1000,
				2000,
				20,
				Getters.shopEmployees
		);
	}

	@Test
	void closedMallTest() {
		mall.closeMall();
		assertTrue(mall.getMallState() instanceof ClosedMall);

		mall.addFloor(new NormalFloor(Getters.shops));
		assertEquals(3, mall.getFloors().size());

		mall.addShop(newShop(), 0);
		assertEquals(13, mall.getShops().size());
	}

	@Test
	void renovateMallTest() {
		mall.renovateMall(5000);
		assertTrue(mall.getMallState() instanceof RenovateMall);
		assertEquals(5000, mall.getOperationCost());

		mall.addFloor(new NormalFloor(Getters.shops));
		mall.addShop(newShop(), 1);

		assertEquals(3, mall.getFloors().size());
		assertEquals(13, mall.getShops().size());
	}

	@Test
	void maintainMallTest() {
		mall.maintainMall(5000);
		assertTrue(mall.getMallState() instanceof MaintainMall);
		assertEquals(5000, mall.getOperationCost());

		mall.addShop(newShop(), 0);
		assertEquals(13, mall.getShops().size());

		mall.addFloor(new NormalFloor(Getters.shops));
		assertEquals(4, mall.getFloors().size());
	}

	@Test
	void mallStateTest() {
		mall.openMall(10000);
		assertTrue(mall.getMallState() instanceof OpenMall);
		mall.closeMall();
		assertTrue(mall.getMallState() instanceof ClosedMall);
		mall.renovateMall(5000);
		assertTrue(mall.getMallState() instanceof RenovateMall);
		mall.maintainMall(5000);
		assertTrue(mall.getMallState() instanceof MaintainMall);
		mall.openMall(10000);
		assertTrue(mall.getMallState() instanceof OpenMall);
		mall.openMall(10000);
		assertTrue(mall.getMallState() instanceof OpenMall);
	}
}
