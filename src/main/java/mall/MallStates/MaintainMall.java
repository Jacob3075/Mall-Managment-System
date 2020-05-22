package mall.MallStates;

public class MaintainMall implements MallState {

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
		return new RenovateMall();
	}

	@Override
	public MallState maintainMall() {
		return this;
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
