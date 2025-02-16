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
    public static void Game(ArrayList<Fish> fishList, Character player) throws InterruptedException {
        IterativePrint.clearScreen();
        
        // animateRiver.main();
        // IterativePrint.printString("Welcome to the river!", true);
        // IterativePrint.printString("There are plenty of fish to catch!", true);
        // IterativePrint.printString("Type 'cast' to cast your rod!");
        // IterativePrint.printString("Type 'reel' to reel in your line! But be careful to not mistype!");
        // IterativePrint.printString("Ready to fish? Type 'cast'!");
        // castAnimation.main();
        Fish rewardFish = selectFish(fishList);
        waitForFish.main(rewardFish);
        System.out.println("You feel a fish tugging on the line!");
        boolean catchStatus = reelFish.main(rewardFish);
        if (catchStatus == true) {
            System.out.println(rewardFish.ascii_art);
            System.out.println("Congrats! You caught a " + rewardFish.name);
            player.fishInv.addFirst(rewardFish);
        } else if (catchStatus == false) {
            System.out.println("Oh no! The fish got away!");
        }

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
    //class for painful little river/water/waves ascii animation, includes various methods for adjusting size/intensity/various aspects of the wave
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
    public static String modifyWave(String line, Random random) {
        char[] chars = line.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '~' && random.nextInt(10) > 7) {
                chars[i] = (random.nextBoolean()) ? ' ' : '~';
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
    
    public static void main() throws InterruptedException {
        Scanner input = new Scanner(System.in);
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
            castAnimation.main();
        }
        input.close();
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
        double duration = (fish.size * 1.5);
        double endTime = System.currentTimeMillis() + (duration * 500);


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
    public static boolean main(Fish fish) {
        Scanner input = new Scanner(System.in);
        Random random = new Random();

        double reelCountBound = fish.size * 1.5;
        int reelCountBoundInt = (int) reelCountBound;

        int reelCount = random.nextInt((reelCountBoundInt - fish.size) + 1) + fish.size;
        boolean catchStatus = true;
        
        System.out.println("Now! Type 'reel' to reel in your line!!");
        for(int i=0; i<=reelCount; i++) {
            if (input.hasNextLine()){
                String reel = input.nextLine();

                if (reel.equals("reel") && (i < reelCount)) {
                    System.out.println("Again!!");
                    catchStatus=true;
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
        }
        input.close();
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