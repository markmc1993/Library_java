import java.util.*;

import static java.lang.Integer.parseInt;

//Validator to ensure number entered
public class Validators {
    private static Scanner input = new Scanner(System.in); //Setup user input

    public int menuValidate(String num){
        // take string num and check to ensure it is number, parseInt and return if number
        boolean valid = false;
        int newNum = 0;

        while (!valid){
            if (num.matches("\\p{Digit}+")){
                newNum = parseInt(num);
                valid = true;
            }
            else{
                System.out.println("Invalid information entered. Please enter a number");
                num = input.next();
            }
        }

        return newNum;
    }

    public String singleWordValidate(String word){
        //validation to ensure empty string not entered
        boolean valid = false;

        while (!valid){
            if (word.length() < 1){
                System.out.println("Nothing entered. Enter information please.");
                word = input.next();
            }
            else{
                valid = true;
            }
        }
        return word;
    }
}
