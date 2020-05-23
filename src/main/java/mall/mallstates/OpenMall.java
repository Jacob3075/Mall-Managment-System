package mall.mallstates;

import floor.Floor;
import mall.Mall;

import java.util.Optional;
import java.util.function.Consumer;

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
	public MallState addFloor(Floor floor, Consumer<Floor> floorConsumer) {
		return this;
	}

	@Override
	public int getConstructionCost() {
		return 0;
	}

	@Override
	public int getTotalRevenue(Mall mall) {
		return Optional.of(Floor.stream(mall.getFloors()).getFloorsRevenue().sum()).orElse(0);
	}

	@Override
	public int getOperationCost() {
		return this.operationCost;
	}
}
