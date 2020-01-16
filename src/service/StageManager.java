package service;

import domain.*;
import view.ArrowInput;

import java.util.ArrayList;
import java.util.List;

public class StageManager {
	private Player player;
	private Map map;
	private List<SnapShot> snapShots;


	public StageManager() {
		this.player = new Player();
		this.map = new Map();
        this.snapShots = new ArrayList<SnapShot>();
	}

	public void initStage(Integer stage) {
		map.setMap(stage);
		this.player.setAxis(MapDB.playerAxis[stage - 1]);
		map.printMap();
	}

	private Boolean isAxisEmpty(Integer axisX, Integer axisY) {
		return map.getMap()[axisX][axisY].equals(' ')
				|| map.getMap()[axisX][axisY].equals('*');
	}

	private Boolean isAxisBox(Integer axisX, Integer axisY) {
		return map.getMap()[axisX][axisY].equals('B');
	}

	private void performMove(Integer currentAxisX, Integer currentAxisY
			, Integer postAxisX, Integer postAxisY) {
		map.moveByIndex(currentAxisX, currentAxisY, postAxisX, postAxisY);
		player.setAxis(new Integer[]{postAxisX, postAxisY});
	}

	public void movePlayer(Cursor cursor) {
		Integer axisX = player.getAxisX();
		Integer axisY = player.getAxisY();
		final Integer AXIS_UP = axisX - 1;
		final Integer AXIS_DOWN = axisX + 1;
		final Integer AXIS_LEFT = axisY - 1;
		final Integer AXIS_RIGHT = axisY + 1;
		final Integer AXIS_UPX2 = axisX - 2;
		final Integer AXIS_DOWNX2 = axisX + 2;
		final Integer AXIS_LEFTX2 = axisY - 2;
		final Integer AXIS_RIGHTX2 = axisY + 2;


		if (cursor.equals(Cursor.UP)) {
			if (isAxisEmpty(AXIS_UP, axisY)) {
				takeSnapShot();
				performMove(axisX, axisY, AXIS_UP, axisY);
			} else if (isAxisBox(AXIS_UP, axisY)) {
				if (isAxisEmpty(AXIS_UPX2, axisY)) {
					takeSnapShot();
					map.moveByIndex(AXIS_UP, axisY, AXIS_UPX2, axisY);
					performMove(axisX, axisY, AXIS_UP, axisY);
				}
			}
		} else if (cursor.equals(Cursor.DOWN)) {
			if (isAxisEmpty(AXIS_DOWN, axisY)) {
				takeSnapShot();
				performMove(axisX, axisY, AXIS_DOWN, axisY);
			} else if (isAxisBox(AXIS_DOWN, axisY)) {
				if (isAxisEmpty(AXIS_DOWNX2, axisY)) {
					takeSnapShot();
					map.moveByIndex(AXIS_DOWN, axisY, AXIS_DOWNX2, axisY);
					performMove(axisX, axisY, AXIS_DOWN, axisY);
					// 아래로 밀고 이동
				}
			}
		} else if (cursor.equals(Cursor.LEFT)) {
			if (isAxisEmpty(axisX, AXIS_LEFT)) {
				takeSnapShot();
				performMove(axisX, axisY, axisX, AXIS_LEFT);
			} else if (isAxisBox(axisX, AXIS_LEFT)) {
				if (isAxisEmpty(axisX, AXIS_LEFTX2)) {
					takeSnapShot();
					map.moveByIndex(axisX, AXIS_LEFT, axisX, AXIS_LEFTX2);
					performMove(axisX, axisY, axisX, AXIS_LEFT);
					// 왼쪽으로 밀고 이동
				}
			}
		} else if (cursor.equals(Cursor.RIGHT)) {
			if (isAxisEmpty(axisX, AXIS_RIGHT)) {
				takeSnapShot();
				performMove(axisX, axisY, axisX, AXIS_RIGHT);
			} else if (isAxisBox(axisX, AXIS_RIGHT)) {
				if (isAxisEmpty(axisX, AXIS_RIGHTX2)) {
					takeSnapShot();
					map.moveByIndex(axisX, AXIS_RIGHT, axisX, AXIS_RIGHTX2);
					performMove(axisX, axisY, axisX, AXIS_RIGHT);
					// 위로 밀고 이동
				}
			}
		} else if (cursor.equals(Cursor.BACK_SPACE)) {
			loadSnapShot();
		}

		if (map.isStageClear()) {
			for (int i = 0; i < 3; i++) {
				this.snapShots.remove(0);
			}

		}
		map.printMap();
	}

	public void takeSnapShot() {
		if (snapShots.size() > 2) {
			snapShots.remove(0);
		}
		snapShots.add(new SnapShot(player.cloneAxis(), map.cloneMap()));
	}

	public void loadSnapShot() {
		try {
			SnapShot snapShot = snapShots.remove(snapShots.size() - 1);
			player.setAxis(snapShot.getPlayerAxis());
			map.setMap(snapShot.getMap());
		} catch (ArrayIndexOutOfBoundsException e) {
		}

	}
}
