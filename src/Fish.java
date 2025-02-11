import java.util.ArrayList;
import java.util.Scanner;

public class Fish extends Item {

    public Fish(String[] values) {
        super(values);
    }

    public static void Game(ArrayList<Fish> fishList, Character player) throws InterruptedException {
        IterativePrint.clearScreen();
        IterativePrint.printString("Welcome to the river!", true);
        IterativePrint.printString("There are plenty of fish to catch!", true);

        animateBobber();

    }

    public static void animateBobber() throws InterruptedException {
        String[] frames = {
            "      ~~~~~~~~~~~~~~~\n      ~    O~~~     ~\n      ~~~~~~~~~~~~~~~",
            "      ~~~~~~~~~~~~~~~\n      ~     O~~~    ~\n      ~~~~~~~~~~~~~~~",
            "      ~~~~~~~~~~~~~~~\n      ~      O~~~   ~\n      ~~~~~~~~~~~~~~~"
        };
    
        for (int i = 0; i < 10; i++) {
            IterativePrint.clearScreen();
            System.out.println(frames[i % frames.length]);
            Thread.sleep(500); // 500ms delay
        }
    }

    public static void castLine() {
        Scanner input = new Scanner(System.in);
        



        input.close();

    }

    // public static String selectFish() {
    //     return fish; 
    // }
    
}





// show little river animation while starting text
// player types cast to cast their line out, little casting rahrah
// 