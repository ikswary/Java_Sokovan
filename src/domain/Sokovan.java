package domain;

public class Sokovan {
	private Player player;
	private int stage;
	private char[][] map;

	public void initStage(int stage) {
		this.map = Stage.map[stage];
		this.player.setAxis(Stage.axis[stage]);
	}
}
