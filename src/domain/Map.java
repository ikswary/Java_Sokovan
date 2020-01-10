package domain;

public class Map {
	private Character[][] map;
	private Integer [][] clearAxis;

	public Map() {
		this.map = new Character[8][8];
		this.clearAxis = new Integer[3][2];
	}

	public void setMap(Integer stage) {
		for (int i = 0; i < this.map.length; i++) {
			map[i] = Stage.map[stage - 1][i].clone();
		}
		for (int i = 0; i < this.clearAxis.length; i++) {
			this.clearAxis[i] = Stage.clearAxis[stage - 1][i].clone();
		}
	}

	public Integer length() {
		return this.map.length;
	}

	public Character[][] getMap() {
		return map;
	}

	private Boolean isInClearAxis(Integer axisX, Integer axisY) {
		for (int i = 0; i < clearAxis.length; i++) {
			if (clearAxis[i][0] == axisX && clearAxis[i][1] == axisY) {
				return true;
			}
		}
		return false;
	}

	public void moveByIndex(Integer currentAxisX, Integer curruntAxisY
			, Integer postAxisX, Integer postAxisY) {
		map[postAxisX][postAxisY] = 'P';
		if (isInClearAxis(currentAxisX, curruntAxisY)) {
			map[currentAxisX][curruntAxisY] = '*';
		} else {
			map[currentAxisX][curruntAxisY] = ' ';
		}
	}


}
