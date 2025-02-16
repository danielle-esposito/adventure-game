//author: alex and dani
//class for printing out text one letter at a time
//includes method overloading to allow configuration for EnterToContinue
//pass through a boolean along with the string to access these options

import java.util.Scanner;

public class IterativePrint {
    public static void printString(String text){ // Standard method just prints iteratively
        for (char character : text.toCharArray()) { // takes the incoming string and turns it into an array of chars and loops through each one
            System.out.print(character); // print each char
            try {
            Thread.sleep(50); // wait 50ms between printing each char 
            } catch (InterruptedException e) { // This is a catch for when using Thread.sleep
                e.printStackTrace();
            }
        }
        System.out.println(); // new line
    }
    public static void printString(String text, boolean EnterToContinue) {
        for (char character : text.toCharArray()) {
            System.out.print(character);
            try {
            Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        Scanner input = new Scanner(System.in);
        System.out.println();
        
        // if bool=true, then the program prints out "Press Enter to continue" and waits for user input
        if (EnterToContinue == true) {
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Press Enter to continue...");
            input.nextLine();
            clearScreen();
        // if EnterToContinue==false, then it does not print out Enter To Continue, but still requires you to hit enter to progress
        } else if (EnterToContinue == false) {
            input.nextLine();
        }
    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}


