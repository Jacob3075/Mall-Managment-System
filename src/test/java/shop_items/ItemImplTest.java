package shop_items;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ItemImplTest {

	private static Item item = new ItemImpl("Item1", 20, 2);

	@Test
	void methodsTest() {
		assertEquals("Item1", item.getName());
		assertEquals(20, item.getPrice());
		assertEquals(2, item.getCount());
		item = item.addItem();
		assertEquals(3, item.getCount());
		item = item.addItems(2);
		assertEquals(5, item.getCount());
		item = item.sellItem();
		assertEquals(4, item.getCount());
		item = item.sellItems(4);
		assertEquals(0, item.getCount());
		assertThrows(
				UnsupportedOperationException.class,
				() -> item.sellItem()
		);
		item = item.setPrice(25);
		assertEquals(25, item.getPrice());
	}
}
