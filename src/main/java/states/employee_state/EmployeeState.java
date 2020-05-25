package states.employee_state;

import java.util.function.IntSupplier;

public interface EmployeeState {

	EmployeeState working();

	EmployeeState paidLeave();

	EmployeeState unPaidLeave();

	EmployeeState unEmployed();

	EmployeeStates getStatus();

	int getSalary(IntSupplier intSupplier);

	int getWorkingHours(IntSupplier intSupplier);

	int getAge(IntSupplier intSupplier);

}
