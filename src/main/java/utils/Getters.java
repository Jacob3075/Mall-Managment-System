package utils;

import employee_managment.Employee;
import employee_managment.MallEmployee;
import employee_managment.ShopEmployee;
import floor.Floor;
import floor.NormalFloor;
import shops.ClothsShop;
import shops.Shop;

import java.util.List;

public class Getters {

	public static List<Employee> mallEmployees = List.of(
			new MallEmployee("Name1", 20, 1000, 6),
			new MallEmployee("Name2", 20, 1000, 6),
			new MallEmployee("Name3", 20, 1000, 6),
			new MallEmployee("Name4", 20, 1000, 6)
	);

	public static List<Employee> shopEmployees = List.of(
			new ShopEmployee("Name1", 20, 1000, 6),
			new ShopEmployee("Name2", 20, 1000, 6),
			new ShopEmployee("Name3", 20, 1000, 6),
			new ShopEmployee("Name4", 20, 1000, 6)
	);

	public static List<Shop> shops = List.of(
			new ClothsShop("Shop1", 1000, 2000, 20, shopEmployees),
			new ClothsShop("Shop2", 1000, 2000, 20, shopEmployees),
			new ClothsShop("Shop3", 1000, 2000, 20, shopEmployees),
			new ClothsShop("Shop4", 1000, 2000, 20, shopEmployees)
	);

	public static List<Floor> floors = List.of(
			new NormalFloor(shops),
			new NormalFloor(shops),
			new NormalFloor(shops)
	);


	private Getters() {
		throw new IllegalStateException("Utility Class");
	}

	public static void reset() {
		floors = List.of(
				new NormalFloor(shops),
				new NormalFloor(shops),
				new NormalFloor(shops)
		);

		shops = List.of(
				new ClothsShop("Shop1", 1000, 2000, 20, shopEmployees),
				new ClothsShop("Shop2", 1000, 2000, 20, shopEmployees),
				new ClothsShop("Shop3", 1000, 2000, 20, shopEmployees),
				new ClothsShop("Shop4", 1000, 2000, 20, shopEmployees)
		);

		shopEmployees = List.of(
				new ShopEmployee("Name1", 20, 1000, 6),
				new ShopEmployee("Name2", 20, 1000, 6),
				new ShopEmployee("Name3", 20, 1000, 6),
				new ShopEmployee("Name4", 20, 1000, 6)
		);

		mallEmployees = List.of(
				new MallEmployee("Name1", 20, 1000, 6),
				new MallEmployee("Name2", 20, 1000, 6),
				new MallEmployee("Name3", 20, 1000, 6),
				new MallEmployee("Name4", 20, 1000, 6)
		);


	}
}
