package mall;

import floor.Floor;
import mall.mallstates.ConstructMall;
import mall.mallstates.MallState;
import shops.Shop;

import java.util.List;
import java.util.stream.Collectors;

public class Mall implements Floor {
	private final List<Floor> floors;
	private MallState mallState;

	public Mall(List<Floor> floors, int constructionCost) {
		this.floors = floors;
		this.mallState = new ConstructMall(constructionCost);
	}

	public List<Floor> getFloors() {
		return floors;
	}

	public int getOperationCost() {
		return this.mallState.getOperationCost();
	}

	@Override
	public List<Shop> getShops() {
		return Floor.stream(floors)
				.getShops()
				.collect(Collectors.toList());
	}

	public Floor addShop(Shop shop, int floorLevel) {
		return this.addShop(shop, floors.get(floorLevel));
	}

	@Override
	public int getFreeSpace() {
		return Floor.stream(floors).getTotalFreeSpace();
	}

	@Override
	public int getTotalSpace() {
		return Floor.stream(floors).getTotalFloorsArea();
	}

	@Override
	public int getTotalUsedSpace() {
		return Floor.stream(floors).getFloorsUsedArea();
	}

	@Override
	public Integer getRevenue() {
		return mallState.getTotalRevenue(this);
	}

	public int getConstructionCost() {
		return mallState.getConstructionCost();
	}

	public void addFloor(Floor floor) {
		this.mallState = this.mallState.addFloor(floor, this::addNewFloor);
	}

	private void addNewFloor(Floor floor) {
		this.floors.add(floor);
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
