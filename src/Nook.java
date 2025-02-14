public class Nook {
    public static boolean Office(Character player){
        if (player.money >= player.debt){
            IterativePrint.printString("Tom Nook: Well if I'll be, you actually paid off your debt [Player]! I guess you're not as useless as I thought. Congratulations, the island house is all yours now. Now scram you rascal!");
            return true;
        } else {
            IterativePrint.printString("Tom Nook: What? You don't even have enough money! Get back out there and earn more bells! I want my money [player], and I want it now!");
            return false;
        }
    }
}
