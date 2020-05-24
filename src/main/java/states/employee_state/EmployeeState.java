package states.employee_state;

public interface EmployeeState {

	EmployeeState working();

	EmployeeState paidLeave();

	EmployeeState unPaidLeave();

	EmployeeState unEmployed();

	EmployeeStates getStatus();

}
