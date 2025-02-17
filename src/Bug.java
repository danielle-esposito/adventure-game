// Written by Alex
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.io.IOException;

public class Bug extends Item {

    public Bug(String[] values) { // Inherit attributes / constructor from the Item superclass
        super(values);
    }

    public static void Game(ArrayList<Bug> bugList, Character player, Scanner input) throws InterruptedException, IOException {
        IterativePrint.clearScreen();
        IterativePrint.printString("Welcome to the bug mini game", true); // Introduce the game
        IterativePrint.printString("A bug is moving back and forth. Press [Enter] at the right moment to catch it!", true);

        Bug targetBug = selectBug(bugList); // Select the bug that is to be potentially catched
        boolean caught = attemptCatch(targetBug, input); // the user attempts to catch the bug

        if (caught) { // If it was caught inform user and add it to the player's inventory
            targetBug.printCapture();
            player.bugInv.add(targetBug);
            IterativePrint.printString("",true);
        } else { // If it got away inform the user
            IterativePrint.printString("The bug escaped!", true);
        }
    }

    private static Bug selectBug(ArrayList<Bug> bugList) {
        Random random = new Random();
        return bugList.get(random.nextInt(bugList.size())); // Randomly selects a bug from the bugList
    }

    private static boolean attemptCatch(Bug bug, Scanner input) throws InterruptedException, IOException {
        int bugPosition = 0;
        int direction = 1;
        int maxPosition = 10;
        
        for (int i = 0; i < 30; i++) { // bug moves back and forth 2 whole rotations to allow the user to catch before it goes away
            IterativePrint.clearScreen(); // clearing the screen before each frame
            printBugPosition(bugPosition, maxPosition); // printing the frame
            Thread.sleep(300 - (bug.size * 35)); // the movement is faster depending on the size of the bug
            
            bugPosition += direction;
            if (bugPosition == 0 || bugPosition == maxPosition) { // turn the bug around at the max position
                direction *= -1;
            }

            if (System.in.available() > 0) {
                input.nextLine();
                return (bugPosition == 6); // This value should be 5 but I think with how the timing get's processed i had to make it 6 to work
            }
        }
        return false; // Bug escapes if no successful attempt
    }

    private static void printBugPosition(int pos, int max) {
        StringBuilder sb = new StringBuilder(" "); // Use of string builder class to format frame for final print, a little easier than just making a char array 
        for (int i = 0; i <= max; i++) {
            if (i == pos) {
                sb.append("B"); // Bug position represented with a B
            } else if (i == 5) {
                sb.append("|"); // Center position (net)
            } else {
                sb.append("-");
            }
        }
        System.out.println(sb.toString());
    }
}
