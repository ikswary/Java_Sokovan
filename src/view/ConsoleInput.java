package view;

import java.util.InputMismatchException;
import java.util.Scanner;
import Exception.OutOfMenuException;

public class ConsoleInput {
    private static Scanner scanner = new Scanner(System.in);
    private final static Integer GAME_START = 1;
    private final static Integer EXIT = 2;

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
        } catch (InputMismatchException e) {
            System.out.println("잘못된 입력입니다");
            getIntFromConsole();
        }
        return input;
    }
}
