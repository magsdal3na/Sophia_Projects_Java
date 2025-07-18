import java.util.Scanner;

public class DrinkOrders {
    public static void main (String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.println("What type of drink would you like to order?");
    // Separating statements with \n instead of new lines
    System.out.println("1. Water\n2. Coffee\n3. Tea");
    System.out.print("Drink selection #: ");
    // Variables for drink details
    String drinkDetails = "No drink chosen";
    int choice = input.nextInt();
    // This is removing the next line?
    input.nextLine();
    if(choice == 1) {
        drinkDetails = "Water";
        System.out.println("Would you like that 1. hot or 2. cold?");
        System.out.print("Temperature selection #: ");
        choice = input.nextInt();
        input.nextLine();
        // Water temp options
        if(choice == 1) {
            drinkDetails += ", hot";
        }
        else if(choice == 2) {
            drinkDetails += ", cold";
            System.out.print("Would you like ice? (Y/N) ");
            // Read input as a String
            String response = input.nextLine();
            // Extract 1st char
            char yesNo = response.charAt(0);
            // Y or y is yes, anything else interpreted as no
            if(yesNo == 'Y' || yesNo == 'y') {
                drinkDetails += ", with ice";
            }    
        }
        else {
            System.out.print("That is not a valid choice. Please run program again. ");
        }
    }
    else if(choice == 2) {
        drinkDetails = "Coffee";
        System.out.print("Would you like decaf? (y/n): ");
        String decafResponse = input.nextLine();
        char decafYesNo = decafResponse.charAt(0);
        if(decafYesNo == 'Y' || decafYesNo == 'y') {
            drinkDetails += ", decaf";
        }
        // Build else here?
        System.out.println("Would you like 1. Milk, 2. Cream, or 3. None? ");
        System.out.print("Enter choice #: ");
        int milkCreamChoice = input.nextInt();
        // Remove new line left in input stream to avoid problems with later inputs
        input.nextLine();
        if(milkCreamChoice == 1) {
            drinkDetails += ", milk";
        }
        else if(milkCreamChoice == 2) {
            drinkDetails += ", cream";
        }
        System.out.print("Would you like sugar? (y/n): ");
        String sugarResponse = input.nextLine();
        char sugar = sugarResponse.charAt(0);
        if(sugar == 'Y' || sugar == 'y') {
            drinkDetails += ", sugar";
        }
    }
    else if(choice == 3) {
        drinkDetails = "Tea";
        System.out.print("Type of tea?: 1. Black 2. Green ");
        int teaChoice = input.nextInt();
        input.nextLine();
        if(teaChoice == 1) {
            drinkDetails += ", black";
        }
        else if(teaChoice == 2) {
            drinkDetails += ", green";
        }
        else {
            System.out.print("That is not a valid choice. Please run the program again. ");
        }
    }
    else {
        System.out.print("Sorry, that is not a valid drink choice. ");
    }
    // Print out final selection
    System.out.print("Your drink selection is: " + drinkDetails);
    }
}
