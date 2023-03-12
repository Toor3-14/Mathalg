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

class MatrixIterator<T> implements Iterable<T>{
    private T[][] array;

    public Array2d(T[][] array) {
        this.array = array;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {

            private int i, j;

            @Override
            public boolean hasNext() {
                for(int i = this.i; i< array.length; i++){
                    for(int j = this.j; j< array[i].length; j++){
                        return true;
                    }
                }
                return false;
            }

            @Override
            public T next() {
                if(!hasNext())
                    throw new NoSuchElementException();
                T t = array[i][j];
                j++;
                for(int i = this.i; i< array.length; i++){
                    for(int j = (i == this.i ? this.j : 0); j< array[i].length; j++){
                        this.i = i;
                        this.j = j;
                        return t;
                    }
                }

                return t;
            }
        };
    }
}
