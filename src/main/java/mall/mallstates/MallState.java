package mall.mallstates;

import floor.Floor;
import mall.Mall;

import java.util.function.Consumer;

public interface MallState {
	MallState closeMall();

	MallState openMall(int operationCost);

	MallState renovateMall(int operationCost);

	MallState maintainMall(int maintenanceCost);

	MallState addFloor(Floor floor, Consumer<Floor> floorConsumer);

	int getConstructionCost();

	int getTotalRevenue(Mall mall);

	int getOperationCost();
}
