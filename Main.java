import Mathalg.Matrix;

public class Main {
	
	public static void main(String[] args) {

		
		Integer[][] a = new Integer[][] {
			{3, -1, 2}, 
			{4, 2, 0},
			{-5, 6, 1}
		};
		Integer[][] b = new Integer[][] {
			{8}, 
			{7},
			{-1}
		};
		Integer[][] c = new Integer[][] {
			{8,2,4}, 
			{7,5,6},
			{2,2,4}
		};
		Integer[][] d = new Integer[][] {
			{8,2,4}, 
			{7,5,6},
			{2,2,5}
		};
		
		Number[][] res = Matrix.plus(c, d);
		for(int i = 0; i<res.length;i++) {
			for(int j = 0;j<res[i].length;j++) {
				System.out.print(res[i][j] + ", ");
			}
			System.out.println();
		}

	}
}