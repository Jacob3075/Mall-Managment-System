package states.employee_state;

import java.util.function.IntSupplier;

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
	public int getSalary(IntSupplier intSupplier) {
		return intSupplier.getAsInt();
	}

	@Override
	public int getWorkingHours(IntSupplier intSupplier) {
		return 0;
	}

	@Override
	public int getAge(IntSupplier intSupplier) {
		return intSupplier.getAsInt();
	}

	@Override
	public String toString() {
		return "PaidLeave";
	}
}
