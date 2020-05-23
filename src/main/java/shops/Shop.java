package shops;


import utils.ShopsStream;

import java.util.List;

public interface Shop {
	int getRent();

	int getRevenue();

	int getShopUsedArea();

	List<Object> getItemsOnSale();

	ClothsShop addItemForSale(Object item);

	static ShopsStream stream(List<Shop> shops) {
		return new ShopsStream(shops.stream());
	}


}
