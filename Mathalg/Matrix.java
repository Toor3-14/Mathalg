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

public class Matrix<E extends Number> extends MatrixOperation {

// PRIVATE SECTION
	
	private List<List<E>> matrix;
	private int sizeY = 0;
	private int sizeX = 0;
	
	
// CONSTRUCTOR SECTION
	
	public Matrix() {
		this.matrix = new ArrayList<>();
	}
	
	public Matrix(Matrix<E> matrixClass) {
		this.sizeY = matrixClass.getSizeY();
		this.sizeX = matrixClass.getSizeX();
		this.matrix = matrixClass.getMatrix();
	}
	
	public Matrix(List<List<E>> collection) {
		this.matrix = collection;
	}
	
	public Matrix(E[][] array) {
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
	
	public Matrix(int sizeY) {
		List<List<E>> newMatrix = new ArrayList<>(sizeY);
		for(int i = 0; i < sizeY; i++) {
			newMatrix.add(i, new ArrayList<E>());
		}
		this.sizeY = sizeY;
		this.matrix = newMatrix;
	}
	
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
	
	public E get(int indexY, int indexX) {
		return matrix.get(indexY).get(indexX);
	}
	public void set(int indexY, int indexX, E value) {
		matrix.get(indexY).set(indexX, value);
	}
	
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
	public List<E> remove(int indexY) {
		return  matrix.remove(indexY);
	}
	public E remove(int indexY, int indexX) {
		return  matrix.get(indexY).remove(indexX);
	}
	
	public boolean isEmpty() {
		return matrix.isEmpty();
	}
	public boolean isEmpty(int indexY) {
		return matrix.get(indexY).isEmpty();
	}
	
// GETTERS SECTION
	
	public int getSizeY() {return sizeY;}
	public int getSizeX() {return sizeX;}
	public List<List<E>> getMatrix() {return matrix;}
	

// OVERRIDE SECTION
	
	@Override
	public String toString() {
		return this.matrix.toString();
	}
}
