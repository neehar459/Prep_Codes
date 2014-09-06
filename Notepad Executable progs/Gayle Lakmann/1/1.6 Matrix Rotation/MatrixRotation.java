public class MatrixRotation{
	public static void main(String[] args){
	// Basically if the order of matrix is not N X N, then it cannot be rotated. Assume that the matrix order is N X N.
	int[][] matrix ={{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
	System.out.println("Original Matrix");
	for(int i=0;i<matrix.length;i++){
		System.out.println(matrix[i][0] + " " +matrix[i][1]+ " " +matrix[i][2] + " " +matrix[i][3]);
	}
	rotateMatrix(matrix,4);
	}
	public static void rotateMatrix(int[][] matrix, int n){
		for(int row=0; row < n/2; row++){			
			int first = row;
			int last = n-1-row;
			for(int i= first; i < last; i++){
				// place till where to swap
				int endLoop = i-first; 
				// have to save one row to start swapping. Save top row
				int top = matrix[first][i];
				// swap left to top
				matrix[first][i] = matrix[last-endLoop][first];
				// swap bottom to left
				matrix[last-endLoop][first] = matrix[last][last-endLoop];
				// swap right to bottom
				matrix[last][last-endLoop] = matrix[i][last];
				// swap top to right
				matrix[i][last] = top;
			}
		}
		System.out.println("Displaying rotated matrix");
		for(int i=0;i<matrix.length;i++){
		System.out.println(matrix[i][0] + " " +matrix[i][1]+ " " +matrix[i][2] + " " +matrix[i][3]);
	}
	}	
}