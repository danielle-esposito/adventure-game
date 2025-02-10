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

    public void setDebt(int debt) {
        this.debt+=debt;
    }
    public void setMoney(int money) {
        this.money-=money;
    }
}
