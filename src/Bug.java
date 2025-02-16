//Written by Alex Merryman
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.io.IOException;

public class Bug extends Item {

    public Bug(String[] values) {
        super(values);
    }

    public static void Game(ArrayList<Bug> bugList, Character player, Scanner input) throws InterruptedException, IOException {
        IterativePrint.clearScreen();
        IterativePrint.printString("Welcome to the bug-catching minigame!", true);
        IterativePrint.printString("A bug is moving back and forth. Press [Enter] at the right moment to catch it!", true);

        Bug targetBug = selectBug(bugList);
        boolean caught = attemptCatch(targetBug, input);

        if (caught) {
            IterativePrint.printString("You caught a " + targetBug.name + "!", true);
            player.bugInv.add(targetBug);
        } else {
            IterativePrint.printString("The bug escaped!", true);
        }
    }

    private static Bug selectBug(ArrayList<Bug> bugList) {
        Random random = new Random();
        return bugList.get(random.nextInt(bugList.size())); // Randomly selects a bug
    }

    private static boolean attemptCatch(Bug bug, Scanner input) throws InterruptedException, IOException {
        Random random = new Random();
        int bugPosition = 0;
        int direction = 1;
        int maxPosition = 10;
        
        IterativePrint.printString("Press [Enter] when the bug reaches the center (5).", true);
        
        for (int i = 0; i < 15; i++) { // Bug moves back and forth for 15 frames
            IterativePrint.clearScreen();
            printBugPosition(bugPosition, maxPosition);
            Thread.sleep(300 - (bug.size * 30)); // Faster for rarer bugs
            
            bugPosition += direction;
            if (bugPosition == 0 || bugPosition == maxPosition) {
                direction *= -1; // Reverse direction
            }

            if (System.in.available() > 0) {
                input.nextLine();
                return (bugPosition == 6); // This value should be 5 but I think with how the timing get's processed i had to make it 6 to work
            }
        }
        return false; // Bug escapes if no successful attempt
    }

    private static void printBugPosition(int pos, int max) {
        StringBuilder line = new StringBuilder(" ");
        for (int i = 0; i <= max; i++) {
            if (i == pos) {
                line.append("B");
            } else if (i == 5) {
                line.append("|"); // Net position
            } else {
                line.append("-");
            }
        }
        System.out.println(line.toString());
    }
}
