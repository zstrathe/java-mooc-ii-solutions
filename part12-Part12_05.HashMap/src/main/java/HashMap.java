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

public class HashMap<K, V> {
    private ArrayList<Pair<K, V>>[] values;
    private int pairsStored;
    
    public HashMap() {
        this.values = new ArrayList[32];
        this.pairsStored= 0;
    }
    
    public void add(K key, V value) {
        int hashValue = Math.abs(key.hashCode() % values.length);
        if (values[hashValue] == null) {
            values[hashValue] = new ArrayList<>();
        }
        
        ArrayList<Pair<K, V>> hashIdxList = this.values[hashValue];
        
        boolean setFlag = false;
        
        // check if a pair already exists and update it
        for (int i = 0; i < hashIdxList.size(); i++) {
            if (hashIdxList.get(i).getKey() == key) {
                hashIdxList.get(i).setValue(value);
                setFlag = true;
                break;
            }
        }
        // if a Pair doesn't already exist for the key, then create a new one
        if (setFlag == false) {
            Pair<K, V> newPair = new Pair(key, value);
            hashIdxList.add(newPair);
            this.pairsStored ++;
        } 
        
        // check the number of pairs stored and grow if necessary
        // when pairsStored > 75% of hash map array
        if (this.pairsStored > (this.values.length * .75)) {
            grow();
        }
    }
    
    public V remove(K key, V value) {
        int hashValue = Math.abs(key.hashCode() % values.length);
        if (values[hashValue] == null) {
            return null;
        }
        
        ArrayList<Pair<K, V>> hashIdxList = this.values[hashValue];
        
        // iterate through the ArrayList at the hashValue idx to find the key
        for (int i = 0; i < hashIdxList.size(); i++) {
            if (hashIdxList.get(i).getKey() == key) {
                V returnVal = hashIdxList.get(i).getValue();
                hashIdxList.remove(i);
                return returnVal;
            }
        }
        // return null if there was no value to remove
        return null;
    }
    
    public void grow() {
        int newArrSize = this.values.length + this.values.length / 2;
        System.out.println("TEST: growing hash map array from " + this.values.length + " to " + newArrSize);
        ArrayList<Pair<K, V>>[] newValues = new ArrayList[newArrSize];
        
        // iterate through the array of ArrayLists and 
        // re-allocate into the new array
        for (int i = 0; i < this.values.length; i++) {
            if (this.values[i] != null) {
                ArrayList<Pair<K,V>> idxList = this.values[i];
                for (int j = 0; j < idxList.size(); j++) {
                    Pair<K, V> pair = idxList.get(j);
                    int newHashValue = Math.abs(pair.getKey().hashCode() % newValues.length);
                    
                    if (newValues[newHashValue] == null) {
                        newValues[newHashValue] = new ArrayList<>();
                    }
                    newValues[newHashValue].add(pair);
                }
            }
        }
        this.values = newValues;
    }
    
    public V get(K key) {
        int hashValue = Math.abs(key.hashCode() % values.length);
        if (this.values[hashValue] != null) {
            ArrayList<Pair<K, V>> hashList = this.values[hashValue];
            for (int i = 0; i < hashList.size(); i++) {
                if (hashList.get(i).getKey() == key || hashList.get(i).getKey().equals(key)) {
                    return hashList.get(i).getValue();
                }
            }
        }
        return null;
    }
    
    public String toString() {
        String outputString = "{";
        // iterate through the hash map array first
        for (int i = 0; i < this.values.length; i++) {
            if (this.values[i] != null) {
                // iterate through the ArrayList at each hash map index
                // that is not null
                ArrayList<Pair<K, V>> listAtIdx = this.values[i];
                for (int j = 0; j < listAtIdx.size(); j++) {
                    String pairString = listAtIdx.get(j).toString();
                    outputString += pairString + ", "; 
                }
            }
        }
        // trim the last ", " from the outPut string at this point since it's 
        // difficult to determine when the last pair is encountered 
        // in the hash map array
        outputString = outputString.substring(0, outputString.length() - 2);
        outputString += "}";
        return outputString;
    }
    
}
