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

import java.util.List;
import java.util.ArrayList;


/**
 * This class contains various methods for manipulating with list {@code <list<E>>} and set it logic.
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

public class Matrix<E extends Number> extends MatrixOperation {

// PRIVATE SECTION
	
	/**
	 * The List<List> is a inner two-dimensional list.
	 * As default has {@code new ArrayList<>(16)}
	 */
	private List<List<E>> matrix;
	/**
	 * size is a pointer of line end
	 */
	private int sizeY = 0;
	/**
	 * size is a pointer of line end
	 */
	private int sizeX = 0;
	
	
// CONSTRUCTOR SECTION
	
	/**
	 * Default constructor set inner two-dimensional List default value: {@code new ArrayList<>()}
	 */
	public Matrix() {
		this.matrix = new ArrayList<>();
	}
	/**
	 * This constructor get from param {@code matrixClass} 
	 * all data {@code sizeY}, {@code sizeX}, {@code matrix}, and set them to this data.
	 * 
	 * @param matrixClass matrix class to copy it in this class 
	 */
	public Matrix(Matrix<E> matrixClass) {
		this.sizeY = matrixClass.getSizeY();
		this.sizeX = matrixClass.getSizeX();
		this.matrix = matrixClass.getMatrix();
	}
	/**
	 * This constructor set {@code collection} to this matrix
	 * 
	 * @param collection A two-dimensional list to set it in matrix
	 */
	public Matrix(List<List<E>> collection) {
		this.matrix = collection;
	}
	/**
	 * This constructor apply two-dimensional array type of any number wrapper 
	 * and set it elements to this matrix. 
	 * 
	 * @param array A two-dimensional array to copy it data to matrix 
	 */
	public Matrix(E[][] array) {
		
		// iter checks the same length of each line of the array
		int iter = 0;
		
		List<List<E>> newMatrix = new ArrayList<>(array.length);
		
		for(int i = 0; i < array.length; i++) {
			newMatrix.add(i, new ArrayList<E>(array[i].length));
			for(int j = 0; j < array[i].length; j++) {
				newMatrix.get(i).add(j, array[i][j]);
				if(sizeX < array[i].length) {
					sizeX = array[i].length;
					iter++;
				}else if(sizeX > array[i].length) iter++;
			}
		}
		if(iter > 1) {
			throw new IllegalArgumentException("Incorrect size of lines");
		}
		this.sizeY =  array.length;
		this.matrix = newMatrix;
		
	}
	/**
	 * This constructor create empty matrix with initial capacity of {@code sizeY}
	 * 
	 *  @param sizeY the capacity of lines
	 */
	public Matrix(int sizeY) {
		List<List<E>> newMatrix = new ArrayList<>(sizeY);
		for(int i = 0; i < sizeY; i++) {
			newMatrix.add(i, new ArrayList<E>());
		}
		this.sizeY = sizeY;
		this.matrix = newMatrix;
	}
	/**
	 * This constructor create empty matrix with initial capacity of {@code sizeY} and {@code sizeX}
	 * 
	 *  @param sizeY the capacity of lines
	 *  @param sizeY the capacity of columns
	 */
	public Matrix(int sizeY, int sizeX) {
		List<List<E>> newMatrix = new ArrayList<>(sizeY);
		for(int i = 0; i < sizeY; i++) {
			newMatrix.add(i, new ArrayList<E>(sizeX));
		}
		this.sizeY = sizeY;
		this.sizeX = sizeX;
		this.matrix = newMatrix;
	}


