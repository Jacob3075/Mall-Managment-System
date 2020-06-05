package shops;

import employee_managment.Employee;
import employee_managment.EmployeeManager;
import shop_items.Item;
import shop_items.ItemManager;

import java.util.List;
import java.util.function.ToIntFunction;

public abstract class ShopsCommon implements Shop {
	protected final ShopCategory    shopCategory = ShopCategory.CLOTHING;
	protected final int             shopFloorArea;
	protected       int             revenue      = 0;
	protected       String          shopName;
	protected       int             rent;
	protected       ItemManager     itemManager;
	protected       EmployeeManager employeeManager;

	public ShopsCommon(
			String shopName,
			int rent,
			int revenue,
			int shopFloorArea,
			ItemManager itemManager,
			EmployeeManager employeeManager
	) {
		this.shopFloorArea = shopFloorArea;
		this.revenue = revenue;
		this.shopName = shopName;
		this.rent = rent;
		this.itemManager = itemManager;
		this.employeeManager = employeeManager;
	}

	public ShopCategory getShopCategory() {
		return shopCategory;
	}

	public int getShopFloorArea() {
		return shopFloorArea;
	}

	public Shop setRevenue(int revenue) {
		this.revenue = revenue;
		return this;
	}

	public String getShopName() {
		return shopName;
	}

	public Shop setShopName(String shopName) {
		this.shopName = shopName;
		return this;
	}

	public Shop setRent(int rent) {
		this.rent = rent;
		return this;
	}

	public ItemManager getItemManager() {
		return itemManager;
	}

	public Shop setItemManager(ItemManager itemManager) {
		this.itemManager = itemManager;
		return this;
	}

	public EmployeeManager getEmployeeManager() {
		return employeeManager;
	}

	public Shop setEmployeeManager(EmployeeManager employeeManager) {
		this.employeeManager = employeeManager;
		return this;
	}

	@Override
	public List<Item> getAllItems() {
		return itemManager.getItems();
	}

	@Override
	public List<Item> getItemsSortedBy(ToIntFunction<Item> comparingBy) {
		return this.itemManager.getItemsSortedBy(comparingBy);
	}

	@Override
	public List<Item> getItemsInStock() {
		return itemManager.stream().itemsInStock();
	}

	@Override
	public Shop addItem(String itemName) {
		itemManager = itemManager.increaseItemCount(itemName);
		return this;
	}

	@Override
	public Shop addItems(String itemName, int count) {
		itemManager = itemManager.increaseItemCount(itemName, count);
		return this;
	}

	@Override
	public Shop addNewItem(Item item) {
		itemManager = itemManager.addItem(item);
		return this;
	}

	@Override
	public Shop sellItem(String itemName) {
		itemManager = itemManager.sellItem(itemName, this::increaseRevenue);
		return this;
	}

	private void increaseRevenue(int price) {
		this.revenue += price;
	}

	@Override
	public Shop sellItems(String itemName, int count) {
		itemManager = itemManager.sellItems(
				itemName,
				count,
				this::increaseRevenue
		);
		return this;
	}

	@Override
	public Shop removeItemFromStock(String itemName) {
		itemManager = itemManager.removeItem(itemName);
		return this;
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

	@Override
	public String toString() {
		return "ShopsCommon{" +
				       "shopCategory=" + shopCategory +
				       ", shopFloorArea=" + shopFloorArea +
				       ", revenue=" + revenue +
				       ", shopName='" + shopName + '\'' +
				       ", rent=" + rent +
				       ", itemManager=" + itemManager +
				       ", employeeManager=" + employeeManager +
				       '}';
	}
}
