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

public class BoxWithMaxWeight extends Box {
    private int capacity;
    private ArrayList<Item> itemsInBox;
    
    public BoxWithMaxWeight(int capacity) {
        this.capacity = capacity;
        this.itemsInBox = new ArrayList<>();
    }
    
    @Override
    public void add(Item item) {
        int currentWeight = 0;
        for (Item boxItem: this.itemsInBox) {
            currentWeight += boxItem.getWeight();
        }
        if (item.getWeight() + currentWeight <= this.capacity) {
            this.itemsInBox.add(item);
        }
    }
    
    @Override
    public boolean isInBox(Item item) {
        for (Item boxItem: this.itemsInBox) {
            if (item.equals(boxItem)) {
                return true;
            }
        }
        return false;
    }
}
