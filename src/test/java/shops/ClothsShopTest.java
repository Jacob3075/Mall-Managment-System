package shops;

import employee_managment.EmployeeManager;
import employee_managment.ShopEmployee;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import shop_items.ItemManager;
import utils.Getters;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ClothsShopTest {

	private static Shop shop;

	static {
		Getters.reset();
		shop = new ClothsShop(
				"Name",
				1000,
				2000,
				30,
				new ItemManager(List.of()),
				new EmployeeManager(Getters.getShopEmployees())
		);
	}

	@BeforeEach
	void setUp() {
		Getters.reset();
		shop = new ClothsShop(
				"Name",
				1000,
				2000,
				30,
				new ItemManager(List.of()),
				new EmployeeManager(Getters.getShopEmployees())
		);
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
		Shop.ShopBuilder shopBuilder = new Shop.ShopBuilder("Name", 30);
		shopBuilder = shopBuilder.setRent(1000)
		                         .setEmployeeManager(new EmployeeManager(Getters.getShopEmployees()))
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
