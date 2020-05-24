package employee_managment;

import utils.EmployeeStream;

import java.util.List;

public interface Employee {
	static EmployeeStream stream(List<Employee> employees) {
		return new EmployeeStream(employees.stream());
	}

	void work();

	void paidLeave();

	void unpaidLeave();
}
