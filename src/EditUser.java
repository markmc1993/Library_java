import java.util.LinkedList;
import java.util.Scanner;

public class EditUser {

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
    private static String choice;
    Validators val = new Validators();
    PassEncrypt pass = new PassEncrypt();
    Register reg = new Register();

    public void addVip(){
        //Admin adding vip with required info
        System.out.println("Add VIP");
        System.out.println("Please enter first name");
        firstName = input.next(); firstName = firstName.substring(0, 1).toUpperCase() + firstName.substring(1);
        firstName = val.singleWordValidate(firstName);
        System.out.println("Please enter last name");
        lastName = input.next(); lastName = lastName.substring(0, 1).toUpperCase() + lastName.substring(1);
        lastName = val.singleWordValidate(lastName);
        System.out.println("Please enter email address");
        email = input.next();
        System.out.println("Please enter address");
        input.nextLine();
        address = input.nextLine();
        address = val.multiWordValidate(address);
        System.out.println("Please enter postcode");
        postCode = input.next().toUpperCase();
        System.out.println("Please enter phone number");
        phoneNo = input.next();
        phoneNo = val.phoneValidate(phoneNo);
        System.out.println("Please enter date of birth (ddmmyyyy)");
        dob = input.next();
        dob = val.dateValidate(dob);
        System.out.println("Please enter password");
        password = input.next();

        username = reg.userNameGenerate(firstName, lastName);
        System.out.println("The username is " + username);

        VIPMember newVip = new VIPMember(firstName, lastName, username, pass.encrypt(password), email, address, postCode, phoneNo, dob);
        Control.users.put(newVip.getUserName(), newVip);
        System.out.println(username + " added to system. Close app and login to confirm");
        Control.userlogins.put(username, new LinkedList<>());
        Control.loans.put(username, new LinkedList<>());
        Control.loanhistories.put(username, new LinkedList<>());
        Control.loanrequests.put(username, new LinkedList<>());
    }

    public void addMember(){
        //Admin adding member with required info
        System.out.println("Add member");
        System.out.println("Please enter first name");
        firstName = input.next(); firstName = firstName.substring(0, 1).toUpperCase() + firstName.substring(1);
        firstName = val.singleWordValidate(firstName);
        System.out.println("Please enter last name");
        lastName = input.next(); lastName = lastName.substring(0, 1).toUpperCase() + lastName.substring(1);
        lastName = val.singleWordValidate(lastName);
        System.out.println("Please enter email address");
        email = input.next();
        System.out.println("Please enter address");
        input.nextLine();
        address = input.nextLine();
        address = val.multiWordValidate(address);
        System.out.println("Please enter postcode");
        postCode = input.next().toUpperCase();
        System.out.println("Please enter phone number");
        phoneNo = input.next();
        phoneNo = val.phoneValidate(phoneNo);
        System.out.println("Please enter date of birth (ddmmyyyy)");
        dob = input.next();
        dob = val.dateValidate(dob);
        System.out.println("Please enter password");
        password = input.next();

        username = reg.userNameGenerate(firstName, lastName);
        System.out.println("The username is " + username);

        Member newMem = new Member(firstName, lastName, username, pass.encrypt(password), email, address, postCode, phoneNo, dob);
        Control.users.put(newMem.getUserName(), newMem);
        System.out.println(username + " added to system. Close app and login to confirm");
        Control.userlogins.put(username, new LinkedList<>());
        Control.loans.put(username, new LinkedList<>());
        Control.loanhistories.put(username, new LinkedList<>());
        Control.loanrequests.put(username, new LinkedList<>());
    }

    public void addCasual(){
        //Admin adding casual user with required info
        System.out.println("Add casual");
        System.out.println("Please enter first name");
        firstName = input.next(); firstName = firstName.substring(0, 1).toUpperCase() + firstName.substring(1);
        firstName = val.singleWordValidate(firstName);
        System.out.println("Please enter last name");
        lastName = input.next(); lastName = lastName.substring(0, 1).toUpperCase() + lastName.substring(1);
        lastName = val.singleWordValidate(lastName);
        System.out.println("Please enter email address");
        email = input.next();
        System.out.println("Please enter password");
        password = input.next();

        username = reg.userNameGenerate(firstName, lastName);
        System.out.println("The username is " + username);

        User newUser = new User(firstName, lastName, username, pass.encrypt(password), email);
        Control.users.put(newUser.getUserName(), newUser);
        System.out.println(username + " added to system. Close app and login to confirm");
        Control.userlogins.put(username, new LinkedList<>());
    }


