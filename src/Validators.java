// Validator class
// Created by Mark McAllister
// Last update 10/02/2020
import java.text.SimpleDateFormat;
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
                num = input.nextLine();
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
                word = input.nextLine(); word = word.substring(0, 1).toUpperCase() + word.substring(1);
            }
            else{
                valid = true;
            }
        }
        return word;
    }

    public String multiWordValidate(String words){
        //validation to ensure empty string not entered
        boolean valid = false;

        while (!valid){
            if (words.length() < 1){
                System.out.println("Nothing entered. Enter information please.");
                input.nextLine();
                words = input.nextLine(); words = words.substring(0, 1).toUpperCase() + words.substring(1);
            }
            else{
                valid = true;
            }
        }


        return words;
    }

    public String passValidate(String pass){
        //validation to ensure password contains 1 uppercase letter, 1 lowecase letter, 1 number and 1 symbol
        boolean valid = false;

        while(!valid){
            if (pass.matches(".*[A-Z]+.*") && pass.matches(".*[a-z]+.*") && pass.matches(".*[0-9]+.*") && pass.matches(".*\\p{Punct}+.*" ) && pass.length() >=8 && pass.length() <= 20){
                valid = true;
            }
            else{
                System.out.println("Invalid password. Password must be between 8 and 20 characters and contain at least 1 of the following: ");
                System.out.printf("%1s %n %1s %n %1s %n %1s %n",
                        "Uppercase character",
                        "Lowercase character",
                        "A number",
                        "Special character");
                pass = input.nextLine();
            }
        }

        return pass;
    }

    public String phoneValidate(String num){
        // take string num and check to ensure it is number
        boolean valid = false;

        while (!valid){
            if (num.matches("\\p{Digit}+")){
                valid = true;
            }
            else{
                System.out.println("Invalid information entered. Please enter numbers only");
                num = input.nextLine();
            }
        }

        return num;
    }

    public String dateValidate(String dob){
        //Validation of date entered
        boolean dateConfirm = false;
        SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyy");
        sdf.setLenient(false);
        Date parsedDate = null;

        while (!dateConfirm) {

            try {
                parsedDate = sdf.parse(dob);
                dateConfirm = true;
            } catch (Exception e){
                System.out.println("Invalid date entry, enter ddmmyyyy");
                dob = input.nextLine();
            }


        }

        return parsedDate.toString();
    }

    public double doubleValidate(String num){
        // take string num and check to ensure it is number, parseInt and return if number
        boolean valid = false;
        double newNum = 0;

        while (!valid){
            if (num.matches(".*[0-9]+.*" ) && num.matches(".*[.]+.*")){
                newNum = Double.parseDouble(num);
                valid = true;
            }
            else{
                System.out.println("Invalid information entered. Please enter a valid price e.g. 0.5");
                num = input.nextLine();
            }
        }

        return newNum;
    }

    public String runtimeValidate(String runtime){
        boolean valid = false;
        SimpleDateFormat time = new SimpleDateFormat("HH:mm:ss");
        Date parsedDate = null;
        while(!valid) {
            try {
                parsedDate = time.parse(runtime);
                valid = true;
            } catch (Exception e){
                System.out.println("Invalid date entry, enter HH:mm:ss");
                runtime = input.nextLine();
            }
        }

        return runtime;
    }
}
