package domain;

public class Map {
	private Character[][] map;

	public Map() {
		this.map = new Character[8][8];
	}

	public Integer length() {
		return this.map.length;
	}

	public Character[][] getMap() {
		return map;
	}
}
