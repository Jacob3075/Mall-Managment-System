package employee_managment;

import java.util.List;

public class EmployeeManager {
	private List<Employee> employees;

	public EmployeeManager(List<Employee> employees) {
		this.employees = employees;
	}

	public EmployeeManager addEmployee(Employee employee) {
		this.employees.add(employee);
		return this;
	}

	public EmployeeManager removeEmployee(Employee employee) {
		this.employees.remove(employee);
		return this;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public EmployeeManager setEmployees(List<Employee> employees) {
		this.employees = employees;
		return this;
	}

	@Override
	public String toString() {
		return "\n\t\t\tEmployeeManager{" +
				"employees=" + employees +
				'}';
	}
}
