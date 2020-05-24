package employee_managment;

import states.employee_state.EmployeeState;
import states.employee_state.EmployeeStates;
import states.employee_state.Working;

public class MallEmployee implements Employee {

	private final String name;
	private int age;
	private int salary;
	private int workingHours;
	private EmployeeState employeeState;

	public MallEmployee(String name, int age, int salary, int workingHours) {
		this.name = name;
		this.age = age;
		this.salary = salary;
		this.workingHours = workingHours;
		this.employeeState = new Working();
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public MallEmployee setAge(int age) {
		this.age = age;
		return this;
	}

	@Override
	public int getSalary() {
		return salary;
	}

	public MallEmployee setSalary(int salary) {
		this.salary = salary;
		return this;
	}

	@Override
	public int getWorkingHours() {
		return workingHours;
	}

	public MallEmployee setWorkingHours(int workingHours) {
		this.workingHours = workingHours;
		return this;
	}

	@Override
	public void work() {
		this.employeeState = this.employeeState.working();
	}

	@Override
	public void paidLeave() {
		this.employeeState = this.employeeState.paidLeave();
	}

	@Override
	public void unpaidLeave() {
		this.employeeState = this.employeeState.unPaidLeave();
	}

	@Override
	public void unEmployed() {
		this.employeeState = this.employeeState.unEmployed();
	}

	@Override
	public EmployeeStates getStatus() {
		return employeeState.getStatus();
	}

	@Override
	public String toString() {
		return "MallEmployee{" +
				"name='" + name + '\'' +
				", age=" + age +
				", salary=" + salary +
				", workingHours=" + workingHours +
				", employeeState=" + employeeState +
				'}';
	}
}
