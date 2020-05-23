package mall.MallStates;

public class ClosedMall implements MallState {

	@Override
	public MallState closeMall() {
		return this;
	}

	@Override
	public MallState openMall() {
		return new OpenMall();
	}

	@Override
	public MallState renovateMall() {
		return null;
	}

	@Override
	public MallState maintainMall() {
		return null;
	}

	@Override
	public MallState constructMall() {
		return this;
	}

	@Override
	public int getRevenue() {
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
	public int getTotalRevenue() {
		return 0;
	}
}
