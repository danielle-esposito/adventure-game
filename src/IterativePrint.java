public class IterativePrint {
    public  static void printString(String text){
        for (char character : text.toCharArray()) {
            System.out.print(character);
            try {
            Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
