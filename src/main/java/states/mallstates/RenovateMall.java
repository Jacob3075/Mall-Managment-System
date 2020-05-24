package states.mallstates;

import floor.Floor;
import mall.Mall;

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
	public MallState addFloor(Floor floor) {
		return null;
	}

	@Override
	public int getConstructionCost() {
		return this.operationCost;
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
	public MallState addFloor() {
		return null;
	}
}
