/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author zack
 */
public class Pair<K, V> {
    private K key;
    private V value;
    
    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }
    
    public K getKey() {
        return this.key;
    }
    
    public V getValue() {
        return this.value;
    }
    
    public void setValue(V value) {
        this.value = value;
    }
    
    public String toString() {
        String keyString = String.valueOf(getKey());
        String valueString = String.valueOf(getValue());
        return keyString + ": " + valueString;
    }
}
