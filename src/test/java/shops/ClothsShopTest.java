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

	@Test
	void usingShopBuilder() {
		ShopBuilder shopBuilder = new ShopBuilder("Name", 30);
		shopBuilder = shopBuilder.setRent(1000)
		                         .setEmployees(Getters.shopEmployees)
		                         .setRevenue(2000);
		Shop shopFromBuilder = shopBuilder.buildClothsShop();
		assertEquals(30, shopFromBuilder.getShopUsedArea());
		assertEquals(4, shopFromBuilder.getEmployeeCount());
		assertEquals(2000, shopFromBuilder.getRevenue());
		assertEquals(1000, shopFromBuilder.getRent());
		shopFromBuilder = shopFromBuilder.addEmployee(
				new ShopEmployee(
						"Name",
						20,
						1000,
						6
				)
		);
		assertEquals(5, shopFromBuilder.getEmployeeCount());
		shopFromBuilder = shopFromBuilder.removeEmployee(shopFromBuilder.getEmployees().get(0));
		assertEquals(4, shopFromBuilder.getEmployeeCount());

	}
}
