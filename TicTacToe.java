import java.util.Arrays;
import java.util.Scanner;

public class TicTacToe
{
	public static void main(String[] args) {
		String[][] board = {{" - ", " - ", " - "},
			{" - ", " - ", " - "},
			{" - ", " - ", " - "}
		};
		// \t tabs in the lines
		System.out.println("\t" + Arrays.toString(board [0]));
		System.out.println("\t" + Arrays.toString(board [1]));
		System.out.println("\t" + Arrays.toString(board [2]) + "\n");

		Scanner input = new Scanner(System.in);

		// Defining col and row to help with validation
		int col = 0;
		int row = 0;

		// Defining player char via an array
		char[] player = {'X', 'O'};

		// Setting the validSelection boolean to false so input goes until
		// input is valid
		boolean validSelection = false;

		// Drawing initial board
		drawGame(board);
// Starts the for loop
		for(int turn = 0; turn < 9; turn++) {
			// Starts the while loop. Even turns are X, odds are O
			while(!validSelection) {
				System.out.print(player[turn % 2] + " - Select row (1 - 3) & " + "select column (1 - 3) separated by a space: ");
				row = input.nextInt();
				col = input.nextInt();
				if(isValidSelection(row, col)) {
					if(isPositionOpen(board, row, col)) {
						// Sets player at position
						board[row - 1][col - 1] = " " + player[turn % 2] + " ";
						// While loop will end when selected move is valid
						validSelection = true;
					}
					else { // Position is not open
						System.out.println("Sorry, that spot is taken.");
						System.out.println("Please try again.");
					}
				}
				else {
					System.out.println("Sorry, that is not a valid selection.");
					System.out.println("Please try again.");
				}

			}
			drawGame(board);
			//Check if it's the fifth or later turn
			if(turn >= 4) {
				int winningRow = checkForRowWin(board, player[turn % 2]);
				int winningColumn = checkForColumnWin(board, player[turn % 2]);
				int winningDiagonal = checkForDiagonalWin(board, player[turn % 2]);
				if(winningRow > 0 || winningColumn > 0 || winningDiagonal > 0 ) {
					System.out.println("\n" + player[turn % 2] + " wins!\n");
					break;
				}
			}
			// Set so that while loop repeats until next move is made
			validSelection = false;
		} // end of loop for turns
	}// end of main()

// Method to draw the board. Parameter is a 2D array
	public static void drawGame(String[][] board) {
		for(int row = 0; row < board.length; row++) {
			System.out.println(Arrays.toString(board[row]));
		}
		System.out.println();
	}

// Method to check if player has selected row & column within bounds
// Takes 2 int parameters
// Returns ture if selection is in bounds
	public static boolean isValidSelection(int row, int column) {
		return (row >= 1 && row <= 3 && column >= 1 && column <= 3);
	}

// Method to check if slected position is open
	public static boolean isPositionOpen(String[][] board, int row, int column) {
		return board[row - 1][column - 1].equals(" - ");
	}
// Check if player has won in one of the rows
	public static int checkForRowWin(String[][] board, char player) {
		int rowNumber = 0;
		for(int row = 0; row < 3; row++) {
			if(board[row][0].equals(" " + player + " ") &&
			        board[row][1].equals(" " + player + " ") &&
			        board[row][2].equals(" " + player + " ")) {
				rowNumber = row + 1;
				break;
			}
		}
		return rowNumber;
	}

// Check if player has won in one of the columns
	public static int checkForColumnWin(String[][] board, char player) {
		int columnNumber = 0;
		for(int column = 0; column < 3; column++) {
			if(board[0][columnNumber].equals(" " + player + " ") &&
			        board[1][columnNumber].equals(" " + player + " ") &&
			        board[2][columnNumber].equals(" " + player + " ")) {
				columnNumber = column + 1;
			}
		}
		return columnNumber;
	}

	// Check if a player has a win in 1 of the diagonals.
	public static int checkForDiagonalWin(String[][] board, char player) {
		int diagonalNumber = 0;
		// Player must have central square to have winning diagonal
		if(board[1][1].equals(" " + player + " ")) {
			if(board[0][0].equals(" " + player + " ") &&
			        board[2][2].equals(" " + player + " ")) {
				diagonalNumber = 1;
			}
			else if(board[0][2].equals(" " + player + " ") &&
			        board[2][0].equals(" " + player + " ")) {
				diagonalNumber = 2;
			}
		}
		return diagonalNumber;
	}
} // end of program