    public void editVip () {
        //menu for vip to select info to edit
        int selection = 0;
        System.out.println("Edit VIP");
        while (selection != 7){
            System.out.println("Please enter a number to select what you wish to edit");
            System.out.printf("%1s %n %1s %n %1s %n %1s %n %1s %n %1s %n %1s %n %1s %n %1s %n",
                "",
                "1: Edit first name",
                "2: Edit last name",
                "3: Edit email",
                "4: Edit address",
                "5: Edit phone number",
                "6: Edit password",
                "7: Cancel",
                "");
            choice = input.next();
            selection = val.menuValidate(choice);
            processVip(selection);
        }
    }

    public void editMember(){
        //menu for member to select info to edit
        int selection = 0;
        System.out.println("Edit member");
        while (selection != 7){
            System.out.println("Please enter a number to select what you wish to edit");
            System.out.printf("%1s %n %1s %n %1s %n %1s %n %1s %n %1s %n %1s %n %1s %n %1s %n",
                    "",
                    "1: Edit first name",
                    "2: Edit last name",
                    "3: Edit email",
                    "4: Edit address",
                    "5: Edit phone number",
                    "6: Edit password",
                    "7: Cancel",
                    "");
            choice = input.next();
            selection = val.menuValidate(choice);
            processMember(selection);
        }
    }

    public void editCasual(){
        //menu for casual user to select info to edit
        int selection = 0;
        System.out.println("Edit casual");
        while (selection != 5) {
            System.out.println("Please enter a number to select what you wish to edit");
            System.out.printf("%1s %n %1s %n %1s %n %1s %n %1s %n %1s %n %1s %n",
                    "",
                    "1: Edit first name",
                    "2: Edit last name",
                    "3: Edit email",
                    "4: Edit password",
                    "5: Cancel",
                    "");
            choice = input.next();
            selection = val.menuValidate(choice);
            processCasual(selection);
        }
    }

    private void processVip(int num){
        switch(num){
            case 1:
                //Edit first name
                System.out.println("Edit first name");
                System.out.println("Please enter your first name");
                firstName = input.next();
                firstName = val.singleWordValidate(firstName);
                Control.vipmembers.get(Control.userInput).setFirstName(firstName);
                break;
            case 2:
                //Edit last name
                System.out.println("Edit last name");
                System.out.println("Please enter your last name");
                lastName = input.next();
                lastName = val.singleWordValidate(lastName);
                Control.vipmembers.get(Control.userInput).setLastName(lastName);
                break;
            case 3:
                //Edit email
                System.out.println("Edit email");
                System.out.println("Please enter your email");
                email = input.next();
                Control.vipmembers.get(Control.userInput).setEmail(email);
                break;
            case 4:
                //Edit address
                System.out.println("Edit address");
                System.out.println("Please enter your address");
                input.nextLine();
                address = input.nextLine();
                address = val.multiWordValidate(address);
                System.out.println("Please enter your postcode");
                postCode = input.next();
                Control.vipmembers.get(Control.userInput).setAddress(address);
                Control.vipmembers.get(Control.userInput).setPostcode(postCode);
                break;
            case 5:
                //Edit phone number
                System.out.println("Edit phone number");
                System.out.println("Please enter your phone number");
                phoneNo = input.next();
                phoneNo = val.phoneValidate(phoneNo);
                break;
            case 6:
                //Edit password
                System.out.println("Edit password");
                System.out.println("Please enter your password");
                password = input.next();
                password = val.passValidate(password);
                while (!equalPass) {
                    System.out.println("Please confirm desired password");
                    rePassword = input.next();
                    if (password.equals(rePassword)) {
                        System.out.println("Passwords match");
                        equalPass = true;
                    } else {
                        System.out.println("Passwords do not match, try again");
                        rePassword = input.next();
                    }
                }
                Control.vipmembers.get(Control.userInput).setPassword(pass.encrypt(password));
                break;
            case 7:
                //Cancel
                System.out.println("Returning to menu");
                break;
            default:
                System.out.println("Invalid number entered. Please enter a number between 1 and 7");
        }
    }

