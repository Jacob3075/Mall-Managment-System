package states.employee_state;

public class PaidLeave implements EmployeeState {

	@Override
	public EmployeeState working() {
		return new Working();
	}

	@Override
	public EmployeeState paidLeave() {
		return this;
	}

	@Override
	public EmployeeState unPaidLeave() {
		return new UnPaidLeave();
	}

	@Override
	public String toString() {
		return "PaidLeave";
	}
}
