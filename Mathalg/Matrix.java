/*
 * Copyright (c) 2023, chi76. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * This code is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License version 3 only, as
 * published by the Free Software Foundation. 
 *
 * This code is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * version 3 for more details (a copy is included in the LICENSE file that
 * accompanied this code).
 *
 * You should have received a copy of the GNU General Public License version
 * 3 along with this work; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301 USA.
 *
 * Please contact me:
 * 		Email - toorkeor@gmail.com
 * 		Telegram - t.me/@redltoor
 */
package Mathalg;

/**
 * This class contains various methods for manipulating arrays[][] as matrix
 *
 * <p>Almost all methods in this class have an unchecked type  {@code @SuppressWarnings("unchecked")}
 *
 * <p>The documentation for the methods contained in this class includes
 * brief descriptions of the <i>implementations</i>. Such descriptions should
 * be regarded as <i>implementation notes</i>, rather than parts of the
 * <i>specification</i>.
 *
 * <p>This class is a member of the
 * <a href="https://github.com/Toor3-14/Mathalg/tree/main/Mathalg">
 * Mathalg Framework</a>.
 *
 * @author chi76
 * @version  0.1
 */
public class Matrix {
	
	private static <R extends Number> byte checkType(R var) {
		String strType = String.valueOf( var.getClass() );
		if( strType.contains("Integer") )  return 1;
		else if( strType.contains("Long") ) return 2;
		else if( strType.contains("Float") ) return 3;
		else if( strType.contains("Double") ) return 4;
		else throw new IllegalArgumentException("Undefind type"); 
	}
	
	private static<R extends Number> int getMax(R[][] matrix) {
		int max = 0;
		int iter = 0;
		for(int i = 0; i < matrix.length; i++) {
			if(matrix[i].length > max) {
				max = matrix[i].length;
				iter++;
			}else if(matrix[i].length < max) {
				iter++;
			}
		}
		if(iter>1) throw new IllegalArgumentException("Incorrect line size of array, the lines must be the same size inside the array!"); 
		return max;
	}
	@SuppressWarnings("unchecked")
	public static<R extends Number> R plus(R x,R y) {
		byte type = checkType(x);
		if(type == 1) {
			Integer res =  Integer.parseInt( String.valueOf( x ) ) + Integer.parseInt( String.valueOf( y ) );
			return (R) res;
		}else if(type == 2) {
			Long res = Long.parseLong( String.valueOf( x ) ) + Long.parseLong( String.valueOf( y ) );
			return (R) res;
		}else if(type == 3) {
			Float res = Float.parseFloat( String.valueOf( x ) ) + Float.parseFloat( String.valueOf( y ) );
			return (R) res;
		}else if(type == 4) {
			Double res = Double.parseDouble( String.valueOf( x ) ) +Double.parseDouble( String.valueOf( y ) );
			return (R) res;
		}else throw new IllegalArgumentException("Undefind type"); 
	}
	@SuppressWarnings("unchecked")
	public static<R extends Number> R minus(R x,R y) {
		byte type = checkType(x);
		if(type == 1) {
			Integer res =  Integer.parseInt( String.valueOf( x ) ) - Integer.parseInt( String.valueOf( y ) );
			return (R) res;
		}else if(type == 2) {
			Long res = Long.parseLong( String.valueOf( x ) ) - Long.parseLong( String.valueOf( y ) );
			return (R) res;
		}else if(type == 3) {
			Float res = Float.parseFloat( String.valueOf( x ) ) - Float.parseFloat( String.valueOf( y ) );
			return (R) res;
		}else if(type == 4) {
			Double res = Double.parseDouble( String.valueOf( x ) ) - Double.parseDouble( String.valueOf( y ) );
			return (R) res;
		}else throw new IllegalArgumentException("Undefind type"); 
	}
	@SuppressWarnings("unchecked")
	public static<R extends Number> R mult(R x,R y) {
		byte type = checkType(x);
		if(type == 1) {
			Integer res =  Integer.parseInt( String.valueOf( x ) ) * Integer.parseInt( String.valueOf( y ) );
			return (R) res;
		}else if(type == 2) {
			Long res = Long.parseLong( String.valueOf( x ) ) * Long.parseLong( String.valueOf( y ) );
			return (R) res;
		}else if(type == 3) {
			Float res = Float.parseFloat( String.valueOf( x ) ) * Float.parseFloat( String.valueOf( y ) );
			return (R) res;
		}else if(type == 4) {
			Double res = Double.parseDouble( String.valueOf( x ) ) * Double.parseDouble( String.valueOf( y ) );
			return (R) res;
		}else throw new IllegalArgumentException("Undefind type"); 
	}
	@SuppressWarnings("unchecked")
	public static<R extends Number> R divid(R x,R y) {
		byte type = checkType(x);
		if(type == 1) {
			Integer res =  Integer.parseInt( String.valueOf( x ) ) / Integer.parseInt( String.valueOf( y ) );
			return (R) res;
		}else if(type == 2) {
			Long res = Long.parseLong( String.valueOf( x ) ) / Long.parseLong( String.valueOf( y ) );
			return (R) res;
		}else if(type == 3) {
			Float res = Float.parseFloat( String.valueOf( x ) ) / Float.parseFloat( String.valueOf( y ) );
			return (R) res;
		}else if(type == 4) {
			Double res = Double.parseDouble( String.valueOf( x ) ) / Double.parseDouble( String.valueOf( y ) );
			return (R) res;
		}else throw new IllegalArgumentException("Undefind type"); 
	}
	@SuppressWarnings("unchecked")
	public static<R extends Number> R mod(R x,R y) {
		byte type = checkType(x);
		if(type == 1) {
			Integer res =  Integer.parseInt( String.valueOf( x ) ) % Integer.parseInt( String.valueOf( y ) );
			return (R) res;
		}else if(type == 2) {
			Long res = Long.parseLong( String.valueOf( x ) ) % Long.parseLong( String.valueOf( y ) );
			return (R) res;
		}else if(type == 3) {
			Float res = Float.parseFloat( String.valueOf( x ) ) % Float.parseFloat( String.valueOf( y ) );
			return (R) res;
		}else if(type == 4) {
			Double res = Double.parseDouble( String.valueOf( x ) ) % Double.parseDouble( String.valueOf( y ) );
			return (R) res;
		}else throw new IllegalArgumentException("Undefind type"); 
	}
	
	
	
	
	
