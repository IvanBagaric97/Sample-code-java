package hr.fer.zemris.java.custom.collections;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;


class LinkedListIndexedCollectionTest {

	@Test
	void constructorTest1() {
		LinkedListIndexedCollection list = new LinkedListIndexedCollection();
		int size = list.size();
		assertEquals(0, size);
	}
	
	@Test
	void constructorTest2() {
		LinkedListIndexedCollection other = new LinkedListIndexedCollection();
		other.add("Ivan");
		other.add("Matej");
		other.add("Marko");
		other.add("Luka");
		
		LinkedListIndexedCollection list = new LinkedListIndexedCollection(other);
		int size = list.size();
		assertEquals(4, size);
	}
	
	@Test
	void indexOfTest() {
		LinkedListIndexedCollection collection = new LinkedListIndexedCollection();
		collection.add("Ivan");
		collection.add("Matej");
		collection.add("Marko");
		collection.add("Luka");
		
		int index = collection.indexOf("Marko");
		assertEquals(2, index);
	}
	
	@Test
	void getTest() {
		LinkedListIndexedCollection collection = new LinkedListIndexedCollection();
		collection.add("Ivan");
		collection.add("Matej");
		collection.add("Marko");
		collection.add("Luka");
		
		Object name = collection.get(2);
		assertEquals("Marko", name);
	}
	
	@Test
	void insertTest() {
		LinkedListIndexedCollection collection = new LinkedListIndexedCollection();
		collection.add("Ivan");
		collection.add("Matej");
		collection.add("Marko");
		collection.add("Luka");
		
		collection.insert("Štefica", 1);
		assertEquals("Štefica", collection.get(1));
		assertEquals("Matej", collection.get(2));
	}
	@Test
	void insertTest2() {
		LinkedListIndexedCollection collection = new LinkedListIndexedCollection();
		collection.add("Ivan");
		collection.add("Matej");
		collection.add("Marko");
		collection.add("Luka");
		
		collection.insert("Štefica", 0);
		assertEquals("Štefica", collection.get(0));
		assertEquals("Matej", collection.get(2));
	}
	
	@Test
	void insertTest3() {
		LinkedListIndexedCollection collection = new LinkedListIndexedCollection();
		collection.add("Ivan");
		collection.add("Matej");
		collection.add("Marko");
		collection.add("Luka");
		
		collection.insert("Štefica", 4);
		assertEquals("Štefica", collection.get(4));
		assertEquals("Marko", collection.get(2));
	}
	
	@Test
	void removeTest() {
		LinkedListIndexedCollection collection = new LinkedListIndexedCollection();
		collection.add("Ivan");
		collection.add("Matej");
		collection.add("Marko");
		collection.add("Luka");
		
		collection.remove(1);
		assertEquals("Ivan", collection.get(0));
		assertEquals("Marko", collection.get(1));
		assertEquals("Luka", collection.get(2));
	}
	
	@Test
	void sizeTest() {
		LinkedListIndexedCollection collection = new LinkedListIndexedCollection();
		collection.add("Ivan");
		collection.add("Matej");
		collection.add("Marko");
		collection.add("Luka");
		
		int size = collection.size();
		assertEquals(4, size);
	}
	
	@Test
	void containsTest() {
		LinkedListIndexedCollection collection = new LinkedListIndexedCollection();
		collection.add("Ivan");
		collection.add("Matej");
		collection.add("Marko");
		collection.add("Luka");
		
		boolean flag = collection.contains("Marko");
		assertEquals(true, flag);
	}
	
	@Test
	void removeTest2() {
		LinkedListIndexedCollection collection = new LinkedListIndexedCollection();
		collection.add("Ivan");
		collection.add("Matej");
		collection.add("Marko");
		collection.add("Luka");
		
		collection.remove("Matej");
		assertEquals("Ivan", collection.get(0));
		assertEquals("Marko", collection.get(1));
		assertEquals("Luka", collection.get(2));
	}
	
	@Test
	void containsToArray() {
		LinkedListIndexedCollection collection = new LinkedListIndexedCollection();
		collection.add("Ivan");
		collection.add("Matej");
		collection.add("Marko");
		collection.add("Luka");
		
		Object[] expected = {"Ivan", "Matej", "Marko", "Luka"};
		Object[] array = collection.toArray();
		assertArrayEquals(expected, array);
	}
	
	@Test
	void clearTest() {
		LinkedListIndexedCollection collection = new LinkedListIndexedCollection();
		collection.add("Ivan");
		collection.add("Matej");
		collection.add("Marko");
		collection.add("Luka");
		
		collection.clear();
		assertEquals(0, collection.size());
	}

}
