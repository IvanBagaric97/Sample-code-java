package hr.fer.zemris.java.custom.collections;

/**
 * Exception thrown when stack is empty.
 * @author Ivan
 *
 */
public class EmptyStackException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5019575938076748881L;
	
	public EmptyStackException() {
		super();
	}
	
	public EmptyStackException(String message) {
		super(message);
	}
}
