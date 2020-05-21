package shops;


import java.util.List;

public interface Shop {
	int getRent();

	int getRevenue();

	int getShopFloorArea();

	List<Object> getItemsOnSale();

	ClothsShop addItemForSale(Object item);
}
