import java.util.List;
import java.util.ArrayList;
import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {
		
		List<Fish> fishList = new ArrayList<>(); //creates empty new list to store values of all fish objects
		fishList = CsvImporter.importCSV("resources/fish.csv"); // sets newly created fishList equal to output from the fish csv file
		for (Fish fish: fishList) {
			fish.printDetails();
		}
	}

}
