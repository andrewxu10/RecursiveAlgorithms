import java.awt.List;
import java.util.ArrayList;
import java.util.Arrays;

//palindrome decomposition / partitioning 
//dynamic programming solution (not written by me)
public class palindromePartitioning {

	
	public static void printRow(int[] row) {
        for (int i : row) {
            System.out.print(i);
            System.out.print("\t");
        }
        System.out.println();
    }

    public static void printGrid(int[][] table) {
        for(int[] row : table) {
            printRow(row);
        }
    }

	public static void main(String[] args) {
		
		String input = "ababa";
		int[][] table = new int[input.length()][input.length()];
		System.out.println(Arrays.toString(palinPartitioning(input, table).toArray()));
		
		printGrid(table);
		
		System.out.println();
		
		
	}
	
	public static ArrayList<String> palinPartitioning(String s, int[][] table) {
	 
		ArrayList<String> result = new ArrayList<String>();
	 
		if (s == null)
			return result;
	 
		if (s.length() <= 1) {
			result.add(s);
			return result;
		}
	 
		int length = s.length();
	 
		
	 
		// l is length, i is index of left boundary, j is index of right boundary
		for (int l = 1; l <= length; l++) {
			for (int i = 0; i <= length - l; i++) {
				int j = i + l - 1;
				if (s.charAt(i) == s.charAt(j)) {
					if (l == 1 || l == 2) {
						table[i][j] = 1;
					} else {
						table[i][j] = table[i + 1][j - 1];
					}
					if (table[i][j] == 1) {
						result.add(s.substring(i, j + 1));
					}
				} else {
					table[i][j] = 0;
				}
			}
		}
	 
		return result;
	}
}