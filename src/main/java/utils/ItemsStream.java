package utils;

import shop_items.Item;

import java.util.Optional;
import java.util.stream.Stream;

public class ItemsStream implements ForwardingStream<Item> {

	private final Stream<Item> itemStream;

	public ItemsStream(Stream<Item> itemStream) {
		this.itemStream = itemStream;
	}

	public Optional<Item> findItem(String itemName) {
		return this.getStream().filter(item -> item.getName().equals(itemName)).findFirst();
	}

	@Override
	public Stream<Item> getStream() {
		return this.itemStream;
	}

}
