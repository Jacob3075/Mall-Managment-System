package shops;

import employee_managment.ShopEmployee;

import java.util.List;

public class ClothsShop implements Shop {
	private String shopName;
	private int rent;
	private int revenue;
	private int shopFloorArea;
	private List<ShopEmployee> employees;
	private final ShopCategory shopCategory = ShopCategory.CLOTHING;

	public ClothsShop() {

	}

	public ClothsShop(String shopName, int rent, int revenue, int shopFloorArea, List<ShopEmployee> employees) {
		this.shopName = shopName;
		this.rent = rent;
		this.revenue = revenue;
		this.shopFloorArea = shopFloorArea;
		this.employees = employees;
	}

	public ShopCategory getShopCategory() {
		return shopCategory;
	}

	public String getShopName() {
		return shopName;
	}

	public Shop setShopName(String shopName) {
		this.shopName = shopName;
		return this;
	}

	@Override
	public int getRent() {
		return rent;
	}

	public Shop setRent(int rent) {
		this.rent = rent;
		return this;
	}

	@Override
	public int getRevenue() {
		return revenue;
	}

	public Shop setRevenue(int revenue) {
		this.revenue = revenue;
		return this;
	}

	@Override
	public int getShopUsedArea() {
		return shopFloorArea;
	}

	@Override
	public List<ShopEmployee> getEmployees() {
		return employees;
	}

	public Shop setEmployees(List<ShopEmployee> employees) {
		this.employees = employees;
		return this;
	}

	@Override
	public int getEmployeeCount() {
		return employees.size();
	}

	@Override
	public Shop addEmployee(ShopEmployee employee) {
		this.employees.add(employee);
		return this;
	}

	@Override
	public Shop removeEmployee(ShopEmployee employee) {
		this.employees.remove(employee);
		return this;
	}

	@Override
	public String toString() {
		return "\n\t\tClothsShop{" +
				"shopName='" + shopName + '\'' +
				", rent=" + rent +
				", revenue=" + revenue +
				", shopFloorArea=" + shopFloorArea +
				", shopCategory=" + shopCategory +
				'}';
	}

}
