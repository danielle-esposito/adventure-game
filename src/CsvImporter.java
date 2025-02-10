import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

public class CsvImporter {

	public static List<Fish> importCSV(String csvFile) throws IOException {
		
		List<Fish> List = new ArrayList<>();
		
		BufferedReader br = new BufferedReader(new FileReader(csvFile));
		String line;
		
		String[] values;
		values = new String[5];
		
		while ((line = br.readLine()) != null) {
			values = line.split(",");
			
			if (csvFile == "resources/fish.csv") {
				Fish fish = new Fish(values);
				List.add(fish);
			} //else if (csvFile == "resources/bug.csv") {
			// 	Bug bug = new Bug(values);
			// }

			
			//System.out.println(); // Not sure why this was here?
		}
		br.close();
		
		return List;
	}

}
