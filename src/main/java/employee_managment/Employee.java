package employee_managment;

import states.employee_state.EmployeeStates;
import utils.EmployeeStream;

import java.util.List;

public interface Employee {
	static EmployeeStream stream(List<Employee> employees) {
		return new EmployeeStream(employees.stream());
	}

	Employee work();

	Employee paidLeave();

	Employee unPaidLeave();

	Employee unEmployed();

	String getName();

	EmployeeStates getStatus();

	int getSalary();

	Employee setSalary(int salary);

	int getAge();

	Employee setAge(int age);

	int getWorkingHours();

	Employee setWorkingHours(int workingHours);
}
