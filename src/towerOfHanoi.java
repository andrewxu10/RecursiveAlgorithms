import java.util.Arrays;
import java.util.Stack;

public class towerOfHanoi {
	
	public static void main (String args[]) {
		Stack<Integer> original = new Stack<Integer>();
		original.push(5);
		original.push(4);
		original.push(3);
		original.push(2);
		original.push(1);
		System.out.println("Original : " + Arrays.toString(original.toArray()));
		System.out.println();
		
		Stack<Integer> destination = new Stack<Integer>();
		Stack<Integer> temporary = new Stack<Integer>();
		moveTower(5, original, destination, temporary);
		System.out.println("Final : " + Arrays.toString(destination.toArray()));
	}
	
	public static void moveTower (int N, Stack<Integer> original, Stack<Integer> destination, Stack<Integer> temporary) {
		if (N == 1) {
			original.pop();
			destination.push(1);
		}
		
		if (N > 1) {
			System.out.println("Step: " + N);
			System.out.println(Arrays.toString(original.toArray()));
			System.out.println(Arrays.toString(destination.toArray()));
			System.out.println(Arrays.toString(temporary.toArray()));
			System.out.println();
			
			moveTower(N - 1, original, temporary, destination);
			Integer var = original.pop();
			destination.push(var);
			moveTower(N-1, temporary, destination, original);
		}
	}

}
