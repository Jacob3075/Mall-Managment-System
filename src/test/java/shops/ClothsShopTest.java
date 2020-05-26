package shops;

import employee_managment.ShopEmployee;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utils.Getters;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ClothsShopTest {

	private static Shop shop;

	static {
		Getters.reset();
		shop = new ClothsShop("Name", 1000, 2000, 30, Getters.shopEmployees);
	}

	@BeforeEach
	void setUp() {
		Getters.reset();
		shop = new ClothsShop("Name", 1000, 2000, 30, Getters.shopEmployees);
	}

	@Test
	void methodTests() {
		assertEquals(30, shop.getShopUsedArea());
		assertEquals(4, shop.getEmployeeCount());
		assertEquals(2000, shop.getRevenue());
		assertEquals(1000, shop.getRent());
		shop = shop.addEmployee(
				new ShopEmployee(
						"Name",
						20,
						1000,
						6
				)
		);
		assertEquals(5, shop.getEmployeeCount());
		shop = shop.removeEmployee(shop.getEmployees().get(0));
		assertEquals(4, shop.getEmployeeCount());
	}
}
