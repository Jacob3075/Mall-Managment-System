package mall.mallstates;

import floor.Floor;
import mall.Mall;

import java.util.function.Consumer;

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
		return null;
	}

	@Override
	public MallState maintainMall(int maintenanceCost) {
		return null;
	}

	@Override
	public MallState addFloor(Floor floor, Consumer<Floor> floorConsumer) {
		return this;
	}

	@Override
	public int getConstructionCost() {
		return 0;
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
