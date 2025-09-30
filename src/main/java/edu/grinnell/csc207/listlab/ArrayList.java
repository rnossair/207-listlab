package edu.grinnell.csc207.listlab;
import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * An array-based implementation of the list ADT.
 */
public class ArrayList {

    private int[] data;
    private int size;

    public ArrayList(){
        this.size = 0;
        this.data = new int[1];
    }



    private void ensureCapacity() {
        if(size == data.length){
            data = Arrays.copyOf(data, data.length * 2);
        }
    }


    /**
     * Adds <code>value</code> to the end of the list
     * 
     * @param value the value to add to the end of the list
     */
    public void add(int value) {
        Array.set(this.data, this.size, value);
        this.size++;
        this.ensureCapacity();
    }

    /**
     * @return the number of elements in the list
     */
    public int size() {
        return this.size;
    }

    /**
     * @param index the index of the element to retrieve
     * @return the value at the specified <code>index</code>
     */
    public int get(int index) {
        if(index >= this.size || index < 0){
            throw new IndexOutOfBoundsException();
        }
        int result = this.data[index];
        return result;
    }

    /**
     * Removes the value at <code>index</code> from the list
     * 
     * @param index the index of the element to remove
     * @return the element at <code>index</code>
     */
    public int remove(int index) {
        int result = Array.getInt(this.data, index);
        int[] resultingArray = new int[this.data.length];
        for(int i = 0; i < this.size; i++){
            if(i < index){
                resultingArray[i] = this.data[i];
                continue;
            }
            if(i > index){
                resultingArray[i-1] = this.data[i];
            }
        }
        this.size--;
        this.data = resultingArray;
        return result;

    }


    public boolean isEmpty(){
        return this.size == 0;
    }

    public void clear(){
        this.data = new int[1];
        this.size = 0;
    }

    public int indexOf(int value){
        for(int i = 0; i < this.size; i++){
            if(this.data[i] == value){
                return i;
            }
        }
        return -1;
    }

    public boolean contains(int value){
        for(int i = 0; i < this.size; i++){
            if(this.data[i] == value){
                return true;
            }
        }
        return false;
    }

    public void add(int index, int value) {
        if(index >= this.size || index < 0){
            throw new IndexOutOfBoundsException();
        }
        int[] resultingArray = new int[this.data.length];
        for(int i = 0; i < this.size; i++){
            if(i <= index){
                resultingArray[i] = this.data[i];
                continue;
            }
            if(i > index){
                resultingArray[i+1] = this.data[i];
            }
        }
        this.size++;
        this.data = resultingArray;
        this.ensureCapacity();
    }
}
