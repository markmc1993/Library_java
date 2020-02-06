//Password encryption
//Takes password sent from another class
//Splits and creates a new password which is made up from first password backwards followed by first password forwards
//Newpass put through encryption inspired by Caeser Cipher
//Return encrypted password

//Created by: Mark McAllister
//Date created: 28/01/2020

import java.util.*;

public class PassEncrypt {

    public String encrypt(String password){

        char [] passSplit = password.toCharArray();
        String newpass = "";
        String finalpass = "";


        //for loop along passSplit in reverse
        for (int i = passSplit.length  -1; i >=0; i--){
            newpass += passSplit[i];
        }

        //for loop along passSplit forwards
        for (int i = 0; i < passSplit.length; i++){
            newpass += passSplit[i];
        }

        //letters of newpass stored in char array and string array
        char [] charNewpassSplit = newpass.toCharArray();
        String [] stringNewpassSplit = newpass.split("");

        //For loop getting ascii number of character and then adding 8
        //if the number is greater than the ascii of z, -26 from it
        for (int i = 0; i < charNewpassSplit.length; i++){
            char c = charNewpassSplit[i];
            char z = 'z';
            int ascii = c;

            if (stringNewpassSplit[i].matches("\\p{Alnum}+")){

                ascii += 8;
                if (ascii > z){
                    ascii -= 26;
                }
                c = (char) ascii;
            }
            else{
                c = charNewpassSplit[i];
            }
            finalpass += c;
        }

        return finalpass;
    }
}
