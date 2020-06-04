package shops;

import employee_managment.Employee;
import employee_managment.EmployeeManager;
import shop_items.ItemManager;

import java.util.List;

public class ClothsShop implements Shop {
	private final ShopCategory    shopCategory = ShopCategory.CLOTHING;
	private final int             revenue;
	private final int             shopFloorArea;
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
	public ItemManager getItemManager() {
		return itemManager;
	}

	public Shop setItemManager(ItemManager itemManager) {
		this.itemManager = itemManager;
		return this;
	}

	public void addItem(String itemName) {
		itemManager = itemManager.increaseItemCount(itemName);
	}

	public void addItems(String itemName, int count) {
		itemManager = itemManager.increaseItemCount(itemName, count);
	}

	public void sellItem(String itemName) {
		itemManager.sellItem(itemName);
	}

	public void sellItems(String itemName, int count) {
		itemManager.sellItems(itemName, count);
	}
//	endregion

	//region Getters
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

	//region Setters
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
