package states.employee_state;

public class UnPaidLeave implements EmployeeState {

	@Override
	public EmployeeState working() {
		return new Working();
	}

	@Override
	public EmployeeState paidLeave() {
		return new PaidLeave();
	}

	@Override
	public EmployeeState unPaidLeave() {
		return this;
	}

	@Override
	public String toString() {
		return "UnPaidLeave";
	}
}
