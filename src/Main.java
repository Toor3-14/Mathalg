import Mathalg.Matrix;

public class Main {
	
	public static void main(String[] args) {
		Integer[][] x = new Integer[][] {{1,2}, {3,4}};
		Integer[][] y = new Integer[][] {{1,2,3}, {3,2,1}};
		
		Matrix<Integer> q = new Matrix<>();
		q.add(0,1);
		q.add(0, 2);
		
		q.add(1, 3);
		q.add(1, 4);
		


		//Matrix<Integer> t = Matrix.plus(u, q);
		System.out.println(Matrix.mult(Matrix.toMatrix(x), q));
	}
}