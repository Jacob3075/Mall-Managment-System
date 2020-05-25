package employee_managment;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EmployeeManagerTest {

	private static EmployeeManager employeeManager;
	private static List<Employee> employees;

	@BeforeEach
	void setUp() {
		employees = List.of(
				new ShopEmployee("Employee1", 20, 1000, 7),
				new ShopEmployee("Employee2", 20, 1000, 7),
				new ShopEmployee("Employee3", 20, 1000, 7)
		);

		employeeManager = new EmployeeManager(new ArrayList<>(employees));
	}

	@Test
	void methodsTest() {
		assertEquals(3, employeeManager.getEmployees().size());
		employeeManager = employeeManager.addEmployee(
				new ShopEmployee(
						"Employee4",
						20,
						1000,
						7
				)
		);
		assertEquals(4, employeeManager.getEmployees().size());
		employeeManager.removeEmployee(employees.get(2));
		assertEquals(3, employeeManager.getEmployees().size());

	}
}