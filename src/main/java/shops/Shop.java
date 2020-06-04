package shops;


import employee_managment.Employee;
import employee_managment.EmployeeManager;
import shop_items.Item;
import shop_items.ItemManager;
import utils.ShopsStream;

import java.util.List;
import java.util.function.ToIntFunction;

public interface Shop {
	static ShopsStream stream(List<Shop> shops) {
		return new ShopsStream(shops.stream());
	}

	//region Shop Items
	List<Item> getAllItems();

	List<Item> getItemsSortedBy(ToIntFunction<Item> comparingBy);

	List<Item> getItemsInStock();

	Shop addItem(String itemName);

	Shop addItems(String itemName, int count);

	Shop sellItem(String itemName);

	Shop sellItems(String itemName, int count);

	Shop removeItemFromStock(String itemName);
	//endregion

	int getRent();

	int getRevenue();

	int getShopUsedArea();

	//region Shop Employees
	List<Employee> getEmployees();

	int getEmployeeCount();

	Shop addEmployee(Employee employee);

	Shop removeEmployee(Employee employee);
	//endregion

	class ShopBuilder {
		private final String          shopName;
		private final int             shopFloorArea;
		private       int             rent    = 0;
		private       int             revenue = 0;
		private       ItemManager     itemManager;
		private       EmployeeManager employeeManager;

		public ShopBuilder(String shopName, int shopFloorArea) {
			this.shopName = shopName;
			this.shopFloorArea = shopFloorArea;
		}

		public Shop buildClothsShop() {
			return new ClothsShop(
					shopName,
					rent,
					revenue,
					shopFloorArea,
					itemManager,
					employeeManager
			);
		}

		public Shop buildSportsShop() {
			return null;
		}

		public Shop buildFoodShop() {
			return null;
		}

		public ShopBuilder setRent(int rent) {
			this.rent = rent;
			return this;
		}

		public ShopBuilder setRevenue(int revenue) {
			this.revenue = revenue;
			return this;
		}


		public ShopBuilder setItemManager(ItemManager itemManager) {
			this.itemManager = itemManager;
			return this;
		}

		public ShopBuilder setEmployeeManager(EmployeeManager employeeManager) {
			this.employeeManager = employeeManager;
			return this;
		}
	}

}
