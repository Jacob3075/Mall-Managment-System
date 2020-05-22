package utils;

import floor.Floor;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class FloorsStream implements ForwardingStream<Floor> {

	private final Stream<Floor> stream;

	public FloorsStream(Stream<Floor> stream) {
		this.stream = stream;
	}

	@Override
	public Stream<Floor> getStream() {
		return this.stream;
	}

	public IntStream getFloorsRevenue() {
		return this.getStream()
				.map(Floor::getRevenue)
				.mapToInt(revenue -> revenue);
	}

	public IntStream getFloorsArea() {
		return this.getStream()
				.map(Floor::getTotalUsedSpace)
				.mapToInt(usedSpace -> usedSpace);
	}

	public FloorsStream filterByArea(int area) {
		return new FloorsStream(this.getStream()
				.filter(floor -> floor.getTotalUsedSpace() < area)
		);
	}

}
