package utils;

import employee_managment.Employee;

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

}
