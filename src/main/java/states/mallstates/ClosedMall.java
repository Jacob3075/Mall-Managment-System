package states.mallstates;

import floor.Floor;
import mall.Mall;
import shops.Shop;

import java.util.function.Consumer;
import java.util.function.ObjIntConsumer;

public class ClosedMall implements MallState {

	@Override
	public MallState closeMall() {
		return this;
	}

	@Override
	public MallState openMall(int operationCost) {
		return new OpenMall(operationCost);
	}

	@Override
	public MallState renovateMall(int operationCost) {
		return new RenovateMall(operationCost);
	}

	@Override
	public MallState maintainMall(int maintenanceCost) {
		return new MaintainMall(maintenanceCost);
	}

	@Override
	public MallState addFloor(Floor floor, Consumer<Floor> floorConsumer) {
		return this;
	}

	@Override
	public MallState addShop(Shop shop, int floorLevel, ObjIntConsumer<Shop> shopObjIntConsumer) {
		shopObjIntConsumer.accept(shop, floorLevel);
		return this;
	}

	@Override
	public int getTotalRevenue(Mall mall) {
		return 0;
	}

	@Override
	public int getOperationCost() {
		return 0;
	}

	@Override
	public String toString() {
		return "Closed Mall";
	}

}
