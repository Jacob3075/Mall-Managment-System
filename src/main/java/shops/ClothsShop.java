package shops;

import employee_managment.Employee;
import employee_managment.EmployeeManager;

import java.util.List;

public class ClothsShop implements Shop {
	private final ShopCategory shopCategory = ShopCategory.CLOTHING;
	private final int revenue;
	private final int shopFloorArea;
	private String shopName;
	private int rent;
	private EmployeeManager employeeManager;

	public ClothsShop(
			String shopName,
			int rent,
			int revenue,
			int shopFloorArea,
			List<Employee> employees
	) {
		this.shopName = shopName;
		this.rent = rent;
		this.revenue = revenue;
		this.shopFloorArea = shopFloorArea;
		this.employeeManager = new EmployeeManager(employees);

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

	@Override
	public int getShopUsedArea() {
		return shopFloorArea;
	}

	@Override
	public List<Employee> getEmployees() {
		return employeeManager.getEmployees();
	}

	public Shop setEmployees(List<Employee> employees) {
		this.employeeManager = this.employeeManager.setEmployees(employees);
		return this;
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
