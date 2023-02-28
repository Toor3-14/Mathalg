import Mathalg.Matrix;

public class Main {
	
	public static void main(String[] args) {
		Integer[][] x = new Integer[][] {{1,2,3}, {1,2,3}};
		Integer[][] y = new Integer[][] {{1,2,3}};
		
		Matrix<Integer> q = new Matrix<>();
		q.add(0,532);
		q.add(0, 53);
		q.add(0, 5);
		
		q.add(2, 0, 1);
		q.add(2, 1, 2);
		q.add(2, 3532532);
		System.out.println(q);
	}
}