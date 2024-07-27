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

public class VehicleRegistry {
    private HashMap<LicensePlate, String> hashMap;
    
    public VehicleRegistry() {
        this.hashMap = new HashMap<>();
    }
    
    public boolean add(LicensePlate licenseplate, String owner) {
        if (!(this.hashMap.containsKey(licenseplate))) {
            this.hashMap.put(licenseplate, owner);
            return true;
        }
        System.out.println("License plate already in registry!");
        return false;
    }
    
    public String get(LicensePlate licenseplate) {
        return this.hashMap.getOrDefault(licenseplate, null);
    }
    
    public boolean remove(LicensePlate licenseplate) {
        if (this.hashMap.containsKey(licenseplate)) {
            this.hashMap.remove(licenseplate);
            return true;
        }
        return false;
    }
    
    public void printLicensePlates() {
        for (LicensePlate lp: this.hashMap.keySet()) {
            System.out.println(lp);
        }
    }
    
    public void printOwners() {
        ArrayList<String> seenOwners = new ArrayList<>();
        for (String owner: this.hashMap.values()) {
            if (!(seenOwners.contains(owner))) {
                System.out.println(owner);
                seenOwners.add(owner);
            }
    
        }
    }
    
    public String search(LicensePlate searchLP) {
        for (LicensePlate lp: this.hashMap.keySet()) {
            if (lp.equals(searchLP)) {
                return get(lp);
            }
        }
        return null;
    }
}
