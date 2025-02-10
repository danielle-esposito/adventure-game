import java.util.List;
import java.util.ArrayList;
import java.io.IOException;

public class Main {
	public static void main(String[] args) throws IOException {
		
		Intro();

		ArrayList<Fish> fishList = new ArrayList<>(); //creates empty new list to store values of all fish objects
		fishList = CsvImporter.ImportFish("resources/fish.csv",fishList); // sets newly created fishList equal to output from the fish csv file

		for (Fish fish: fishList) {
			fish.printDetails();
		}

		//adding fruit to main for testing, basically copying the same as fish
		ArrayList<Fruit> fruitList = new ArrayList<>();
		fruitList = CsvImporter.ImportFruit("resources/fruit.csv",fruitList);

		for (Fruit fruit: fruitList) {
			fruit.printDetails();
		}
	}



	public static void Intro(){
		IterativePrint.printString("Into back and forth narative to be written here");
		System.out.println();
	}



}
