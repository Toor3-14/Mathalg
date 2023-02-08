
import Mathalg.Matrix;


public class Main {
	
	public static void main(String[] args) {
		Integer[][] x = new Integer[][] {{1,2,3},{4,5,6,7}}; 
		Matrix<Integer> y = new Matrix<>(x);
		y.append(1,2,3);
		System.out.println(y.getElement(2, 7));
	}
	
}