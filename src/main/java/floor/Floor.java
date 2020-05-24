package floor;

import employee_managment.Employee;
import shops.Shop;
import utils.FloorsStream;

import java.util.List;

public interface Floor {

	static FloorsStream stream(List<Floor> floors) {
		return new FloorsStream(floors.stream());
	}

	List<Shop> getShops();

	default Floor addShop(Shop shop, Floor floor) {
		this.getShops().add(shop);
		return this;
	}

	int getFreeSpace();

	int getTotalSpace();

	int getTotalUsedSpace();

	Integer getRevenue();

	List<Employee> getEmployees();

	int getEmployeesCount();

	Floor addEmployee(Employee employee);

	Floor removeEmployee(Employee employee);
}
