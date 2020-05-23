package shops;

import java.util.List;

public class ClothsShop implements Shop {
	private String shopName;
	private int rent;
	private int revenue;
	private int shopFloorArea;
	private List<Object> itemsOnSale;
	private final ShopCategory shopCategory = ShopCategory.CLOTHING;

	public ClothsShop() {

	}

	public ClothsShop(String shopName, int rent, int revenue, int shopFloorArea) {
		this.shopName = shopName;
		this.rent = rent;
		this.revenue = revenue;
		this.shopFloorArea = shopFloorArea;
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
		return "\n\t\tClothsShop{" +
				"shopName='" + shopName + '\'' +
				", rent=" + rent +
				", revenue=" + revenue +
				", shopFloorArea=" + shopFloorArea +
				", shopCategory=" + shopCategory +
				'}';
	}

	@Override
	public int getShopUsedArea() {
		return shopFloorArea;
	}

	@Override
	public List<Object> getItemsOnSale() {
		return itemsOnSale;
	}

	@Override
	public ClothsShop addItemForSale(Object item) {
		this.itemsOnSale.add(item);
		return this;
	}
}
