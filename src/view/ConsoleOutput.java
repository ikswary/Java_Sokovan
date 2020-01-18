package view;

public class ConsoleOutput {
    public static void printChangingStage() {
        for (int i = 0; i < 10; i++) {
            System.out.println("");
        }
        System.out.println("Stage Clear!\nLoading Stage");
        System.out.println("\n\n\n");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
        }
    }

    public static void printGameMenu(){
        System.out.println("1. Play Sokovan");
        System.out.println("2. EXIT");
    }
}
