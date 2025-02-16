import java.util.ArrayList;
import java.util.Random;
import java.util.stream.IntStream; 

public class Fruit extends Item{
	
	public Fruit(String[] values) {
        super(values);
	}

public static void Game(ArrayList<Fruit> fruitList, Character player) {
   IterativePrint.printString("Welcome to the Fruit Picking Game!");
   IterativePrint.printString("Here your task is to plant and then shake the trees and pick the fruit. This will be the fruit that you will then sell to the Shop to earn some more bells to pay off your debt!");
   
   characterPlantTree();
   characterShakeTree();
   
   }
    
    public static void characterPlantTree() {
	Scanner scanner = new Scanner(System.in); 
	    
        System.out.print("First, you need to plant a tree, but before you can do that, you'll need to answer a question...");
	System.out.println("Convert the following number to binary code: 36");

	String characterResponse = scanner.nextLine().trim(); 

	if (characterResponse.equals("100100")) {
		System.out.println("That is correct! Your tree will now proceed to plant!"); 
		
    	IntStream.range(0, 10).forEach(i -> {
		try {
		    Thread.sleep(500);
		} catch (InterruptedException e) {
		    Thread.currentThread().interrupt();
    		}
		System.out.print(".");
	});
	System.out.println("\nThe tree has fully grown now!");
    } else {
	System.out.println("Not quite... try again :("); 
	}
    }	    
	
    public static void characterShakeTree() {
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
        IterativePrint.printString("Good job! You've successfully made the fruit fall :)");
    }
    // Pick a random fruit from arraylist: fruitlist - 
    // that random fruit should be added to the player inventory

}
