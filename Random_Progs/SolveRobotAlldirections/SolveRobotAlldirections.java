public class SolveRobotAlldirections {
	public static void main (String[] args) {
		int[][] iniMaze = {{1,0,1,0,1},{1,1,0,1,0},{0,1,1,0,0}, {1,0,1,1,0}, {1,0,0,1,1}};
		int[][] solutionMaze = findPath(iniMaze);
		if(solutionMaze != null){
			displayMaze(solutionMaze);
		} else {
			System.out.println("No Path Found");
		}
	}
	public static void displayMaze (int[][] maze) {
		if(maze != null) {
			for(int i=0; i< maze.length; i++) {
				for(int j=0; j< maze[i].length; j++) {
					System.out.print(maze[i][j] + " ");
				}
				System.out.println();
			}
		}
	}
	public static int[][] findPath (int[][] iniMaze) {
		if(iniMaze == null || iniMaze.length == 0){
			return null;
		} else {
			int[][] solMaze = {{0,0,0,0,0},{0,0,0,0,0},{0,0,0,0,0}, {0,0,0,0,0}, {0,0,0,0,0}};
			boolean solution = findPathMain(iniMaze, 0, 0, solMaze);
			if(solution) {
				return solMaze;
			} else {
				return null;
			}
		}
	}
	public static boolean findPathMain (int[][] iniMaze, int x, int y, int[][] solMaze) {
		if(x == (iniMaze.length-1) && y == (iniMaze[0].length)-1) {
			solMaze[x][y] = 1;
			return true;
		}
		//System.out.println("x : "+x + " , y: "+y);
		// check if step is valid 
		if(isValidPos(x,y,iniMaze) == true) {
			solMaze[x][y] = 1;
			// Move in hor direction for  right
			if(findPathMain(iniMaze, x,y+1,solMaze) == true){
				return true;
			}
			// Else check in down direction
			if(findPathMain(iniMaze, x+1,y,solMaze) == true){
				return true;
			}
			 // Else check in up direction
			if(findPathMain(iniMaze, x-1,y,solMaze) == true){
				return true;
			}
			// Else check in left direction
			if(findPathMain(iniMaze, x,y-1,solMaze) == true){
				return true;
			} 
			
			// Else make the old pos = 0 as it is invalid pos
			solMaze[x][y] = 0;
			return false;
		}
		return false;
	}
	public static boolean isValidPos (int x, int y, int[][] maze) {
		if(x >=0 && x < maze.length && y>=0 && y < maze[0].length && maze[x][y] == 1) {
			return true;
		} else {
			return false;
		}
	}
}