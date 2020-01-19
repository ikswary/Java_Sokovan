package controller;

import domain.Cursor;
import domain.MapDB;
import service.StageManager;
import utils.utility;
import view.ArrowInput;
import view.ConsoleInput;
import view.ConsoleOutput;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SokovanMaster {
    private StageManager stageManager;
    private List<Integer> stageOrder;
    private ArrowInput arrowInput;

    public SokovanMaster() {
        this.stageManager = new StageManager();
        this.stageOrder = new ArrayList<Integer>();
    }

    public void movePlayerWithInteger(Integer cursor) {
        Boolean stageClear = false;
        if (cursor.equals(Cursor.UP.getCursorInteger())) {
            stageClear = stageManager.movePlayer(Cursor.UP);
        } else if (cursor.equals(Cursor.DOWN.getCursorInteger())) {
            stageClear = stageManager.movePlayer(Cursor.DOWN);
        } else if (cursor.equals(Cursor.LEFT.getCursorInteger())) {
            stageClear = stageManager.movePlayer(Cursor.LEFT);
        } else if (cursor.equals(Cursor.RIGHT.getCursorInteger())) {
            stageClear = stageManager.movePlayer(Cursor.RIGHT);
        } else if (cursor.equals(Cursor.BACK_SPACE.getCursorInteger())) {
            stageClear = stageManager.movePlayer(Cursor.BACK_SPACE);
        }
        if (stageClear.equals(true)) {
            try {
                System.out.println("\n\n\n\n\n\nStage Clear!");
                ConsoleOutput.printChangingStage();
                sleep(3000);
                arrowInput.dispose();
                this.arrowInput = new ArrowInput(this);
                stageManager.initStage(stageOrder.remove(0));
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Game Clear\n\n\n\n\n");
                System.exit(0);
            }
        }

    }

    private void setRandomStageOrder(Integer maxStage) {
        List<Integer> stageOrder = utility.getListByInteger(maxStage);
        Collections.shuffle(stageOrder);
        this.stageOrder = stageOrder;
    }

    public void startSokovan() {
        Integer selectedMenu = selectMenu();

        if (selectedMenu == 1) {
            setRandomStageOrder(MapDB.map.length);
            stageManager.initStage(stageOrder.remove(0)); // 첫번째 스테이지 로딩
            this.arrowInput = new ArrowInput(this);
        } else if (selectedMenu == 2) {
            System.out.println("Sokovan을 종료합니다");
            System.exit(0);
        }

    }

    private Integer selectMenu() {
        ConsoleOutput.printGameMenu();
        return ConsoleInput.getIntFromConsole();
    }

    private void sleep(Integer time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
        }
    }
}
