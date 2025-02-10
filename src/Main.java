import java.util.List;
import java.util.ArrayList;
import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {
		
		Intro();

		ArrayList<Fish> fishList = new ArrayList<>(); //creates empty new list to store values of all fish objects
		fishList = CsvImporter.ImportFish("resources/fish.csv",fishList); // sets newly created fishList equal to output from the fish csv file

		//ArrayList<Bug> bugList = new ArrayList<>();
		//bugList = CsvImporter.ImportBugs("resources/bug.csv",bugList);


		//Print details for all of the Items (Debug)
		for (Fish fish : fishList) {
			fish.printDetails();
		}
		//for (Bug bug : bugList) {
		//	bug.printDetails();
		//}


	}



	public static void Intro(){
		IterativePrint.printString("Into back and forth narative to be written here");
		System.out.println();
	}

}
