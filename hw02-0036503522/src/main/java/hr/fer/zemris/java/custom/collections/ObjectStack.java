package hr.fer.zemris.java.custom.collections;

/**
 * Class that represents stack and uses {@link ArrayIndexedCollection} to 
 * implement the needed functionality. 
 * 
 * @author Ivan
 *
 */
public class ObjectStack {
	
	/**
	 * Resizable array-backed collection used to implement the stack.
	 * 
	 */
	private ArrayIndexedCollection stack;
	
	public ObjectStack() {
		this.stack = new ArrayIndexedCollection();
	}
	
	/**
	 * 
	 * Method that determines is the given 
	 * stack empty or not.
	 * 
	 * @return true if given stack is empty and false otherwise
	 *
	 */
	public boolean isEmpty() {
		return this.stack.isEmpty();
	}
	
	/**
	 * Method that returns number of objects in given collection.
	 * 
	 * @return number of object currently stored in collection.
	 */
	public int size() {
		return this.stack.size();
	}
	
	/**
	 * Pushes given value on the stack.
	 * @param value
	 * @throws NullPointerException if the given value is null.
	 */
	public void push(Object value) {
		if(value == null) {
			throw new NullPointerException();
		}
		this.stack.insert(value, 0);
	}
	
	/**
	 * Removes last value pushed on stack and returns it.
	 * @return removed value from top of the stack.
	 * @throws EmptyStackException when the method is called but the stack is empty.
	 */
	public Object pop() {
		if(this.stack.isEmpty()) {
			throw new EmptyStackException();
		}
		Object value = this.stack.get(0);
		this.stack.remove(0);
		return value;
	}
	
	/**
	 * Removes the last element pushed on stack and returns it bud doesn't 
	 * delete it from the stack.
	 * @return element that is stored on top of the stack.
	 * @throws EmptyStackException if the method is called but the stack is empty.
	 */
	public Object peek(){
		if(this.stack.isEmpty()) {
			throw new EmptyStackException();
		}
		return this.stack.get(0);
	}
	
	/**
	 * Removes all elements from the stack.
	 */
	public void clear() {
		this.stack.clear();
	}
	
	
}
