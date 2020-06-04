package shops;

import employee_managment.Employee;
import employee_managment.EmployeeManager;
import shop_items.Item;
import shop_items.ItemManager;

import java.util.List;
import java.util.function.ToIntFunction;

public class ClothsShop implements Shop {
	private final ShopCategory    shopCategory = ShopCategory.CLOTHING;
	private final int             shopFloorArea;
	private       int             revenue      = 0;
	private       String          shopName;
	private       int             rent;
	private       ItemManager     itemManager;
	private       EmployeeManager employeeManager;

	public ClothsShop(
			String shopName,
			int rent,
			int revenue,
			int shopFloorArea,
			ItemManager itemManager,
			EmployeeManager employeeManager
	) {
		this.revenue = revenue;
		this.shopFloorArea = shopFloorArea;
		this.shopName = shopName;
		this.rent = rent;
		this.employeeManager = employeeManager;
		this.itemManager = itemManager;

	}

	//region Item Region
	public List<Item> getAllItems() {
		return itemManager.getItems();
	}

	public List<Item> getItemsSortedBy(ToIntFunction<Item> comparingBy) {
		return this.itemManager.getItemsSortedBy(comparingBy);
	}

	public List<Item> getItemsInStock() {
		return itemManager.stream().itemsInStock();
	}

	public Shop setItemManager(ItemManager itemManager) {
		this.itemManager = itemManager;
		return this;
	}

	public Shop addItem(String itemName) {
		itemManager = itemManager.increaseItemCount(itemName);
		return this;
	}

	public Shop addItems(String itemName, int count) {
		itemManager = itemManager.increaseItemCount(itemName, count);
		return this;
	}

	public Shop sellItem(String itemName) {
		itemManager = itemManager.sellItem(itemName, this::increaseRevenue);
		return this;
	}

	private void increaseRevenue(int price) {
		this.revenue += price;
	}

	public Shop sellItems(String itemName, int count) {
		itemManager = itemManager.sellItems(
				itemName,
				count,
				this::increaseRevenue
		);
		return this;
	}

	public Shop removeItemFromStock(String itemName) {
		itemManager = itemManager.removeItem(itemName);
		return this;
	}
//	endregion

	//region Other Getters
	public ShopCategory getShopCategory() {
		return shopCategory;
	}

	public String getShopName() {
		return shopName;
	}

	@Override
	public int getRent() {
		return rent;
	}

	@Override
	public int getRevenue() {
		return revenue;
	}

	@Override
	public int getShopUsedArea() {
		return shopFloorArea;
	}
	//endregion

	//region Employee Region
	@Override
	public List<Employee> getEmployees() {
		return employeeManager.getEmployees();
	}

	@Override
	public int getEmployeeCount() {
		return this.employeeManager.getEmployees().size();
	}

	@Override
	public Shop addEmployee(Employee employee) {
		this.employeeManager = this.employeeManager.addEmployee(employee);
		return this;
	}

	@Override
	public Shop removeEmployee(Employee employee) {
		this.employeeManager = this.employeeManager.removeEmployee(employee);
		return this;
	}
	//endregion

	//region Other Setters
	public Shop setRent(int rent) {
		this.rent = rent;
		return this;
	}

	public Shop setShopName(String shopName) {
		this.shopName = shopName;
		return this;
	}

	public Shop setEmployees(List<Employee> employees) {
		this.employeeManager = this.employeeManager.setEmployees(employees);
		return this;
	}

	//endregion

	@Override
	public String toString() {
		return "\n\t\tClothsShop{" +
				       "shopCategory=" + shopCategory +
				       ", shopName='" + shopName + '\'' +
				       ", rent=" + rent +
				       ", revenue=" + revenue +
				       ", shopFloorArea=" + shopFloorArea +
				       ", employeeManager=" + employeeManager +
				       '}';
	}
}
