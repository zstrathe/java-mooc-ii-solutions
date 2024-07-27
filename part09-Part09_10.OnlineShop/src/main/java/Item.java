
import java.util.Objects;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author zack
 */
public class Item {
    private String name;
    private int quantity;
    private int price;
    
    public Item(String product, int qty, int unitPrice) {
        this.name = product;
        this.quantity = qty;
        this.price = unitPrice;
    }
    
    public int price() {
        return this.price * this.quantity;
    }
    
    public void increaseQuantity() {
        this.quantity ++;
    }
    
    public String toString() {
        return this.name + ": " + this.quantity;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 61 * hash + Objects.hashCode(this.name);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Item other = (Item) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        return true;
    }

}
