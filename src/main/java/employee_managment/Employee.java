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

	class Builder {
		private final String name;
		private final int    age;
		private       int    salary;
		private       int    workingHours;

		public Builder(String name, int age) {
			this.name = name;
			this.age = age;
		}

		public Builder setSalary(int salary) {
			this.salary = salary;
			return this;
		}

		public Builder setWorkingHours(int workingHours) {
			this.workingHours = workingHours;
			return this;
		}

		public Employee employShopEmployee() {
			return new ShopEmployee(name, age, salary, workingHours);
		}

		public Employee employMallEmployee() {
			return new MallEmployee(name, age, salary, workingHours);
		}
	}
}
