package domain;

public class Stage {
	final static Character[][][] map = {
			{   //stage1의 맵
					{'#', '#', '#', '#', '#', '#', '#', '#'},
					{'#', '#', '#', '#', '#', '#', '#', '#'},
					{'#', '#', ' ', 'B', '*', ' ', '#', '#'},
					{'#', '#', 'P', 'B', ' ', '*', ' ', '#'},
					{'#', '#', ' ', 'B', '*', ' ', '#', '#'},
					{'#', '#', '#', '#', '#', '#', '#', '#'},
					{'#', '#', '#', '#', '#', '#', '#', '#'},
					{'#', '#', '#', '#', '#', '#', '#', '#'}
			},
			{
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
					{'#', '#', 'P', '#', '#', '#', '#', '#'},
					{'#', '#', '#', '#', '#', '#', '#', '#'},
					{'#', '#', '#', '#', '#', '#', '#', '#'},
					{'#', '#', '#', '#', '#', '#', '#', '#'},
					{'#', '#', '#', '#', '#', '#', '#', '#'}
			}
	};
	final static Integer[][] playerAxis = {{3, 2}, {1, 2}, {0,0}};
	final static Integer[][][] clearAxis = {
			{
					{2, 4}, {3, 5}, {4, 4} // Stage1의 클리어 좌표
			},
			{
					{4, 1}, {5, 1}, {6, 1}
			},
			{
					{4, 1}, {5, 1}, {6, 1}
			}
	};
}




