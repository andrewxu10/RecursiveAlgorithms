//This program takes an integer 'n' and creates an n*n Chess board. It then prints all of the combinations where n queens can be placed on the board
public class nQueens {

	public static void main(String[] args) {
		boolean[][] board = new boolean[5][5];
		board[2][1] = true;
		
//		System.out.println(placeable(3,2,board));
//		System.out.println(placeable(0,1,board));
//		System.out.println(placeable(0,2,board));
//		
//		System.out.println(placeable(1,0,board));
//		System.out.println(placeable(1,2,board));
//		
//		System.out.println(placeable(2,0,board));
		System.out.println(placeable(3,4,board));
		System.out.println(placeable(4,3,board));
		
		printGrid(board);
		recursion(0,0,board);
	}
	
	public static int recursion(int pX, int pY, boolean[][] board) {
		for (int x = pX; x <= board.length; x++) { //going horiz 0 -> board.length
			//base case - print board if done
			if(x == board.length) {
				printGrid(board);
				return 1;
			}
			for (int y = pY; y < board.length; y++) { //going down vert 0 -> board.length
				//if placeable, recurse, place, recurse again
				if(placeable(y, x, board)) {
					//make board clone
					recursion(x, y+1, board); //recurse with board clone
					//add to board, continue
				} else {System.out.println("HIII");}
			}
		}
		return 1;
	}
	
	public static boolean placeable(int pX, int pY, boolean[][] board) { //Y,X input
		if (board[pX][pY]) { //check if spot occupied
			return false;
		}
		for (int a = 0; a < board.length; a++) { //check vertical + horizontal moves
			if (board[pX][a] || board[a][pY]) {
				return false;
			}
		}
		//lets go diagonal (RIGHT)
		int c = pY; //up
		int d = pY; //down
		for (int b = pX+1; b < board.length; b++) { //b-x .... c-y1 (up) .... d-y2 (down)
			c++;
			d--;
			if (c < board.length) { //lets not go out of bounds
				if (board[b][c]) { //go right of piece, check diagonal up&down
					return false;
				}
			}
			if (d >= 0) { //lets not go out of bounds
				if (board[b][d]) { //go right of piece, check diagonal up&down
					return false;
				}
			}
		}
		//lets go diagonal (LEFT)
		int f = pY; //up
		int g = pY; //down
		for (int e = pX-1; e >= 0; e--) { //e-x .... f-y1 (up) .... g-y2 (down)
			f++;
			g--;
			if (f < board.length) { //lets not go out of bounds
				if (board[e][f]) { //go right of piece, check diagonal up&down
					return false;
				}
			}
			if (g >= 0) { //lets not go out of bounds
				if (board[e][g]) { //go right of piece, check diagonal up&down
					return false;
				}
			}
		}		
		return true;
	}
	//debugging printer
	public static void printGrid(boolean[][] table) {
        for(boolean[] row : table) {
            printRow(row);
        }
    }
	public static void printRow(boolean[] row) {
        for (boolean b : row) {
        	if (b) {
        		System.out.print("X");
        	} else {
        		System.out.print("_");
        	}
            System.out.print("\t");
        }
        System.out.println();
    }
}
