package task2;

import java.util.Scanner;

public class TicTacToe {
	public static final char EMPTY = ' ';
	private char[][] board;
	private char turn;

	public TicTacToe(char[][] board) {
		this.board = board;
	}

	public TicTacToe() {
		board = new char[3][3];
		turn = 'X';

		// Initialize a 2-dimensional array
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				board[i][j] = EMPTY;
			}
		}
	}

	public void printBoard() {
		for (int i = 0; i < 3; i++) {
			System.out.print("| ");
			for (int j = 0; j < 3; j++) {
				System.out.print(board[i][j] + " | ");
			}

			System.out.println();
			System.out.println();
		}
	}

	// kiểm tra xem có còn trống ô đó không
	public boolean checkEmpty(int row, int col) {
		return board[row][col] == EMPTY;
	}

	// Đặt đâu 'X' hoặc 'O' vào vị trí đã lựa chọn
	public void placeMark(int row, int column) {
		board[row][column] = turn;
	}

	// thay đổi 'X' thành 'O' và ngược lại( tức đổi lượt chơi)
	public void changeTurn() {
		turn = (turn == 'X') ? 'O' : 'X';
	}

	/*
	 * This method checks all rows and returns true if any of them are marked with
	 * all of a single player's markers. Otherwise, returns false.
	 */
	public boolean checkRows() {
		for (int i = 0; i < 3; i++) {
			if (board[i][0] != ' ' && board[i][0] == board[i][1] && board[i][1] == board[i][2]) {
				return true;
			}
		}

		return false;
	}

	public boolean checkColumns() {
		for (int i = 0; i < 3; i++) {
			if (board[0][i] != ' ' && board[0][i] == board[1][i] && board[1][i] == board[2][i]) {
				return true;
			}
		}

		return false;
	}

	/*
	 * This method checks both diagonals and returns true if any of them are marked
	 * with all of a single player's markers. Otherwise, returns false.
	 */
	public boolean checkDiagonals() {
		// Check top-left to bottom-right
		if (board[0][0] != ' ' && board[0][0] == board[1][1] && board[1][1] == board[2][2]) {
			return true;
		}

		// Check bottom-left to top-right
		if (board[0][2] != ' ' && board[0][2] == board[1][1] && board[1][1] == board[2][0]) {
			return true;
		}

		return false;
	}
	
	// check draw
	public boolean checkDraw() {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				if(board[i][j] ==' ') {
					return false;
				}
			}
		}
		return true;
	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		TicTacToe game = new TicTacToe();
		char winner = EMPTY;

		System.out.println("Start game Tic Tac Toe with 3x3");
		System.out.println();

		// print arr 3x3 out the board
//		| 1 | 2 | 3 |
//		
//		| 4 | 5 | 6 |
//		
//		| 7 | 8 | 9 |

		game.printBoard();

		System.out.println("X will play first. Enter row and column to place X in.");

		// cứ còn chỗ trống sẽ lặp lại vòng lặp
		while (winner == ' ') {
			int row = input.nextInt();
			int column = input.nextInt();

			while (row < 0 || row >= 3 || column < 0 || column >= 3 || !game.checkEmpty(row, column)) {
				System.out.println(" Rows and columns of 2-dimensional array invalid!");
				System.out.println("Retype row and column: ");
				row = input.nextInt();
				column = input.nextInt();
			}

			game.placeMark(row, column);
			game.printBoard();
			
			if (game.checkRows()== true || game.checkColumns()==true || game.checkDiagonals()==true) {
				System.out.println("Congratulations! " + game.turn + "'s have won");
			    winner=game.turn;
			}else if(game.checkDraw()) {
				System.out.println("X and O draw!");
				winner = game.turn;
			} else {
				game.changeTurn();
				System.out.println(game.turn + "'s turn. Enter row and column to place " + game.turn + " in.");
			}

		}
	}

}
