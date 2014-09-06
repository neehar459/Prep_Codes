public class MatrixZeroes{
	public static void main(String[] args){
		int[][]matrix = {{1,2,0,3},{3,2,4,5},{1,2,3,4},{0,5,6,7}};
		System.out.println("Before making zeroes");
		displayMatrix(matrix);
		makeZeroes(matrix);
		System.out.println("After making zeroes");
		displayMatrix(matrix);
	}
	public static void makeZeroes(int[][]matrix){
		boolean [] rowPosition = new boolean[matrix.length];
		boolean [] colPosition = new boolean[matrix[0].length];
		for(int i=0;i<matrix.length;i++){
			for(int j=0;j<matrix[0].length;j++){
				if(matrix[i][j]==0){
					rowPosition[i]=true;
					colPosition[j]=true;
				}
			}
		}
		for(int i=0;i<matrix.length;i++){
			for(int j=0;j<matrix[0].length;j++){
				if(rowPosition[i]||colPosition[j]){
					matrix[i][j]=0;
				}
			}
		}	
	}
	public static void displayMatrix(int[][] matrix){
		int rows = matrix.length;
		int columns = matrix[0].length;
		for(int i=0;i<rows;i++){
			for(int j=0;j<columns;j++){
				System.out.print(matrix[i][j]+" ");
			}
			System.out.println(" ");
		}
	}
}