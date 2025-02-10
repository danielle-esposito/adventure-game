import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

public class CsvImporter {

	public static ArrayList<Fish> ImportFish(String csvFile, ArrayList<Fish> list) throws IOException {
		
		//List<Fish> list = new ArrayList<>();
		
		BufferedReader br = new BufferedReader(new FileReader(csvFile));
		String line;
		
		String[] values;
		values = new String[5];
		
		while ((line = br.readLine()) != null) {
			values = line.split(",");
			Fish item = new Fish(values);
			list.add(item);
		}
		br.close();
		
		return list;
	}

	public static ArrayList<Bug> ImportBugs(String csvFile, ArrayList<Bug> list) throws IOException{
		//List<Bug> list = new ArrayList<>();
		
		BufferedReader br = new BufferedReader(new FileReader(csvFile));
		String line;
		
		String[] values;
		values = new String[5];
		
		while ((line = br.readLine()) != null) {
			values = line.split(",");
			Bug item = new Bug(values);
			list.add(item);
		}
		br.close();
		
		return list;
	}

	public static ArrayList<Fruit> ImportFruit(String csvFile, ArrayList<Fruit> list) throws IOException {
		
		//List<Fish> list = new ArrayList<>();
		
		BufferedReader br = new BufferedReader(new FileReader(csvFile));
		String line;
		
		String[] values;
		values = new String[5];
		
		while ((line = br.readLine()) != null) {
			values = line.split(",");
			Fruit item = new Fruit(values);
			list.add(item);
		}
		br.close();
		
		return list;
	}
}