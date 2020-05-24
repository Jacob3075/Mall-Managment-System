package shops;


import employee_managment.ShopEmployee;
import utils.ShopsStream;

import java.util.List;

public interface Shop {
	int getRent();

	int getRevenue();

	int getShopUsedArea();

	List<ShopEmployee> getEmployees();

	int getEmployeeCount();

	Shop addEmployee(ShopEmployee employee);

	Shop removeEmployee(ShopEmployee employee);

	static ShopsStream stream(List<Shop> shops) {
		return new ShopsStream(shops.stream());
	}
}
