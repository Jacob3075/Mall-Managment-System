package shops;

import java.util.List;

public class SportsShop implements Shop{
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
}
