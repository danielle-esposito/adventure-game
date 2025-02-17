// Written by Alex
// This is the main superclass refrenced by all the minigame classes Fish, Fruit, and Bug

public class Item {
	public String name; // Definte object attributes
	public int bell_value;
	public int size;
	public String capture_quote;
	public String ascii_art;
	
	public Item(){}; // Default constructor

	public Item(String[] values) { // Overloaded constructor 
		this.name = values[0]; // Assign the values from the indexes to each of the attributes of the array passed through
		this.bell_value = Integer.parseInt(values[1]);
		this.size = Integer.parseInt(values[2]);
		this.capture_quote = values[3];
		this.ascii_art = values[4].replace("\\n", "\n"); // Fix newlines in the ascii art from the CSV files
		
	}
	public void printCapture() { // Print ascii and the capture quote for when the item is captured
		System.out.println(this.ascii_art); 
		IterativePrint.printString(this.capture_quote);
	}

	public void printDetails() { // Print the details of the item, Name and Value. Used when displaying inventory
		System.out.println(this.name + " Value: " + this.bell_value + " Bells");
	}
}