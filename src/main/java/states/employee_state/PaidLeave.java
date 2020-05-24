package states.employee_state;

public class PaidLeave implements EmployeeState {

	private final EmployeeStates status = EmployeeStates.PAIDLEAVE;

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
	public EmployeeState unEmployed() {
		return new UnEmployed();
	}

	@Override
	public EmployeeStates getStatus() {
		return status;
	}

	@Override
	public String toString() {
		return "PaidLeave";
	}
}
