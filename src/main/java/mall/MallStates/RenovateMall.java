package mall.MallStates;

public class RenovateMall implements MallState {
	@Override
	public MallState closeMall() {
		return new ClosedMall();
	}

	@Override
	public MallState openMall() {
		return new OpenMall();
	}

	@Override
	public MallState renovateMall() {
		return this;
	}

	@Override
	public MallState maintainMall() {
		return new MaintainMall();
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
	public int getTotalRevenue() {
		return 0;
	}
}
