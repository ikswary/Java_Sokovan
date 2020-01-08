package domain;

public class Sokovan {
	private Player player;
	private int stage = 1;
	private char[][] map;
	private Integer [][] clearAxis;

	public Sokovan() {
		this.player = new Player();
		this.map = new char[8][8];
		this.clearAxis = new Integer[3][2];
	}

	public void initStage(int stage) {
		for (int i = 0; i < this.map.length; i++) {
			this.map[i] = Stage.map[stage - 1][i].clone();
		}
		for (int i = 0; i < this.clearAxis.length; i++) {
			this.clearAxis[i] = Stage.clearAxis[stage - 1][i].clone();
		}
		this.player.setAxis(Stage.playerAxis[stage - 1]);
	}

	public void printMap() {
		for (int i = 0; i < this.map.length; i++) {
			System.out.println(map[i]);
		}
		/*
		클리어 좌표 복사 확인 코드
		for (int i = 0; i < this.clearAxis.length; i++) {
			System.out.println(clearAxis[i][0].toString() + ", " + clearAxis[i][1].toString());
		}

		 */
	}
}
