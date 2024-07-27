/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author zack
 */
import java.util.ArrayList;

public class Pipe<T> {
    private ArrayList<T> pipe;
    
    public Pipe() {
        this.pipe = new ArrayList<>();
    }
    
    public void putIntoPipe(T value) {
        this.pipe.add(value);
    }
    
    public T takeFromPipe() {
        int lastIdx = this.pipe.size() - 1;
        if (lastIdx == 0) {
            return null;
        }
        T takeObj = this.pipe.get(lastIdx);
        this.pipe.remove(lastIdx);
        return takeObj;
    }
    
    public boolean isInPipe() {
        if (this.pipe.size() == 0) {
            return false;
        }
        return true;
    }
}
