// author: dani esposito
// class for fish and for making/playing the minigame

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Fish extends Item {

    public Fish(String[] values) {
        super(values);
    }
    // section of code that handles execution of the game itself
    public static void Game(ArrayList<Fish> fishList, Character player, Scanner input) throws InterruptedException {
        //Scanner input = new Scanner(System.in); //defined scanner globally
        IterativePrint.clearScreen();
        
        animateRiver.main(input);
        IterativePrint.printString("Welcome to the river!", true);
        IterativePrint.printString("There are plenty of fish to catch!", true);
        IterativePrint.printString("Type 'cast' to cast your rod!");
        IterativePrint.printString("Type 'reel' to reel in your line! But be careful to not mistype!");
        IterativePrint.printString("Ready to fish? Type 'cast'!");
        castAnimation.main(input);
        Fish rewardFish = selectFish(fishList); //selects a random fish from csv file and sets it equal to rewardFish
        waitForFish.main(rewardFish); //runs the wait in water animation for a time determined by fish size
        System.out.println("You feel a fish tugging on the line!");
        boolean catchStatus = reelFish.main(rewardFish, input); //calls the reelFish class and returns a boolean if a fish was caught
        if (catchStatus == true) {
            rewardFish.printCapture();
            player.fishInv.addFirst(rewardFish);
        } else if (catchStatus == false) {
            System.out.println("Oh no! The fish got away!");
        }
        System.out.println("Enter to continue");
        input.nextLine();
    }

    
//method for selecting random fish from ArrayList
    public static Fish selectFish(ArrayList<Fish> fishList) {
        Random random = new Random();
        //weighted probability for selecting the size of fish
        int [] probability = {1,1,1,1,1,1,1,1,1,1,2,2,2,2,2,2,2,2,3,3,3,3,3,3,4,4,5};
        int randomIndex = random.nextInt(probability.length);
        ArrayList<Fish> sizedFishList = new ArrayList<>();
        
        //creating an array of fish that fit the size selected for reward
        for (Fish fish : fishList) {
            if (fish.size == probability[randomIndex]) {
                sizedFishList.add(fish);
            }
        }
        // selecting random fish from sized fish list
        int randomFish = random.nextInt(sizedFishList.size());
        return sizedFishList.get(randomFish);
    }
    
}

