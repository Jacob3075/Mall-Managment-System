package mall.MallStates;

import floor.Floor;

public interface MallState {
	MallState closeMall();

	MallState openMall(int operationCost);

	MallState renovateMall(int operationCost);

	MallState maintainMall(int maintenanceCost);

	MallState addFloor(Floor floor);

	MallState addFloor();

	int getConstructionCost();

	int getTotalRevenue();

	int getOperationCost();
}
