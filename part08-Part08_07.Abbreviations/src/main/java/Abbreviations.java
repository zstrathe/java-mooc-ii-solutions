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

public class Abbreviations {
    private HashMap<String, String> abbvs;
    
    public Abbreviations() {
        this.abbvs = new HashMap<>();
    }
    
    public void addAbbreviation(String abbreviation, String explanation) {
        if (this.abbvs.containsKey(abbreviation)) {
            System.out.println("ERROR: Abbreviation is already added!");
        }
        this.abbvs.put(abbreviation, explanation);
    }
    
    
    public boolean hasAbbreviation(String abbreviation) {
        if (this.abbvs.containsKey(abbreviation)) {
            return true;
        }
        return false;
    }
    
    public String findExplanationFor(String abbreviation) {
        String expl = this.abbvs.get(abbreviation);
        
        return expl;
    }
}
