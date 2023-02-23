package Mathalg;
public class Matrix<T extends Number> {
	/*
	 * init
	 * */
	private Object[][] matrix = {};
	private int sizeY;
	private int sizeX;
	
	/*
	 * Byte - 1
	 * Short - 2
	 * Integer - 3
	 * Long - 4
	 * Float - 5
	 * Double - 6
	 * 
	 * */
	private byte type;
	
	private void setType() {
		T var = (T) matrix[0][0];
		String strType = String.valueOf( var.getClass() );
		if( strType.contains("Byte") ) type = 1;
		else if( strType.contains("Short") ) type = 2;
		else if( strType.contains("Integer") ) type = 3;
		else if( strType.contains("Long") ) type = 4;
		else if( strType.contains("Float") ) type = 5;
		else if( strType.contains("Double") ) type = 6;
	}
	
	/*
	 * constructor
	 * */
	private Matrix(Object[][] matrix) {
		this.matrix = matrix;
	}
	public Matrix(T[][] item) {
		
		int max = 0;
		
		for(int i = 0; i < item.length; i++) {
			if(item[i].length > max) max = item[i].length;
		}
		
		Object[][] newMatrix = new Object[item.length][max];
		
		for(int i = 0; i < item.length; i++) {
			for(int j = 0; j < item[i].length; j++) {
				newMatrix[i][j] = item[i][j];
			}
			for(int j = item[i].length; j < newMatrix[i].length; j++) {
				if(newMatrix[i][j] == null) newMatrix[i][j] = 0;
			}
		}
		matrix = newMatrix;
		sizeY = newMatrix.length;
		sizeX = max;
		setType();
		
	}
	
	/*
	 * getters
	 * */
	public int getSizeY() { return sizeY; }
	public int getSizeX() { return sizeX; }
	public int getType() { return type; }
	public T getElement(int y, int x) { return (T) matrix[y][x]; }
	public Object[][] getObject() { return matrix; }
	/*
	 * methods
	 * */
	public void plus(Matrix<T> operatedMatrix) {
		if(getSizeY() == operatedMatrix.getSizeY() && getSizeX() == operatedMatrix.getSizeX()) {
			for(int i = 0; i < matrix.length; i++) {
				for(int j = 0; j < matrix[i].length; j++) {
					if(type == 1) matrix[i][j] = Byte.parseByte( String.valueOf( getElement(i, j) ) ) + Byte.parseByte( String.valueOf( operatedMatrix.getElement(i, j) ) );
					else if(type == 2) matrix[i][j] = Short.parseShort( String.valueOf( getElement(i, j) ) ) + Short.parseShort(  String.valueOf( operatedMatrix.getElement(i, j) ) );
					else if(type == 3) matrix[i][j] = Integer.parseInt( String.valueOf( getElement(i, j) ) ) + Integer.parseInt(String.valueOf( operatedMatrix.getElement(i, j) ) );
					else if(type == 4) matrix[i][j] = Long.parseLong( String.valueOf( getElement(i, j) ) ) + Long.parseLong( String.valueOf( operatedMatrix.getElement(i, j) ) );
					else if(type == 5) matrix[i][j] = Float.parseFloat( String.valueOf( getElement(i, j) ) ) + Float.parseFloat( String.valueOf( operatedMatrix.getElement(i, j) ) );
					else if(type == 6) matrix[i][j] = Double.parseDouble( String.valueOf( getElement(i, j) ) ) +Double.parseDouble( String.valueOf( operatedMatrix.getElement(i, j) ) );
				}
			}
		}else {
			throw new IllegalArgumentException("Incorrect size of operated Matrix, " +
					getSizeY() + ", " + getSizeX() + " != " + operatedMatrix.getSizeY() + ", " + operatedMatrix.getSizeX());
		}
	}
	
