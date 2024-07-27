/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dictionary;

/**
 *
 * @author zack
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.nio.file.Paths;
import java.io.PrintWriter;

public class SaveableDictionary {
    private ArrayList<String[]> dictionary;
    private String filename;
    
    public SaveableDictionary() {
        this.dictionary = new ArrayList<>();
    }
    
    public SaveableDictionary(String file) {
        this.dictionary = new ArrayList<>();
        this.filename = file;
    }
    
    public boolean load() {
        try (Scanner scanner = new Scanner(Paths.get(this.filename))) {
        
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(":");
                this.dictionary.add(parts);
            }
            return true;
            
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return false;
        } 
    }
    
    public boolean save() {
        try {
            PrintWriter writer = new PrintWriter(this.filename); 
            for (int i=0; i < this.dictionary.size(); i++) {
                String[] lineString = this.dictionary.get(i);
                String concatString = lineString[0] + ":" + lineString[1];
                writer.println(concatString);
            }
            writer.close();
            return true;
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return false;
        }
    
    }
    
    public void add(String words, String translation) {
        String[] translationArray = {words, translation};
        this.dictionary.add(translationArray);
    }
    
    private int getTranslationIndex(String word) {
        for (int i = 0; i < this.dictionary.size(); i++) {
            String[] translationArray = this.dictionary.get(i);
            if (word.equals(translationArray[0]) || word.equals(translationArray[1])) {
                return i;
            }
        }
        return -1;
    }
    
    public String translate(String word) {
        int translationIndex = this.getTranslationIndex(word);
        if (translationIndex != -1) {
            String[] translationArray = this.dictionary.get(translationIndex);
            String word1 = translationArray[0];
            String word2 = translationArray[1];
            if (word.equals(word1)) {
                return word2;
            } else if (word.equals(word2)) {
                return word1;
            }
        }
        return null;
    }
    
    public void delete(String word) {
        int translationIndex = this.getTranslationIndex(word);
        if (translationIndex != -1) {
            this.dictionary.remove(translationIndex);
        }
    }
}
