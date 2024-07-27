/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

/**
 *
 * @author zack
 */
import java.util.HashMap;
import java.util.Random;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class VocabDictionary {
    private HashMap<String, String> dictionary;
    private ArrayList<String> words;
    
    public VocabDictionary() {
        this.dictionary = new HashMap<>();
        this.words = new ArrayList<>();
//        addWord("test", "test");
    }
    
    public void addWord(String word, String translation) {
        if (!this.words.contains(word)) {
            this.words.add(word);
        }
        this.dictionary.put(word, translation);
    }
    
    public String getTranslation(String word) {
        return this.dictionary.getOrDefault(word, "");
    }
    
    public String getRandomWord() {
        Random random = new Random();
        if (this.words.size() > 0) {
            return this.words.get(random.nextInt(this.words.size()));
        } else {
            return null;
        }
    }
}
