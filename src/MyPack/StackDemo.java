package MyPack;

import java.util.Scanner;

/**
 * In here i've created a class named StackDemo
 * @author Vishwas
 *
 */
public class StackDemo {
	
	/**
	 * Main method of this class
	 * @param args
	 */
	public static void main(String[] args) {
		// In here I'm taking scanner for input
		Scanner scanner = new Scanner(System.in);
		// Window console for stack size
		System.out.println(" Enter the Size of the stack");
		// size will be integer type 
		int size = scanner.nextInt();
		// In here i'm creating object
		FixedStack fixedStack = new FixedStack(size);
		VariableStack stack = new VariableStack(size);
		
		// Creating a while loop for implement FixedStack and Variable Stack.
		while (true) {
			System.out.println("Enter F to implement FixedStack and V to implement VariableStack");
			char ch = scanner.next().toCharArray()[0];
			// In here using switch case
			switch (ch) {
			case 'f':// in here using 'f' char for FixedStack
				while (true) {
					// window console for choice
					System.out.println("Enter 1 to push");
					System.out.println("Enter 2 to pop");
					System.out.println("Enter 3 to close");
					System.out.println("Enter your choice");
					int choice = scanner.nextInt();
					//using switch case for choice option  
					switch (choice) {
					case 1:
						System.out.println(" Enter a integer to push into stack");
						int push = scanner.nextInt();
						fixedStack.push(push);// inserting element into the array
						break;
					case 2:
						// deleting element from the array
						int item = fixedStack.pop();
						System.out.println("push item is :" + item);
						break;

					case 3:
						scanner.close();

					}
				}
			case 'V'://in here using 'V' char for VariableStack
				while (true) {
					// window console for choice
					System.out.println("Enter 1 to push");
					System.out.println("Enter 2 to pop");
					System.out.println("Enter 3 to close");
					System.out.println("Enter your choice");
					int choice = scanner.nextInt();
					// in here creating switch case
					switch (choice) {
					case 1:
						System.out.println("Enter a integer to push into stack");
						int push = scanner.nextInt();
						stack.push(push);

						break;
					case 2:
						int item = stack.pop();
						System.out.println("popped item is :" + item);
						break;

					case 3:
						scanner.close();

					}
				}
			default:
				scanner.close();

			}
		}
	}

}

/*
 creating a interface named Stack as mention in question.
 In the Interface declare two method void push() and int pop() as mention in question
*/
interface Stack {

	void push(int i);

	int pop();
}

/** 
 * In here creating class FixedStact as mention in question and 
 * also implements from Stack interface.
 */ 
class FixedStack implements Stack {

	int top = -1;// stack size from the top
	static int size;

	int[] stackItems;// integer array 

	public FixedStack(int size) {
		
		FixedStack.size = size;
		stackItems = new int[size];// initializing length of the array
	}

	@Override
	public void push(int i) {
		
		if (top < size) {// if else statement

			top = top + 1;// inserting element at the top
			stackItems[top] = i;
			System.out.println("top value" + top);
			System.out.println("size value" + size);
			System.out.println("Item saved " + stackItems[top] + "\n");
		} else {
			System.out.println("STACK OVERFLOW" + "\n");//window console for OVERFLOW.

		}

	}

	@Override
	public int pop() {
		

		int item;
		if (top < 0) {
			System.out.println("No item for popped out" + "\n");
			return 0;

		} else {

			item = stackItems[top];
			top = top - 1;// deleting element
			return item;// return type
		}

	}

}
/**
 *  In here creating class VariableStack as mention in question and 
 * also implements from Stack interface.
 */ 

class VariableStack implements Stack {

	int top = -1;// stack size from the top
	static int size;

	int[] stackItems;// integer array

	public VariableStack(int size) {
		
		this.size = size;
		stackItems = new int[size];
	}

	@Override
	public void push(int i) {
		

		if (top < size) {

			top = top + 1;
			stackItems[top] = i;
			System.out.println("top value" + top);
			System.out.println("size value" + size);
			System.out.println("Item saved " + stackItems[top] + "\n");
		} else if (top >= size) {

			stackItems = new int[size * 2];
			top = top + 1;
			stackItems[top] = i;
			System.out.println("top value" + top);
			System.out.println("size value" + size);
			System.out.println("Item saved " + stackItems[top] + "\n");

		}

	}

	@Override
	public int pop() {

		int item;
		if (top < 0) {
			System.out.println("No item for popped out" + "\n");
			return 0;

		} else {

			item = stackItems[top];
			top = top - 1;// deleting element
			return item;// return type
		}

	}

}
