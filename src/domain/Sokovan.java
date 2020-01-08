package domain;

public class Sokovan {
	private Player player;
	private int stage = 1;
	private Map map;
	private Integer[][] clearAxis;

	public Sokovan() {
		this.player = new Player();
		this.map = new Map();
		this.clearAxis = new Integer[3][2];
	}

	public void initStage(int stage) {
		for (int i = 0; i < this.map.length(); i++) {
			map.getMap()[i] = Stage.map[stage - 1][i].clone();
		}
		for (int i = 0; i < this.clearAxis.length; i++) {
			this.clearAxis[i] = Stage.clearAxis[stage - 1][i].clone();
		}
		this.player.setAxis(Stage.playerAxis[stage - 1]);
	}

	public void printMap() {
		for (int i = 0; i < this.map.length(); i++) {
			System.out.println(map.getMap()[i]);
		}
		/*
		클리어 좌표 복사 확인 코
		for (int i = 0; i < this.clearAxis.length; i++) {
			System.out.println(clearAxis[i][0].toString() + ", " + clearAxis[i][1].toString());
		}

		 */
	}

	private Boolean isAxisEmpty(Integer axisX, Integer axisY) {
		if (map.getMap()[axisX - 1][axisY].equals(' ') || map.getMap()[axisX - 1][axisY].equals('*')) {
			return true;
		}
		return false;
	}

	private Boolean isAxisBox(Integer axisX, Integer axisY) {
		if (map.getMap()[axisX - 1][axisY].equals('B')) {
			return true;
		}
		return false;
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
