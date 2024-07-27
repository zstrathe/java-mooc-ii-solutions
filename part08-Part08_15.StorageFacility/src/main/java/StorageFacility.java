/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author zack
 */
import java.util.HashMap;
import java.util.ArrayList;

public class StorageFacility {
    private HashMap<String, ArrayList<String>> unitDB;
    
    public StorageFacility() {
        this.unitDB = new HashMap<>();
    }
    
    public void add(String unit, String item) {
        // init unit key and empty list if not present
        this.unitDB.putIfAbsent(unit, new ArrayList<>());
        
        // get unit list
        ArrayList unitList = this.unitDB.get(unit);
        // add the item
        unitList.add(item);
    }
    
    public ArrayList<String> contents(String storageUnit) {
        return this.unitDB.getOrDefault(storageUnit, new ArrayList<>());
    }
    
    public void remove(String storageUnit, String item) {
        ArrayList<String> unitItems = this.unitDB.getOrDefault(storageUnit, new ArrayList<>());
        unitItems.remove(item);
        if (unitItems.size() == 0) {
            this.unitDB.remove(storageUnit);
        }
        
    }
    
    public ArrayList<String> storageUnits() {
        ArrayList<String> storageUnits = new ArrayList<>();
        for (String unit: this.unitDB.keySet()) {
            storageUnits.add(unit);
        }
        return storageUnits;
    }
    
}
