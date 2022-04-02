/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

import java.util.Arrays;
import java.util.Locale;

/**
 *
 * @author Tharuka Sandaruwan
 */ 
public class Country implements Comparable<Country> {
    private String code;
    private String name;
 
    public Country(String code, String name) {
        this.code = code;
        this.name = name;
    }
 
    public String getCode() {
        return code;
    }
 
    public void setCode(String code) {
        this.code = code;
    }
 
    public String getName() {
        return name;
    }
 
    public void setName(String name) {
        this.name = name;
    }
 
    @Override
    public String toString() {
        return this.name;
    }
 
    @Override
    public int compareTo(Country anotherCountry) {
        return this.name.compareTo(anotherCountry.getName());
    }
    
    public static int getcountryIndex(String country){
    String[] countryCodes = Locale.getISOCountries();
    Country[] listCountry = new Country[countryCodes.length];
 
    for (int i = 0; i < countryCodes.length; i++) {
        Locale locale = new Locale("", countryCodes[i]);
        String code = locale.getCountry();
        String name = locale.getDisplayCountry();
 
        listCountry[i] = new Country(code, name);
    }
 
        Arrays.sort(listCountry);
     
       

        String[] mylist = new String[249] ;
    
        int i = 0;
    
        while (i < 249 ) {   // there are 249 countries         
             mylist[i] = listCountry[i].getName();
            i++;
       }

        return (Arrays.asList(mylist).indexOf(country));  
 
    } 
}