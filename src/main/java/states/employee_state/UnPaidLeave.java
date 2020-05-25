package states.employee_state;

import java.util.function.IntSupplier;

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

	@Override
	public String toString() {
		return "UnPaidLeave";
	}
}
