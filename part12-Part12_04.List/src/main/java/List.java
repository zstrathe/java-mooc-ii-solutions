/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author zack
 */
public class List<Type> {
    private Type[] values;
    private int firstFreeIndex;
    
    public List() {
        this.values = (Type[]) new Object[10];
        this.firstFreeIndex= 0;
    }
    
    private void growList() {
        int newSize = this.firstFreeIndex + this.firstFreeIndex / 2;
        Type[] newValues = (Type[]) new Object[newSize];
        for (int i = 0; i < this.firstFreeIndex; i++) {
            newValues[i] = this.values[i];
        }
        this.values = newValues;
    }
    
    public void add(Type value) {
        if (this.firstFreeIndex > this.values.length - 1) {
            growList();
        }
        this.values[firstFreeIndex] = value;
        this.firstFreeIndex ++;
    }
    
    public void remove(Type value) {
        int valIndex = getIndexOf(value);
        if (valIndex >= 0) {
            moveValsLeft(valIndex);
        }
    }
    
    public boolean contains(Type value) {
        if (getIndexOf(value) >= 0) {
            return true;
        }
        return false;
    }
    
    private int getIndexOf(Type value) {
        for (int i = 0; i < this.firstFreeIndex; i++) {
            if (this.values[i] == value || this.values[i].equals(value)){
                return i;
            }
        }
        return -1;
    }
    
    private void moveValsLeft(int fromIndex) {
        for (int i = fromIndex; i < this.firstFreeIndex; i++) {
            // check that this isn't the last value in the array 
            // if it is, just set the value to null
            if (i < this.values.length - 1) {
                this.values[i] = this.values[i+1];
                this.values[i+1] = null;
            } else {
                this.values[i] = null;
            }
        }
        this.firstFreeIndex --;
    }
    
    public Type value(int index) {
        if (index < 0 || index >= this.firstFreeIndex) {
           throw new ArrayIndexOutOfBoundsException("Index: " + index + " is out of bounds for list!");
        }
        return this.values[index];
    }
    
    public int size() {
        System.out.println("TEST: array length: " + this.values.length);
        return this.firstFreeIndex;
    }
    
    public String toString() {
        String output = "[";
        for (int i = 0; i < this.firstFreeIndex; i++) {
            output += this.values[i];
            if (i < this.firstFreeIndex - 1) {
                output += ", ";
            }
        }
        output += "]";
        return output;
    }
}
