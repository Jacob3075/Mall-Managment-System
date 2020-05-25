package employee_managment;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import states.employee_state.EmployeeStates;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ShopEmployeeTest {
	private static final String name = "Name";
	private static final int workingHours = 6;
	private static final int salary = 1000;
	private static final int age = 20;
	private static Employee shopEmployee;

	@BeforeAll
	static void beforeAll() {
		shopEmployee = new MallEmployee(
				name,
				age,
				salary,
				workingHours
		);
	}

	@BeforeEach
	void setUp() {
		shopEmployee = shopEmployee.setAge(age)
				.setSalary(salary)
				.setWorkingHours(workingHours)
				.work();
	}

	@Test
	void getterValidation() {
		assertEquals(age, shopEmployee.getAge());
		assertEquals(salary, shopEmployee.getSalary());
		assertEquals(workingHours, shopEmployee.getWorkingHours());
		assertEquals(EmployeeStates.WORKING, shopEmployee.getStatus());
	}

	@Test
	void settersValidation() {
		shopEmployee = shopEmployee.setAge(21)
				.setWorkingHours(8)
				.setSalary(2000)
				.paidLeave();
		System.out.println("mallEmployee = " + shopEmployee);
		assertEquals(21, shopEmployee.getAge());
		assertEquals(2000, shopEmployee.getSalary());
		assertEquals(0, shopEmployee.getWorkingHours());
		assertEquals(EmployeeStates.PAIDLEAVE, shopEmployee.getStatus());
	}

	@Test
	void paidLeaveTest() {
		shopEmployee = shopEmployee.paidLeave();
		assertEquals(age, shopEmployee.getAge());
		assertEquals(0, shopEmployee.getWorkingHours());
		assertEquals(salary, shopEmployee.getSalary());
		assertEquals(EmployeeStates.PAIDLEAVE, shopEmployee.getStatus());
	}

	@Test
	void unPaidLeaveTest() {
		shopEmployee = shopEmployee.unPaidLeave();
		assertEquals(age, shopEmployee.getAge());
		assertEquals(0, shopEmployee.getWorkingHours());
		assertEquals(0, shopEmployee.getSalary());
		assertEquals(EmployeeStates.UNPAIDLEAVE, shopEmployee.getStatus());
	}

	@Test
	void unEmployedTest() {
		shopEmployee = shopEmployee.unEmployed();
		assertEquals(age, shopEmployee.getAge());
		assertEquals(0, shopEmployee.getWorkingHours());
		assertEquals(0, shopEmployee.getSalary());
		assertEquals(EmployeeStates.UNEMPLOYED, shopEmployee.getStatus());
	}

	@Test
	void changingStateTest() {
		assertEquals(EmployeeStates.WORKING, shopEmployee.getStatus());
		shopEmployee = shopEmployee.paidLeave();
		assertEquals(EmployeeStates.PAIDLEAVE, shopEmployee.getStatus());
		shopEmployee = shopEmployee.unPaidLeave();
		assertEquals(EmployeeStates.UNPAIDLEAVE, shopEmployee.getStatus());
		shopEmployee = shopEmployee.unEmployed();
		assertEquals(EmployeeStates.UNEMPLOYED, shopEmployee.getStatus());
		shopEmployee = shopEmployee.paidLeave();
		assertEquals(EmployeeStates.UNEMPLOYED, shopEmployee.getStatus());
		shopEmployee = shopEmployee.unPaidLeave();
		assertEquals(EmployeeStates.UNEMPLOYED, shopEmployee.getStatus());
		shopEmployee = shopEmployee.work();
		assertEquals(EmployeeStates.WORKING, shopEmployee.getStatus());
	}
}