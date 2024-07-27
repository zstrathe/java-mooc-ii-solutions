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

public class DictionaryOfManyTranslations {
    private HashMap<String, ArrayList<String>> transDict;
    
    public DictionaryOfManyTranslations() {
        this.transDict = new HashMap<>();
    }
    
    public void add(String word, String translation) {
        // add HashMap key if not present and initialize empty list
        this.transDict.putIfAbsent(word, new ArrayList<>());
        
        ArrayList<String> wordTransList = this.transDict.get(word);
        wordTransList.add(translation);
    }
    
    public ArrayList<String> translate(String word) {
        return this.transDict.getOrDefault(word, new ArrayList<>());
    }
    
    public void remove(String word) {
        this.transDict.remove(word);
    }
    
}
