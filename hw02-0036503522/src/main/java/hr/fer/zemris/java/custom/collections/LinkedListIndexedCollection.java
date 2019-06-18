package hr.fer.zemris.java.custom.collections;

/**
 * Linked list-backed collection of objects. It can contain 
 * duplicate elements and can't contain null references.
 * 
 * @author Ivan
 *
 */
public class LinkedListIndexedCollection extends Collection {
	
	/**
	 * Private class that represents data structure 
	 * used to build linked list. Every instance of this class 
	 * contains stored value and reference to previous and 
	 * next instance of the same class.
	 * 
	 * @author Ivan
	 *
	 */
	private static class ListNode{
		ListNode previous;
		ListNode next;
		Object value;
	}
	
	/**
	 * Current size of elements stored in collection,
	 */
	private int size;
	/**
	 * First ListNode in the collection.
	 */
	private ListNode first;
	/**
	 * Last List node in the collection.
	 */
	private ListNode last;
	
	public LinkedListIndexedCollection() {
		this.first = null;
		this.last = null;
		this.size = 0;
	}
	
	public LinkedListIndexedCollection(Collection other) {
		if(other == null) {
			throw new NullPointerException();
		}
		this.addAll(other);
	}
	
	/**
	 * Searches the collection and returns the index of the first 
	 * occurrence of the given value.
	 * @param value object whose index method returns.
	 * @return the index of the first occurrence of the given 
	 * value or -1 if the value is not found.
	 * 
	 */
	public int indexOf(Object value) {
		ListNode list = this.first;
		if(value == null) {
			return -1;
		}
		for(int i=0; i<this.size; i++) {
			if(list.value.equals(value)) {
				return i;
			}
			list = list.next;
		}
		return -1;
	}
	
	/**
	 * Method which finds and returns the object stored at the given index.
	 * Has complexity that is never greater than n/2+1.
	 * 
	 * @param index location of the wanted object.
	 * @return object stored at given index.
	 * @throws IndexOutOfBoundsException if index is not between 0 and size of collection-1.
	 */
	public Object get(int index) {
		if(index < 0 || index > this.size-1) {
			throw new IndexOutOfBoundsException();
		}		//from first
		if(this.size-index > index) {
			ListNode list = this.first;
			for(int i=0; i<index+1; i++) {
				if(i == index) {
					return list.value;
				}
				list = list.next;
			}
		}else {//from last
			ListNode list = this.last;
			for(int i=this.size-1; i > index-1; i--) {
				if(i == index) {
					return list.value;
				}
				list = list.previous;
			}
		}
		return null;
	}
	
	/**
	 * Inserts the given value at given position in backed-list. 
	 * Elements are shifted one position so all values are saved.
	 * 
	 * @param value object which is inserted in backed-list.
	 * @param position represents index at which the value is inserted.
	 * @throws IndexOutOfBoundsException if position is not between 0 and size-1.
	 */
	public void insert(Object value, int position) {
		if(position < 0 || position > this.size) {
			throw new IndexOutOfBoundsException();
		}
		ListNode newList = new ListNode();
		newList.value = value;
		ListNode pom = this.first;
		if(position == 0) {
			pom.previous = newList;
			newList.next = pom;
			this.first = newList;
			this.size++;
			return;
		}
		if(position == this.size) {
			pom = this.last;
			pom.next = newList;
			newList.previous = pom;
			this.last = newList;
			this.size++;
			return;
		}
		for(int i=0; i<this.size; i++) {
			if(i == (position-1)) {
				ListNode pom2 = pom.next;
				pom2.previous = newList;
				pom.next = newList;
				newList.previous = pom;
				newList.next = pom2;
				this.size++;
				break;
			}
			pom = pom.next;
		}
	}
	
	/**
	 * Removes element at specified index from collection.
	 * All element are shifted after removal so the functionality 
	 * of backed-list is preserved.
	 * 
	 * @param index position of the object the method is removing.
	 * @throws if index is not between 0 and size-1.
	 */
	public void remove(int index) {
		if(index < 0 || index > this.size-1) {
			throw new IndexOutOfBoundsException();
		}
		ListNode pom = this.first;
		if(index == 0) {
			ListNode pom2 = pom.next;
			pom = null;
			this.first = pom2;
			return;
		}
		if(index == this.size-1) {
			pom = this.last;
			ListNode pom2 = pom.previous;
			pom = null;
			pom2.next = null;
			this.last = pom2;
			return;
		}
		for(int i=0; i<index+1; i++) {
			if(i == index-1) {
				ListNode pom2 = pom.next.next;
				pom.next = pom2;
				pom2.previous = pom;
				this.size--;
			}
			pom = pom.next;
		}
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
		if(this.isEmpty()) {
			ListNode newValue = new ListNode();
			newValue.value = value;
			this.first = newValue;
			this.last = newValue;
			this.size++;
		}else {
			ListNode newValue = new ListNode();
		
			newValue.value = value;
			newValue.previous = this.last;
			this.last.next = newValue;
			this.last = newValue;
			this.size++;
		}
	}

	@Override
	public boolean contains(Object value) {
		ListNode pom = this.first;
		if(value == null) {
			throw new NullPointerException();
		}
		for(int i=0; i<this.size; i++) {
			if(pom.value.equals(value)) {
				return true;
			}
			pom = pom.next;
		}
		return false;
	}

	@Override
	public boolean remove(Object value) {
		ListNode pom = this.first;
		if(!this.contains(value)) {
			return false;
		}
		for(int i=0; i<this.size; i++) {
			if(pom.value.equals(value)) {
				remove(i);
			}
			pom = pom.next;
		}
		return false;
	}

	@Override
	public Object[] toArray() {
		Object[] array = new Object[this.size];
		ListNode pom = this.first;
		for(int i=0; i<this.size; i++) {
			array[i] = pom.value;
			pom = pom.next;
		}
		return array;
	}

	@Override
	public void forEach(Processor processor) {
		ListNode pom = this.first;
		for(int i=0; i<this.size; i++) {
			processor.process(pom.value);
			pom = pom.next;
		}
	}

	@Override
	public void clear() {
		this.first = null;
		this.last = null;
		this.size = 0;
	}
}
