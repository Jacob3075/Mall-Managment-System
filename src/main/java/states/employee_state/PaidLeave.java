package states.employee_state;

import employee_managment.Employee;

public class PaidLeave implements EmployeeState {

	private final EmployeeStates status = EmployeeStates.PAIDLEAVE;
	private final Employee employee;

	public PaidLeave(Employee employee) {
		this.employee = employee;
	}

	@Override
	public EmployeeState working(Employee employee) {
		return new Working(employee);
	}

	@Override
	public EmployeeState paidLeave(Employee employee) {
		return this;
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
		return 0;
	}

	@Override
	public int getAge() {
		return employee.getAge();
	}

	@Override
	public String toString() {
		return "PaidLeave";
	}
}
