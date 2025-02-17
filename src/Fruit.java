import java.util.Scanner; 
import java.util.ArrayList;
import java.util.Random;

public class Fruit extends Item{
	
	public Fruit(String[] values) {
        super(values);
	}

public static void Game(ArrayList<Fruit> fruitList, Character player, Scanner input) {
   IterativePrint.printString("Welcome to the Fruit Picking Game!");
   IterativePrint.printString("Here your task is to plant and then shake the trees and pick the fruit. This will be the fruit that you will then sell to the Shop to earn some more bells to pay off your debt!");
   
   characterPlantTree(input);
   for (int i = 0; i > 10; i++){
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            }
        System.out.print(".");
    }

   characterShakeTree(input);

    Fruit selectedFruit = selectFruit(fruitList);
    selectedFruit.printCapture();
    IterativePrint.printString("",true);

    // Store the fruit you got into the inve
        player.fruitInv.add(selectedFruit); 
   
   }
    
    public static void characterPlantTree(Scanner input) {

        System.out.print("First, you need to plant a tree, but before you can do that, you'll need to answer a question...");

        boolean binarySolved = false;
        while (binarySolved == false){
            binarySolved = plantTreeGame(input);
        }
    }
	public static boolean plantTreeGame(Scanner input) {
        	Random random = new Random();

        	int decimalNumber = random.nextInt(256); // Generates a random number between 0 and 255
        	String binaryNumber = Integer.toBinaryString(decimalNumber);

        System.out.println("Convert the following decimal number to binary:");
        System.out.println(decimalNumber);
        System.out.print("Your answer: ");
        String characterResponse = input.nextLine();
 
	if (characterResponse.equals(binaryNumber)) {
            System.out.println("That is correct! Your tree will now proceed to plant and grow!");
            return true;
        } else {
            System.out.println("Not quite... The correct answer was: " + binaryNumber + " try again");
            return false;
        }
    }

	
    public static void characterShakeTree(Scanner input) {
	System.out.println("Good, now that the tree has grown, you'll need to shake it to retrieve the fruit.");
	    System.out.println("However, once again, you need to answer the following riddle...");
	    System.out.println("You go at red, but stop at green. What am I?");

	    String playerResponse = input.nextLine().trim(); 

	if (playerResponse.equalsIgnoreCase("Watermelon")) {
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
        IterativePrint.printString("Good job! You've successfully made the fruit fall :)",true);
    } else {
	    System.out.println("That is incorrect, try again!");
	}
    }
 public static Fruit selectFruit(ArrayList<Fruit> fruitList) {
        Random random = new Random();
	int randomFruit = random.nextInt(fruitList.size());
        return fruitList.get(randomFruit);
 }
}
