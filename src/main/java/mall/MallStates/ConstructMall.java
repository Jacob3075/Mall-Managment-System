package mall.MallStates;

import floor.Floor;

public class ConstructMall implements MallState {

	private final int constructionCost;

	public ConstructMall(int constructionCost) {
		this.constructionCost = constructionCost;
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
		return this;
	}

	@Override
	public MallState maintainMall(int maintenanceCost) {
		return this;
	}

	@Override
	public MallState addFloor(Floor floor) {
		return null;
	}

	@Override
	public int getConstructionCost() {
		return this.constructionCost;
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
		return "\n\tConstructMall{" +
				"constructionCost=" + constructionCost +
				'}';
	}
}
