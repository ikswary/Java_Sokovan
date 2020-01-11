package domain;

import view.Output;

import java.util.ArrayList;
import java.util.List;

public class Sokovan {
	private Player player;
	private int stage = 1;
	private Map map;
	private List<SnapShot> SnapShots = new ArrayList<SnapShot>();


	public Sokovan() {
		this.player = new Player();
		this.map = new Map();
		initStage();
	}

	public void initStage() {
		map.setMap(this.stage);
		this.player.setAxis(Stage.playerAxis[stage - 1]);
	}

	public void printMap() {
		Output.printMap(this.map.getMap());
		/*
		클리어 좌표 복사 확인 코드
		for (int i = 0; i < this.clearAxis.length; i++) {
			System.out.println(clearAxis[i][0].toString() + ", " + clearAxis[i][1].toString());
		}

		 */
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

		takeSnapShot();
		if (cursor == Cursor.UP) {
			if (isAxisEmpty(AXIS_UP, axisY)) {
				performMove(axisX, axisY, AXIS_UP, axisY);
			} else if (isAxisBox(AXIS_UP, axisY)) {
				if (isAxisEmpty(AXIS_UPX2, axisY)) {
					map.moveByIndex(AXIS_UP, axisY, AXIS_UPX2, axisY);
					performMove(axisX, axisY, AXIS_UP, axisY);
				}
			}
		} else if (cursor == Cursor.DOWN) {
			if (isAxisEmpty(AXIS_DOWN, axisY)) {
				performMove(axisX, axisY, AXIS_DOWN, axisY);
			} else if (isAxisBox(AXIS_DOWN, axisY)) {
				if (isAxisEmpty(AXIS_DOWNX2, axisY)) {
					map.moveByIndex(AXIS_DOWN, axisY, AXIS_DOWNX2, axisY);
					performMove(axisX, axisY, AXIS_DOWN, axisY);
					// 아래로 밀고 이동
				}
			}
		} else if (cursor == Cursor.LEFT) {
			if (isAxisEmpty(axisX, AXIS_LEFT)) {
				performMove(axisX, axisY, axisX, AXIS_LEFT);
			} else if (isAxisBox(axisX, AXIS_LEFT)) {
				if (isAxisEmpty(axisX, AXIS_LEFTX2)) {
					map.moveByIndex(axisX, AXIS_LEFT, axisX, AXIS_LEFTX2);
					performMove(axisX, axisY, axisX, AXIS_LEFT);
					// 왼쪽으로 밀고 이동
				}
			}
		} else if (cursor == Cursor.RIGHT) {
			if (isAxisEmpty(axisX, AXIS_RIGHT)) {
				performMove(axisX, axisY, axisX, AXIS_RIGHT);
			} else if (isAxisBox(axisX, AXIS_RIGHT)) {
				if (isAxisEmpty(axisX, AXIS_RIGHTX2)) {
					map.moveByIndex(axisX, AXIS_RIGHT, axisX, AXIS_RIGHTX2);
					performMove(axisX, axisY, axisX, AXIS_RIGHT);
					// 위로 밀고 이동
				}
			}
		} else if (cursor == Cursor.BACK_SPACE) {
			loadSnapShot();
		}

		System.out.println(player.getAxisX() + ", " + player.getAxisY());
		if (map.isStageClear()) {
			this.stage++;
			initStage();
		}
		printMap();
	}

	public void takeSnapShot() {
		if(SnapShots.size() < 3) {
			SnapShots.add(new SnapShot(player.cloneAxis(), map.cloneMap()));
		}
	}

	public void loadSnapShot() {
		SnapShot snapShot = SnapShots.remove(SnapShots.size());
		player.setAxis(snapShot.getPlayerAxis());
		map.setMap(snapShot.getMap());
	}
}
