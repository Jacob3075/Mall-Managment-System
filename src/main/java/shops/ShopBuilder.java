package shops;

import employee_managment.Employee;

import java.util.ArrayList;
import java.util.List;

public class ShopBuilder {
	private final String shopName;
	private final int shopFloorArea;
	private int rent = 0;
	private int revenue = 0;
	private List<Employee> employees = new ArrayList<>();

	public ShopBuilder(String shopName, int shopFloorArea) {
		this.shopName = shopName;
		this.shopFloorArea = shopFloorArea;
	}

	public Shop build() {
		return new ClothsShop(
				shopName,
				rent,
				revenue,
				shopFloorArea,
				employees
		);
	}

	public ShopBuilder setRent(int rent) {
		this.rent = rent;
		return this;
	}

	public ShopBuilder setRevenue(int revenue) {
		this.revenue = revenue;
		return this;
	}

	public ShopBuilder setEmployees(List<Employee> employees) {
		this.employees = employees;
		return this;
	}
}