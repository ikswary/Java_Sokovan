package domain;

import view.output;

public class Sokovan {
	private Player player;
	private int stage = 1;
	private Map map;


	public Sokovan() {
		this.player = new Player();
		this.map = new Map();
	}

	public void initStage(int stage) {
		map.setMap(stage);
		this.player.setAxis(Stage.playerAxis[stage - 1]);
	}

	public void printMap() {
		output.printMap(this.map.getMap());
		/*
		클리어 좌표 복사 확인 코드
		for (int i = 0; i < this.clearAxis.length; i++) {
			System.out.println(clearAxis[i][0].toString() + ", " + clearAxis[i][1].toString());
		}

		 */
	}

	private Boolean isAxisEmpty(Integer axisX, Integer axisY) {
		return map.getMap()[axisX][axisY].equals(' ') || map.getMap()[axisX][axisY].equals('*');
	}

	private Boolean isAxisBox(Integer axisX, Integer axisY) {
		return map.getMap()[axisX][axisY].equals('B');
	}

	public void movePlayer(Integer cursor) {
		Integer axisX = player.getAxisX();
		Integer axisY = player.getAxisY();

		if (cursor == Cursor.UP) {
			if (isAxisEmpty(axisX - 1, axisY)) {
				// 위로 이동
			} else if (isAxisBox(axisX - 1, axisY)) {
				if (isAxisEmpty(axisX - 2, axisY)) {
					// 위로 밀고 이동
				}
			}
		} else if (cursor == Cursor.DOWN) {
			if (isAxisEmpty(axisX - 1, axisY)) {
				// 아래로 이동
			} else if (isAxisBox(axisX + 1, axisY)) {
				if (isAxisEmpty(axisX + 2, axisY)) {
					// 아래로 밀고 이동
				}
			}
		} else if (cursor == Cursor.LEFT) {
			if (isAxisEmpty(axisX, axisY - 1)) {
				// 왼쪽으로 이동
			} else if (isAxisBox(axisX, axisY - 1)) {
				if (isAxisEmpty(axisX, axisY - 2)) {
					// 왼쪽으로 밀고 이동
				}
			}
		} else if (cursor == Cursor.RIGHT) {
			if (isAxisEmpty(axisX, axisY + 1)) {
				// 위로 이동
			} else if (isAxisBox(axisX, axisY + 1)) {
				if (isAxisEmpty(axisX, axisY + 2)) {
					// 위로 밀고 이동
				}
			}
		} else if (cursor == Cursor.BACK_SPACE) {
			// 돌아가기
		}
	}
}
