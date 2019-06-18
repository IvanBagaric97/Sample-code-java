package hr.fer.zemris.java.custom.collections;


/**
 * Class that represents general collection of objects
 * 
 * @author Ivan
 *
 */
public class Collection {
	
	/**
	 * Method that determines is the given 
	 * collection empty or not.
	 * 
	 * @return true if given collection is empty and false otherwise
	 */
	public boolean isEmpty() {
		if(this.size() == 0) {
			return true;
		}else {
			return false;
		}
	}
	
	/**
	 * Method that returns number of objects in given collection.
	 * 
	 * @return number of object currently stored in collection.
	 */
	public int size() {
		return 0;
	}
	
	/**
	 * Method that adds given object into the collection.
	 * 
	 * @param value object which method adds in collection.
	 */
	public void add(Object value) {
		
	}
	
	/**
	 * Method that determines if the collection
	 * contains the given object.
	 * 
	 * @param value object for which method checks is it stored in collection.
	 * @return true if the value is stored in collection, false otherwise.
	 */
	public boolean contains(Object value) {
		return false;
	}
	
	/**
	 * Removes the given object from collection.
	 * @param value object which we want to remove.
	 * @return true if object is successfully removed, false otherwise.
	 */
	public boolean remove(Object value) {
		return false;
	}
	
	/**
	 * Method that transfers all objects from collection to 
	 * array and keeps collection unchanged.
	 * 
	 * @return array that contains all objects stored in given collection.
	 */
	public Object[] toArray() {
		throw new UnsupportedOperationException();
	}
	
	/**
	 * Method that executes operation defined by processor on all 
	 * objects stored in collection.
	 * 
	 * @param processor object that contains the implementation of method 
	 * process which determines what action is being executed on all objects 
	 * stored in collection.
	 */
	public void forEach(Processor processor) {
		
	}
	
	/**
	 * Method which adds all elements of one collection to the other collection. 
	 * Other collection remains unchanged.
	 * 
	 * @param other collection that is copied into the given collection.
	 */
	public void addAll(Collection other) {
		Processor processor = new Processor() {
			@Override
			public void process(Object value) {
				add(value);
			}
		};
		other.forEach(processor);
	}
	
	/**
	 * Removes all elements from collection.
	 */
	public void clear() {
		
	}
}
