package hr.fer.zemris.java.custom.collections;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Test;


class ArrayIndexedCollectionTest {

	@Test
	void ConstructorTest1() {
		ArrayIndexedCollection collection = new ArrayIndexedCollection();
		assertEquals(0, collection.size());
	}
	
	@Test
	void ConstructorTest2() {
		Throwable throwable = assertThrows(IllegalArgumentException.class, ()-> new ArrayIndexedCollection(-1));
		assertEquals("Capacity is less than one", throwable.getMessage());
	}
	
	@Test
	void ConstructorTest3() {
		ArrayIndexedCollection other = new ArrayIndexedCollection();
		other.add("Ivan");
		other.add("Marko");
		other.add("Matej");
		other.add("Luka");
		ArrayIndexedCollection collection = new ArrayIndexedCollection(other);
		assertEquals(4, collection.size());
	}
	
	@Test
	void ConstructorTest4() {
		Throwable throwable = assertThrows(NullPointerException.class, ()-> new ArrayIndexedCollection(null, 14));
		assertEquals(null, throwable.getMessage());
	}
	
	@Test
	void getTest() {
		ArrayIndexedCollection collection = new ArrayIndexedCollection();
		collection.add("Ivan");
		collection.add("Marko");
		collection.add("Matej");
		collection.add("Luka");
		
		String name = (String) collection.get(2);
		assertEquals("Matej", name);
	}
	
	@Test
	void insertTest() {
		ArrayIndexedCollection collection = new ArrayIndexedCollection();
		collection.add("Ivan");
		collection.add("Marko");
		collection.add("Matej");
		collection.add("Luka");
				
		collection.insert("Štefica", 0);
		assertEquals("Štefica", collection.get(0));
		assertEquals("Ivan", collection.get(1));
		assertEquals("Marko", collection.get(2));
		assertEquals("Matej", collection.get(3));
		assertEquals("Luka", collection.get(4));
	
	}
	
	@Test
	void indexOfTest() {
		ArrayIndexedCollection collection = new ArrayIndexedCollection();
		collection.add("Ivan");
		collection.add("Marko");
		collection.add("Matej");
		collection.add("Luka");
		
		int index = collection.indexOf("Marko");
		assertEquals(1, index);
	}
	
	@Test
	void removeTest() {
		ArrayIndexedCollection collection = new ArrayIndexedCollection();
		collection.add("Ivan");
		collection.add("Marko");
		collection.add("Matej");
		collection.add("Luka");
		
		collection.remove(2);
		Object name = collection.get(2);
		assertEquals("Luka", name);
	}
	
	@Test
	void sizeTest() {
		ArrayIndexedCollection collection = new ArrayIndexedCollection();
		collection.add("Ivan");
		collection.add("Marko");
		collection.add("Matej");
		collection.add("Luka");
		
		int size = collection.size();
		assertEquals(4, size);
	}
	
	@Test
	void addTest1() {
		ArrayIndexedCollection collection = new ArrayIndexedCollection();
		collection.add("Ivan");
		collection.add("Marko");
		collection.add("Matej");
		collection.add("Luka");
		
		collection.add("Štefica");
		Object name = collection.get(4);
		assertEquals("Štefica", name);
	}
	
	@Test
	void addTest2() {
		ArrayIndexedCollection collection = new ArrayIndexedCollection(4);
		collection.add("Ivan");
		collection.add("Marko");
		collection.add("Matej");
		collection.add("Luka");
		
		collection.add("Štefica");
		
		int length = collection.size();
		String name = (String) collection.get(4);
		assertEquals("Štefica", name);
		assertEquals(5, length);
	}
	
	@Test
	void containsTest() {
		ArrayIndexedCollection collection = new ArrayIndexedCollection();
		collection.add("Ivan");
		collection.add("Marko");
		collection.add("Matej");
		collection.add("Luka");
		
		boolean contain = collection.contains("Matej");
		assertEquals(true, contain);
	}
	
	@Test
	void removeTest2() {
		ArrayIndexedCollection collection = new ArrayIndexedCollection();
		collection.add("Ivan");
		collection.add("Marko");
		collection.add("Matej");
		collection.add("Luka");
		
		collection.remove("Marko");
		
		String name = (String) collection.get(1);
		assertEquals("Matej", name);
	}
	
	@Test
	void toArrayTest() {
		ArrayIndexedCollection collection = new ArrayIndexedCollection();
		collection.add("Ivan");
		collection.add("Marko");
		collection.add("Matej");
		collection.add("Luka");
		
		Object[] array = collection.toArray();
		String name1 = (String) collection.get(2);
		String name2 = (String) array[2];
		assertEquals(name1, name2);
	}
	
	@Test
	void clearTest() {
		ArrayIndexedCollection collection = new ArrayIndexedCollection();
		collection.add("Ivan");
		collection.add("Marko");
		collection.add("Matej");
		collection.add("Luka");
		
		collection.clear();
		
		int size = collection.size();
		assertEquals(0, size);
	}	
}
