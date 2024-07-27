/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author zack
 */
public class OneItemBox extends Box{
    private Item itemInBox;
    
    public OneItemBox() {
        //this.itemInBox = null;
    }
    
    public OneItemBox(Item item) {
        this.itemInBox = item;
    }
    
    @Override
    public void add(Item item) {
        if (this.itemInBox == null) {
            this.itemInBox = item;
        }
    }
    
    @Override
    public boolean isInBox(Item item) {
        if (item.equals(this.itemInBox)) {
            return true;
        }
        return false;
    }
    
    
}
