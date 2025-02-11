import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Fish extends Item {

    public Fish(String[] values) {
        super(values);
    }

    public static void Game(ArrayList<Fish> fishList, Character player) throws InterruptedException {
        IterativePrint.clearScreen();
        animateRiver.main();
        IterativePrint.printString("Welcome to the river!", true);
        IterativePrint.printString("There are plenty of fish to catch!", true);
        IterativePrint.printString("Ready to fish?");
        IterativePrint.printString("When ready, type 'cast' to cast your rod!");
        castAnimation.main();
        waitForFish.main();
        //animateRiver();

    }

    // public static void animateBobber() throws InterruptedException {
    //     String[] frames = {
    //         "      ~~~~~~~~~~~~~~~\n      ~    O~~~     ~\n      ~~~~~~~~~~~~~~~",
    //         "      ~~~~~~~~~~~~~~~\n      ~     O~~~    ~\n      ~~~~~~~~~~~~~~~",
    //         "      ~~~~~~~~~~~~~~~\n      ~      O~~~   ~\n      ~~~~~~~~~~~~~~~"
    //     };
    //     for (int i = 0; i < 10; i++) {
    //         IterativePrint.clearScreen();
    //         System.out.println(frames[i % frames.length]);
    //         try {
    //             Thread.sleep(500); // 500ms delay
    //         } catch (InterruptedException e) {
    //             e.printStackTrace();
    //         }
    //     }
    // }

    

    public static String selectFish() {
        return fish; 
    }
    
}

