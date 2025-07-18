import java.util.Arrays;
import java.util.Scanner;

public class TicTacToe
{
	public static void main(String[] args) {
	int col;
	int row;
	Scanner input = new Scanner(System.in);
	String[][] board = {{" - ", " - ", " - "},
                        {" - ", " - ", " - "},
                        {" - ", " - ", " - "}};
    // \t tabs in the lines
    System.out.println("\t" + Arrays.toString(board [0]));
    System.out.println("\t" + Arrays.toString(board [1]));
    System.out.println("\t" + Arrays.toString(board [2]) + "\n");
    
    // Display the prompt text 
    System.out.print("X - Select row (1-3) & select column  (1-3) ");
    // Space separates row & column
    System.out.print("separated by a space: ");
    row = input.nextInt();
    col = input.nextInt();
    // Adding the X to the board
    board[row - 1][col - 1] = " X ";
    System.out.println("\nTic-Tac-Toe Board: \n");
    System.out.println("\t" + Arrays.toString(board[0]));
    System.out.println("\t" + Arrays.toString(board[1]));
    System.out.println("\t" + Arrays.toString(board[2]) + "\n");
    
    // Prompting player using O 
    System.out.print("O - Select row (1-3) & select column (1-3) ");
    System.out.print("separated by a space: ");
    row = input.nextInt();
    col = input.nextInt();
    // Mark requested square while subtracting 1 
    board[row - 1][col - 1] = " O ";
    System.out.println("\t" + Arrays.toString(board[0]));
    System.out.println("\t" + Arrays.toString(board[1]));
    System.out.println("\t" + Arrays.toString(board[2]) + "\n");
    
    // Checking if square is already marked
    if(board[row - 1][col - 1].equals(" - ")) {
        board[row - 1][col - 1] = " O ";
    }
    else {
        System.out.println("Sorry, that spot is taken.");
        System.out.println("Your turn will be skipped.");
    }
	}
}
