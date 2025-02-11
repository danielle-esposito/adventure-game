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
		Character player = new Character();
		Intro(player);

		boolean winCondition = false;

		while(winCondition == false){
			Menu(player);
		}
	}

	public static void Intro(Character player){

		IterativePrint.printString("Into back and forth narative to be written here");

		Scanner input = new Scanner(System.in);
		IterativePrint.printString("Nice to meet you! What's your name? ");
		String name = input.nextLine();
		player.setName(name);
		input.close();

	}

	public static void Menu(Character player){
		IterativePrint.printString("You got some debt to pay off, here's what you can do!");
		IterativePrint.printString("Current debt: " + player.debt);
		IterativePrint.printString("Current money:" + player.money);
		player.printInventory();

	}
}
