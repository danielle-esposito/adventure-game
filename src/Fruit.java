import java.util.Scanner; 
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
	public static boolean plantTreeGame() {
        	Random random = new Random();
        	Scanner scanner = new Scanner(System.in);

        	int decimalNumber = random.nextInt(256); // Generates a random number between 0 and 255
        	String binaryNumber = Integer.toBinaryString(decimalNumber);

        System.out.println("Convert the following decimal number to binary:");
        System.out.println(decimalNumber);
        System.out.print("Your answer: ");
        String characterResponse = scanner.nextLine();
		
        scanner.close();
 
	if (characterResponse.equals(binaryNumber)) {
            System.out.println("That is correct! Your tree will now proceed to plant and grow!");
            return true;
        } else {
            System.out.println("Not quite... The correct answer was: " + binaryNumber + " try again");
            return false;
        }
    }
        boolean binarySolved = false;
        while (binarySolved == false){
            binarySolved = plantTreeGame();
    }
}
    	IntStream.range(0, 10).forEach(i -> {
		try {
		    Thread.sleep(500);
		} catch (InterruptedException e) {
		    Thread.currentThread().interrupt();
    		}
		System.out.print(".");
	});
	System.out.println("\nThe tree has fully grown now!");  

	
    public static void characterShakeTree() {
	System.out.println("Good, now that you've planted your tree, you'll need to shake it to retrieve the fruit.");
	    System.out.println("However, once again, you need to answer the following riddle...");
	    System.out.println("You go at red, but stop at green. What am I?");

	    Scanner scanner = new Scanner(System.in); 

	    String playerResponse = scanner.nextLine().trim(); 

	if (playerResponse.equals("watermelon" || "Watermelon")) {
		System.out.println("Correct, now you can shake the tree!");
		
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
    } else {
	    System.out.println("That is incorrect, try again!");
	}
    }
 public static Fruit selectFruit(ArrayList<Fruit> fruitList) {
        Random random = new Random();
	
     
    // Pick a random fruit from arraylist: fruitlist - 
    // that random fruit should be added to the player inventory

