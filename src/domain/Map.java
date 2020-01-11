package domain;

public class Map {
	private Character[][] map;
	private Integer[][] clearAxis;

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
		System.out.println(clearAxis[0][0] + ", " + clearAxis[0][1]);
		System.out.println(clearAxis[1][0] + ", " + clearAxis[1][1]);
		System.out.println(clearAxis[2][0] + ", " + clearAxis[2][1]);
	}

	public Character[][] getMap() {
		return map;
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
		//Character tmp = map[postAxisX][postAxisY];
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
		System.out.println("stage clear " + result);
		return result;

	}
}
