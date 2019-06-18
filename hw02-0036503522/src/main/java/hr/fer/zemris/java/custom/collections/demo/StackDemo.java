package hr.fer.zemris.java.custom.collections.demo;

import hr.fer.zemris.java.custom.collections.ObjectStack;

/**
 * Class used to demonstrate the usage of ObjectStack 
 * class and its methods. This class accepts single command-line 
 * argument witch is String representation of expression 
 * witch should be evaluated.
 * 
 * @author Ivan
 *
 */
public class StackDemo {
	
	/**
	 * Method witch performs the given operation between two values.
	 * @param operation operation witch is being performed.
	 * @param value1 and value2 are values on which the operation is executed.
	 * @return result given by performing operation on two values.
	 * @throws IllegalArgumentException if user tries to divide with 0.
	 * 
	 */
	public static Integer performOperation(String operation, Integer value1, Integer value2) {
		if(operation.equals("/")) {
			if(value2 == 0) {
				System.err.println("Can't divide with 0, expression in invalid");
				System.exit(1);
			}
			return value1/value2;
		}else if(operation.equals("+")) {
			return value1+value2;
		}else if(operation.equals("-")) {
			return value1-value2;
		}else if(operation.equals("*")) {
			return value1*value2;
		}else if(operation.equals("%")) {
			return value1%value2;
		}else {
			System.err.println("The expression is invalid");
			System.exit(1);
			return 0;
		}
	}
	
	/**
	 * Checks if the given expression is appropriate for usage in postfix representation.
	 * @param input expression given trough the command line.
	 * @return true if the expression is appropriate, false otherwise.
	 */
	public static boolean isAppropriate(String[] input) {
		int numberCounter = 0;
		int operationCounter = 0;
		for(String s : input) {
			if(s.equals(" ") || s.equals("")) {
				continue;
			}
			if("-0-1-2-3-4-5-6-7-8-9".contains(s) && !(s.equals("-"))) {
				numberCounter++;
			}else {
				operationCounter++;
				if(operationCounter >= numberCounter) {
					return false;
				}
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		if(args.length != 1) {
			System.err.println("Number of arguments must be 1");
			System.exit(0);
		}
		ObjectStack stack = new ObjectStack();
		String[] values = args[0].split(" ");
		if(!isAppropriate(values)) {
			System.err.println("The expression is invalid");
			System.exit(1);
		}
		for(String s : values) {
			if(s.equals(" ") || s.equals("")) {
				continue;
			}else {
				if("-0-1-2-3-4-5-6-7-8-9".contains(s) && !(s.equals("-"))) {
					Integer value = Integer.parseInt(s);
					stack.push(value);
					continue;
				}else {
					Integer value2 = (Integer) stack.pop();
					Integer value1 = (Integer) stack.pop();
					Integer result = performOperation(s, value1, value2);
					stack.push(result);
				}
			}
		}
		if(stack.size() != 1) {
			System.err.println("Error, size of stack is greather than one");
			System.exit(0);
		}else {
			System.out.println(stack.pop());
		}
	}
	
}
