package utils;

import floor.Floor;

import java.util.Collection;
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
		return this.mapToInt(Floor::getRevenue);
	}

	public int getTotalFloorsArea() {
		return this.mapToInt(Floor::getTotalSpace).sum();
	}

	public int getFloorsUsedArea() {
		return this.mapToInt(Floor::getTotalUsedSpace).sum();
	}

	public int getTotalFreeSpace() {
		return this.getTotalFloorsArea() - this.getFloorsUsedArea();
	}

	public FloorsStream filterByArea(int area) {
		return new FloorsStream(this.getStream()
				.filter(floor -> floor.getTotalUsedSpace() < area)
		);
	}

	public ShopsStream getShops() {
		return new ShopsStream(this
				.map(Floor::getShops)
				.flatMap(Collection::stream)
		);
	}

}
