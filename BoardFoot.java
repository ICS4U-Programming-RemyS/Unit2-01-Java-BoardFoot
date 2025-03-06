import java.util.Scanner;

/**.
* This program will check the user width and height of a board
* and display the required length to make exactly 1 board foot
* (144 cubic inches).
*
* @author  Remy Skelton
* @version 1.0
* @since   2025-March-3
*/
final class BoardFoot {

    /**.
    * Set Board Foot constant to 144 cubic inches.
    */
    public static final double BOARD_FOOT = 144;

    /**
    * Private constructor to prevent instantiation.
    */
    private BoardFoot() {
        throw new IllegalStateException("Utility class");
    }

    /**
    * This is the main method.
    *
    * @param args Unused.
    */
    public static void main(final String[] args) {
        // Welcome message and instructions
        System.out.print("This program will ask for the width"
                + " and height of a piece of wood.");
        System.out.println(" It will then calculate the required"
                + " length to make exactly 1 board foot (144 cubic inches).");

        // Use a scanner to get user input
        Scanner scanner = new Scanner(System.in);

        // Declare userHeightDouble and userWidthDouble
        double userHeightDouble = 0;
        double userWidthDouble = 0;

        // Do-while loop for valid userHeightDouble and width input
        do {
            // Message for user to enter height
            System.out.println("Please enter"
                    + " the height of the piece of wood: ");

            // Get user height string
            String userHeightString = scanner.nextLine();

            // Message for user to enter width
            System.out.println("Please enter the width of the piece of wood: ");

            // Get user width string
            String userWidthString = scanner.nextLine();

            // Try-catch block for non-numeric input
            try {
                // Convert user height to double
                userHeightDouble = Double.parseDouble(userHeightString);

                // Convert user width to double
                userWidthDouble = Double.parseDouble(userWidthString);

                // Check if values are less than or equal to 0
                if (userWidthDouble <= 0 || userHeightDouble <= 0) {
                    // Display error message when height or width is invalid
                    System.out.println("Invalid input: "
                            + userHeightString
                            + " or " + userWidthString
                            + ". Please enter a height"
                            + " and width greater than 0.");
                }
            } catch (NumberFormatException error) {
                // Display error message when input is not a number
                System.out.println("Invalid input: " + userHeightString
                        + " or " + userWidthString
                        + ". Please enter a valid number.");
            }

        // Runs until user enters valid width and height
        } while (userWidthDouble <= 0 || userHeightDouble <= 0);

        // Calculate required length by calling calculateBoardFoot method
        double length =
                calculateBoardFoot(userWidthDouble, userHeightDouble);

        // Display the required length
        System.out.print("To make exactly 1 board foot,"
                + " the required length is ");
        System.out.format("%.2f", length);
        System.out.println(" inches.");

        // Close scanner
        scanner.close();
    }

    /**
    * This method calculates the required length
    * of wood to make exactly 1 board foot.
    *
    * @param userWidthDouble The width of the wood in inches.
    * @param userHeightDouble The height of the wood in inches.
    * @return The required length in inches.
    */
    public static double calculateBoardFoot(
            final double userWidthDouble, final double userHeightDouble) {
        double length = BOARD_FOOT / (userWidthDouble * userHeightDouble);
        return length;
    }
}
