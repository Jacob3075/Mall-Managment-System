import floor.Floor;
import floor.NormalFloor;
import mall.Mall;
import shops.ClothsShop;
import shops.Shop;

import java.util.List;

public class Main {
	public static void main(String[] args) {
		List<Shop> shops1 = List.of(
				new ClothsShop("Shop1", 100, 150, 50),
				new ClothsShop("Shop2", 120, 170, 40)
		);
		List<Shop> shops2 = List.of(
				new ClothsShop("Shop3", 100, 150, 20),
				new ClothsShop("Shop4", 120, 170, 50)
		);

		Floor floor1 = new NormalFloor(shops1);
		Floor floor2 = new NormalFloor(shops2);

		List<Floor> floors = List.of(floor1, floor2);

		Mall mall = new Mall(floors, 1000);

		System.out.println("mall.getTotalRevenue() = " + mall.getRevenue());
		Floor.stream(mall.getFloors())
				.filterByArea(100)
				.forEach(System.out::println);
		System.out.println("mall = " + mall);

		Mall newMall = new Mall(floors, 1000);
		newMall.addFloor(floor1);
		System.out.println("newMall.getFloors() = " + newMall.getFloors());
		newMall.openMall(1000);
		newMall.closeMall();
	}
}
