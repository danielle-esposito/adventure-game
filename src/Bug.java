public class Bug {
    public String bug_name;
    public int bell_value;
    public String capture_quote;
    public String ascii_art;

    public Bug(String[] bug_values) {
        this.bug_name = bug_values[0];
        this.bell_value = Integer.parseInt(bug_values[1]);
        this.capture_quote = bug_values[2];
        this.ascii_art = bug_values[3];
    }
    public void printDetails() {
        System.out.println(this.ascii_art);
        System.out.println(this.bug_name + ", " + this.bell_value + ", " + this.capture_quote ); 
    }
}
