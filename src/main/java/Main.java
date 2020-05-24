import employee_managment.Employee;
import employee_managment.ShopEmployee;
import floor.Floor;
import floor.NormalFloor;
import mall.Mall;
import shops.ClothsShop;
import shops.Shop;
import shops.ShopBuilder;

import java.util.List;

public class Main {
	public static void main(String[] args) {
		List<Employee> employees1 = List.of(
				new ShopEmployee("name1", 25, 2000, 6),
				new ShopEmployee("name2", 25, 2000, 6)
		);
		List<Employee> employees2 = List.of(
				new ShopEmployee("name3", 25, 2000, 6),
				new ShopEmployee("name4", 25, 2000, 6)
		);

		List<Shop> shops1 = List.of(
				new ClothsShop("Shop1", 100, 150, 50, employees1),
				new ClothsShop("Shop2", 120, 170, 40, employees2)
		);
		List<Shop> shops2 = List.of(
				new ClothsShop("Shop3", 100, 150, 20, employees1),
				new ClothsShop("Shop4", 120, 170, 50, employees2)
		);

		Floor floor1 = new NormalFloor(shops1);
		Floor floor2 = new NormalFloor(shops2);

		List<Floor> floors = List.of(floor1, floor2);

		Mall mall = new Mall(floors, 1000, employees1);

		System.out.println("mall.getTotalRevenue() = " + mall.getRevenue());
		Floor.stream(mall.getFloors())
				.filterByArea(100)
				.forEach(System.out::println);
		System.out.println("mall = " + mall);

		Mall newMall = new Mall(floors, 1000, employees2);
		newMall.addFloor(floor1);
		System.out.println("newMall.getFloors() = " + newMall.getFloors());
		newMall.openMall(1000);
		newMall.closeMall();


		Shop shop = new ShopBuilder(
				"Name",
				1000
		)
				.setRent(100)
				.build();
		System.out.println("shop = " + shop);

	}
}
