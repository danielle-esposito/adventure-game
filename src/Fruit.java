public class Fruit {
	public String fruit_name;
	public int bell_value; 
	public String capture_quote;
	
	
	public Fruit(String[] fruit_values) {
		this.fruit_name = fruit_values[0]
		this.bell_value = integer.parseint(fruit_values[1]);
		this.capture_quote = fruit_values[2];
			
	}
	public void printDetails() {
		System.out.println(this.capture_quote + " " + "This fruit is worth " + this.bell_value + " bells!");
	}
public static void Game(String[] args) {
   System.out.println("Welcome to the Fruit Picking Game!"); 
   System.out.println("Here your task is to plant and then shake the trees and pick the fruit. This will be the fruit that you will then sell to the Shop to earn some more bells to pay off your debt!");
   
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
        System.out.println("\nThe tree has fully grown!");
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
        System.out.println("The fruit has fallen!");
        System.out.println(printDetails()); 
 
    }
}
