import java.util.List;
import java.util.ArrayList;
import java.io.IOException;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws IOException, InterruptedException{

		ArrayList<Fish> fishList = new ArrayList<>(); //creates empty new list to store values of all fish objects
		fishList = CsvImporter.ImportFish("resources/fish.csv",fishList); // sets newly created fishList equal to output from the fish csv file
		//ArrayList<Bug> bugList = new ArrayList<>();
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
		ArrayList<Bug> bugList = new ArrayList<>();

		Character player = new Character();
		Intro(player);

		boolean winCondition = false;

		while(winCondition == false){
			Menu(player, winCondition, fishList, bugList, fruitList);
		}
	}

	public static void Intro(Character player){

		IterativePrint.printString("Guide: Welcome! What's your name?");

		Scanner input = new Scanner(System.in);
		String name = input.nextLine();
		player.setName(name);
		//input.close();

		IterativePrint.printString("Mr. Resetti: Well, well, well, if it isn't " + player.name + " You’ve got quite the problem on your hands.",true);
		IterativePrint.printString(player.name + ": What do you mean?",false);
		IterativePrint.printString("Mr. Resetti: Don’t you remember the big fancy island house you bought? Now you owe me 50,000 bells! And I want my money NOW!",false);
		IterativePrint.printString(player.name + ": 50,000 bells? How on earth am I supposed to pay that?!",false);
		IterativePrint.printString("Mr. Resetti: I don’t know, figure it out! Go fishing, catch some bugs, and harvest fruit trees. Just get me my money!",false);
		IterativePrint.printString("Guide: To pay off your debt, you'll need to earn bells by selling items you collect throughout the island. Good luck, " + player.name + "!",true);

	}

	public static void Menu(Character player, boolean winCondition, ArrayList<Fish> fishList, ArrayList<Bug> bugList, ArrayList<Fruit> fruitList) throws IOException, InterruptedException {
		IterativePrint.printString("You got some debt to pay off, here's what you can do!");
		IterativePrint.printString("Current debt: " + player.debt);
		IterativePrint.printString("Current money: " + player.money);
		player.printInventory();
		System.out.println("Select from one of the options below \n[1]Talk to Mr. Resetti\n[2] Vist the shop to sell your Items\n[3] Go Fishing\n[4] Gather Fruit\n[5]Catch Bugs");
		Scanner input = new Scanner(System.in);
		String choice = input.nextLine();
		//input.close();
		switch (choice) {
			case "1":
				System.out.println("Mr. R");
				break;
			case "2":
				System.out.println("Shop");
				break;
			case "3":
				Fish.Game(fishList, player);
				break;
			case "4":
				Fruit.Game(fruitList, player);
				break;
			case "5":
				//Bug.Game(bugList, player);
				break;
			default:
			IterativePrint.printString("Invalid selection, please try again");
		}

	}
}
