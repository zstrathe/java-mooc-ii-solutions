/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author zack
 */
public class LiteracyStatistic {
    private String statYear;
    private String country;
    private String gender;
    private String literacyRate;
    
    public LiteracyStatistic(String statYear, String country, String gender, String literacyRate) {
        this.statYear = statYear;
        this.country = country;
        this.gender = gender.trim().split(" ")[0];
        this.literacyRate = literacyRate;
    }
    
    public String getLiteracyRate() {
        return this.literacyRate;
    }
    
    public String toString() {
        return this.country + " (" + this.statYear + "), " + this.gender + ", " + this.literacyRate;
    }
}
