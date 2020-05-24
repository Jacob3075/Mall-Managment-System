package states.employee_state;

public class Working implements EmployeeState {

	@Override
	public EmployeeState working() {
		return this;
	}

	@Override
	public EmployeeState paidLeave() {
		return new PaidLeave();
	}

	@Override
	public EmployeeState unPaidLeave() {
		return new UnPaidLeave();
	}

	@Override
	public String toString() {
		return "Working";
	}
}