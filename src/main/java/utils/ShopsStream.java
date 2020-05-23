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
		return this.mapToInt(Shop::getShopUsedArea).sum();
	}

	public int getRevenue() {
		return this.mapToInt(Shop::getRevenue).sum();
	}

	public int getTotalUsedSpace() {
		return this.mapToInt(Shop::getShopUsedArea).sum();
	}
}
