package mall.MallStates;

import floor.Floor;

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
	public int getOperationCost() {
		return 0;
	}

	@Override
	public MallState addFloor() {
		return null;
	}

	@Override
	public String toString() {
		return "Closed Mall";
	}

}
