import java.util.ArrayList;

public class Character {
    public String name;
    public int money;
    public int debt;
    public ArrayList<Fish> fishInv;
    public ArrayList<Bug> bugInv;
    public ArrayList<Fruit> fruitInv;

    public Character(String name) {
        this.name = name;
    }

    public void removeDebt(int debt) {
        this.debt+=debt;
    }
    public void addMoney(int money) {
        this.money-=money;
    }

    public void printInventory(){
        System.out.println("Fish");
        if (fishInv != null){
            for(Fish fish : fishInv){
                fish.printDetails();
            }
        } else {
            System.out.println("No Fish in inventory");
        }
        System.out.println("Bugs:");
        if (bugInv != null){
            for(Bug bug : bugInv){
                bug.printDetails();
            }
        } else {
            System.out.println("No Bugs in inventory");
        }
        System.out.println("Fruit: ");
        if (fruitInv != null){
            for(Fruit fruit : fruitInv){
                fruit.printDetails();
            }
        } else {
            System.out.println("No Fruit in inventory");
        }
    }
}
