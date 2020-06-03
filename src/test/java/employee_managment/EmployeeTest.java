package employee_managment;

import org.junit.jupiter.api.Test;
import states.employee_state.EmployeeStates;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class EmployeeTest {

	@Test
	void employeeCreationTest() {
		Employee.Builder builder = new Employee.Builder("name", 20);
		builder = builder.setSalary(5000);
		builder = builder.setWorkingHours(6);
		Employee shopEmployee = builder.employShopEmployee();
		assertTrue(shopEmployee instanceof ShopEmployee);
		assertEquals("name", shopEmployee.getName());
		assertEquals(20, shopEmployee.getAge());
		assertEquals(5000, shopEmployee.getSalary());
		assertEquals(6, shopEmployee.getWorkingHours());
		assertEquals(EmployeeStates.WORKING, shopEmployee.getStatus());

		builder = new Employee.Builder("name2", 21);
		builder = builder.setWorkingHours(7).setSalary(4000);
		Employee mallEmployee = builder.employMallEmployee();
		assertTrue(mallEmployee instanceof MallEmployee);
		assertEquals("name2", mallEmployee.getName());
		assertEquals(21, mallEmployee.getAge());
		assertEquals(4000, mallEmployee.getSalary());
		assertEquals(7, mallEmployee.getWorkingHours());
		assertEquals(EmployeeStates.WORKING, mallEmployee.getStatus());
	}
}
