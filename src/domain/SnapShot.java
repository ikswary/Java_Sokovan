package domain;

public class SnapShot {
	private Integer[] playerAxis;
	private Character[][] map = new Character[8][8];

	public SnapShot(Integer[] axis, Character[][] map) {
		this.playerAxis = axis;
		this.map = map;
	}

	public Integer[] getPlayerAxis() {
		return playerAxis;
	}

	public Character[][] getMap() {
		return map;
	}
}
