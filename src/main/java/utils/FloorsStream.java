package utils;

import floor.Floor;
import java.util.stream.Stream;

public class FloorsStream implements ForwardingStream<Floor> {

	private Stream<Floor> stream;


	public FloorsStream(Stream<Floor> stream) {
		this.stream = stream;
	}

	@Override
	public Stream<Floor> getStream() {
		return this.stream;
	}

	public Stream<Floor> newStream() {
		return this.stream;
	}
}