// TYPE MATHODS
	
    /**
     * Returns the element at the specified position in this Matrix.
     *
     * @param  indexY index of the line to reach element
     * @param  indexX index of the element to return
     * @return the element at the specified position in this {@codeMatrix.get(indexY).get(indexX)}
     * @throws IndexOutOfBoundsException {@inheritDoc}
     */
	public E get(int indexY, int indexX) {
		return matrix.get(indexY).get(indexX);
	}
    /**
     * Replaces the element at the specified position in this {@codeMatrix.get(indexY).get(indexX)} with
     * the specified element.
     *
     * @param indexY index of the line to reach element
     * @param indexX index of the element to replace
     * @param element element to be stored at the specified position
     * @return the element previously at the specified position
     * @throws IndexOutOfBoundsException {@inheritDoc}
     */
	public E set(int indexY, int indexX, E value) {
		return matrix.get(indexY).set(indexX, value);
	}
    /**
     * Appends the specified element to the end of this {@code Matrix.get(indexY)}.
     *
     * @param indexY line to be appended to this Matrix.get(indexY)
     * @param value element to be inserted
     * @throws IndexOutOfBoundsException {@inheritDoc}
     * @return {@code true} (as specified by {@link Collection#add})
     */
	public boolean add(int indexY, E value) {
		if(this.sizeY > indexY ) 
			matrix.get(indexY).add(value);
		else {
			matrix.add(indexY, new ArrayList<E>(sizeX));
			matrix.get(indexY).add(value);
			this.sizeY = indexY+1;
		}
		this.sizeX = matrix.get(indexY).size();
		return true;
	}
    /**
     * Inserts the specified element at the specified position in this
     * {@code Matrix.get(indexY).get(indexX)}. Shifts the element currently at that position (if any) and
     * any subsequent elements to the right (adds one to their indices).
     *
     * @param indexY line to be appended to this {@code Matrix.get(indexY)}
     * @param indexX index at which the specified element is to be inserted
     * @param value element to be inserted
     * @throws IndexOutOfBoundsException {@inheritDoc}
     * @return {@code true} (as specified by {@link Collection#add})
     */
	public boolean add(int indexY, int indexX, E value) {
		if(this.sizeY > indexY) 
			matrix.get(indexY).add(indexX, value);
		else {
			matrix.add(indexY, new ArrayList<E>(sizeX));
			matrix.get(indexY).add(indexX, value);
			this.sizeY = indexY+1;
		}
		this.sizeX = matrix.get(indexY).size();
		return true;
	}
	/**
     * Removes the element at the specified position in this {@code Matrix.get(indexY)}.
     * Shifts any subsequent elements to the left (subtracts one from their
     * indices).
     *
     * @param indexY the index of the line to be removed
     * @return the line that was removed from the Matrix
     * @throws IndexOutOfBoundsException {@inheritDoc}
     */
	public List<E> remove(int indexY) {
		return  matrix.remove(indexY);
	}
	/**
     * Removes the element at the specified position in this {@code Matrix.get(indexY).get(indexX)}.
     * Shifts any subsequent elements to the left (subtracts one from their
     * indices).
     *
     * @param indexY the index of the line to reach element
     * @param indexX the index of the element to be delete
     * @return the element that was removed from the Matrix
     * @throws IndexOutOfBoundsException {@inheritDoc}
     */
	public E remove(int indexY, int indexX) {
		return  matrix.get(indexY).remove(indexX);
	}
	
	/**
     * Returns {@code true} if this matrix contains no elements.
     *
     * @return {@code true} if this matrix contains no elements
     */
	public boolean isEmpty() {
		return matrix.isEmpty();
	}
    /**
     * Returns {@code true} if this {@code matrix.get(indexY)} contains no elements.
     *
     * @return {@code true} if this matrix.get(indexY) contains no elements
     */
	public boolean isEmpty(int indexY) {
		return matrix.get(indexY).isEmpty();
	}
	
// GETTERS SECTION
	
    /**
     * Returns the number of lines in this matrix.
     *
     * @return the number of lines in this matrix
     */
	public int getSizeY() {return sizeY;}
    /**
     * Returns the maximal number of elements in this matrix.
     *
     * @return the maximal number of elements in this matrix
     */
	public int getSizeX() {return sizeX;}
    /**
     * Returns the inner two-dimensional list.
     *
     * @return the inner two-dimensional list.
     */
	public List<List<E>> getMatrix() {return matrix;}
	

// OVERRIDE SECTION
	
	@Override
	public String toString() {
		String str = "";
		for(int i = 0; i < sizeY; i++) {
			for(int j = 0; j < sizeX; j++) {
				str += String.valueOf( get(i,j) ) + ", ";
			}
			str += '\n';
		}
		return str;
	}
}
