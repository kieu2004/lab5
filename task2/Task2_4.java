package task2;

import java.util.Scanner;

public class Task2_4 {
	private static final char EMPTY = ' ';

	private char[][] board;
	private char turn;

	public Task2_4(char[][] board) {
		this.board = board;
	}

	public Task2_4(int n) {
		board = new char[n][n];
		turn = 'X';

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				board[i][j] = EMPTY;
			}
		}

	}

	public void printBoard(int n) {
		for (int i = 0; i < n; i++) {
			System.out.print("| ");
			for (int j = 0; j < n; j++) {
				System.out.print(board[i][j] + " | ");
			}
			System.out.println();
			System.out.println();
		}
	}

	public void placeMark(int row, int column) {
		board[row][column] = turn;

	}

	public boolean checkEmpty(int row, int column) {
		return board[row][column] == EMPTY;
	}

	public boolean checkRows(int n) {
		for (int i = 0; i < n; i++) {
			if (board[i][0] != EMPTY && allEqual(board[i])) {
				return true;
			}
		}
		return false;
	}

	public boolean allEqual(char[] arrChar) {
		for (char c : arrChar) {
			if (c != arrChar[0]) {
				return false;
			}
		}
		return true;
	}

	public boolean checkColumns(int n) {
		for (int i = 0; i < n; i++) {
			if (board[0][i] != EMPTY && allEqual(i, n)) {
				return true;
			}
		}
		return false;
	}

	public boolean allEqual(int i, int n) {
		for (int j = 0; j < n; j++) {
			if (board[j][i] != board[0][i]) {
				return false;
			}
		}
		return true;
	}

	public boolean checkDiagonals(int n) {

		// Check top-left to bottom-right
		if (board[0][0] != EMPTY && allEqualDiagonal_main(n)) {
			return true;
		}

		// Check bottom-left to top-right
		if (board[0][n - 1] != EMPTY && allEqualDiagonal(n)) {
			return true;
		}

		return false;
	}

	public boolean allEqualDiagonal_main(int n) {
		for (int i = 0; i < n - 1; i++) {
			if (board[i][i] != board[i + 1][i + 1]) {
				return false;
			}
		}
		return true;
	}

	public boolean allEqualDiagonal(int n) {
		for (int i = 0; i < n - 1; i++) {
			if (board[i][n - 1 - i] != board[i + 1][n - 2 - i]) {
				return false;
			}
		}

		return true;
	}

	public boolean checkDraw(int n) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (board[i][j] == ' ') {
					return false;
				}

			}
		}
		return true;
	}

	public void changeTurn() {
		turn = (turn == 'X') ? 'O' : 'X';
	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n = -1;

		while (n < 0) {
			System.out.println("Enter n: ");
			n = input.nextInt();
		}

		Task2_4 game = new Task2_4(n);
		char winner = EMPTY;

		System.out.println("Start game with nxn");
		System.out.println();

		game.printBoard(n);
		System.out.println("X will play first. Enter row and column to place X in.");

		while (winner == ' ') {
			int row = input.nextInt();
			int column = input.nextInt();

			while (row < 0 || row >= n || column < 0 || column >= n || !game.checkEmpty(row, column)) {
				System.out.println(" Rows and columns of 2-dimensional array invalid!");
				System.out.println("Retype row and column: ");
				row = input.nextInt();
				column = input.nextInt();
			}

			game.placeMark(row, column);
			game.printBoard(n);

			if (game.checkRows(n) == true || game.checkColumns(n) == true || game.checkDiagonals(n) == true) {
				System.out.println("Congratulations! " + game.turn + "'s have won");
				winner = game.turn;
			} else if (game.checkDraw(n)) {
				System.out.println("X and O draw!");
				winner = game.turn;
			} else {
				game.changeTurn();
				System.out.println(game.turn + "'s turn. Enter row and column to place " + game.turn + " in.");
			}

		}

	}

}
