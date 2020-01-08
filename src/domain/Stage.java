package domain;

public class Stage {
	final static char[][][] map = {
			{   //stage1의 맵
					{'#', '#', '#', '#', '#', '#', '#', '#'},
					{'#', '#', 'P', ' ', '#', '#', '#', '#'},
					{'#', '#', ' ', 'B', ' ', ' ', '#', '#'},
					{'#', '#', '#', ' ', '#', ' ', '#', '#'},
					{'#', '*', '#', ' ', '#', ' ', ' ', '#'},
					{'#', '*', 'B', ' ', ' ', '#', ' ', '#'},
					{'#', '*', ' ', ' ', ' ', 'B', ' ', '#'},
					{'#', '#', '#', '#', '#', '#', '#', '#'}
			},
			{
					{'#', '#', '#', '#', '#', '#', '#', '#'},
					{'#', '#', '#', '#', '#', '#', '#', '#'},
					{'#', '#', '#', '#', '#', '#', '#', '#'},
					{'#', '#', '#', '#', '#', '#', '#', '#'},
					{'#', '#', '#', '#', '#', '#', '#', '#'},
					{'#', '#', '#', '#', '#', '#', '#', '#'},
					{'#', '#', '#', '#', '#', '#', '#', '#'},
					{'#', '#', '#', '#', '#', '#', '#', '#'}
			},
			{
					{'#', '#', '#', '#', '#', '#', '#', '#'},
					{'#', '#', '#', '#', '#', '#', '#', '#'},
					{'#', '#', '#', '#', '#', '#', '#', '#'},
					{'#', '#', '#', '#', '#', '#', '#', '#'},
					{'#', '#', '#', '#', '#', '#', '#', '#'},
					{'#', '#', '#', '#', '#', '#', '#', '#'},
					{'#', '#', '#', '#', '#', '#', '#', '#'},
					{'#', '#', '#', '#', '#', '#', '#', '#'}
			}
	};
	final static Integer[][] playerAxis = {{1, 2}, {0, 0}, {0, 0}};
	final static Integer[][][] clearAxis = {
			{
					{4, 1}, {5, 1}, {6, 1} // Stage1의 클리어 좌표
			},
			{
					{0, 0}, {1, 1}, {2, 3}
			},
			{
					{0, 0}, {1, 1}, {2, 3}
			}
	};
}




