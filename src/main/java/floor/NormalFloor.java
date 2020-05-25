package floor;

import employee_managment.Employee;
import shops.Shop;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;

public class NormalFloor implements Floor {
	private final int totalSpace = 100;
	private final List<Shop> shops;
	private int revenue;

	public NormalFloor(List<Shop> shops) {
		if (Shop.stream(shops).totalUsedArea() > 100)
			throw new InvalidParameterException("Total area by shops exceeds floor space");

		this.shops = shops;
	}

	@Override
	public List<Shop> getShops() {
		return shops;
	}

	public Floor addShop(Shop shop) {
		return this.addShop(shop, this);
	}

	@Override
	public int getTotalUsedSpace() {
		return Shop.stream(shops).getTotalUsedSpace();
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
	public Integer getRevenue() {
		return Shop.stream(shops).getRevenue();
	}

	//	TODO: Use singleton for mall employees

	@Override
	public List<Employee> getEmployees() {
		return new ArrayList<>();
	}

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

	@Override
	public String toString() {
		return "\n\tNormalFloor{" +
				"totalSpace=" + totalSpace +
				", revenue=" + revenue +
				", com.jacob.shops=" + shops +
				'}';
	}
}
