import java.awt.List;
import java.util.ArrayList;
import java.util.Arrays;

//palindromic decomposition breaks down a string into substrings that are all palindromes
public class palindromicDecomposition {
	
	public static void palin(String process, String left, ArrayList<String> list) {
		if(left.length() == 0) {
			if(isPalin(process) || process.length() == 0) {
				list.add(process);
				System.out.println("Solution: " + Arrays.toString(list.toArray()));
			}
		} else if(isPalin(process)) {
			if(left.length() != 0) {
				ArrayList<String> list2 = new ArrayList<String>();
				list2.addAll(list);
				palin(process + left.charAt(0), left.substring(1, left.length()), list2); //process++, left--, list
				list.add(process);
				palin(String.valueOf(left.charAt(0)), left.substring(1, left.length()), list); //left.(0), left--, list++
			}
		} else if (!isPalin(process) && left.length() > 0) {
			palin(process + left.charAt(0), left.substring(1, left.length()), list);
		}
	}
	
	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<String>();
		palin("", "asabadfdabasa", list);
	}
	
	public static boolean isPalin(String s) {
		if(s.equals("")){
			return false;
		}
		if(s.length() == 1) {
			return true;
		}
		if(s.equals(new StringBuffer(s).reverse().toString())){
			return true;
		} else {
			return false;
		}
	}
	
	//debug helpers
	//System.out.println("Processing: " + process);
	//System.out.println("Function1: " + process + left.charAt(0) + "," + left.substring(1, left.length()) + "," + Arrays.toString(list2.toArray()));
	//System.out.println("Function2: " + left.charAt(0) + "," + left.substring(1, left.length()) + "," + Arrays.toString(list.toArray()));
	//System.out.println();
}
