/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author zack
 */
import java.util.List;
import java.util.ArrayList;

public class ShoppingCart {
    private List<Item> items;
    
    public ShoppingCart() {
        this.items = new ArrayList<>();
    }
    
    public void add(String product, int price) {
        Item searchItem = new Item(product, 0, price);
        if (this.items.contains(searchItem)) {
            for (Item existingItem: this.items) {
                if (existingItem.equals(searchItem)) {
                    existingItem.increaseQuantity();
                    break;
                }
            }
        } else {
            Item item = new Item(product, 1, price);
            items.add(item);
        }
    }
    
    public int price() {
        int totalPrice = 0;
        for (int i=0; i<items.size(); i++) {
            totalPrice += items.get(i).price();
        }
        return totalPrice;
    }
    
    public void print() {
        for (int i = 0; i < this.items.size(); i++) {
            System.out.println(this.items.get(i));
        }
    }
}
