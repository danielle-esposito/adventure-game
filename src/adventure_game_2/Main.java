package adventure_game_2;
import java.util.List;
import java.util.ArrayList;
import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {
		List<Fish> fishList = new ArrayList<>();
		fishList = CsvImporter.importFish("resources/fish.csv");
		for (Fish fish: fishList) {
			fish.printDetails();
		}
	}

}
