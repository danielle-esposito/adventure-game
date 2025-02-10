import java.util.List;
import java.util.ArrayList;
import java.io.IOException;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws IOException {
		

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

		Intro();

		boolean winCondition = false;

		while(winCondition == false){
			Menu();
		}
	}

	public static void Intro(){
		Scanner input = new Scanner(System.in);

		IterativePrint.printString("Into back and forth narative to be written here");
		IterativePrint.printString("Nice to meet you! What's your name? ");

		String name = input.nextLine();
		//Character player = new Character(name);
		//Character defualt constuctor needs to be in here when prompted for name

		input.close();
	}

	public static void Menu(){
		IterativePrint.printString("You got some debt to pay off, here's what you can do!");
		IterativePrint.printString("Current debt: ");
		//player.printInventory();

	}



}
