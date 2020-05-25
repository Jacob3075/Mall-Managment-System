package states.employee_state;

import employee_managment.Employee;

public interface EmployeeState {

	EmployeeState working(Employee employee);

	EmployeeState paidLeave(Employee employee);

	EmployeeState unPaidLeave(Employee employee);

	EmployeeState unEmployed(Employee employee);

	EmployeeStates getStatus();

	int getSalary();

	int getWorkingHours();

	int getAge();

}
