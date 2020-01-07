package domain;

import java.util.Arrays;

public class Sokovan {
	private Player player;
	private int stage;
	private char[][] map;

	public Sokovan() {
		this.player = new Player();
		this.map = new char[8][8];
	}

	public void initStage(int stage) {
		for (int i = 0; i < this.map.length; i++) {
			this.map[i] = Stage.map[stage - 1][i].clone();
		}
		this.player.setAxis(Stage.axis[stage - 1]);
	}

	public void printMap() {
		for (int i = 0; i < this.map.length; i++) {
			System.out.println(map[i]);
		}
	}
}
