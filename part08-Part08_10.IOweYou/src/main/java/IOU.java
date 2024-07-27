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

public class IOU {
    private HashMap<String, Double> ledger;
    
    public IOU() {
        this.ledger = new HashMap<>();
    }
    
    public void setSum(String toWhom, double amount) {
        double curBal = this.ledger.getOrDefault(toWhom, 0.00);
        curBal += amount;
        this.ledger.put(toWhom, curBal);
    }
    
    public double howMuchDoIOweTo(String toWhom) {
        double bal = this.ledger.getOrDefault(toWhom, 0.00);
        return bal;
    }
}
