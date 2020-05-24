package states.employee_state;

public class UnPaidLeave implements EmployeeState {

	private final EmployeeStates status = EmployeeStates.UNPAIDLEAVE;

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
	public EmployeeState unEmployed() {
		return new UnEmployed();
	}

	@Override
	public EmployeeStates getStatus() {
		return status;
	}

	@Override
	public String toString() {
		return "UnPaidLeave";
	}
}
