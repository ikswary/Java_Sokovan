package domain;

public class Map {
	private Character[][] map;
	private Integer[][] clearAxis;

	public Map() {
		this.map = new Character[8][8];
		this.clearAxis = new Integer[3][2];
	}

	public void setMap(Character[][] cloneMap) {
		this.map = cloneMap;
	}

	public void setMap(Integer stage) {
		for (int i = 0; i < this.map.length; i++) {
			map[i] = MapDB.map[stage - 1][i].clone();
		}
		for (int i = 0; i < this.clearAxis.length; i++) {
			this.clearAxis[i] = MapDB.clearAxis[stage - 1][i].clone();
		}
	}

	public Character[][] getMap() {
		return map;
	}

	public void printMap() {
		String space = "\n";

		for (int i = 0; i < 10; i++) {
			space += "\n";
		}
		System.out.println(space);

		for (int i = 0; i < map.length; i++) {
			String mapString = "";

			for (int j =0 ; j < map[i].length; j++) {
				mapString += map[i][j];
			}
			System.out.println(mapString);
		}
	}

	private Boolean isInClearAxis(Integer axisX, Integer axisY) {
		for (Integer[] clearCoordnate : clearAxis) {
			if (clearCoordnate[0] == axisX && clearCoordnate[1] == axisY) {
				System.out.println(clearCoordnate[0] + " == " + axisX + " ?");
				System.out.println(clearCoordnate[1] + " == " + axisY + " ?");
				return true;
			}
		}
		return false;
	}

	public void moveByIndex(Integer currentAxisX, Integer currentAxisY
			, Integer postAxisX, Integer postAxisY) {
		map[postAxisX][postAxisY] = map[currentAxisX][currentAxisY];
		map[currentAxisX][currentAxisY] = ' ';

		if (isInClearAxis(currentAxisX, currentAxisY)) {
			map[currentAxisX][currentAxisY] = '*';
		}
	}

	public Boolean isStageClear() {
		Boolean result = true;

		for (Integer[] clearCoordnate : clearAxis) {
			if (!map[clearCoordnate[0]][clearCoordnate[1]].equals('B')) {
				result = false;
			}
		}
		return result;

	}

	public Character[][] cloneMap() {
		Character[][] result = new Character[8][8];
		for (int i = 0; i < map.length; i++) {
			result[i] = map[i].clone();
		}
		return result;
	}
}
