package states.employee_state;

import employee_managment.Employee;

public class Working implements EmployeeState {

	private final EmployeeStates status = EmployeeStates.WORKING;
	private final Employee employee;

	public Working(Employee employee) {

		this.employee = employee;
	}

	@Override
	public EmployeeState working(Employee employee) {
		return this;
	}

	@Override
	public EmployeeState paidLeave(Employee employee) {
		return new PaidLeave(employee);
	}

	@Override
	public EmployeeState unPaidLeave(Employee employee) {
		return new UnPaidLeave(employee);
	}

	@Override
	public EmployeeState unEmployed(Employee employee) {
		return new UnEmployed(employee);
	}

	@Override
	public EmployeeStates getStatus() {
		return status;
	}

	@Override
	public int getSalary() {
		return employee.getSalary();
	}

	@Override
	public int getWorkingHours() {
		return employee.getWorkingHours();
	}

	@Override
	public int getAge() {
		return employee.getAge();
	}

	@Override
	public String toString() {
		return "Working";
	}
}
