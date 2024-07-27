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

public class ChangeHistory {
    private ArrayList<Double> changeList;
    
    public ChangeHistory() {
        this.changeList = new ArrayList<>();
    }
    
    public void add(double status) {
        this.changeList.add(status);
    }
    
    public void clear() {
        this.changeList.clear();
    }
    
    public String toString() {
        return this.changeList.toString();
    }
    
    public double maxValue() {
        double max = 0;
        for (double val: this.changeList) {
            if (val > max) {
                max = val;
            }
        }
        return max;
    }
    
    public double minValue() {
        double min = 999999999.9999999;
        for (double val: this.changeList) {
            if (val < min) {
                min = val;
            }
        }
        return min;
    }
    
    public double average() {
        double sum = 0;
        if (this.changeList.size() == 0) {
            return 0;
        }
        for (double val: this.changeList) {
            sum += val;
        }
        return sum / this.changeList.size();
    }
}
