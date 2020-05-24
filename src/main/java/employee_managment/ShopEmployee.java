package employee_managment;

import states.employee_state.EmployeeState;
import states.employee_state.Working;

public class ShopEmployee implements Employee {

	private final String name;
	private int age;
	private int salary;
	private int workingHours;
	private EmployeeState employeeState;

	public ShopEmployee(String name, int age, int salary, int workingHours) {
		this.name = name;
		this.age = age;
		this.salary = salary;
		this.workingHours = workingHours;
		employeeState = new Working();
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public Employee setAge(int age) {
		this.age = age;
		return this;
	}

	public int getSalary() {
		return salary;
	}

	public Employee setSalary(int salary) {
		this.salary = salary;
		return this;
	}

	public int getWorkingHours() {
		return workingHours;
	}

	public Employee setWorkingHours(int workingHours) {
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
	public String toString() {
		return "ShopEmployee{" +
				"name='" + name + '\'' +
				", age=" + age +
				", salary=" + salary +
				", workingHours=" + workingHours +
				", employeeState=" + employeeState +
				'}';
	}
}
