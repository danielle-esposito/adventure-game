import java.util.Scanner;
import java.util.ArrayList;

public class Shop {
    public void visitShop(Character player) {
        Scanner input = new Scanner(System.in);
        IterativePrint.clearScreen();
        while (true) {
            System.out.println("\n--- Welcome to the Shop! ---");
            System.out.println("Your Money: " + player.money + " Bells");
            System.out.println("[1] Sell Fish");
            System.out.println("[2] Sell Bugs");
            System.out.println("[3] Sell Fruits");
            System.out.println("[4] Exit Shop");

            String choice = input.nextLine();

            switch (choice) {
                case "1":
                    sellItems(player.fishInv, player);
                    break;
                case "2":
                    sellItems(player.bugInv, player);
                    break;
                case "3":
                    sellItems(player.fruitInv, player);
                    break;
                case "4":
                    IterativePrint.printString("Thanks for visiting!", true);
                    //IterativePrint.clearScreen();
                    return;
                default:
                    System.out.println("Invalid choice, try again.");
            }
        }
    }

    private void sellItems(ArrayList<? extends Item> inventory, Character player) {
        IterativePrint.clearScreen();
        if (inventory.isEmpty()) {
            System.out.println("You have no items to sell.");
            return;
        }

        int totalEarned = 0;
        for (Item item : inventory) {
            totalEarned += item.bell_value;
        }

        player.money += totalEarned;
        inventory.clear();
        System.out.println("You sold your items for " + totalEarned + " Bells!");
    }
}
