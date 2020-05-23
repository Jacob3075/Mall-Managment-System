package mall.MallStates;

public interface MallState {
	MallState closeMall();

	MallState openMall();

	MallState renovateMall();

	MallState maintainMall();

	MallState constructMall();

	MallState addFloor();

	int getRevenue();

	int getOperationCost();

	int getTotalRevenue();
}
