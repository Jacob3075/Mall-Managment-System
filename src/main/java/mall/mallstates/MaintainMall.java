package mall.mallstates;

import floor.Floor;

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
	public MallState addFloor(Floor floor) {
		return this;
	}

	@Override
	public int getConstructionCost() {
		return this.maintenanceCost;
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
	public String toString() {
		return "MaintainMall{" +
				"maintenanceCost=" + maintenanceCost +
				'}';
	}

	@Override
	public MallState addFloor() {
		return null;
	}
}
