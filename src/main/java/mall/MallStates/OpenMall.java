package mall.MallStates;

import floor.Floor;

public class OpenMall implements MallState {

	private int operationCost;

	public OpenMall(int operationCost) {
		this.operationCost = operationCost;
	}

	@Override
	public MallState closeMall() {
		return new ClosedMall();
	}

	@Override
	public MallState openMall(int operationCost) {
		return this;
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
	public MallState addFloor(Floor floor) {
		return null;
	}

	@Override
	public int getConstructionCost() {
		return 0;
	}

	@Override
	public int getTotalRevenue() {
		return 0;
	}

	@Override
	public MallState addFloor() {
		return null;
	}

	@Override
	public int getOperationCost() {
		return this.operationCost;
	}
}
