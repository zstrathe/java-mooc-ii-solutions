/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author zack
 */
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class Hand implements Comparable<Hand> {
    private List<Card> cards;
    
    public Hand() {
        this.cards = new ArrayList<>();
    }
    
    public void add(Card card) {
        if (!cards.contains(card)) {
            cards.add(card);
        }
    }
    
    public void print() {
        cards.stream()
                .forEach(card -> System.out.println(card));
    }
    
    public void sort() {
        Collections.sort(cards);
    }
    
    public int getHandValue() {
        int handVal = cards.stream()
                .map(card -> card.getValue())
                .reduce(0, (previous, current) -> previous + current);
        return handVal;       
    }
    
    public int compareTo(Hand other) {
        return this.getHandValue() - other.getHandValue();
    }
    
    public void sortBySuit() {
        Collections.sort(this.cards, new BySuitInValueOrder());
    }
}
