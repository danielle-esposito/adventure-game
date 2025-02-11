import java.util.Scanner;

public class IterativePrint {
    public static void printString(String text){
        for (char character : text.toCharArray()) {
            System.out.print(character);
            try {
            Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println();
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
        
        if (EnterToContinue == true) {
            try {
                Thread.sleep(750);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Press Enter to continue...");
            input.nextLine();
            clearScreen();
        } else if (EnterToContinue == false) {
            input.nextLine();
        }
    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
    }
}


