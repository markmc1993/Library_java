import java.util.Scanner;

public class Register {
    private static Scanner input = new Scanner(System.in);
    private static String firstName;
    private static String lastName;
    private static String password;
    private static String rePassword;
    private static String username;
    private boolean equalPass = false;
    private static String email;
    private static String address;
    private static String postCode;
    private static String phoneNo;
    private static String dob;
    Validators val = new Validators();
    PassEncrypt pass = new PassEncrypt();
    public void casualRegister()
    {
        //Get details from user, validate and add to correct user hashmap
        System.out.println("Casual register setup");
        System.out.println("Please enter your first name");
        firstName = input.next(); firstName = firstName.substring(0, 1).toUpperCase() + firstName.substring(1);
        val.singleWordValidate(firstName);
        System.out.println("Please enter your last name");
        lastName = input.next(); lastName = lastName.substring(0, 1).toUpperCase() + lastName.substring(1);
        val.singleWordValidate(lastName);
        System.out.println("Please enter your email address");
        email = input.next();
        System.out.println("Please enter your desired password");
        password = input.next();
        val.passValidate(password);
        while (!equalPass){
            System.out.println("Please confirm desired password");
            rePassword = input.next();
            if (password.equals(rePassword)){
                System.out.println("Passwords match");
                equalPass = true;
            }
            else{
                System.out.println("Passwords do not match, try again");
                rePassword = input.next();
            }
        }

        username = userNameGenerate(firstName, lastName);
        System.out.println("Your username is " + username);

        User newUser = new User(firstName, lastName, username, pass.encrypt(password), email);
        Control.users.put(newUser.getUserName(), newUser);
        System.out.println(username + " added to system. Close app and login to confirm");

    }

    public void memberRegister(){
        //Get details from user, validate and add to correct user hashmap
        System.out.println("Member register setup");
        System.out.println("Please enter your first name");
        firstName = input.next(); firstName = firstName.substring(0, 1).toUpperCase() + firstName.substring(1);
        val.singleWordValidate(firstName);
        System.out.println("Please enter your last name");
        lastName = input.next(); lastName = lastName.substring(0, 1).toUpperCase() + lastName.substring(1);
        val.singleWordValidate(lastName);
        System.out.println("Please enter your email address");
        email = input.next();
        System.out.println("Please enter your address");
        input.nextLine();
        address = input.nextLine();
        val.multiWordValidate(address);
        System.out.println("Please enter your postcode");
        postCode = input.next().toUpperCase();
        System.out.println("Please enter your phone number");
        phoneNo = input.next();
        val.phoneValidate(phoneNo);
        System.out.println("Please enter your date of birth (ddmmyyyy)");
        dob = input.next();
        val.dateValidate(dob);
        System.out.println("Please enter your desired password");
        password = input.next();
        val.passValidate(password);
        while (!equalPass){
            System.out.println("Please confirm desired password");
            rePassword = input.next();
            if (password.equals(rePassword)){
                System.out.println("Passwords match");
                equalPass = true;
            }
            else{
                System.out.println("Passwords do not match, try again");
                rePassword = input.next();
            }
        }

        username = userNameGenerate(firstName, lastName);
        System.out.println("Your username is " + username);

        Member newMem = new Member(firstName, lastName, username, pass.encrypt(password), email, address, postCode, phoneNo, dob);
        Control.users.put(newMem.getUserName(), newMem);
        System.out.println(username + " added to system. Close app and login to confirm");
    }

    public void vipRegister(){
        //Get details from user, validate and add to correct user hashmap
        System.out.println("VIP register setup");
        System.out.println("Member register setup");
        System.out.println("Please enter your first name");
        firstName = input.next(); firstName = firstName.substring(0, 1).toUpperCase() + firstName.substring(1);
        val.singleWordValidate(firstName);
        System.out.println("Please enter your last name");
        lastName = input.next(); lastName = lastName.substring(0, 1).toUpperCase() + lastName.substring(1);
        val.singleWordValidate(lastName);
        System.out.println("Please enter your email address");
        email = input.next();
        System.out.println("Please enter your address");
        input.nextLine();
        address = input.nextLine();
        val.multiWordValidate(address);
        System.out.println("Please enter your postcode");
        postCode = input.next().toUpperCase();
        System.out.println("Please enter your phone number");
        phoneNo = input.next();
        val.phoneValidate(phoneNo);
        System.out.println("Please enter your date of birth (ddmmyyyy)");
        dob = input.next();
        val.dateValidate(dob);
        System.out.println("Please enter your desired password");
        password = input.next();
        val.passValidate(password);
        while (!equalPass){
            System.out.println("Please confirm desired password");
            rePassword = input.next();
            if (password.equals(rePassword)){
                System.out.println("Passwords match");
                equalPass = true;
            }
            else{
                System.out.println("Passwords do not match, try again");
                rePassword = input.next();
            }
        }

        username = userNameGenerate(firstName, lastName);
        System.out.println("Your username is " + username);

        Member newMem = new Member(firstName, lastName, username, pass.encrypt(password), email, address, postCode, phoneNo, dob);
        Control.users.put(newMem.getUserName(), newMem);
        System.out.println(username + " added to system. Close app and login to confirm");
    }

    private String userNameGenerate(String fName, String lName){
        String userName = fName.substring(0,1) + lName.substring(1) + (Control.userlogins.size() + 1);
        return userName;
    }
}
