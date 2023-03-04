/*
 * Copyright (C) 1997-2018 Free Software Foundation, Inc.
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
 * This class contains various methods for manipulating {@code list<list<E>>} as matrix
 *
 * <p>A large number of methods in this class have an unchecked type  {@code @SuppressWarnings("unchecked")}
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
class MatrixOperation {

// PRIVATE SECTION
	
	/**
	 * This method determines the type of generalized number for the simplest operations
	 * Table of types:
	 * 		Type    |   Value
	 *     - - - - -+- - - - - -
	 *     Integer -   1
	 *     Long         2
	 *     Float         3
	 *     Double     4
	 *     - - - - - - - - - - - 
	 * 
	 * 
	 * @implNote This is a crutch, however it is due to a java limitation. The generalized type 
	 * of numbers in Java does not have the ability to perform the simplest operations (+,-,*,/,%).
	 * @param checkClass is generic type . getClass(), that was convert to String
	 * @return this method return value of the type (check table of types) or throw IllegalArgumentException
	 * @throw IllegalArgumentException {@inheritDoc}
	 */
	private static <R extends Number> byte checkType(String checkClass) {
		if( checkClass.contains("Integer") )  return 1;
		else if( checkClass.contains("Long") ) return 2;
		else if( checkClass.contains("Float") ) return 3;
		else if( checkClass.contains("Double") ) return 4;
		else throw new IllegalArgumentException("Undefind type"); 
	}
	
	/**
	 * This method determines maximal length of lines in the matrix
	 * 
	 * @implNote This is necessary because the matrix must have the same length of each internal list.
	 * @param matrix that need for determining of maximal length internal list
	 * @return {@code int max} - maximal length of each internal list
	 * @throw IllegalArgumentException {@inheritDoc}, if the length of internal lists varies.
	 */
	private static<R extends Number> int getMax(Matrix<R> matrix) {
		int max = 0;
		int iter = 0;
		for(int i = 0; i < matrix.getSizeY(); i++) {
			if(matrix.getSizeX() > max) {
				max = matrix.getSizeX();
				iter++;
			}else if(matrix.getSizeX()  < max) {
				iter++;
			}
		}
		if(iter>1) throw new IllegalArgumentException("Incorrect line size of array, the lines must be the same size inside the array!"); 
		return max;
	}


