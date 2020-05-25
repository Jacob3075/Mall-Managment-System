package employee_managment;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import states.employee_state.EmployeeStates;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MallEmployeeTest {
	private static Employee mallEmployee;
	private static final String name = "Name";
	private static final int workingHours = 6;
	private static final int salary = 1000;
	private static final int age = 20;


	@BeforeAll
	static void beforeAll() {
		mallEmployee = new MallEmployee(
				name,
				age,
				salary,
				workingHours
		);
	}

	@BeforeEach
	void setUp() {
		mallEmployee = mallEmployee.setAge(age)
				.setSalary(salary)
				.setWorkingHours(workingHours)
				.work();
	}

	@Test
	void getterValidation() {
		assertEquals(age, mallEmployee.getAge());
		assertEquals(salary, mallEmployee.getSalary());
		assertEquals(workingHours, mallEmployee.getWorkingHours());
		assertEquals(EmployeeStates.WORKING, mallEmployee.getStatus());
	}

	@Test
	void settersValidation() {
		mallEmployee = mallEmployee.setAge(21)
				.setWorkingHours(8)
				.setSalary(2000)
				.paidLeave();
		System.out.println("mallEmployee = " + mallEmployee);
		assertEquals(21, mallEmployee.getAge());
		assertEquals(2000, mallEmployee.getSalary());
		assertEquals(0, mallEmployee.getWorkingHours());
		assertEquals(EmployeeStates.PAIDLEAVE, mallEmployee.getStatus());
	}

	@Test
	void paidLeaveTest() {
		mallEmployee = mallEmployee.paidLeave();
		assertEquals(age, mallEmployee.getAge());
		assertEquals(0, mallEmployee.getWorkingHours());
		assertEquals(salary, mallEmployee.getSalary());
		assertEquals(EmployeeStates.PAIDLEAVE, mallEmployee.getStatus());
	}

	@Test
	void unPaidLeaveTest() {
		mallEmployee = mallEmployee.unPaidLeave();
		assertEquals(age, mallEmployee.getAge());
		assertEquals(0, mallEmployee.getWorkingHours());
		assertEquals(0, mallEmployee.getSalary());
		assertEquals(EmployeeStates.UNPAIDLEAVE, mallEmployee.getStatus());
	}

	@Test
	void unEmployedTest() {
		mallEmployee = mallEmployee.unEmployed();
		assertEquals(age, mallEmployee.getAge());
		assertEquals(0, mallEmployee.getWorkingHours());
		assertEquals(0, mallEmployee.getSalary());
		assertEquals(EmployeeStates.UNEMPLOYED, mallEmployee.getStatus());
	}

	@Test
	void changingStateTest() {
		assertEquals(EmployeeStates.WORKING, mallEmployee.getStatus());
		mallEmployee = mallEmployee.paidLeave();
		assertEquals(EmployeeStates.PAIDLEAVE, mallEmployee.getStatus());
		mallEmployee = mallEmployee.unPaidLeave();
		assertEquals(EmployeeStates.UNPAIDLEAVE, mallEmployee.getStatus());
		mallEmployee = mallEmployee.unEmployed();
		assertEquals(EmployeeStates.UNEMPLOYED, mallEmployee.getStatus());
		mallEmployee = mallEmployee.paidLeave();
		assertEquals(EmployeeStates.UNEMPLOYED, mallEmployee.getStatus());
		mallEmployee = mallEmployee.unPaidLeave();
		assertEquals(EmployeeStates.UNEMPLOYED, mallEmployee.getStatus());
		mallEmployee = mallEmployee.work();
		assertEquals(EmployeeStates.WORKING, mallEmployee.getStatus());
	}
}