import java.io.IOException;
import java.util.ArrayList;

public class FishTest {
    public static void main(String[] args) throws IOException, InterruptedException {
        ArrayList<Fish> fishList = new ArrayList<>(); //creates empty new list to store values of all fish objects
		fishList = CsvImporter.ImportFish("resources/fish.csv",fishList); // sets newly created fishList equal to output from the fish csv file
        
        Fish.Game(fishList, null);
    }
}
