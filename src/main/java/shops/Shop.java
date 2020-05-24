package shops;


import employee_managment.Employee;
import utils.ShopsStream;

import java.util.List;

public interface Shop {
	static ShopsStream stream(List<Shop> shops) {
		return new ShopsStream(shops.stream());
	}

	int getRent();

	int getRevenue();

	int getShopUsedArea();

	List<Employee> getEmployees();

	int getEmployeeCount();

	Shop addEmployee(Employee employee);

	Shop removeEmployee(Employee employee);
}
