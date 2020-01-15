package view;

public class Output {
	public static void printMap(Character[][] map) {
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
}