	public void minus(Matrix<T> operatedMatrix) {
		if(getSizeY() == operatedMatrix.getSizeY() && getSizeX() == operatedMatrix.getSizeX()) {
			for(int i = 0; i < matrix.length; i++) {
				for(int j = 0; j < matrix[i].length; j++) {
					if(type == 1) matrix[i][j] = Byte.parseByte( String.valueOf( getElement(i, j) ) ) - Byte.parseByte( String.valueOf( operatedMatrix.getElement(i, j) ) );
					else if(type == 2) matrix[i][j] = Short.parseShort( String.valueOf( getElement(i, j) ) ) - Short.parseShort(  String.valueOf( operatedMatrix.getElement(i, j) ) );
					else if(type == 3) matrix[i][j] = Integer.parseInt( String.valueOf( getElement(i, j) ) ) - Integer.parseInt(String.valueOf( operatedMatrix.getElement(i, j) ) );
					else if(type == 4) matrix[i][j] = Long.parseLong( String.valueOf( getElement(i, j) ) ) - Long.parseLong( String.valueOf( operatedMatrix.getElement(i, j) ) );
					else if(type == 5) matrix[i][j] = Float.parseFloat( String.valueOf( getElement(i, j) ) ) - Float.parseFloat( String.valueOf( operatedMatrix.getElement(i, j) ) );
					else if(type == 6) matrix[i][j] = Double.parseDouble( String.valueOf( getElement(i, j) ) ) - Double.parseDouble( String.valueOf( operatedMatrix.getElement(i, j) ) );
				}
			}
		}else {
			throw new IllegalArgumentException("Incorrect size of operated Matrix, " +
					getSizeY() + ", " + getSizeX() + " != " + operatedMatrix.getSizeY() + ", " + operatedMatrix.getSizeX());
		}
	}
	
	
	public void mult(T num) {
		for(int i = 0; i < matrix.length; i++) {
			for(int j = 0; j < matrix[i].length; j++) {
				if(type == 1) matrix[i][j] = Byte.parseByte( String.valueOf( getElement(i, j) ) ) * Byte.parseByte( String.valueOf( num ) );
				else if(type == 2) matrix[i][j] = Short.parseShort( String.valueOf( getElement(i, j) ) ) * Short.parseShort(  String.valueOf( num ) );
				else if(type == 3) matrix[i][j] = Integer.parseInt( String.valueOf( getElement(i, j) ) ) * Integer.parseInt(String.valueOf( num ) );
				else if(type == 4) matrix[i][j] = Long.parseLong( String.valueOf( getElement(i, j) ) ) * Long.parseLong( String.valueOf( num ) );
				else if(type == 5) matrix[i][j] = Float.parseFloat( String.valueOf( getElement(i, j) ) ) * Float.parseFloat( String.valueOf( num ) );
				else if(type == 6) matrix[i][j] = Double.parseDouble( String.valueOf( getElement(i, j) ) ) * Double.parseDouble( String.valueOf( num ) );
			}
		}
	}
	public void mult(Matrix<T> operatedMatrix) {
		if(getSizeX() == operatedMatrix.getSizeY()) {
			Object[][] newMatrix = new Object[operatedMatrix.getSizeY()][operatedMatrix.getSizeX()];
			for(int i = 0; i < newMatrix.length; i++) {
				for(int j = 0; j < newMatrix[i].length; j++) {
					newMatrix[i][j] = 0;
				}
			}
			for(int x = 0; x < operatedMatrix.getSizeX(); x++) {
				for(int j = 0; j < getSizeX(); j++) {
					for(int y = 0; y < operatedMatrix.getSizeY(); y++) {
						if(type == 1) newMatrix[j][x] = Byte.parseByte( String.valueOf(newMatrix[j][x]) ) + Byte.parseByte( String.valueOf(matrix[j][y]) ) * Byte.parseByte( String.valueOf(operatedMatrix.getElement(y,x)));
						else if(type == 2) newMatrix[j][x] = Short.parseShort( String.valueOf(newMatrix[j][x]) ) + Short.parseShort( String.valueOf(matrix[j][y]) ) * Short.parseShort( String.valueOf(operatedMatrix.getElement(y,x)));
						else if(type == 3) newMatrix[j][x] = Integer.parseInt( String.valueOf(newMatrix[j][x]) ) + Integer.parseInt( String.valueOf(matrix[j][y]) ) * Integer.parseInt( String.valueOf(operatedMatrix.getElement(y,x)));
						else if(type == 4) newMatrix[j][x] = Long.parseLong( String.valueOf(newMatrix[j][x]) ) + Long.parseLong( String.valueOf(matrix[j][y]) ) * Long.parseLong( String.valueOf(operatedMatrix.getElement(y,x)));
						else if(type == 5) newMatrix[j][x] = Float.parseFloat( String.valueOf(newMatrix[j][x]) ) + Float.parseFloat( String.valueOf(matrix[j][y]) ) * Float.parseFloat( String.valueOf(operatedMatrix.getElement(y,x)));
						else if(type == 6) newMatrix[j][x] = Double.parseDouble( String.valueOf(newMatrix[j][x]) ) + Double.parseDouble( String.valueOf(matrix[j][y]) ) * Double.parseDouble( String.valueOf(operatedMatrix.getElement(y,x)));
					}
				}
			}
			matrix = newMatrix;
		}else {
			throw new IllegalArgumentException("Incorrect size of operated Matrix, " +
					"this.x: " + getSizeX() + " != operatedMatrix.y: " + operatedMatrix.getSizeY());
		}
	}
	/*
	 * override
	 * */
	@Override
	public String toString() {
		String x = "";
		for(int i = 0; i < matrix.length; i++) {
			x+="[";
			for(int j = 0; j < matrix[i].length; j++) 
				if(matrix[i].length-1 == j) x += String.valueOf(matrix[i][j]) + "],"; 
				else x+= String.valueOf(matrix[i][j] + ", ");
			x+="\n";
		}
		return x;
	}
	
}
