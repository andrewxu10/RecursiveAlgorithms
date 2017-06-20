//count trees takes an integer n and decides how many unique trees could be constructed with n nodes
public class countTrees {
	
	public static void main(String[] args) {
		System.out.println(treeCount(10));
	}
	
	public static int treeCount(Integer n) {
		if (n == 3) {
			return 5;
		}
		if (n == 2) {
			return 2;
		}
		if (n == 1 || n == 0) {
			return 1;
		}		
		int total = 0;		
		for (int i = 1; i <= n; i++) {
				//int a = n - i;
				//int b = n - a - 1;
				total += treeCount(n - i) * treeCount(n - (n-i) - 1); //tC(a) * tC(b)
		}
		return total;
	}
}
