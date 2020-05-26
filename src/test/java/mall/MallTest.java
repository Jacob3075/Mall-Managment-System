package mall;

import employee_managment.MallEmployee;
import floor.NormalFloor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import shops.ClothsShop;
import states.mallstates.ClosedMall;
import states.mallstates.MaintainMall;
import states.mallstates.OpenMall;
import states.mallstates.RenovateMall;
import utils.Getters;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class MallTest {

	private static Mall mall;

	@BeforeEach
	void setUp() {
		Mall.Builder mallBuilder =
				new Mall.Builder(List.of(
						new NormalFloor(List.of(
								new ClothsShop(
										"Shop1", 1000, 2000, 20, Getters.shopEmployees),
								new ClothsShop(
										"Shop2", 1000, 2000, 20, Getters.shopEmployees),
								new ClothsShop(
										"Shop3", 1000, 2000, 20, Getters.shopEmployees),
								new ClothsShop(
										"Shop4", 1000, 2000, 20, Getters.shopEmployees)
						)),
						new NormalFloor(List.of(
								new ClothsShop(
										"Shop1", 1000, 2000, 20, Getters.shopEmployees),
								new ClothsShop(
										"Shop2", 1000, 2000, 20, Getters.shopEmployees),
								new ClothsShop(
										"Shop3", 1000, 2000, 20, Getters.shopEmployees),
								new ClothsShop(
										"Shop4", 1000, 2000, 20, Getters.shopEmployees)
						)),
						new NormalFloor(List.of(
								new ClothsShop(
										"Shop1", 1000, 2000, 20, Getters.shopEmployees),
								new ClothsShop(
										"Shop2", 1000, 2000, 20, Getters.shopEmployees),
								new ClothsShop(
										"Shop3", 1000, 2000, 20, Getters.shopEmployees),
								new ClothsShop(
										"Shop4", 1000, 2000, 20, Getters.shopEmployees)
						))
				)).setOperationCost(10000).setEmployees(List.of(
						new MallEmployee("Name1", 20, 1000, 6),
						new MallEmployee("Name2", 20, 1000, 6),
						new MallEmployee("Name3", 20, 1000, 6),
						new MallEmployee("Name4", 20, 1000, 6)
				));
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

		mall.addShop(
				new ClothsShop(
						"Name",
						1000,
						2000,
						20,
						Getters.shopEmployees
				),
				0
		);
		assertEquals(12, mall.getShops().size());

		mall.addFloor(
				new NormalFloor(
						List.of(
								new ClothsShop(
										"Shop1", 1000, 2000, 20, Getters.shopEmployees),
								new ClothsShop(
										"Shop2", 1000, 2000, 20, Getters.shopEmployees),
								new ClothsShop(
										"Shop3", 1000, 2000, 20, Getters.shopEmployees),
								new ClothsShop(
										"Shop4", 1000, 2000, 20, Getters.shopEmployees)
						)
				)
		);
		assertEquals(3, mall.getFloors().size());
	}

	@Test
	void closedMallTest() {
		mall.closeMall();
		assertTrue(mall.getMallState() instanceof ClosedMall);

		mall.addFloor(
				new NormalFloor(
						List.of(
								new ClothsShop(
										"Shop1", 1000, 2000, 20, Getters.shopEmployees),
								new ClothsShop(
										"Shop2", 1000, 2000, 20, Getters.shopEmployees),
								new ClothsShop(
										"Shop3", 1000, 2000, 20, Getters.shopEmployees),
								new ClothsShop(
										"Shop4", 1000, 2000, 20, Getters.shopEmployees)
						)
				)
		);
		assertEquals(3, mall.getFloors().size());

		mall.addShop(
				new ClothsShop(
						"Name",
						1000,
						2000,
						20,
						Getters.shopEmployees
				),
				0
		);
		assertEquals(13, mall.getShops().size());
	}

	@Test
	void renovateMallTest() {
		mall.renovateMall(5000);
		assertTrue(mall.getMallState() instanceof RenovateMall);
		assertEquals(5000, mall.getOperationCost());

		mall.addFloor(
				new NormalFloor(
						List.of(
								new ClothsShop(
										"Shop1", 1000, 2000, 20, Getters.shopEmployees),
								new ClothsShop(
										"Shop2", 1000, 2000, 20, Getters.shopEmployees),
								new ClothsShop(
										"Shop3", 1000, 2000, 20, Getters.shopEmployees),
								new ClothsShop(
										"Shop4", 1000, 2000, 20, Getters.shopEmployees)
						)
				)
		);
		mall.addShop(
				new ClothsShop(
						"Name",
						1000,
						2000,
						20,
						Getters.shopEmployees
				),
				1
		);

		assertEquals(3, mall.getFloors().size());
		assertEquals(13, mall.getShops().size());
	}

	@Test
	void maintainMallTest() {
		mall.maintainMall(5000);
		assertTrue(mall.getMallState() instanceof MaintainMall);
		assertEquals(5000, mall.getOperationCost());

		mall.addShop(
				new ClothsShop(
						"Name",
						1000,
						2000,
						20,
						Getters.shopEmployees
				),
				0
		);
		assertEquals(13, mall.getShops().size());

		mall.addFloor(
				new NormalFloor(
						List.of(
								new ClothsShop(
										"Shop1", 1000, 2000, 20, Getters.shopEmployees),
								new ClothsShop(
										"Shop2", 1000, 2000, 20, Getters.shopEmployees),
								new ClothsShop(
										"Shop3", 1000, 2000, 20, Getters.shopEmployees),
								new ClothsShop(
										"Shop4", 1000, 2000, 20, Getters.shopEmployees)
						)
				)
		);
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
