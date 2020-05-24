package utils;

import employee_managment.Employee;
import states.employee_state.EmployeeStates;

import java.util.stream.Stream;

public class EmployeeStream implements ForwardingStream<Employee> {

	private final Stream<Employee> stream;

	public EmployeeStream(Stream<Employee> stream) {
		this.stream = stream;
	}

	@Override
	public Stream<Employee> getStream() {
		return this.stream;
	}

	public EmployeeStream filterByStatus(EmployeeStates status) {
		return new EmployeeStream(
				this.filter(employee -> employee.getStatus() == status)
		);
	}

}