class animateRiver {
    static String[] river = {
    "~  ~  ~  ~  ~  ~  ~  ~  ~  ~  ~  ~  ~  ~  ~  ~  ~  ~  ~  ~  ",
    "  ~    ~  ~    ~~   ~~    ~   ~~~    ~    ~~   ~  ~~   ~   ",
    "~  ~  ~  ~  ~  ~~~~  ~   ~~  ~    ~   ~~~  ~~   ~~   ~   ~  ",
    "  ~    ~    ~  ~~    ~   ~   ~~  ~~   ~    ~~~   ~  ~~~  ~  ",
    "~  ~  ~~   ~  ~  ~  ~~   ~~   ~  ~~   ~~~  ~    ~~   ~~  ~  ",
    "  ~    ~~~   ~    ~   ~   ~~   ~~  ~   ~~   ~~   ~  ~~~  ~  ",
    "~~  ~  ~   ~  ~  ~   ~   ~~   ~~~~   ~    ~~   ~  ~~   ~  ~  ",
    "  ~  ~~   ~  ~   ~    ~~   ~   ~~   ~~  ~~~   ~   ~  ~~  ~  ",
    "~  ~   ~  ~~  ~   ~~   ~  ~~   ~~~   ~   ~~   ~   ~~   ~~  ",
    "  ~   ~~  ~~~   ~~  ~    ~~   ~~   ~~  ~~~  ~~   ~~   ~~  ~  ",
    "  ~    ~  ~    ~~   ~~    ~   ~~~    ~    ~~   ~  ~~   ~   ",
    "~  ~  ~  ~  ~  ~  ~  ~  ~  ~  ~  ~  ~  ~  ~  ~  ~  ~  ~  ~  "
    };
    static boolean running = true;
    public static void main() throws InterruptedException {
        Scanner input = new Scanner(System.in);
    
        Random random = new Random();
        int direction =1;
        int shift =0;
            
        Thread inputThread = new Thread(() -> {
            input.nextLine();
            running=false;
        });
        inputThread.start();

        while (running) {
            IterativePrint.clearScreen();
        for (String line : river) {
            System.out.println(shiftLine(modifyWave(line, random), shift));
        }

        shift += direction;
        if (shift >= 2 || shift <= -2) {
            direction *= -1; // Change direction after shifting a few steps
        }

        try {
            Thread.sleep(300); // Adjust speed of animation
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
    public static String modifyWave(String line, Random random) {
        char[] chars = line.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '~' && random.nextInt(10) > 7) {
                chars[i] = (random.nextBoolean()) ? ' ' : '~'; // Occasionally remove or add waves
            }
        }
        return new String(chars);
    }

    public static String shiftLine(String line, int shift) {
        if (shift > 0) {
            return " ".repeat(shift) + line.substring(0, Math.max(0, line.length() - shift));
        } else if (shift < 0) {
            return line.substring(-shift) + " ".repeat(-shift);
        }
        return line;
    }
}

class castAnimation {
    static String[] frames = {
        // Rod Casting and Water Waves
        "   \n         | \n         | \n         | \n         | \n~~~~~~~~~~~~~~~\n~  ~~~ ~ ~~  ~  ~~~ ~ ~~~~ ~~",
        "   \n         |\\  \n         | \\ \n         |  \\ \n         |   \\ \n~~~~~~~~~~~~~~~\n ~~  ~  ~ ~~   ~ ~~~  ~~  ~  ~~ ~~",
        "   \n         |   \\ \n         |    \\ \n         |     \\ \n         |      \\ \n~~~~~~~~~~~~~~~\n  ~  ~  ~~ ~   ~ ~~~~ ~ ~~~  ~ ~ ~~",
        "   \n         |     \\ \n         |      \\ \n         |       \\ \n         |        \\ \n~~~~~~~~~~~~~~~\n ~  ~~  ~   ~ ~~~~   ~~  ~    ~~~ ~ ",
        "   \n         |       \\ \n         |        \\ \n         |         \\ \n         |          \\ \n~~~~~~~~~~~~~~~\n ~   ~   ~ ~   ~~  ~~ ~    ~ ~   ~",
        "   \n         |         \\ \n         |          \\ \n         |           \\ \n         |            \\~~ ~~~~  ~~ ~ ~\n~~~~~~~~~~~~~~~ \n ~  ~~~ ~ ~~  ~  ~~~ ~ ~~~~ ~~ ",
        "   \n         |         \\ \n         |          \\ \n         |           \\ \n         |            \\~ ~~~~ ~~  ~  ~\n~~~~~~~~~~~~~~~ \n~~  ~  ~ ~~   ~ ~~~  ~~  ~  ~~ ~~",
        "   \n         |         \\ \n         |          \\ \n         |           \\ \n         |            \\~~ ~~ ~~ ~ ~~  \n~~~~~~~~~~~~~~~ \n ~  ~  ~~ ~   ~ ~~~~ ~ ~~~  ~ ~ ~~",
        "   \n         |         \\ \n         |          \\ \n         |           \\ \n         |            \\~~~ ~~ ~ ~ ~~ ~\n~~~~~~~~~~~~~~~ \n ~  ~~  ~   ~ ~~~~   ~~  ~    ~~~ ~ ",
        "   \n         |         \\ \n         |          \\ \n         |           \\ \n         |            \\~ ~~   ~ ~~~~ ~\n~~~~~~~~~~~~~~~ \n ~   ~   ~ ~   ~~  ~~ ~    ~ ~   ~",
        "   \n         |         \\ \n         |          \\ \n         |           \\ \n         |            \\~~ ~~~~  ~~ ~ ~\n~~~~~~~~~~~~~~~ \n ~  ~~~ ~ ~~  ~  ~~~ ~ ~~~~ ~~ ",
        "   \n         |         \\ \n         |          \\ \n         |           \\ \n         |            \\~ ~~~~ ~~  ~  ~\n~~~~~~~~~~~~~~~ \n~~  ~  ~ ~~   ~ ~~~  ~~  ~  ~~ ~~",
        "   \n         |         \\ \n         |          \\ \n         |           \\ \n         |            \\~~ ~~ ~~ ~ ~~  \n~~~~~~~~~~~~~~~ \n ~  ~  ~~ ~   ~ ~~~~ ~ ~~~  ~ ~ ~~",
        "   \n         |         \\ \n         |          \\ \n         |           \\ \n         |            \\~~~ ~~ ~ ~ ~~ ~\n~~~~~~~~~~~~~~~ \n ~  ~~  ~   ~ ~~~~   ~~  ~    ~~~ ~ ",
        "   \n         |         \\ \n         |          \\ \n         |           \\ \n         |            \\~ ~~   ~ ~~~~ ~\n~~~~~~~~~~~~~~~ \n ~   ~   ~ ~   ~~  ~~ ~    ~ ~   ~",
        "   \n         |         \\ \n         |          \\ \n         |           \\ \n         |            \\~~ ~~~~  ~~ ~ ~\n~~~~~~~~~~~~~~~ \n ~  ~~~ ~ ~~  ~  ~~~ ~ ~~~~ ~~ ",
        "   \n         |         \\ \n         |          \\ \n         |           \\ \n         |            \\~ ~~~~ ~~  ~  ~\n~~~~~~~~~~~~~~~ \n~~  ~  ~ ~~   ~ ~~~  ~~  ~  ~~ ~~",
        "   \n         |         \\ \n         |          \\ \n         |           \\ \n         |            \\~~ ~~ ~~ ~ ~~  \n~~~~~~~~~~~~~~~ \n ~  ~  ~~ ~   ~ ~~~~ ~ ~~~  ~ ~ ~~",
        "   \n         |         \\ \n         |          \\ \n         |           \\ \n         |            \\~~~ ~~ ~ ~ ~~ ~\n~~~~~~~~~~~~~~~ \n ~  ~~  ~   ~ ~~~~   ~~  ~    ~~~ ~ ",
        "   \n         |         \\ \n         |          \\ \n         |           \\ \n         |            \\~ ~~   ~ ~~~~ ~\n~~~~~~~~~~~~~~~ \n ~   ~   ~ ~   ~~  ~~ ~    ~ ~   ~"
    };
    
