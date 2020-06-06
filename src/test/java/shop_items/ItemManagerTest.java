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
	private static int         revenue     = 0;

	@BeforeEach
	void setUp() {
		items = List.of(
				new ItemImpl("Item1", 20, 5),
				new ItemImpl("Item2", 30, 1),
				new ItemImpl("Item3", 25, 2)
		);
		itemManager = new ItemManager(List.copyOf(items));
		int revenue = 0;

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

		itemManager = itemManager.increaseItemCount("Item2", 5);
		assertEquals(
				6,
				itemManager.findItem("Item2").get().getCount()
		);

		itemManager = itemManager.removeItem("Item3");
		assertTrue(itemManager.findItem("Item3").isEmpty());
		assertTrue(itemManager.findItem("Item4").isEmpty());

		itemManager = itemManager.addItem(new ItemImpl("Item4", 10, 2));
		itemManager = itemManager.sellItems(
				"Item4",
				2,
				this::increaseRevenue
		);
		assertEquals(
				0,
				itemManager.findItem("Item4").get().getCount()
		);
		assertEquals(20, revenue);
	}

	private void increaseRevenue(int price) {
		revenue += price;
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
