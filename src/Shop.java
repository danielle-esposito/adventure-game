// Written by Ludun and Alex
// Class for visting the shop to sell Items

import java.util.Scanner;
import java.util.ArrayList;

public class Shop {
    public void visitShop(Character player) { // Main method to trigger sequence when the shop is visited
        Scanner input = new Scanner(System.in); // Start scanner
        IterativePrint.clearScreen(); // Clear screen
        IterativePrint.printString("Tommy : Welcome to Nook’s Cranny! I'm Tommy, and this is Timmy.", false); // Dialogue
        IterativePrint.printString("Timmy: … Timmy!", false);
        IterativePrint.printString("Tommy: Do you have anything to sell?");

        while (true) { // Menu loop
            System.out.println("[1] Sell Fish"); // Display options to user
            System.out.println("[2] Sell Bugs");
            System.out.println("[3] Sell Fruits");
            System.out.println("[4] Exit Shop");

            String choice = input.nextLine();

            switch (choice) { // Switch-case to handle user's choice
                case "1":
                    sellItems(player.fishInv, player); // Call to sell items depending on the item type chosen to sell
                    break;
                case "2":
                    sellItems(player.bugInv, player);
                    break;
                case "3":
                    sellItems(player.fruitInv, player);
                    break;
                case "4": // player choses to leave
                    IterativePrint.printString("Tommy: No problem! Feel free to come back anytime.", false);
                    IterativePrint.printString("Timmy: ...anytime.", true);
                    return;
                default: // Handling invalid input
                    IterativePrint.printString("Tommy: You can't sell those here, do you have anything else to sell?");
            }
        }
    }

    private void sellItems(ArrayList<? extends Item> inventory, Character player) { // To sell the items the specific inventory of the item type that is being sold is bought in as an ArrayList using generics
        IterativePrint.clearScreen();
        if (inventory.isEmpty()) { // If their inventory ArrayList is empty then turn tell user and turn them away 
            System.out.println("Tommy: Looks like you have no items to sell, you can try another catagory!");
            return;
        }

        int totalEarned = 0; 
        for (Item item : inventory) { // Loop through objects in the ArrayList and total their values
            totalEarned += item.bell_value;
        }

        player.money += totalEarned; // Add the value total to the players money balance
        inventory.clear();  // Clear the arrayList
        System.out.println("You sold your items for " + totalEarned + " Bells!"); // Tell the user of what they earned
        IterativePrint.printString("Tommy: Thanks for your business!");
        IterativePrint.printString("Timmy: ...business!", true);
    }
}
