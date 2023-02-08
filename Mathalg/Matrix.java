package Mathalg;

public class Matrix<T extends Number> {
	
	/*
	 * PRIVATE SECTION
	 * 
	 * Here is:
	 *  matrix (Object[][]) for saving data
	 *  lines and columns (int) for matrix (Object[lines][columns]) - is maximal size for Object array
	 *  
	 *  int getSize(T[][] array), used for second constructor (take max length of column's array)
	 *  void fillEmpties(), used for second constructor (fill the void of array (fill from void to 0))
	 *  */
	
	private Object[][] matrix;
	private int lines = 0;
	private int columns = 0;
	
	private int getSize(T[][] arr) {
		int max = 0;
		for(int i = 0; i < arr.length; i++) {
			if(arr[i].length > max) max = arr[i].length;
		}
		return max;
	}
	
	private void fillEmpties() {
		Object[][] newMatrix = new Object[lines][columns];
		for(int i = 0; i < matrix.length; i++) {
			for(int j = 0; j < matrix[i].length; j++) {
				if(matrix[i][j] == null) {
					newMatrix[i][j] = 0;
				}else {
					newMatrix[i][j] = matrix[i][j];
				}
			}
			if(matrix[i].length < columns) {
				for(int j = matrix[i].length; j < columns; j++) {
					newMatrix[i][j] = 0;
				}
			}
		}
		this.matrix = newMatrix;
	}

	
	/*
	 * CONSTRUCTORS:
	 * 
	 * Matrix(int lines, int columns): 
	 *  1.sets the value of the fields (private int lines, columns)
	 *  2.create new exemplar of array with a specific size 
	 * 
	 * Matrix(T[][] matrix):
	 *  1.sets the values from T[][ matrix] to private Object[][] matrix
	 *  2.sets the value of the fields (private int lines, 
	 *  columns[throw private method getSize(T[][])] )
	 *  3.fill the void of array (fill from void to 0) throw void fillEmpties() method
	 *  */
	
	public Matrix(int lines, int columns) {
		this.lines = lines;
		this.columns = columns;
		matrix = new Object[lines][columns];
	}
	public Matrix(T[][] matrix) {
		this.matrix = matrix;
		this.lines = matrix.length;
		this.columns = getSize(matrix);
		fillEmpties();
	}
	
	/*
	 * ARRAY METHODS 
	 * 
	 * 
	 * */
	public T getElement(int line, int column) {
		return (T) matrix[line][column];
	}
	public void setElement(int line, int column, T num) {
		matrix[line][column] = num;
	}
	public void setLine(int line, T... num) {
		matrix[line] = num;
	}
	
	
	
	public void append(T... num) {
		Object[][] newMatrix = new Object[lines+1][columns];
		for(int i = 0; i < matrix.length; i++) {
			for(int j = 0; j < matrix[i].length; j++) {
				newMatrix[i][j] = matrix[i][j];
			}
		}
		for(int j = 0; j < num.length; j++) {
			newMatrix[lines][j] = num[j];
		}
		this.lines += 1;
		this.matrix = newMatrix;
		fillEmpties();
	}
	public void appendElement(int line, T... num) {
		
		Object[][] newMatrix = new Object[lines][columns+num.length];
		for(int i = 0; i < matrix.length; i++) {
			for(int j = 0; j < matrix[i].length; j++) {
				newMatrix[i][j] = matrix[i][j];
			}
		}
		
		for(int j = columns; j < columns+num.length; j++) {
			newMatrix[line][j] = num[j-columns];
		}
		
		this.matrix = newMatrix;
		this.columns += num.length;
		fillEmpties();
	}

	public void setNumberOfLines(int lines) {
		this.lines = lines;
		Object[][] newMatrix = new Object[lines][columns];
		for(int i = 0; i < matrix.length; i++) {
			for(int j = 0; j < matrix[i].length; j++) {
				newMatrix[i][j] = matrix[i][j];
			}
		}
		fillEmpties();
	}
	public void setNumberOfColumns(int columns) {
		this.columns = columns;
		Object[][] newMatrix = new Object[lines][columns];
		for(int i = 0; i < matrix.length; i++) {
			for(int j = 0; j < matrix[i].length; j++) {
				newMatrix[i][j] = matrix[i][j];
			}
		}
		fillEmpties();
	}
}
