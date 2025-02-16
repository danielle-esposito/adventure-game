import java.util.ArrayList;
import java.io.IOException;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws IOException, InterruptedException{

		// Import the Items involved in each of the minigames from their respective CSV Files
		ArrayList<Fish> fishList = new ArrayList<>(); // creates empty arrayList for Fish(Item) objects to be stored
		fishList = CsvImporter.ImportFish("resources/fish.csv",fishList); // sets this arraylist to to contain all of the fish objects imported form the CSV
		ArrayList<Bug> bugList = new ArrayList<>();
		//bugList = CsvImporter.ImportBugs("resources/bug.csv",bugList);
		ArrayList<Fruit> fruitList = new ArrayList<>();
		fruitList = CsvImporter.ImportFruit("resources/fruit.csv",fruitList);

		//Print details for all of the Items (Debug)
		//for (Fish fish : fishList) {
		//	fish.printDetails();
		//}
		//for (Bug bug : bugList) {
		//	bug.printDetails();
		//}
		// for (Fruit fruit: fruitList) {
		// 	fruit.printDetails();
		// }

		// Game Sequence begins
		Character player = new Character(); // Initilize the player as an intance of the Character class
		Intro(player); // Run's the intro portion of the game sequence, player is passed through because the player's name is set during this sequence

		boolean winCondition = false;

		while(winCondition == false){ //Gameplay loop keeps occuring untill the game is won
			Menu(player, winCondition, fishList, bugList, fruitList); // The game revolves around the menu which let's you choose what action's to take
		}
	}

	public static void Intro(Character player){ // Written by:

		IterativePrint.clearScreen(); //Introduction diolougue
		IterativePrint.printString("Guide: Welcome! What's your name?");

		Scanner input = new Scanner(System.in); //Scanner user input
		String name = input.nextLine(); // Get the player's name from the user and set it to their class object
		player.setName(name);

		IterativePrint.printString("Guide: You can press [Enter] to advance the text",false); // Dialogue continued
		IterativePrint.printString("Tom Nook: Well, well, well, if it isn't " + player.name + "! You've got quite the problem on your hands.",true);
		IterativePrint.printString(player.name + ": What do you mean?",false);
		IterativePrint.printString("Tom Nook: Don't you remember the big fancy island house you bought? Now you owe me 50,000 bells! And I want my money NOW!",false);
		IterativePrint.printString(player.name + ": 50,000 bells? How on earth am I supposed to pay that?!",false);
		IterativePrint.printString("Tom Nook: I don't know, figure it out! Go fishing, catch some bugs, harvest fruit from trees, I don't care! Just get me my money!",false);
		IterativePrint.printString("Guide: To pay off your debt, you'll need to earn bells by selling items you collect throughout the island. Good luck, " + player.name + "!",true);

	}

	public static boolean Menu(Character player, boolean winCondition, ArrayList<Fish> fishList, ArrayList<Bug> bugList, ArrayList<Fruit> fruitList) throws IOException, InterruptedException { // core game sequence Written by: 
		IterativePrint.clearScreen();
		IterativePrint.printString("You got some debt to pay off, here's what you can do!"); // Begins with telling the user their balances
		IterativePrint.printString("Current debt: " + player.debt);
		IterativePrint.printString("Current money: " + player.money);
		player.printInventory(); // Shows them their inventory
		System.out.println("Select from one of the options below: \n[1] Talk to Tom Nook\n[2] Vist the shop to sell your Items\n[3] Go Fishing\n[4] Gather Fruit\n[5] Catch Bugs"); // Display game choices
		Scanner input = new Scanner(System.in);
		String choice = input.nextLine();

		switch (choice) { // Simple numeric choice selector to launch needed program
			case "1":
				winCondition = Nook.Office(player); // Call Nook office method, this also checks if the player has won the game or not through the winCondition bool
				break;
			case "2":
				Shop shop = new Shop(); 
				shop.visitShop(player); // Call shop method to sell items
				break;
			case "3":
				Fish.Game(fishList, player); // Call Fish Game method to play minigame
				break;
			case "4":
				Fruit.Game(fruitList, player); // Call Fruit Game method to play minigame
				break;
			case "5":
				//Bug.Game(bugList, player); // Call Bug Game method to play minigame
				break;
			default: // If their response was invalid, inform user
			IterativePrint.clearScreen();
			IterativePrint.printString("Invalid selection, please try again\n ");
		}
		return winCondition; // Since the menu sequence is running in a loop we need to return if whether the game has been won

	}
}
