package mall;

import floor.Floor;
import mall.MallStates.*;

import java.util.List;
import java.util.Optional;

public class Mall {
	private final List<Floor> floors;
	private MallState mallState;

	public Mall(List<Floor> floors, int constructionCost) {
		this.floors = floors;
		this.mallState = new ConstructMall(constructionCost);
	}

	public List<Floor> getFloors() {
		return floors;
	}

	public int getOperationCost(int operationCost) {
		return this.mallState.getOperationCost();
	}

	public Integer getTotalRevenue() {
		return Optional.of(Floor.stream(floors).getFloorsRevenue().sum()).orElse(0);
	}

	public void addFloor(Floor floor) {
		this.mallState = this.mallState.addFloor(floor);
	}

	public void renovateMall(int operationCost) {
		this.mallState = this.mallState.renovateMall(operationCost);
	}

	public void maintainMall(int maintenanceCost) {
		this.mallState = this.mallState.maintainMall(maintenanceCost);
	}

	public void closeMall() {
		this.mallState = this.mallState.closeMall();
	}

	public void openMall(int operationCost) {
		this.mallState = this.mallState.openMall(operationCost);
	}

	@Override
	public String toString() {
		return "Mall{" +
				"floors=" + floors +
				", mallState=" + mallState +
				'}';
	}
}
