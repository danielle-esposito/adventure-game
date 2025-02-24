//author alex and dani
// class for importing and creating ArrayLists from CSV files that include all information and aspects about the various items

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CsvImporter {
	//passes through path for CSV, and a list to use for the items
	public static ArrayList<Fish> ImportFish(String csvFile, ArrayList<Fish> list) throws IOException {
		//uses bufferedreader to read values from CSV
		BufferedReader br = new BufferedReader(new FileReader(csvFile));
		String line;
		
		String[] values; // String array for the values of each CSV Line to be stored into
		values = new String[5];
	
		while ((line = br.readLine()) != null) { // Loop through the lines untill you get to the last line: Null
			values = line.split(","); // split the string with the commas in the CSV
			Fish item = new Fish(values); // Create fish Object with the values from the array
			list.add(item); // Add it to the ArrayList that is returned
		}
		br.close();
		
		return list;
	}

	// Same sequence for each of the other object types:
	// Import Bugs
	public static ArrayList<Bug> ImportBugs(String csvFile, ArrayList<Bug> list) throws IOException{
		
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

	// import Fruit
	public static ArrayList<Fruit> ImportFruit(String csvFile, ArrayList<Fruit> list) throws IOException {
		
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