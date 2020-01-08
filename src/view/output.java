package view;

import java.util.Arrays;

public class output {
	public static void printMap(Character[][] map) {
		for (int i = 0; i < map.length; i++) {
			String mapString = "";

			for (int j =0 ; j < map[i].length; j++) {
				mapString += map[i][j];
			}
			System.out.println(mapString);
		}
	}
}
