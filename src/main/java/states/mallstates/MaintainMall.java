package states.mallstates;

import floor.Floor;
import mall.Mall;
import shops.Shop;

import java.util.function.Consumer;
import java.util.function.ObjIntConsumer;

public class MaintainMall implements MallState {

	private final int maintenanceCost;

	public MaintainMall(int maintenanceCost) {
		this.maintenanceCost = maintenanceCost;
	}

	@Override
	public MallState closeMall() {
		return new ClosedMall();
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
		return this;
	}

	@Override
	public MallState addFloor(Floor floor, Consumer<Floor> floorConsumer) {
		floorConsumer.accept(floor);
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
		return this.maintenanceCost;
	}

	@Override
	public String toString() {
		return "MaintainMall{" +
				"maintenanceCost=" + maintenanceCost +
				'}';
	}

}
