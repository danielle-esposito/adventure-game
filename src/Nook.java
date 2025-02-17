// Written by Ludun
// Class for visiting Tom Nook's office

public class Nook {
    public static boolean Office(Character player){ 
        IterativePrint.clearScreen();
        if (player.money >= player.debt){ // Check if the players money is higher than their debt value, if it is inform the player they've won!
            IterativePrint.printString("Tom Nook: Well if I'll be, you actually paid off your debt " + player.name + "! I guess you're not as useless as I thought. Congratulations, the island house is all yours now. Now scram you rascal!");
            return true;
        } else { // If the player came to nook before getting enough money they are turned away
            IterativePrint.printString("Tom Nook: What? You don't even have enough money! Get back out there and earn more bells! I want my money " + player.name + ", and I want it now!");
            return false;
        }
    }
}
