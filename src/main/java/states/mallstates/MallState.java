package states.mallstates;

import floor.Floor;
import mall.Mall;
import shops.Shop;

import java.util.function.Consumer;
import java.util.function.ObjIntConsumer;

public interface MallState {
	MallState closeMall();

	MallState openMall(int operationCost);

	MallState renovateMall(int operationCost);

	MallState maintainMall(int maintenanceCost);

	MallState addFloor(Floor floor, Consumer<Floor> floorConsumer);

	MallState addShop(Shop shop, int floorLevel, ObjIntConsumer<Shop> shopObjIntConsumer);

	int getTotalRevenue(Mall mall);

	int getOperationCost();
}
