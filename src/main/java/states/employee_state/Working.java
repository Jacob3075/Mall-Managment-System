package states.employee_state;

public class Working implements EmployeeState {

	private final EmployeeStates status = EmployeeStates.WORKING;

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
	public EmployeeState unEmployed() {
		return new UnEmployed();
	}

	@Override
	public EmployeeStates getStatus() {
		return status;
	}

	@Override
	public String toString() {
		return "Working";
	}
}
