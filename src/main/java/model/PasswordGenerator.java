/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;
import org.apache.commons.text.CharacterPredicates;
import org.apache.commons.text.RandomStringGenerator;
/**
 *
 * @author zurion
 */
public class PasswordGenerator {
 
public String getGeneratedPassword() 
    { 
        int n = 13;
        // chose a Character random from this String 
        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                                    + "0123456789"
                                    + "abcdefghijklmnopqrstuvxyz" + "<!@%^&*_-#>"; 
  
        // create StringBuffer size of AlphaNumericString 
        StringBuilder pBuilder = new StringBuilder(n); 
  
        for (int i = 0; i < n; i++) { 
  
            // generate a random number between 
            // 0 to AlphaNumericString variable length 
            int index 
                = (int)(AlphaNumericString.length() 
                        * Math.random()); 
  
            // add Character one by one in end of sb 
            pBuilder.append(AlphaNumericString 
                          .charAt(index)); 
        } 
  
        return pBuilder.toString(); 
    } 
}