/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author zack
 */
public enum Education {
    PHD("Doctoral degree"),
    MA("Masters degree"),
    BA("Bachelors degree"),
    HS("High school diploma");
    
    private String degreeFullName;
    
    private Education(String degreeFullName) {
        this.degreeFullName = degreeFullName;
    }
    
    public String getDegreeFullName() {
        return this.degreeFullName;
    }
}
