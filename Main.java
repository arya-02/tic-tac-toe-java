import java.util.Scanner;

public class Main {
	
	static Scanner sc = new Scanner(System.in);
	
	public static void displayBoard(String[][] board) {
		System.out.println(board[0][0]+"|"+board[0][1]+"|"+board[0][2]);
		System.out.println("------");
		System.out.println(board[1][0]+"|"+board[1][1]+"|"+board[1][2]);
		System.out.println("------");
		System.out.println(board[2][0]+"|"+board[2][1]+"|"+board[2][2]);
	}
	
	public static void startGame(String[][] board) {
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				board[i][j] = " ";
			}
		}
		displayBoard(board);
	}
	
	public static void playerMove(String[][] board,int player) {
		int i,j;
		if(player%2==0) {
			System.out.println("X turn");
			System.out.print("Enter row - ");
			i = sc.nextInt();
			System.out.print("\nEnter col - ");
			j = sc.nextInt();
			System.out.println();
			if(i<0||i>2||j<0||j>2) {
				System.out.println("Wrong position!");
			}
			if(board[i][j]==" ") {
				board[i][j] = "X";
			}else
				System.out.println("Position already marked!");
		}else if(player%2!=0) {
			System.out.println("O turn");
			System.out.print("Enter row - ");
			i = sc.nextInt();
			System.out.print("\nEnter col - ");
			j = sc.nextInt();
			if(i<0||i>2||j<0||j>2) {
				System.out.println("Wrong position!");
			}
			if(board[i][j]==" ") {
				board[i][j] = "O";
			}else
				System.out.println("Position already marked!");
		}
		displayBoard(board);
	}
	
	public static int checkWin(String[][] board) {
		int win;
		if((board[0][0]=="X")&&(board[0][1]=="X")&&(board[0][2]=="X")
				||(board[1][0]=="X")&&(board[1][1]=="X")&&(board[1][2]=="X")
				||(board[2][0]=="X")&&(board[2][1]=="X")&&(board[2][2]=="X")
				||(board[0][0]=="X")&&(board[1][0]=="X")&&(board[2][0]=="X")
				||(board[0][1]=="X")&&(board[1][1]=="X")&&(board[2][1]=="X")
				||(board[0][2]=="X")&&(board[1][2]=="X")&&(board[2][2]=="X")
				||(board[0][0]=="X")&&(board[1][1]=="X")&&(board[2][2]=="X")
				||(board[2][0]=="X")&&(board[1][1]=="X")&&(board[0][2]=="X")) {
			win = 1;
		}else if((board[0][0]=="O")&&(board[0][1]=="O")&&(board[0][2]=="O")
				||(board[1][0]=="O")&&(board[1][1]=="O")&&(board[1][2]=="O")
				||(board[2][0]=="O")&&(board[2][1]=="O")&&(board[2][2]=="O")
				||(board[0][0]=="O")&&(board[1][0]=="O")&&(board[2][0]=="O")
				||(board[0][1]=="O")&&(board[1][1]=="O")&&(board[2][1]=="O")
				||(board[0][2]=="O")&&(board[1][2]=="O")&&(board[2][2]=="O")
				||(board[0][0]=="O")&&(board[1][1]=="O")&&(board[2][2]=="O")
				||(board[2][0]=="O")&&(board[1][1]=="O")&&(board[0][2]=="O")) {
			win = -1;
		}else
			win = 0;
		return win;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[][] board = new String[3][3];
		int win=0;
		startGame(board);
		for(int i=0;i<9;i++) {
			playerMove(board,i);
			win = checkWin(board);
			if(win == 1) {
				System.out.println("X wins!");
				System.exit(0);
			}else if(win == -1) {
				System.out.println("O wins!");
				System.exit(0);
			}
		}
		if(win == 0) {
			System.out.println("Tie!");
		}
	}

}
