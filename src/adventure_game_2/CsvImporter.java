package adventure_game_2;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

public class CsvImporter {

	public static List<Fish> importFish(String csvFile) throws IOException {
		
		List<Fish> fishList = new ArrayList<>();
		
		BufferedReader br = new BufferedReader(new FileReader(csvFile));
		String line;
		
		String[] values;
		values = new String[5];
		
		while ((line = br.readLine()) != null) {
			values = line.split(",");
			
			Fish fish = new Fish(values);
			fishList.add(fish);
			
			System.out.println();
		}
		br.close();
		
		return fishList;
	}

}