	@SuppressWarnings("unchecked")
	public static<R extends Number> R[][] plus(R[][] matrix, R[][] operandMatrix) {
		if(matrix.length == operandMatrix.length && getMax(matrix) == getMax(operandMatrix) ) {
			R[][] newMatrix = (R[][]) new Number[operandMatrix.length][getMax(operandMatrix)]; 
			for(int i = 0; i < matrix.length; i++) {
				for(int j = 0; j < matrix[i].length; j++) {
					newMatrix[i][j] = plus(matrix[i][j],  operandMatrix[i][j] );
				}
			}
			return newMatrix;
		}else {
			throw new IllegalArgumentException("Incorrect size of operated Matrix, " +
					matrix.length  + ", " + operandMatrix.length  + " != " + getMax(matrix) + ", " + getMax(operandMatrix));
		}
	}
	@SuppressWarnings("unchecked")
	public static<R extends Number> R[][] minus(R[][] matrix, R[][] operandMatrix) {
		if(matrix.length == operandMatrix.length && getMax(matrix) == getMax(operandMatrix) ) {
			R[][] newMatrix = (R[][]) new Number[operandMatrix.length][getMax(operandMatrix)]; 
			for(int i = 0; i < matrix.length; i++) {
				for(int j = 0; j < matrix[i].length; j++) {
					newMatrix[i][j] = minus(matrix[i][j],  operandMatrix[i][j] );
				}
			}
			return newMatrix;
		}else {
			throw new IllegalArgumentException("Incorrect size of operated Matrix, " +
					matrix.length  + ", " + operandMatrix.length  + " != " + getMax(matrix) + ", " + getMax(operandMatrix));
		}
	}
	@SuppressWarnings("unchecked")
	public static<R extends Number> R[][] mult(R[][] matrix, R num) {
		R[][] newMatrix = (R[][]) new Number[matrix.length][getMax(matrix)]; 
		for(int i = 0; i < matrix.length; i++) {
			for(int j = 0; j < matrix[i].length; j++) {
				newMatrix[i][j] = plus(matrix[i][j],  num);
			}
		}
		return newMatrix;
	}
	@SuppressWarnings("unchecked")
	public static<R extends Number> R[][] mult(R[][] matrix, R[][] operandMatrix) {
		if(getMax(matrix) == operandMatrix.length) {
			R[][] newMatrix = (R[][]) new Number[operandMatrix.length][getMax(operandMatrix)]; 
			for(int x = 0; x < getMax(operandMatrix); x++) {
				for(int j = 0; j < getMax(matrix); j++) {
					for(int y = 0; y < operandMatrix.length; y++) {
						newMatrix[j][x] = plus( (R) newMatrix[j][x], 
															mult( 
																	matrix[j][y], operandMatrix[y][x]
																	)
															);
					}
				}
			}
			return newMatrix;
		}else {
			throw new IllegalArgumentException("Incorrect size of operated Matrix, " +
					"this.x: " + getMax(matrix) + " != operandMatrix.y: " + operandMatrix.length);
		}
	}
	
}
