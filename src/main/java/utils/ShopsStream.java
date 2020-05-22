package utils;

import shops.Shop;

import java.util.stream.Stream;

public class ShopsStream implements ForwardingStream<Shop> {

	private final Stream<Shop> stream;

	public ShopsStream(Stream<Shop> stream) {
		this.stream = stream;
	}

	@Override
	public Stream<Shop> getStream() {
		return this.stream;
	}

	public int totalUsedArea() {
		return this.getStream()
				.map(Shop::getShopFloorArea)
				.mapToInt(i -> i)
				.sum();
	}
}
