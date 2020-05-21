package shops;

public class ShopsFactory {

	public static Shop footWearShop() {
		return new FootWearShop();
	}

	public static Shop techShop() {
		return new TechShop();
	}

	public static Shop foodShop() {
		return new FoodShop();
	}

	public static Shop clothsShop() {
		return new ClothsShop();
	}

	public static Shop sportsShop() {
		return new SportsShop();
	}

}
