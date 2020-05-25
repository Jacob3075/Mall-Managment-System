package employee_managment;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import states.employee_state.EmployeeStates;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MallEmployeeTest {
	private static Employee mallEmployee;

	@BeforeAll
	static void beforeAll() {
		mallEmployee = new MallEmployee(
				"Name",
				20,
				1000,
				7
		);
	}

	@Test
	void getterValidation() {
		mallEmployee = new MallEmployee(
				"Name",
				20,
				1000,
				7
		);
		assertEquals(20, mallEmployee.getAge());
		assertEquals(1000, mallEmployee.getSalary());
		assertEquals(7, mallEmployee.getWorkingHours());
		assertEquals(EmployeeStates.WORKING, mallEmployee.getStatus());
	}

	@Test
	void settersValidation() {
		mallEmployee = mallEmployee.setAge(21)
				.setSalary(2000)
				.setWorkingHours(8)
				.paidLeave();
		assertEquals(21, mallEmployee.getAge());
		assertEquals(2000, mallEmployee.getSalary());
		assertEquals(8, mallEmployee.getWorkingHours());
		assertEquals(EmployeeStates.PAIDLEAVE, mallEmployee.getStatus());
	}

	@Test
	void paidLeaveTest() {

	}

	@Test
	void unPaidLeaveTest() {

	}

	@Test
	void unEmployedTest() {

	}

}