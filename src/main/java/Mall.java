import floor.Floor;

import java.util.List;

public class Mall {
	private List<Floor> floors;
	private int revenue;
	private final int operationCost;


	public Mall(List<Floor> floors, int operationCost) {
		this.floors = floors;
		this.operationCost = operationCost;
	}

	public Mall addFloor(Floor newFloor) {
		this.floors.add(newFloor);
		return this;
	}

	public List<Floor> getFloors() {
		return floors;
	}

	public Mall setFloors(List<Floor> floors) {
		this.floors = floors;
		return this;
	}

	public int getTotalRevenue() {
		if (floors == null) return -1;
		return floors.stream()
				.map(Floor::getRevenue)
				.mapToInt(floorRevenue -> floorRevenue)
				.sum();
	}

	@Override
	public String toString() {
		return "Mall{" +
				"floors=" + floors +
				'}';
	}

	public int getRevenue() {
		return revenue;
	}

	public int getOperationCost() {
		return operationCost;
	}
}
