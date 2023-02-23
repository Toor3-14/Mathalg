import Mathalg.Matrix;
import java.util.List;
import java.util.ArrayList;
public class Main {
	
	public static void main(String[] args) {
		List<String[]> l = new ArrayList<>();
		l.add(new String[]{"1", "2", "3" , "4"});
		l.add(new String[] {"5", "6"});
		
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
		Byte[][] c = new Byte[][] {
			{8,2,4}, 
			{7,5,6},
			{2,2}
		};
		Matrix<Integer> x = new Matrix<>(a);
		Matrix<Integer> y = new Matrix<>(b);
		x.mult(y);
		System.out.println(x);

	}
}