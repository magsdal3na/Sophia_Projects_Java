import java.util.Arrays;
import java.util.Scanner;

public class TicTacToe
{
	public static void main(String[] args) {

	Scanner input = new Scanner(System.in);
	String[][] board = {{" - ", " - ", " - "},
                        {" - ", " - ", " - "},
                        {" - ", " - ", " - "}};
    // \t tabs in the lines
    System.out.println("\t" + Arrays.toString(board [0]));
    System.out.println("\t" + Arrays.toString(board [1]));
    System.out.println("\t" + Arrays.toString(board [2]) + "\n");
    
    // Defining col and row to help with validation
    int col = 0;
    int row = 0;
    // Defining player char
    char player;
    
    // For loop that runs the 9 rounds  
    for(int turn = 0; turn < 9; turn++) {
        // Checking for who's turn it is
        if(turn % 2 == 0) {
            player = 'X';
        }
        else {
            player = 'O';
        }
        // Check if column & row are legitimate integers
        while(col < 1 || col > 3 || row < 1 || row > 3){
            System.out.print(player + " - Select row (1 - 3) & select column (1 - 3) ");
            System.out.print("separated by a space: ");
            row = input.nextInt();
            col = input.nextInt();
        }

        // Checking for available space
        if(board[row - 1][col - 1].equals(" - ")) {
            board[row - 1][col - 1] = " " + player + " ";
        }
        else {
            System.out.println("Sorry, that spot is taken.");
            System.out.println("Try again.");
            // Roll loop back
            turn--;
        }
        // Resetting col and row to reset validation
        col = 0;
        row = 0;
        System.out.println("\t" + Arrays.toString(board[0]));
        System.out.println("\t" + Arrays.toString(board[1]));
        System.out.println("\t" + Arrays.toString(board[2]) + "\n");
        
        // If 9th turn, end after X's turn
        if(turn == 9) {
            break;
        }
    }
	}
}