// PRIMITIVES METHODS

	/**
	 * This method adds two generalized numbers, determining its type.
	 * 
	 * @param x first number
	 * @param y second number
	 * @return the result of the operation extended to R
	 * @throw IllegalArgumentException {@inheritDoc}
	 */
	@SuppressWarnings("unchecked")
	public static<R extends Number> R plus(R x,R y) {
		byte type = checkType(String.valueOf(x.getClass()));
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
	/**
	 * This method negates two generalized numbers, determining its type.
	 * 
	 * @param x first number
	 * @param y second number
	 * @return the result of the operation extended to R
	 * @throw IllegalArgumentException {@inheritDoc}
	 */
	@SuppressWarnings("unchecked")
	public static<R extends Number> R minus(R x,R y) {
		byte type = checkType(String.valueOf(x.getClass()));
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
	/**
	 * This method multiplies two generalized numbers, determining its type.
	 * 
	 * @param x first number
	 * @param y second number
	 * @return the result of the operation extended to R
	 * @throw IllegalArgumentException {@inheritDoc}
	 */
	@SuppressWarnings("unchecked")
	public static<R extends Number> R mult(R x,R y) {
		byte type = checkType(String.valueOf(x.getClass()));
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
	/**
	 * This method divides two generalized numbers, determining its type.
	 * 
	 * @param x first number
	 * @param y second number
	 * @return the result of the operation extended to R
	 * @throw IllegalArgumentException {@inheritDoc}
	 */
	@SuppressWarnings("unchecked")
	public static<R extends Number> R divid(R x,R y) {
		byte type = checkType(String.valueOf(x.getClass()));
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
	/**
	 * This method divides modulo two generalized numbers, determining its type.
	 * 
	 * @param x first number
	 * @param y second number
	 * @return the result of the operation extended to R
	 * @throw IllegalArgumentException {@inheritDoc}
	 */
	@SuppressWarnings("unchecked")
	public static<R extends Number> R mod(R x,R y) {
		byte type = checkType(String.valueOf(x.getClass()));
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
	
	
	
// MATRIX METHODS
	
	/**
	 * This method adds up two matrix
	 * 
	 * @implNote This method uses a different method for operations on numerical generalized values, 
	 * and also uses a method to determine the maximum length of the internal list.
	 * @param matrix first matrix
	 * @param operand operated matrix
	 * @return {@code Matrix<R>} - result of operation
	 * @throw IllegalArgumentException {@inheritDoc}, if the dimensions of the matrices do not meet the requirements.
	 */
	public static<R extends Number> Matrix<R> plus(Matrix<R> matrix, Matrix<R> operand) {
		if(matrix.getSizeY() == operand.getSizeY() && getMax(matrix) == getMax(operand) ) {
			Matrix<R> newMatrix = new Matrix<>(operand.getSizeY(), operand.getSizeX());
			for(int i = 0; i < operand.getSizeY(); i++) {
				for(int j = 0; j < operand.getSizeX(); j++) {
					newMatrix.add(i, j,
												plus(matrix.get(i, j),  operand.get(i,j))
											 );
				}
			}
			return newMatrix;
		}else {
			throw new IllegalArgumentException("Incorrect size of operated Matrix, " +
					matrix.getSizeY()  + ", " + operand.getSizeY()  + " != " + getMax(matrix) + ", " + getMax(operand));
		}
	}
	/**
	 * This method negate two matrix
	 * 
	 * @implNote This method uses a different method for operations on numerical generalized values, 
	 * and also uses a method to determine the maximum length of the internal list.
	 * @param matrix first matrix
	 * @param operand operated matrix
	 * @return {@code Matrix<R>} - result of operation
	 * @throw IllegalArgumentException {@inheritDoc}, if the dimensions of the matrices do not meet the requirements.
	 */
	public static<R extends Number> Matrix<R> minus(Matrix<R> matrix, Matrix<R> operand) {
		if(matrix.getSizeY() == operand.getSizeY() && getMax(matrix) == getMax(operand) ) {
			Matrix<R> newMatrix = new Matrix<>(operand.getSizeY(), operand.getSizeX());
			for(int i = 0; i < operand.getSizeY(); i++) {
				for(int j = 0; j < operand.getSizeX(); j++) {
					newMatrix.add(i, j,
												minus(matrix.get(i, j),  operand.get(i,j))
											 );
				}
			}
			return newMatrix;
		}else {
			throw new IllegalArgumentException("Incorrect size of operated Matrix, " +
					matrix.getSizeY()  + ", " + operand.getSizeY()  + " != " + getMax(matrix) + ", " + getMax(operand));
		}
	}
	/**
	 * This method multiplies the matrix by a number.
	 * 
	 * @implNote This method uses a different method for operations on numerical generalized values, 
	 * and also uses a method to determine the maximum length of the internal list.
	 * @param matrix matrix that will be multiplied
	 * @param num a number that we will multiplies by a matrix
	 * @return {@code Matrix<R>} - result of operation
	 */
	public static<R extends Number> Matrix<R> mult(Matrix<R> matrix, R num) {
		Matrix<R> newMatrix = new Matrix<>(matrix.getSizeY(), getMax(matrix));
		for(int i = 0; i < matrix.getSizeY(); i++) {
			for(int j = 0; j < matrix.getSizeX(); j++) {
				newMatrix.add(i,j,
											mult(matrix.get(i, j), num)
										);
			}
		}
		return newMatrix;
	}
	/**
	 * This method multiplies two matrix
	 * 
	 * @implNote This method uses a different method for operations on numerical generalized values, 
	 * and also uses a method to determine the maximum length of the internal list.
	 * @param matrix first matrix
	 * @param operand operated matrix
	 * @return {@code Matrix<R>} - result of operation
	 * @throw IllegalArgumentException {@inheritDoc}, if the dimensions of the matrices do not meet the requirements.
	 */
	public static<R extends Number> Matrix<R> mult(Matrix<R> matrix, Matrix<R> operand) {
		if(getMax(matrix) == operand.getSizeY()) {
			Matrix<R> newMatrix = new Matrix<>(operand.getSizeY(), getMax(operand));
			for(int x = 0; x < getMax(operand); x++) {
				for(int j = 0; j < getMax(matrix); j++) {
					for(int y = 0; y < operand.getSizeY(); y++) {
						
						if(y == 0) {
							newMatrix.add(j, x,
										mult(matrix.get(j, y), operand.get(y, x))
								); 
						}else {
							newMatrix.set(j, x,
									plus( (R) newMatrix.get(j, x),
										mult(matrix.get(j, y), operand.get(y, x))
									)
								); 
						}
						
					}
				}
			}
			return newMatrix;
		}else {
			throw new IllegalArgumentException("Incorrect size of operated Matrix, " +
					"this.x: " + getMax(matrix) + " != operand Matrix.y: " + operand.getSizeY());
		}
	}

	
	/**
	 * This method converts numeric wrappers into a matrix type.
	 * 
	 * @param item two-dimensional array type of numeric wrapper
	 * @return {@code Matrix<R>} result of convertation 
	 */
	public static<R extends Number> Matrix<R> toMatrix(R[][] item) {
		return new Matrix<>(item);
	}
	/**
	 * This method converts matrix type into a numeric wrapper.
	*
	 * @param item matrix
	 * @return {@code Matrix<R>} result of convertation.
	 * @throw IllegalArgumentException {@inheritDoc}
	 */
	@SuppressWarnings("unchecked")
	public static<R extends Number> R[][] toWrapper(Matrix<R> item) {
		R[][] wrapper;
		String checkType = String.valueOf(item.get(0, 0).getClass());
		
		if( checkType.contains("Integer") )  wrapper = (R[][]) new Integer[item.getSizeY()][item.getSizeX()];
		else if( checkType.contains("Long") ) wrapper = (R[][]) new Long[item.getSizeY()][item.getSizeX()];
		else if( checkType.contains("Float") ) wrapper = (R[][]) new Float[item.getSizeY()][item.getSizeX()];
		else if( checkType.contains("Double") ) wrapper = (R[][]) new Double[item.getSizeY()][item.getSizeX()];
		else throw new IllegalArgumentException("Undefind type"); 
		
		for(int i = 0; i < item.getSizeY(); i++) {
			for(int j = 0; j < item.getSizeX(); j++) {
				wrapper[i][j] = item.get(i, j);
			}
		}
		return wrapper;
	}
}