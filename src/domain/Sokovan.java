package domain;

public class Sokovan {
	private Player player;
	private int stage;
	private char[][] map;

	public Sokovan() {
		player = new Player();
	}

	public void initStage(int stage) {
		this.map = Stage.map[stage - 1];
		this.player.setAxis(Stage.axis[stage - 1]);
	}

	public void printMap() {
		for (int i = 0; i < this.map.length; i++) {
			System.out.println(map[i]);
		}
	}
}
