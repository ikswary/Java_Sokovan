package view;

import java.util.Scanner;
import Exception.OutOfMenuException;

public class ConsoleInput {
    private static Scanner scanner = new Scanner(System.in);
    final static Integer GAME_START = 1;
    final static Integer EXIT = 2;

    public static Integer getIntFromConsole() {
        Integer input = null;

        try {
            input = scanner.nextInt();
            if (input != GAME_START && input != EXIT) {
                throw new OutOfMenuException();
            }
        } catch (OutOfMenuException e) {
            System.out.println("유효한 메뉴를 선택하십시오");
            getIntFromConsole();
        }
        return input;
    }
}