    private void processMember(int num){
        switch(num){
            case 1:
                //Edit first name
                System.out.println("Edit first name");
                System.out.println("Please enter your first name");
                firstName = input.next();
                firstName = val.singleWordValidate(firstName);
                Control.members.get(Control.userInput).setFirstName(firstName);
                break;
            case 2:
                //Edit last name
                System.out.println("Edit last name");
                System.out.println("Please enter your last name");
                lastName = input.next();
                lastName = val.singleWordValidate(lastName);
                Control.members.get(Control.userInput).setLastName(lastName);
                break;
            case 3:
                //Edit email
                System.out.println("Edit email");
                System.out.println("Please enter your email");
                email = input.next();
                Control.members.get(Control.userInput).setEmail(email);
                break;
            case 4:
                //Edit address
                System.out.println("Edit address");
                System.out.println("Please enter your address");
                input.nextLine();
                address = input.nextLine();
                address = val.multiWordValidate(address);
                System.out.println("Please enter your postcode");
                postCode = input.next();
                Control.members.get(Control.userInput).setAddress(address);
                Control.members.get(Control.userInput).setPostcode(postCode);
                break;
            case 5:
                //Edit phone number
                System.out.println("Edit phone number");
                System.out.println("Please enter your phone number");
                phoneNo = input.next();
                phoneNo = val.phoneValidate(phoneNo);
                break;
            case 6:
                //Edit password
                System.out.println("Edit password");
                System.out.println("Please enter your password");
                password = input.next();
                password = val.passValidate(password);
                while (!equalPass) {
                    System.out.println("Please confirm desired password");
                    rePassword = input.next();
                    if (password.equals(rePassword)) {
                        System.out.println("Passwords match");
                        equalPass = true;
                    } else {
                        System.out.println("Passwords do not match, try again");
                        rePassword = input.next();
                    }
                }
                Control.members.get(Control.userInput).setPassword(pass.encrypt(password));
                break;
            case 7:
                //Cancel
                System.out.println("Returning to menu");
                break;
            default:
                System.out.println("Invalid number entered. Please enter a number between 1 and 7");
        }
    }

    private void processCasual(int num) {
        switch (num) {
            case 1:
                //Edit first name
                System.out.println("Edit first name");
                System.out.println("Please enter your first name");
                firstName = input.next();
                firstName = val.singleWordValidate(firstName);
                Control.users.get(Control.userInput).setFirstName(firstName);
                break;
            case 2:
                //Edit last name
                System.out.println("Edit last name");
                System.out.println("Please enter your last name");
                lastName = input.next();
                lastName = val.singleWordValidate(lastName);
                Control.users.get(Control.userInput).setLastName(lastName);
                break;
            case 3:
                //Edit email
                System.out.println("Edit email");
                System.out.println("Please enter your email");
                email = input.next();
                Control.users.get(Control.userInput).setEmail(email);
                break;
            case 4:
                //Edit password
                System.out.println("Edit password");
                System.out.println("Please enter your password");
                password = input.next();
                password = val.passValidate(password);
                while (!equalPass) {
                    System.out.println("Please confirm desired password");
                    rePassword = input.next();
                    if (password.equals(rePassword)) {
                        System.out.println("Passwords match");
                        equalPass = true;
                    } else {
                        System.out.println("Passwords do not match, try again");
                        rePassword = input.next();
                    }
                }
                Control.users.get(Control.userInput).setPassword(pass.encrypt(password));
                break;
            case 5:
                //Cancel
                System.out.println("Returning to menu");
                break;
            default:
                System.out.println("Invalid number entered. Please enter a number between 1 and 7");
        }
    }
}
