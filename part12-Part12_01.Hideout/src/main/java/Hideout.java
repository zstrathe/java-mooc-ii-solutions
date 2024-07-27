/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author zack
 */
public class Hideout<T> {
    private T hiddenObj;
    
    public Hideout() {
    }
    
    public void putIntoHideout(T toHide) {
        this.hiddenObj = toHide;
    }
    
    public T takeFromHideout() {
        if (this.isInHideout()) {
            T returnObj = this.hiddenObj;
            this.hiddenObj = null;
            return returnObj; 
        }
        return null;
    }
    
    public boolean isInHideout() {
        if (this.hiddenObj != null) {
            return true;
        }
        return false;
    }
    
    
    
}
