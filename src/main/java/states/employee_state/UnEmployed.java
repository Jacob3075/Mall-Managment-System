package states.employee_state;

public class UnEmployed implements EmployeeState {

	private final EmployeeStates status = EmployeeStates.UNEMPLOYED;

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
		return new UnPaidLeave();
	}

	@Override
	public EmployeeState unEmployed() {
		return this;
	}

	@Override
	public EmployeeStates getStatus() {
		return status;
	}
}
