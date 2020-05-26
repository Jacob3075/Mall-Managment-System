package floor;

import employee_managment.Employee;
import shops.Shop;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;

public class NormalFloor implements Floor {
	private final int             totalSpace = 100;
	private final ArrayList<Shop> shops;
	private       int             revenue;

	public NormalFloor(List<Shop> shops) {
		if (Shop.stream(shops).totalUsedArea() > 100)
			throw new InvalidParameterException("Total area by shops exceeds floor space");

		this.shops = new ArrayList<>(shops);
	}

	@Override
	public List<Shop> getShops() {
		return shops;
	}

	@Override
	public int getFreeSpace() {
		return totalSpace - this.getTotalUsedSpace();
	}

	@Override
	public int getTotalSpace() {
		return totalSpace;
	}

	@Override
	public int getTotalUsedSpace() {
		return Shop.stream(shops).getTotalUsedSpace();
	}

	@Override
	public int getRevenue() {
		return Shop.stream(shops).getRevenue();
	}

	@Override
	public List<Employee> getEmployees() {
		return new ArrayList<>();
	}

	//	TODO: Singleton? Restructure EmployeeManager?

	@Override
	public int getEmployeesCount() {
		return 0;
	}

	@Override
	public Floor addEmployee(Employee employee) {
		return null;
	}

	@Override
	public Floor removeEmployee(Employee employee) {
		return null;
	}

	public Floor addShop(Shop shop) {
		return this.addShop(shop, this);
	}

	@Override
	public String toString() {
		return "\n\tNormalFloor{" +
				       "totalSpace=" + totalSpace +
				       ", revenue=" + revenue +
				       ", com.jacob.shops=" + shops +
				       '}';
	}
}
