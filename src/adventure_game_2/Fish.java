package adventure_game_2;

public class Fish {
	public String fish_name;
	public String bell_value;
	public String size;
	public String capture_quote;
	public String ascii_art;
	//public String size;
	
	public Fish(String[] fish_values) {
		this.fish_name = fish_values[0];
		this.bell_value = fish_values[1];
		this.size = fish_values[2];
		this.capture_quote = fish_values[3];
		this.ascii_art = fish_values[4];
		
	}
}