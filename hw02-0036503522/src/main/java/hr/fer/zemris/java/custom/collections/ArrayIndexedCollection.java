package hr.fer.zemris.java.custom.collections;

/**
 * Resizable array-backed collection of objects. It can contain 
 * duplicate elements and can't contain null references.
 * 
 * @author Ivan
 *
 */
public class ArrayIndexedCollection extends Collection {
	/**
	 * Represents the number of elements stored in collection.
	 */
	private int size;
	/**
	 * Array of object references.
	 */
	private Object[] elements;
	
	/**
	 * Value that determines initial capacity of collection if the 
	 * user didn't specify the size.
	 */
	public static final int CAPACITY = 16;
	
	public ArrayIndexedCollection() {
		this(CAPACITY);
	}
	
	public ArrayIndexedCollection(int initialCapacity) {
		if(initialCapacity < 1) {
			throw new IllegalArgumentException("Capacity is less than one");
		}
		this.size = 0;
		this.elements = new Object[initialCapacity];
	}
	
	public ArrayIndexedCollection(Collection other) {	
		this(other, other.size());
	}
	
	public ArrayIndexedCollection(Collection other, int initialCapacitiy) {
		if(other == null) {
			throw new NullPointerException();
		}
		if(initialCapacitiy < 1) {
			throw new IllegalArgumentException("Capacity is less than one");
		}
		if(other.size() > initialCapacitiy) {
			this.elements = new Object[other.size()];
		}else {
			this.elements = new Object[initialCapacitiy];
		}
		addAll(other);
	}
	
	/**
	 * Method which doubles the size of the given array and 
	 * keeps all elements stored in it.
	 */
	public void doubleArraySize() {
		Object[] pom = new Object[this.elements.length];
		System.arraycopy(this.elements, 0, pom, 0, this.elements.length);
		this.elements = new Object[2*this.elements.length];
		System.arraycopy(pom, 0, this.elements, 0, pom.length);
	}
	
	/**
	 * Method which returns object stored at the location given with index.
	 * 
	 * @param index location of the object we want to return.
	 * @return object on location described with index.
	 * @throws IndexOutOfBoundsException if given index is not between 0 and size of collection -1.
	 */
	public Object get(int index) {
		if(index < 0 || index > this.size-1) {
			throw new IndexOutOfBoundsException();
		}
		return this.elements[index];
	}
	
	/**
	 * Inserts the given object at given position. Before insertion 
	 * all elements are shifted one place towards the end of array.
	 * 
	 * @param value object which is being inserted in collection.
	 * @param position represents the position in which we are inserting the value.
	 * @throws IndexOutOfBoundsException if position is not between 0 and size of collection-1.
	 */
	public void insert(Object value, int position) {
		if(position < 0 || position > this.size) {
			throw new IndexOutOfBoundsException();
		}
		if(position == this.size) {
			this.add(value);
		}else {
			if(this.elements.length == this.size) {
				this.doubleArraySize();
			}
			//shifting the array elements and making room for new value
			this.size++;
			for(int i=this.size-1; i>position; i--) {
				this.elements[i] = this.elements[i-1];
			}
			this.elements[position] = value;
		}
	}
	
	/**
	 * Searches collection and returns the index of the first occurrence 
	 * of the given value.
	 * 
	 * @param value object that method is searching in collection.
	 * @return index at which the first object that is equal to given value is stored.
	 */
	public int indexOf(Object value) {
		if(value == null) {
			return -1;
		}
		for(int i=0; i<this.size; i++) {
			if(this.elements[i].equals(value)) {
				return i;
			}
		}
		return -1;
	}
	
	/**
	 * Removes object stored in collection at position given with the index variable.
	 * 
	 * @param index represents the location of the object method wants to remove from collection.
	 * @throws IndexOutOfBoundsException if given index is not between 0 and size of collection-1.
	 */
	public void remove(int index) {
		if(index < 0 || index > this.size-1) {
			throw new IndexOutOfBoundsException();
		}
		for(int i=index; i<this.size; i++) {
			this.elements[i] = this.elements[i+1];
		}
		this.elements[this.size-1] = null;
		this.size--;
	}
	
	@Override
	public int size() {
		return this.size;
	}

	@Override
	public void add(Object value) {
		if(value == null) {
			throw new NullPointerException();
		}
		
		if(this.size == this.elements.length) {
			this.doubleArraySize();
		}
		
		this.elements[this.size] = value;
		this.size++;
	}

	@Override
	public boolean contains(Object value) {
		if(value == null) {
			return false;
		}
		for(Object o : this.elements) {
			if(o.equals(value)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean remove(Object value) {
		if(!this.contains(value)) {
			return false;
		}
		for(int i=0; i<this.size; i++) {
			if(this.elements[i].equals(value)) {
				remove(i);
				return true;
			}
		}
		return false;
	}

	@Override
	public Object[] toArray() {
		Object[] values = new Object[this.size];
		for(int i=0; i<this.size; i++) {
			values[i] = this.elements[i];
		}
		return values;
	}

	@Override
	public void forEach(Processor processor) {
		for(int i=0; i<this.size; i++) {
			processor.process(this.elements[i]);
		}
	}

	@Override
	public void clear() {
		for(int i=0; i<this.size; i++) {
			this.elements[i] = null;
		}
		this.size = 0;
	}
}
