package mall;

import employee_managment.Employee;
import employee_managment.EmployeeManager;
import floor.Floor;
import shops.Shop;
import states.mallstates.MallState;
import states.mallstates.OpenMall;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Mall implements Floor {
	private final ArrayList<Floor> floors;
	private       MallState        mallState;
	private       EmployeeManager  employeeManager;

	private Mall(List<Floor> floors, int operationCost, List<Employee> employees) {
		this.floors = new ArrayList<>(floors);
		this.mallState = new OpenMall(operationCost);
		this.employeeManager = new EmployeeManager(employees);
	}

	public MallState getMallState() {
		return mallState;
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
	public int getRevenue() {
		return mallState.getTotalRevenue(this);
	}

	@Override
	public List<Employee> getEmployees() {
		return this.employeeManager.getEmployees();
	}

	@Override
	public int getEmployeesCount() {
		return this.employeeManager.getEmployees().size();
	}

	//	TODO: ADD EMPLOYEES ONLY WHEN MALL IS OPEN
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

	public void addShop(Shop shop, int floorLevel) {
		this.mallState = mallState.addShop(
				shop,
				floorLevel,
				this::addNewShop
		);
	}

	private void addNewShop(Shop shop, int floorLevel) {
		Floor floor = this.floors.get(floorLevel);
		floor.addShop(shop, floor);
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

	public static class Builder {
		private final List<Floor>    floors;
		private       int            operationCost = 0;
		private       List<Employee> employees     = List.of();

		public Builder(List<Floor> floors) {
			this.floors = floors;
		}

		public Mall build() {
			return new Mall(floors, operationCost, employees);
		}

		public Builder setOperationCost(int operationCost) {
			this.operationCost = operationCost;
			return this;
		}

		public Builder setEmployees(List<Employee> employees) {
			this.employees = employees;
			return this;
		}
	}
}
