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
		this.employeeState = new Working(this);
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public int getAge() {
		return age;
	}

	@Override
	public MallEmployee setAge(int age) {
		this.age = age;
		return this;
	}

	@Override
	public Employee setSalary(int salary) {
		this.salary = salary;
		return this;
	}

	@Override
	public int getSalary() {
		return salary;
	}

	@Override
	public int getWorkingHours() {
		return workingHours;
	}

	@Override
	public MallEmployee setWorkingHours(int workingHours) {
		this.workingHours = workingHours;
		return this;
	}

	@Override
	public Employee work() {
		this.employeeState = this.employeeState.working(this);
		return this;
	}

	@Override
	public Employee paidLeave() {
		this.employeeState = this.employeeState.paidLeave(this);
		return this;
	}

	@Override
	public Employee unpaidLeave() {
		this.employeeState = this.employeeState.unPaidLeave(this);
		return this;
	}

	@Override
	public Employee unEmployed() {
		this.employeeState = this.employeeState.unEmployed(this);
		return this;
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
