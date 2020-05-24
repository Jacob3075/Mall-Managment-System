package states.employee_state;

public interface EmployeeState {
//	WORKING, PAIDLEAVE, UNPAIDLEAVE

	EmployeeState working();

	EmployeeState paidLeave();

	EmployeeState unPaidLeave();

}
