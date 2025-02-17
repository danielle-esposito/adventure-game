// Written by Heather and Dani
// Character class for the player

import java.util.ArrayList;

public class Character {
    public String name;
    public int money;
    public int debt;
    public ArrayList<Fish> fishInv;
    public ArrayList<Bug> bugInv;
    public ArrayList<Fruit> fruitInv;

    public Character(){}

    public void setName(String name) {
        this.name = name;
        this.debt = 5000;
        this.fishInv = new ArrayList<>();
        this.bugInv = new ArrayList<>();
        this.fruitInv = new ArrayList<>();
    }

    public void removeDebt(int debt) {
        this.debt+=debt;
    }
    public void addMoney(int money) {
        this.money-=money;
    }

    public void printInventory(){
        IterativePrint.printString("\n---- Item Inventory ----");
        System.out.println("Fish: ");
        if (fishInv.size() > 0){
            for(Fish fish : fishInv){
                fish.printDetails();
            }
        } else {
            System.out.println("No Fish in inventory");
        }
        System.out.println("Bugs:");
        if (bugInv.size() > 0){
            for(Bug bug : bugInv){
                bug.printDetails();
            }
        } else {
            System.out.println("No Bugs in inventory");
        }
        System.out.println("Fruit: ");
        if (fruitInv.size() > 0){
            for(Fruit fruit : fruitInv){
                fruit.printDetails();
            }
        } else {
            System.out.println("No Fruit in inventory");
        }
        System.out.println();
    }
}
