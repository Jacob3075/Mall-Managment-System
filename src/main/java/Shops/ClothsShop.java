package Shops;

public class ClothsShop implements Shop {
	private String shopName;
	private int rent;
	private int revenue;
	private final ShopCategory shopCategory = ShopCategory.CLOTHING;

	public ClothsShop() {

	}

	public ClothsShop(String shopName, int rent, int revenue) {
		this.shopName = shopName;
		this.rent = rent;
		this.revenue = revenue;
	}

	public ShopCategory getShopCategory() {
		return shopCategory;
	}

	public String getShopName() {
		return shopName;
	}

	public ClothsShop setShopName(String shopName) {
		this.shopName = shopName;
		return this;
	}

	@Override
	public int getRent() {
		return rent;
	}

	public ClothsShop setRent(int rent) {
		this.rent = rent;
		return this;
	}

	@Override
	public int getRevenue() {
		return revenue;
	}

	public ClothsShop setRevenue(int revenue) {
		this.revenue = revenue;
		return this;
	}

	@Override
	public String toString() {
		return "ClothsShop{" +
				"shopName='" + shopName + '\'' +
				", rent=" + rent +
				", revenue=" + revenue +
				", shopCategory=" + shopCategory +
				'}';
	}

}
