package shops;

import java.util.List;

public class FoodShop implements Shop {

	private String shopName;
	private int rent;
	private int revenue;
	private int shopFloorArea;
	private final ShopCategory shopCategory = ShopCategory.CLOTHING;

	public FoodShop() {

	}

	public FoodShop(String shopName, int rent, int revenue, int shopFloorArea) {
		this.shopName = shopName;
		this.rent = rent;
		this.revenue = revenue;
		this.shopFloorArea = shopFloorArea;
	}


	@Override
	public int getRent() {
		return 0;
	}

	@Override
	public int getRevenue() {
		return 0;
	}

	@Override
	public int getShopFloorArea() {
		return 0;
	}

	@Override
	public List<Object> getItemsOnSale() {
		return null;
	}

	@Override
	public ClothsShop addItemForSale(Object item) {
		return null;
	}

	public String getShopName() {
		return shopName;
	}

	public FoodShop setShopName(String shopName) {
		this.shopName = shopName;
		return this;
	}

	public FoodShop setRent(int rent) {
		this.rent = rent;
		return this;
	}

	public FoodShop setRevenue(int revenue) {
		this.revenue = revenue;
		return this;
	}

	public FoodShop setShopFloorArea(int shopFloorArea) {
		this.shopFloorArea = shopFloorArea;
		return this;
	}

	public ShopCategory getShopCategory() {
		return shopCategory;
	}
}
