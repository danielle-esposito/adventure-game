public class Item {
	public String name;
	public int bell_value;
	public int size;
	public String capture_quote;
	public String ascii_art;
	
	public Item(String[] values) {
		this.name = values[0];
		this.bell_value = Integer.parseInt(values[1]);
		this.size = Integer.parseInt(values[2]);
		this.capture_quote = values[3];
		this.ascii_art = values[4].replace("\\n", "\n"); // Fix newlines
		
	}
	public void printCapture() {
		System.out.println(this.ascii_art);
		IterativePrint.printString(this.capture_quote);
	}

	public void printDetails() {
		System.out.println(this.name + " Size: " + this.size + " Value: " + " Bells");
	}
}