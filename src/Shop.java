import java.util.Scanner;
import java.util.ArrayList;

public class Shop {
    public void visitShop(Character player) {
        Scanner input = new Scanner(System.in);
        IterativePrint.clearScreen();
        IterativePrint.printString("Tommy : Welcome to Nook’s Cranny! I'm Tommy, and this is Timmy.", false);
        IterativePrint.printString("Timmy: … Timmy!", false);
        IterativePrint.printString("Tommy: Do you have anything to sell?");
        while (true) {
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
                    IterativePrint.printString("Tommy: No problem! Feel free to come back anytime.", false);
                    IterativePrint.printString("Timmy: ...anytime.", true);
                    return;
                default:
                    IterativePrint.printString("Tommy: You can't sell those here, do you have anything else to sell?");
            }
        }
    }

    private void sellItems(ArrayList<? extends Item> inventory, Character player) {
        IterativePrint.clearScreen();
        if (inventory.isEmpty()) {
            System.out.println("Tommy: Looks like you have no items to sell, you can try another catagory!");
            return;
        }

        int totalEarned = 0;
        for (Item item : inventory) {
            totalEarned += item.bell_value;
        }

        player.money += totalEarned;
        inventory.clear();
        System.out.println("You sold your items for " + totalEarned + " Bells!");
        IterativePrint.printString("Tommy: Thanks for your business!");
        IterativePrint.printString("Timmy: ...business!", true);
    }
}
