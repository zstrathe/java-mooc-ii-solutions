/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author zack
 */
import java.util.Map;
import java.util.HashMap;
import java.util.Set;

public class Warehouse {
    private Map<String, Integer> productPrices;
    private Map<String, Integer> productStock;
    
    public Warehouse() {
        this.productPrices = new HashMap<>();
        this.productStock = new HashMap<>();
    }
    
    public void addProduct(String product, int price, int stock) {
        this.productPrices.putIfAbsent(product, price);
        this.productStock.putIfAbsent(product, stock);
    }
    
    public int price(String product) {
        return this.productPrices.getOrDefault(product, -99);
    }
    
    public int stock(String product) {
        return this.productStock.getOrDefault(product, 0);
    }
    
    public boolean take(String product) {
        int amount = this.stock(product);
        if (amount > 0) {
            this.productStock.put(product, amount-1);
            return true;
        }
        return false;
    }
    
    public Set<String> products() {
        Set products = this.productStock.keySet();
        return products;
    }
    
}