    public static void main() throws InterruptedException {
        Scanner input = new Scanner(System.in);
        if ((input.nextLine()).equals("cast")) {
            for (String frame : frames) {
                IterativePrint.clearScreen();
                System.out.println(frame);
                try {
                    Thread.sleep(300); // Adjust speed of casting animation
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        } 
        input.close();
    }
}

class waitForFish {
    static String[] frames = {
        "   \n         |         \\ \n         |          \\ \n         |           \\ \n         |            \\~ ~~~~ ~~  ~  ~\n~~~~~~~~~~~~~~~ \n~~  ~  ~ ~~   ~ ~~~  ~~  ~  ~~ ~~",
        "   \n         |         \\ \n         |          \\ \n         |           \\ \n         |            \\~~ ~~ ~~ ~ ~~  \n~~~~~~~~~~~~~~~ \n ~  ~  ~~ ~   ~ ~~~~ ~ ~~~  ~ ~ ~~",
        "   \n         |         \\ \n         |          \\ \n         |           \\ \n         |            \\~~~ ~~ ~ ~ ~~ ~\n~~~~~~~~~~~~~~~ \n ~  ~~  ~   ~ ~~~~   ~~  ~    ~~~ ~ ",
        "   \n         |         \\ \n         |          \\ \n         |           \\ \n         |            \\~ ~~   ~ ~~~~ ~\n~~~~~~~~~~~~~~~ \n ~   ~   ~ ~   ~~  ~~ ~    ~ ~   ~",
        "   \n         |         \\ \n         |          \\ \n         |           \\ \n         |            \\~~ ~~~~  ~~ ~ ~\n~~~~~~~~~~~~~~~ \n ~  ~~~ ~ ~~  ~  ~~~ ~ ~~~~ ~~ ",
        "   \n         |         \\ \n         |          \\ \n         |           \\ \n         |            \\~ ~~~~ ~~  ~  ~\n~~~~~~~~~~~~~~~ \n~~  ~  ~ ~~   ~ ~~~  ~~  ~  ~~ ~~",
        "   \n         |         \\ \n         |          \\ \n         |           \\ \n         |            \\~~ ~~ ~~ ~ ~~  \n~~~~~~~~~~~~~~~ \n ~  ~  ~~ ~   ~ ~~~~ ~ ~~~  ~ ~ ~~",
        "   \n         |         \\ \n         |          \\ \n         |           \\ \n         |            \\~~~ ~~ ~ ~ ~~ ~\n~~~~~~~~~~~~~~~ \n ~  ~~  ~   ~ ~~~~   ~~  ~    ~~~ ~ ",
        "   \n         |         \\ \n         |          \\ \n         |           \\ \n         |            \\~ ~~   ~ ~~~~ ~\n~~~~~~~~~~~~~~~ \n ~   ~   ~ ~   ~~  ~~ ~    ~ ~   ~",
        "   \n         |         \\ \n         |          \\ \n         |           \\ \n         |            \\~~ ~~~~  ~~ ~ ~\n~~~~~~~~~~~~~~~ \n ~  ~~~ ~ ~~  ~  ~~~ ~ ~~~~ ~~ ",
        "   \n         |         \\ \n         |          \\ \n         |           \\ \n         |            \\~ ~~~~ ~~  ~  ~\n~~~~~~~~~~~~~~~ \n~~  ~  ~ ~~   ~ ~~~  ~~  ~  ~~ ~~",
        "   \n         |         \\ \n         |          \\ \n         |           \\ \n         |            \\~~ ~~ ~~ ~ ~~  \n~~~~~~~~~~~~~~~ \n ~  ~  ~~ ~   ~ ~~~~ ~ ~~~  ~ ~ ~~",
        "   \n         |         \\ \n         |          \\ \n         |           \\ \n         |            \\~~~ ~~ ~ ~ ~~ ~\n~~~~~~~~~~~~~~~ \n ~  ~~  ~   ~ ~~~~   ~~  ~    ~~~ ~ ",
        "   \n         |         \\ \n         |          \\ \n         |           \\ \n         |            \\~ ~~   ~ ~~~~ ~\n~~~~~~~~~~~~~~~ \n ~   ~   ~ ~   ~~  ~~ ~    ~ ~   ~"
    };
        
    public static void main() throws InterruptedException {
        int duration = 5;
        long endTime = System.currentTimeMillis() + (duration * 1000);


        while (System.currentTimeMillis() < endTime) {
            for (String frame : frames) {
                IterativePrint.clearScreen();
                System.out.println(frame);
                try {
                    Thread.sleep(300); // Adjust speed of casting animation
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}



// show little river animation while starting text
// player types cast to cast their line out, little casting rahrah
// wait random time for fish to bite, between x and x seconds
// print message to indicate something is tugging on line
// when times up, print nNOW and you have to type reel as quick as possible
// if you mistype, you dont catch, how many times you have to type is based on rarity
// time limit too
//if caught, print ascii art and info saying you caught and add to inventory