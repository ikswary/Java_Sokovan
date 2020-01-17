package controller;

import domain.Cursor;
import domain.MapDB;
import service.StageManager;
import utils.utility;
import view.ArrowInput;

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

        if (cursor == Cursor.UP.getCursorInteger()) {
            stageClear = stageManager.movePlayer(Cursor.UP);
        } else if (cursor == Cursor.DOWN.getCursorInteger()) {
            stageClear = stageManager.movePlayer(Cursor.DOWN);
        } else if (cursor == Cursor.LEFT.getCursorInteger()) {
            stageClear = stageManager.movePlayer(Cursor.LEFT);
        } else if (cursor == Cursor.RIGHT.getCursorInteger()) {
            stageClear = stageManager.movePlayer(Cursor.RIGHT);
        } else if (cursor == Cursor.BACK_SPACE.getCursorInteger()) {
            stageClear = stageManager.movePlayer(Cursor.BACK_SPACE);
        }
        if (stageClear.equals(true)) {
            try {
                stageManager.initStage(stageOrder.remove(0));
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Game Clear");
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
        setRandomStageOrder(MapDB.map.length);
        stageManager.initStage(stageOrder.remove(0)); // 첫번째 스테이지 로딩
        this.arrowInput = new ArrowInput(this);
    }
}