class animateRiver {
    // class for painful little river/water/waves ascii animation, includes various methods for adjusting size/intensity/various aspects of the wave
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
    public static void main(Scanner input) throws InterruptedException {
        Random random = new Random();
        int direction =1;
        int shift =0;
            
        // creates a new thread to wait for user input to stop the animation
        Thread inputThread = new Thread(() -> {
            input.nextLine();
            running=false;
        });
        inputThread.start();
        
        // loops the animation
        while (running) {
            IterativePrint.clearScreen();
            System.out.println("Enter to continue: ");
        for (String line : river) {
            System.out.println(shiftLine(modifyWave(line, random), shift));
        }

        shift += direction;
        if (shift >= 2 || shift <= -2) {
            direction *= -1;
        }

        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
    // modifies the wave pattern to add randomness 
    public static String modifyWave(String line, Random random) {
        char[] chars = line.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '~' && random.nextInt(10) > 7) {
                chars[i] = (random.nextBoolean()) ? ' ' : '~';
            }
        }
        return new String(chars);
    }
    // shifts the ascii back and forwarth
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
    //class for animating the casting of the fishing rod
    static String[] frames = {
        "   \n         | \n         | \n         | \n         | \n~~~~~~~~~~~~~~~\n~  ~~~ ~ ~~  ~  ~~~ ~ ~~~~ ~~",
        "   \n         |\\  \n         | \\ \n         |  \\ \n         |   \\ \n~~~~~~~~~~~~~~~\n ~~  ~  ~ ~~   ~ ~~~  ~~  ~  ~~ ~~",
        "   \n         |   \\ \n         |    \\ \n         |     \\ \n         |      \\ \n~~~~~~~~~~~~~~~\n  ~  ~  ~~ ~   ~ ~~~~ ~ ~~~  ~ ~ ~~",
        "   \n         |     \\ \n         |      \\ \n         |       \\ \n         |        \\ \n~~~~~~~~~~~~~~~\n ~  ~~  ~   ~ ~~~~   ~~  ~    ~~~ ~ ",
        "   \n         |       \\ \n         |        \\ \n         |         \\ \n         |          \\ \n~~~~~~~~~~~~~~~\n ~   ~   ~ ~   ~~  ~~ ~    ~ ~   ~",
        "   \n         |         \\ \n         |          \\ \n         |           \\ \n         |            \\~~ ~~~~  ~~ ~ ~\n~~~~~~~~~~~~~~~ \n ~  ~~~ ~ ~~  ~  ~~~ ~ ~~~~ ~~ ",
        "   \n         |         \\ \n         |          \\ \n         |           \\ \n         |            \\~ ~~~~ ~~  ~  ~\n~~~~~~~~~~~~~~~ \n~~  ~  ~ ~~   ~ ~~~  ~~  ~  ~~ ~~",
        "   \n         |         \\ \n         |          \\ \n         |           \\ \n         |            \\~~ ~~ ~~ ~ ~~  \n~~~~~~~~~~~~~~~ \n ~  ~  ~~ ~   ~ ~~~~ ~ ~~~  ~ ~ ~~",
        "   \n         |         \\ \n         |          \\ \n         |           \\ \n         |            \\~~~ ~~ ~ ~ ~~ ~\n~~~~~~~~~~~~~~~ \n ~  ~~  ~   ~ ~~~~   ~~  ~    ~~~ ~ ",
        "   \n         |         \\ \n         |          \\ \n         |           \\ \n         |            \\~ ~~   ~ ~~~~ ~\n~~~~~~~~~~~~~~~ \n ~   ~   ~ ~   ~~  ~~ ~    ~ ~   ~"
    };
    
    public static void main(Scanner input) throws InterruptedException {
        if ((input.nextLine()).equals("cast")) {
            for (String frame : frames) {
                IterativePrint.clearScreen();
                System.out.println(frame);
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        } else {
            IterativePrint.clearScreen();
            System.out.println("Type 'cast' to cast your rod!");
            castAnimation.main(input);
        }
    }
}

//class for repeating rod in water animation for set time based on size of fish
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
        
    public static void main(Fish fish) throws InterruptedException {
        // sets the time that the animation runs for 
        double duration = (fish.size * 1.5);
        double endTime = System.currentTimeMillis() + (duration * 500);

        // loops the animation 
        while (System.currentTimeMillis() < endTime) {
            for (String frame : frames) {
                IterativePrint.clearScreen();
                System.out.println(frame);
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

class reelFish {
    public static boolean main(Fish fish, Scanner input) {
        Random random = new Random();

        // creates dynamic random bounds depending on the size of the fish
        double reelCountBound = fish.size * 1.5;
        int reelCountBoundInt = (int) reelCountBound;

        int reelCount = random.nextInt((reelCountBoundInt - fish.size) + 1) + fish.size;
        boolean catchStatus = true;
        // for loop for typing reel to reel in the fish
        System.out.println("Now! Type 'reel' to reel in your line!!");
        for(int i=0; i<=reelCount; i++) {
            String reel = input.nextLine();
            if (reel.equals("reel") && (i < reelCount)) {
                System.out.println("Again!!");
            } else if (reel.equals("reel") && (i == reelCount)){
                System.out.println("You caught the fish!");
                catchStatus = true;
                try {
                    Thread.sleep(1500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                IterativePrint.clearScreen();
            } else {
                System.out.println("It got away!");
                catchStatus = false;
                break;
            }
        }
        return catchStatus;
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