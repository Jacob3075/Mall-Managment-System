package shops;

import employee_managment.EmployeeManager;
import shop_items.ItemManager;

public class ClothsShop extends ShopsCommon implements Shop {

	public ClothsShop(
			String shopName,
			int rent,
			int revenue,
			int shopFloorArea,
			ItemManager itemManager,
			EmployeeManager employeeManager
	) {
		super(
				shopName,
				rent,
				revenue,
				shopFloorArea,
				itemManager,
				employeeManager
		);
	}

	@Override
	public String toString() {
		return "ClothsShop{" +
				       "super=" + super.toString() +
				       '}';
	}

}
