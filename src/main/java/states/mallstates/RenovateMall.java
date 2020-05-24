package states.mallstates;

import floor.Floor;
import mall.Mall;

import java.util.function.Consumer;

public class RenovateMall implements MallState {

	private final int operationCost;

	public RenovateMall(int operationCost) {

		this.operationCost = operationCost;
	}

	@Override
	public MallState closeMall() {
		return new ClosedMall();
	}

	@Override
	public MallState openMall(int operationCost) {
		return new OpenMall(this.operationCost);
	}

	@Override
	public MallState renovateMall(int operationCost) {
		return this;
	}

	@Override
	public MallState maintainMall(int maintenanceCost) {
		return new MaintainMall(maintenanceCost);
	}

	@Override
	public MallState addFloor(Floor floor, Consumer<Floor> floorConsumer) {
		floorConsumer.accept(floor);
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
}