package employee_managment;

import states.employee_state.EmployeeState;
import states.employee_state.EmployeeStates;
import states.employee_state.Working;

public class ShopEmployee implements Employee {

	private final String        name;
	private       int           age;
	private       int           salary;
	private       int           workingHours;
	private       EmployeeState employeeState;

	public ShopEmployee(String name, int age, int salary, int workingHours) {
		this.name = name;
		this.age = age;
		this.salary = salary;
		this.workingHours = workingHours;
		employeeState = new Working();
	}

	@Override
	public Employee work() {
		this.employeeState = this.employeeState.working();
		return this;
	}

	@Override
	public Employee paidLeave() {
		this.employeeState = this.employeeState.paidLeave();
		return this;
	}

	@Override
	public Employee unPaidLeave() {
		this.employeeState = this.employeeState.unPaidLeave();
		return this;
	}

	@Override
	public Employee unEmployed() {
		this.employeeState = this.employeeState.unEmployed();
		return this;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public EmployeeStates getStatus() {
		return employeeState.getStatus();
	}

	@Override
	public int getSalary() {
		return employeeState.getSalary(this::showSalary);
	}

	private int showSalary() {
		return this.salary;
	}

	@Override
	public Employee setSalary(int salary) {
		this.salary = salary;
		return this;
	}

	@Override
	public int getAge() {
		return employeeState.getAge(this::showAge);
	}

	private int showAge() {
		return this.age;
	}

	@Override
	public Employee setAge(int age) {
		this.age = age;
		return this;
	}

	@Override
	public int getWorkingHours() {
		return employeeState.getWorkingHours(this::showWorkingHours);
	}

	private int showWorkingHours() {
		return this.workingHours;
	}

	@Override
	public Employee setWorkingHours(int workingHours) {
		this.workingHours = workingHours;
		return this;
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
