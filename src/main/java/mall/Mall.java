package mall;

import employee_managment.Employee;
import employee_managment.EmployeeManager;
import floor.Floor;
import shops.Shop;
import states.mallstates.ConstructMall;
import states.mallstates.MallState;

import java.util.List;
import java.util.stream.Collectors;

public class Mall implements Floor {
	private final List<Floor> floors;
	private MallState mallState;
	private EmployeeManager employeeManager;

	public Mall(List<Floor> floors, int constructionCost, List<Employee> employees) {
		this.floors = floors;
		this.mallState = new ConstructMall(constructionCost);
		this.employeeManager = new EmployeeManager(employees);
	}

	@Override
	public Floor addShop(Shop shop, Floor floor) {
		return null;
	}

	@Override
	public List<Employee> getEmployees() {
		return this.employeeManager.getEmployees();
	}

	@Override
	public int getEmployeesCount() {
		return this.employeeManager.getEmployees().size();
	}

	@Override
	public Floor addEmployee(Employee employee) {
		this.employeeManager = this.employeeManager.addEmployee(employee);
		return this;
	}

	@Override
	public Floor removeEmployee(Employee employee) {
		this.employeeManager = this.employeeManager.removeEmployee(employee);
		return this;
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
