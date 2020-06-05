package shop_items;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ItemManagerTest {

	private static List<Item>  items       = List.of(
			new ItemImpl("Item1", 20, 5),
			new ItemImpl("Item3", 30, 1),
			new ItemImpl("Item2", 25, 2)
	);
	private static ItemManager itemManager = new ItemManager(List.copyOf(items));

	@BeforeEach
	void setUp() {
		items = List.of(
				new ItemImpl("Item1", 20, 5),
				new ItemImpl("Item2", 30, 1),
				new ItemImpl("Item3", 25, 2)
		);
		itemManager = new ItemManager(List.copyOf(items));
	}

	@Test
	void methodsTest() {
		assertEquals(items, itemManager.getItems());
		itemManager = itemManager.increaseItemCount("Item1");
		assertEquals(
				6,
				itemManager.findItem("Item1").get().getCount()
		);
		assertThrows(
				InvalidParameterException.class,
				() -> itemManager.increaseItemCount("Item4")
		);

	}

	@Test
	void testSortMethods() {
		ArrayList<Item> itemArrayList = new ArrayList<>(ItemManagerTest.items);
		itemArrayList.sort(Comparator.comparing(Item::getCount));
		List<Item> items1 = List.copyOf(itemArrayList);
		assertEquals(items1, itemManager.getItemsSortedBy(Item::getCount));
		assertNotEquals(items, itemManager.getItemsSortedBy(Item::getCount));

		itemArrayList = new ArrayList<>(ItemManagerTest.items);
		itemArrayList.sort(Comparator.comparing(Item::getPrice));
		items1 = List.copyOf(itemArrayList);
		assertEquals(items1, itemManager.getItemsSortedBy(Item::getPrice));
		assertNotEquals(items, itemManager.getItemsSortedBy(Item::getPrice));

	}
}
