import java.util.ArrayList;
import java.util.Random;

public class Fruit extends Item{
	
	public Fruit(String[] values) {
        super(values);
	}

public static void Game(String[] args, ArrayList<Fruit> fruitList, Character player) {
   IterativePrint.printString("Welcome to the Fruit Picking Game!");
   IterativePrint.printString("Here your task is to plant and then shake the trees and pick the fruit. This will be the fruit that you will then sell to the Shop to earn some more bells to pay off your debt!");
   
   plantTree();
   shakeTree();
   
   }
    
    public static void plantTree() {
        System.out.print("First, you need to plant a tree...");
        for (int i = 0; i < 10; i++) { // 5 seconds total
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.print(".");
        }
        IterativePrint.printString("\nThe tree has fully grown!");
    }

    public static void shakeTree() {
        String shakeText = "Shake! Shake! Shake!";
        for (int i = 0; i < 10; i++) { // 10 shakes
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // Create side-to-side movement by adding spaces dynamically
            String padding = " ".repeat(i % 5);
            System.out.println(padding + shakeText);
        }
        IterativePrint.printString("The fruit has fallen!");
    }
    // Pick a random fruit from arraylist: fruitlist - 
    // that random fruit should be added to the player inventory

}
