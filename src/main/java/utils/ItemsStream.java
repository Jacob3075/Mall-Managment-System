package utils;

import shop_items.Item;

import java.util.Comparator;
import java.util.List;
import java.util.function.ToIntFunction;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ItemsStream implements ForwardingStream<Item> {

	private final Stream<Item> itemStream;

	public ItemsStream(Stream<Item> itemStream) {
		this.itemStream = itemStream;
	}

	@Override
	public Stream<Item> getStream() {
		return this.itemStream;
	}

	public List<Item> itemsInStock() {
		return this.getStream()
		           .filter(item -> item.getCount() > 0)
		           .collect(Collectors.toList());
	}

	public ItemsStream sortItemsBy(ToIntFunction<Item> comparingBy) {
		return new ItemsStream(
				this.getStream()
				    .sorted(Comparator.comparingInt(comparingBy))
		);
	}
}
