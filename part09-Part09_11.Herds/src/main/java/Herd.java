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

public class Herd implements Movable {
    private List<Movable> herdList;
    
    public Herd() {
        this.herdList = new ArrayList<>();
    }
    
    public String toString() {
        String outString = "";
        for (Movable member: this.herdList) {
            outString += member.toString() + "\n";
        }
        return outString;
    }
    
    public void addToHerd(Movable movable) {
        this.herdList.add(movable);
    }
    
    public void move(int dx, int dy) {
        for (Movable member: this.herdList) {
            member.move(dx, dy);
        }
    }
    
}
