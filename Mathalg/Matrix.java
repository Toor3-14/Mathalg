/*
 * Copyright (c) 2023, chi76,Toor3-14. All rights reserved.
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
 * 3 along with this work.
 *
 * Please contact with me if you have some ideas for this project
 * Email: toorkeor@gmail.com
 */

package Mathalg;

/**
 * This class contains various methods for manipulating matrix (such as
 * sorting and searching).
 *
 * <p>The methods in this class all throw a {@code NullPointerException},
 * if the specified array reference is null, except where noted.
 *
 * <p>The documentation for the methods contained in this class includes
 * brief descriptions of the <i>implementations</i>. Such descriptions should
 * be regarded as <i>implementation notes</i>, rather than parts of the
 * <i>specification</i>. Implementors should feel free to substitute other
 * algorithms, so long as the specification itself is adhered to. (For
 * example, the algorithm used by {@code sort(Object[])} does not have to be
 * a MergeSort, but it does have to be <i>stable</i>.)
 *
 * <p>This class is a member of the
 * <a href="{@docRoot}/java.base/java/util/package-summary.html#CollectionsFramework">
 * Java Collections Framework</a>.
 *
 * @author Dmitry Terakov (Toor3-14)
 * @since  0.1A
 */

public class Matrix<T extends Number> {
	
	/* 
	 * PRIVATE SECTION:
	 * 
	 * 	There are:
	 * 		(fields)
	 * 		- Object[4][8] matrix - local array for data forming/initializing
	 * 		- int lines - part of capacity, it is Y parallel
	 * 		- int columns - part of capacity, it is X parallel
	 * 
	 * 		(methods)
	 * 		- int getFreeSize(int line) - this method return number of free space, that have tail of nulls or sub nulls.
	 * 
	 * 		- Object[][] gettingInit() - this method return ready object[][] for outputting or initialize (for math methods: plus, minus...).
	 *  
	 * 			#To be more precise, this method find maximal column position, just example:
	 * 				- You have a matrix {1,2,3}, {1,2} with default capacity(4,8), (local object is [1,2,3], [1,2,null]).
	 * 				- Next, you use insert([line] 1,[column] 3,[num] 3), (local object now is [1,2,3,null], [1,2,null,3]).
	 * 				- So, when we search maximal column position, we dont touching tail of nulls.
	 * 				We searching maximal position with any number (this we have max = 3).
	 * 				It mean, that line [1,2,3,null] will be save with 'null' in his end;
	 * 			
	 * 			We also counting number of line with any number element. This all for init new Object
	 * 	
	 * 			#Next step we starting rewrite data from object, how it was in example
	 * 			All sub nulls or tail nulls will be exchange to 0 as a number type;
	 * 
	 *  		!Warning: difference between 'null' and '0' i will say later in constructors
	 *  		and specific [method]/[constant]
	 *   	
	 * */
	
	private static final int DEFAULT_CAPACITY_LINE = 4;
	private static final int DEFAULT_CAPACITY_COLUMN = 8;
	
	private Object[][] matrix = new Object[DEFAULT_CAPACITY_LINE][DEFAULT_CAPACITY_COLUMN];
	private int lines = DEFAULT_CAPACITY_LINE;
	private int columns = DEFAULT_CAPACITY_COLUMN;
	
	private int getFreeSize(int line) {
		int result = 0;
		for(int i = 0; i < matrix[line].length;i++) {
			if(matrix[line][i] == null) result+=1;
		}
		return result;
	}
	private Object[][] gettingInit() {
		
		int max = 0;
		int numOfLines = 0;
		
		int endOfColumn = 0;
		
		for(int i = 0; i < matrix.length;i++) {
			int clearLine = 0;
			for(int j = 0; j < matrix[i].length; j++ ) {
				if(matrix[i][j] != null) {
					endOfColumn = j;
					clearLine++;
				}
			}
			if(clearLine != 0) numOfLines++;
			
			if(max < endOfColumn) {
				max = endOfColumn;
			}
			
		}
				
		/*
		 * max + 1 because we have position of maximal
		 * last (not null) array element[?0] in the line.
		 * 
		 * !Notice: next (in cycle for) I have used '<=' operator.
		 * 
		 * */
		
		Object[][] newMatrix = new Object[numOfLines][max+1];
		
		
		int y = 0;
		for(int i = 0; i < matrix.length; i++ ) {
			int nullLine = 0;
			
			for(int j = 0; j <= max; j++ ) {
				if(matrix[i][j] != null) nullLine++;
			}
			
			
			if(nullLine == 0) {
				continue;
			}else {
				int x = 0;
				for(int j = 0; j <= max; j++ ) {
					if(matrix[i][j] == null) newMatrix[y][x] = '0';
					else newMatrix[y][x] = matrix[i][j];
					x++;
				}
				y++;
			}
		}
		
		return newMatrix;
		
	}


