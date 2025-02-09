package adventure_game_2;

public class Fish {
	public String fish_name;
	public int bell_value;
	public int size;
	public String capture_quote;
	public String ascii_art;
	
	public Fish(String[] fish_values) {
		this.fish_name = fish_values[0];
		this.bell_value = Integer.parseInt(fish_values[1]);
		this.size = Integer.parseInt(fish_values[2]);
		this.capture_quote = fish_values[3];
		this.ascii_art = fish_values[4].replace("\\n", "\n"); // Fix newlines
		
	}
	public void printDetails() {
		System.out.println(this.ascii_art);
		System.out.println(this.fish_name + " " + this.bell_value + " " + this.size + " " + this.capture_quote);
	}
}