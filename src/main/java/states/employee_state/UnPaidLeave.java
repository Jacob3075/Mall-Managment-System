package states.employee_state;

import employee_managment.Employee;

public class UnPaidLeave implements EmployeeState {

	private final EmployeeStates status = EmployeeStates.UNPAIDLEAVE;
	private final Employee employee;

	public UnPaidLeave(Employee employee) {

		this.employee = employee;
	}

	@Override
	public EmployeeState working(Employee employee) {
		return new Working(employee);
	}

	@Override
	public EmployeeState paidLeave(Employee employee) {
		return new PaidLeave(employee);
	}

	@Override
	public EmployeeState unPaidLeave(Employee employee) {
		return this;
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
		return 0;
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
		return "UnPaidLeave";
	}
}