	/*
	 * CONSTRUCTORS SECTION:
	 * 
	 * 	1.default constructor
	 * 		default this.lines = 4
	 * 		default this.columns = 8
	 * 		default object matrix = new Object[4][8]
	 * 
	 * 	2.Matrix(lines, columns) constructor
	 * 		set new value for: 
	 * 			this.lines, this.columns and 
	 * 			local object matrix size of was seted.
	 * 
	 * 	3.Matrix(T[][] matrix) constructor
	 * 		I have almost said about difference between 'null' and '0'.
	 * 			So, in this constructor we can transmit a two-dimensional 
	 * 			array of different numeric types and a variable length of its lines.
	 * 		   j.e: we have Integer arr {{1,2,3}, {1,2} }
	 * 				in previous constructor we had 'a full fill of nulls' according to their size.
	 * 
	 * 				But here we have 'a partial filling of nulls', because 
	 * 				our array convert to object via {{1,2,3}, {1,2,null}}.
	 
	 * 				Together with this filling, we have an additional memory reservation 
	 * 				(line += 4, column += 8)
	 * 
	 * 				So, our ending point is obj: {1, 2,  3,  null,null,null,null,null,null}, 
	 * 											 {1, 2, null,null,null,null,null,null,null}
	 * 
	 * 				But the entry with the gettingInit() method will look like this:
	 * 										     									{1, 2,   3 }, 
	 * 											 									{1, 2, null}
	 * 		 
	 * 
	 * */
	public Matrix() {} 
	
	public Matrix(int lines, int columns) {
		this.lines = lines;
		this.columns = columns;
		matrix = new Object[lines][columns];
	}
	
	public Matrix(T[][] matrix) {
		int max = 0;
		for(int i = 0; i < matrix.length;i++) {
			if(max < matrix[i].length) max = matrix[i].length;
		}
		
		this.columns += max;
		this.lines += matrix.length;
		
		Object[][] newMatrix = new Object[lines][columns];
		for(int i = 0; i < matrix.length;i++) {
			for(int j = 0; j < matrix[i].length;j++) {
				newMatrix[i][j] = matrix[i][j];
			}
		}
		this.matrix = newMatrix;
		
	}
	

	public T get(int line, int column) {
		return (T) matrix[line][column];
	}
	public void set(int line, int column, T num) {
		matrix[line][column] = num;
	}
	
	/*
	public void add(T...num) {
		// new line append
	}*/
	
	public void add(int line, T...num) {
		if(line < lines) {
			if(getFreeSize(line) > num.length) {
				int x = 0;
				for(int i = 0; i < matrix[line].length; i++) {
					if(matrix[line][i] == null) {
						if(x != num.length) {
							matrix[line][i] = num[x];
							x++;
						}else {
							return;
						}
					}
				}
			}else {
				setNumberOfColumns(columns+DEFAULT_CAPACITY_COLUMN );
				add(line,num);
			}
		}else {
			setNumberOfLines(line+DEFAULT_CAPACITY_LINE);
			add(line,num);
		}
	}
	public void insert(int line, int column, T... num) {
		if(line <= lines) {
			if(getFreeSize(line) >= num.length) {
				Object[] copyOldNums = new Object[columns]; 
				
				int x = 0;
				int y = 0;
				for(int i = column; i < matrix[line].length; i++) {
					if(matrix[line][i] != null) {
						copyOldNums[x] = matrix[line][i];
						x++;
					}
					if(y < num.length) {
						matrix[line][i] = num[y];
						y++;
					}
				}
				x = 0;
				for(int i = column+num.length; i < matrix[line].length; i++) {
					matrix[line][i] = copyOldNums[x];
					x++;
				}
					
			}else {
				setNumberOfColumns(columns+DEFAULT_CAPACITY_COLUMN );
				add(line,num);
			}
		}else {
			setNumberOfLines(line+DEFAULT_CAPACITY_LINE);
			add(line,num);
		}
				
	}
	
	
	/*
	 * USER CONTROLE SECTION
	 * 
	 * 
	 * */
	public void setNumberOfLines(int lines) {
		this.lines = lines;
		Object[][] newMatrix = new Object[lines][columns];
		for(int i = 0; i < matrix.length; i++) {
			for(int j = 0; j < matrix[i].length; j++) {
				newMatrix[i][j] = matrix[i][j];
			}
		}
		matrix = newMatrix;
	}
	public void setNumberOfColumns(int columns) {
		this.columns = columns;
		Object[][] newMatrix = new Object[lines][columns];
		for(int i = 0; i < matrix.length; i++) {
			for(int j = 0; j < matrix[i].length; j++) {
				newMatrix[i][j] = matrix[i][j];
			}
		}
		matrix = newMatrix;
	}
	
	@Override
	public String toString() {
		Object[][] initObject = gettingInit();
		String result = "";
		for(int i = 0; i < initObject.length; i++) {
			result += '[';
			for(int j = 0; j < initObject[i].length; j++) {
				result += String.valueOf( initObject[i][j] );
				if(j+1 != initObject[i].length)result += ", ";
			}
				if(i+1 != initObject.length) result += "]\n";
				else result += "]";
		}
		
		return result;
	}
}
