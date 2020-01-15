package controller;

import domain.*;
import view.ArrowInput;

import java.util.ArrayList;
import java.util.List;

public class StageController {
	private Player player;
	private int stage = 1;
	private Map map;
	private List<SnapShot> SnapShots = new ArrayList<SnapShot>();
	private ArrowInput arrowInput;


	public StageController() {
		this.player = new Player();
		this.map = new Map();
		this.arrowInput = new ArrowInput(this);
		initStage();
	}

	public void initStage() {
		map.setMap(this.stage);
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

	public void movePlayer(Integer cursor) {
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


		if (cursor == Cursor.UP) {
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
		} else if (cursor == Cursor.DOWN) {
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
		} else if (cursor == Cursor.LEFT) {
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
		} else if (cursor == Cursor.RIGHT) {
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
		} else if (cursor == Cursor.BACK_SPACE) {
			loadSnapShot();
		}

		if (map.isStageClear()) {
			this.stage++;
			try {
				initStage();
			} catch (ArrayIndexOutOfBoundsException e) {
				map.printMap();
				System.out.println("게임 종료");
				System.exit(0);
			}
		}
		map.printMap();
	}

	public void takeSnapShot() {
		if (SnapShots.size() > 2) {
			SnapShots.remove(0);
		}
		SnapShots.add(new SnapShot(player.cloneAxis(), map.cloneMap()));
	}

	public void loadSnapShot() {
		try {
			SnapShot snapShot = SnapShots.remove(SnapShots.size() - 1);
			player.setAxis(snapShot.getPlayerAxis());
			map.setMap(snapShot.getMap());
		} catch (ArrayIndexOutOfBoundsException e) {
		}

	}
}
