import floor.Floor;
import mall.MallStates.MallState;

import java.util.List;

public class Mall {
	private final List<Floor> floors;
	private int revenue;
	private final int operationCost;

	public Mall(List<Floor> floors, int operationCost) {
		this.floors = floors;
		this.operationCost = operationCost;
	}

	public List<Floor> getFloors() {
		return floors;
	}

	public int getRevenue() {
		return revenue;
	}

	public int getOperationCost() {
		return operationCost;
	}

	public int getTotalRevenue() {
		if (floors == null) return -1;
		return Floor.stream(floors).getFloorsRevenue().sum();
	}

	@Override
	public String toString() {
		return "mall.MallStates.Mall{" +
				"floors=" + floors +
				'}';
	}
}
