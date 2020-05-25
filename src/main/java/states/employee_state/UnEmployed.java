package states.employee_state;

import java.util.function.IntSupplier;

public class UnEmployed implements EmployeeState {

	private final EmployeeStates status = EmployeeStates.UNEMPLOYED;

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
		return this;
	}

	@Override
	public EmployeeState unEmployed() {
		return this;
	}

	@Override
	public EmployeeStates getStatus() {
		return status;
	}

	@Override
	public int getSalary(IntSupplier intSupplier) {
		return 0;
	}

	@Override
	public int getWorkingHours(IntSupplier intSupplier) {
		return 0;
	}

	@Override
	public int getAge(IntSupplier intSupplier) {
		return intSupplier.getAsInt();
	}
}
