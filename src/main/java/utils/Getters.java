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

	private static List<Employee> shopEmployees = List.of(
			new ShopEmployee("Name1", 20, 1000, 6),
			new ShopEmployee("Name2", 20, 1000, 6),
			new ShopEmployee("Name3", 20, 1000, 6),
			new ShopEmployee("Name4", 20, 1000, 6)
	);
	private static List<Shop>     shops         = List.of(
			new ClothsShop("Shop1", 1000, 2000, 20, getShopEmployees()),
			new ClothsShop("Shop2", 1000, 2000, 20, getShopEmployees()),
			new ClothsShop("Shop3", 1000, 2000, 20, getShopEmployees()),
			new ClothsShop("Shop4", 1000, 2000, 20, getShopEmployees())
	);
	private static List<Floor>    floors        = List.of(
			new NormalFloor(getShops()),
			new NormalFloor(getShops()),
			new NormalFloor(getShops())
	);
	private static List<Employee> mallEmployees = List.of(
			new MallEmployee("Name1", 20, 1000, 6),
			new MallEmployee("Name2", 20, 1000, 6),
			new MallEmployee("Name3", 20, 1000, 6),
			new MallEmployee("Name4", 20, 1000, 6)
	);


	private Getters() {
		throw new IllegalStateException("Utility Class");
	}

	public static void reset() {
		setFloors(List.of(
				new NormalFloor(getShops()),
				new NormalFloor(getShops()),
				new NormalFloor(getShops())
		));

		setShops(List.of(
				new ClothsShop("Shop1", 1000, 2000, 20, getShopEmployees()),
				new ClothsShop("Shop2", 1000, 2000, 20, getShopEmployees()),
				new ClothsShop("Shop3", 1000, 2000, 20, getShopEmployees()),
				new ClothsShop("Shop4", 1000, 2000, 20, getShopEmployees())
		));

		setShopEmployees(List.of(
				new ShopEmployee("Name1", 20, 1000, 6),
				new ShopEmployee("Name2", 20, 1000, 6),
				new ShopEmployee("Name3", 20, 1000, 6),
				new ShopEmployee("Name4", 20, 1000, 6)
		));

		setMallEmployees(List.of(
				new MallEmployee("Name1", 20, 1000, 6),
				new MallEmployee("Name2", 20, 1000, 6),
				new MallEmployee("Name3", 20, 1000, 6),
				new MallEmployee("Name4", 20, 1000, 6)
		));


	}

	public static List<Shop> getShops() {
		return shops;
	}

	public static List<Employee> getShopEmployees() {
		return shopEmployees;
	}

	private static void setShopEmployees(List<Employee> shopEmployees) {
		Getters.shopEmployees = shopEmployees;
	}

	private static void setShops(List<Shop> shops) {
		Getters.shops = shops;
	}

	public static List<Employee> getMallEmployees() {
		return mallEmployees;
	}

	private static void setMallEmployees(List<Employee> mallEmployees) {
		Getters.mallEmployees = mallEmployees;
	}

	public static List<Floor> getFloors() {
		return floors;
	}

	public static void setFloors(List<Floor> floors) {
		Getters.floors = floors;
	}
}
