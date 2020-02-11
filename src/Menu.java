// Menu class
// Created by Mark McAllister
// Last update 10/02/2020
import java.util.*;

public class Menu {
    private static Scanner input = new Scanner(System.in); //Setup user input
    private static String userInput;
    public static String userName;
    private static Validators val = new Validators();
    private static Serialize ser = new Serialize();
    private static Register reg = new Register();
    private static EditItem editItem = new EditItem();
    private static EditUser editUser = new EditUser();
    private static Loan newLoan = new Loan();
    private static Catalogue cat = new Catalogue();

    public void welcomeMenu(){
        //welcome menu giving option to login, register or cancel depending on input choice
        int selection = 0;
        while (selection != 3) {
            System.out.printf("%1s %n %1s %n %1s %n %1s %n %1s %n %1s %n ",
                    "Welcome to the library. Please enter a number to select what you wish to do from the menu.",
                    "",
                    "1: Login",
                    "2: Register",
                    "3: Cancel",
                    "");

            userInput = input.nextLine();
            selection = val.menuValidate(userInput);

            if (selection != 3) {
                processWelcome(selection);
            }
        }
    }

    private static void processWelcome(int num){
        switch (num){
            case 1:
                //if user selects 1 to login
                int attempts = 0;

                String password;
                PassEncrypt p1 = new PassEncrypt();
                while (attempts < 3){
                    System.out.println("Please enter your username");
                    userName = input.nextLine();
                    val.singleWordValidate(userName);
                    if (Control.admins.containsKey(userName)){
                        //validate admin login
                        System.out.println("Please enter your password");
                        password = input.nextLine();
                        val.singleWordValidate(password);
                        if (Control.admins.get(userName).getPassword().equals(p1.encrypt(password))){
                            adminMenu();
                        }
                        else{
                            System.out.println("Invalid password entered");
                            attempts += 1;
                        }
                    }
                    else if (Control.vipmembers.containsKey(userName)){
                        //validate vipMember login
                        System.out.println("Please enter your password");
                        password = input.nextLine();
                        val.singleWordValidate(password);
                        if (Control.vipmembers.get(userName).getPassword().equals(p1.encrypt(password))){
                            vipMemberMenu();
                        }
                        else{
                            System.out.println("Invalid password entered");
                            attempts += 1;
                        }
                    }

                    else if (Control.members.containsKey(userName)){
                        //validate member login
                        System.out.println("Please enter your password");
                        password = input.nextLine();
                        val.singleWordValidate(password);
                        if (Control.members.get(userName).getPassword().equals(p1.encrypt(password))){
                            memberMenu();
                        }
                        else{
                            System.out.println("Invalid password entered");
                            attempts += 1;
                        }
                    }

                    else if (Control.users.containsKey(userName)){
                        //validate casual user login
                        System.out.println("Please enter your password");
                        password = input.nextLine();
                        val.singleWordValidate(password);
                        if (Control.users.get(userName).getPassword().equals(p1.encrypt(password))){
                            casualMenu();
                        }
                        else{
                            System.out.println("Invalid password entered");
                            attempts += 1;
                        }
                    }
                    else{
                        System.out.println("Invalid username entered.");
                        attempts += 1;
                    }
                }

                System.out.println("Max number of attempts used, returning to start menu.");
                break;
            case 2:
                //menu choice for user to register a new user of their selection
                int selection = 0;
                while (selection != 4) {
                    System.out.printf("%1s %n %1s %n %1s %n %1s %n %1s %n %1s %n %1s %n %1s %n",
                            "",
                            "Please enter the number for the type of user you wish to register",
                            "",
                            "1: Casual user",
                            "2: Member",
                            "3: VIP Member",
                            "4: Cancel",
                            "");

                    userInput = input.nextLine();
                    selection = val.menuValidate(userInput);

                    registerChoice(selection);
                    ser.Serialization();
                }
                break;
            case 3:
                System.out.println("Returning to start menu.");
                break;
            default:
                System.out.println("Invalid number entered, enter a number between 1 and 3");
        }
    }

    private static void adminMenu(){
        //Display admin menu, take number entered and run through adminChoice
        System.out.println("This is the admin menu");
        int selection = 0;
        while (selection != 9) {
            System.out.printf("%1s %n %1s %n %1s %n %1s %n %1s %n %1s %n %1s %n %1s %n %1s %n %1s %n %1s %n %1s %n",
                    "Enter a number between 1 and 9 to select what you wish to do",
                    "",
                    "1: Register new user",
                    "2: Record loan",
                    "3: Record loan return",
                    "4: List all users",
                    "5: List all logins",
                    "6: List all loans",
                    "7: Add new stock item",
                    "8: Edit existing stock item",
                    "9: Cancel",
                    "");

            userInput = input.nextLine();
            selection = val.menuValidate(userInput);

            adminChoice(selection);
            ser.Serialization();
        }

    }

    private static void adminChoice(int num){
        int selection;
        switch(num){
            case 1:
                //Register new user, give choice of type of user to create, do correct user type create
                System.out.println("Create new user menu");
                selection = 0;
                while (selection != 4) {
                    System.out.printf("%1s %n %1s %n %1s %n %1s %n %1s %n %1s %n %1s %n",
                            "Enter a number between 1 and 4 to select what you wish to do",
                            "",
                            "1: Create VIP Member",
                            "2: Create Member",
                            "3: Create Casual User",
                            "4: Cancel",
                            "");

                    userInput = input.nextLine();
                    selection = val.menuValidate(userInput);

                    createUserChoice(selection);
                    ser.Serialization();
                }

                break;
            case 2:
                //Record loan
                newLoan.loanOut();
                break;
            case 3:
                //Record loan return
                newLoan.acceptReturn();
                break;
            case 4:
                //List all users
                System.out.println("VIP Members:");
                for (Map.Entry<String, VIPMember> entry : Control.vipmembers.entrySet()) {
                    System.out.println("Username: "+ entry.getKey() + ". First name: " + entry.getValue().getFirstName() + ". Last name: " + entry.getValue().getLastName());
                }
                System.out.println();
                System.out.println("Members:");
                for (Map.Entry<String, Member> entry : Control.members.entrySet()) {
                    System.out.println("Username: " + entry.getKey() + ". First name: " + entry.getValue().getFirstName() + ". Last name: " + entry.getValue().getLastName());
                }
                System.out.println();
                System.out.println("Casual users:");
                for (Map.Entry<String, User> entry : Control.users.entrySet()) {
                    System.out.println("Username: " + entry.getKey() + ". First name: " + entry.getValue().getFirstName() + ". Last name: " + entry.getValue().getLastName());
                }
                System.out.println();
                break;
            case 5:
                //List all logins
                System.out.println("Logins");
                for (Map.Entry<String, LinkedList<Date>> entry : Control.userlogins.entrySet()) {
                    System.out.println("Username: " + entry.getKey() + ". Login history: " + entry.getValue());
                }
                System.out.println();
                break;
            case 6:
                //List all loans
                System.out.println("Loans");
                for (Map.Entry<String, LinkedList<Integer>> entry : Control.loans.entrySet()) {
                    System.out.println("Username: " + entry.getKey() + ". Loan itemIDs: " + entry.getValue());
                }
                System.out.println();
                break;
            case 7:
                //Add new stock item
                System.out.println("Add new Stock item");
                selection = 0;
                while (selection != 5) {
                    System.out.printf("%1s %n %1s %n %1s %n %1s %n %1s %n %1s %n %1s %n %1s %n",
                            "Enter a number between 1 and 4 to select what you wish to do",
                            "",
                            "1: Add book",
                            "2: Add CD",
                            "3: Add journal",
                            "4: Add video",
                            "5: Cancel",
                            "");

                    userInput = input.nextLine();
                    selection = val.menuValidate(userInput);

                    createItem(selection);
                    ser.Serialization();
                }
                break;
            case 8:
                //Edit item
                System.out.println("Edit Stock item");
                System.out.println("Here are the stock IDs and item names");
                for (Map.Entry<Integer, Book> entry : Control.books.entrySet()) {
                    System.out.println("Book ID: " + entry.getKey() + ". Book title: " + entry.getValue().getTitle());
                }
                System.out.println();
                System.out.println("These are the CDs we have");
                for (Map.Entry<Integer, CD> entry : Control.cds.entrySet()) {
                    System.out.println("CD ID: " + entry.getKey() + ". CD title: " + entry.getValue().getTitle());
                }
                System.out.println();
                System.out.println("These are the journals we have");
                for (Map.Entry<Integer, Journal> entry : Control.journals.entrySet()) {
                    System.out.println("Journal ID: " + entry.getKey() + ". Journal title: " + entry.getValue().getTitle());
                }
                System.out.println();
                System.out.println("These are the videos we have");
                for (Map.Entry<Integer, Video> entry : Control.videos.entrySet()) {
                    System.out.println("Video ID: " + entry.getKey() + ". Video title: " + entry.getValue().getTitle());
                }
                selection = 0;
                while (selection != 5) {
                    System.out.printf("%1s %n %1s %n %1s %n %1s %n %1s %n %1s %n %1s %n %1s %n",
                            "Enter a number between 1 and 4 to select what you wish to do",
                            "",
                            "1: Edit book",
                            "2: Edit CD",
                            "3: Edit journal",
                            "4: Edit video",
                            "5: Cancel",
                            "");

                    userInput = input.nextLine();
                    selection = val.menuValidate(userInput);

                    editAnItem(selection);
                    ser.Serialization();
                }
                break;
            case 9:
                System.out.println("Returning to menu.");
                break;
            default:
                System.out.println("Invalid number entered, enter a number between 1 and 9.");

        }
    }

    private static void vipMemberMenu(){
        //Display VIP member menu, take number entered and run through vipChoice
        Date newDate = new Date();
        Control.userlogins.get(userName).add(newDate);
        System.out.println("This is the vip member menu");
        int selection = 0;
        while (selection != 7) {
            System.out.printf("%1s %n %1s %n %1s %n %1s %n %1s %n %1s %n %1s %n %1s %n %1s %n %1s %n",
                    "Enter a number between 1 and 7 to select what you wish to do",
                    "",
                    "1: Edit account",
                    "2: View login history",
                    "3: View loan history",
                    "4: Reserve stock item",
                    "5: Search catalogue",
                    "6: Return item",
                    "7: Logout",
                    "");

            userInput = input.nextLine();
            selection = val.menuValidate(userInput);

            vipMemberChoice(selection);
            ser.Serialization();
        }

    }

    private static void vipMemberChoice(int num){
        switch(num){
            case 1:
                //Edit account
                System.out.println("Edit account");
                editUser.editVip();
                break;
            case 2:
                //login history
                System.out.println("Login history");
                System.out.println(Control.userlogins.get(userName));
                break;
            case 3:
                //loan history
                System.out.println("Loan history");
                System.out.println(Control.loanhistories.get(userName));
                break;
            case 4:
                //reserve stock item
                System.out.println("Reserve item");
                if (Control.loans.get(userName).size() < 6){
                    newLoan.requestLoan();
                }
                else{
                    System.out.println("You have maxed out the number of items you can loan at one time.");
                }
                break;
            case 5:
                //Search catalogue
                cat.viewItem();
                break;
            case 6:
                //return item
                System.out.println("Return item");
                newLoan.loanReturn();
                break;
            case 7:
                System.out.println("Returning to menu.");
                break;
            default:
                System.out.println("Invalid number entered, enter a number between 1 and 7.");

        }
    }

    private static void memberMenu(){
        //Display member menu, take number entered and run through memberChoice
        Date newDate = new Date();
        Control.userlogins.get(userName).add(newDate);
        System.out.println("This is the member menu");
        int selection = 0;
        while (selection != 7) {
            System.out.printf("%1s %n %1s %n %1s %n %1s %n %1s %n %1s %n %1s %n %1s %n %1s %n %1s %n",
                    "Enter a number between 1 and 7 to select what you wish to do",
                    "",
                    "1: Edit account",
                    "2: View login history",
                    "3: View loan history",
                    "4: Reserve stock item",
                    "5: Search catalogue",
                    "6: Return item",
                    "7: Logout",
                    "");

            userInput = input.nextLine();
            selection = val.menuValidate(userInput);

            memberChoice(selection);
            ser.Serialization();
        }
    }

    private static void memberChoice(int num){
        switch(num){
            case 1:
                //Edit account
                System.out.println("Edit account");
                editUser.editMember();
                break;
            case 2:
                //login history
                System.out.println("Login history");
                System.out.println(Control.userlogins.get(userName));
                break;
            case 3:
                //loan history
                System.out.println("Loan history");
                System.out.println(Control.loanhistories.get(userName));
                break;
            case 4:
                //reserve stock item
                System.out.println("Reserve item");
                if (Control.loans.get(userName).size() < 6){
                    newLoan.requestLoan();
                }
                else{
                    System.out.println("You have maxed out the number of items you can loan at one time.");
                }
                break;
            case 5:
                //Search catalogue
                cat.viewItem();
                break;
            case 6:
                //return item
                System.out.println("Return item");
                newLoan.loanReturn();
                break;
            case 7:
                System.out.println("Returning to menu.");
                break;
            default:
                System.out.println("Invalid number entered, enter a number between 1 and 7.");

        }
    }

    private static void casualMenu(){
        //Display casual menu, take number entered and run through casualChoice
        Date newDate = new Date();
        Control.userlogins.get(userName).add(newDate);
        System.out.println("This is the casual user1 menu");
        int selection = 0;
        while (selection != 4) {
            System.out.printf("%1s %n %1s %n %1s %n %1s %n %1s %n %1s %n %1s %n",
                    "Enter a number between 1 and 4 to select what you wish to do",
                    "",
                    "1: Edit account",
                    "2: View login history",
                    "3: Search catalogue",
                    "4: Cancel",
                    "");

            userInput = input.nextLine();
            selection = val.menuValidate(userInput);

            casualChoice(selection);
            ser.Serialization();
        }

    }

    private static void casualChoice(int num){
        switch(num){
            case 1:
                //Edit account
                System.out.println("Edit account");
                editUser.editCasual();
                break;
            case 2:
                //login history
                System.out.println("Login history");
                System.out.println(Control.userlogins.get(userName));
                break;
            case 3:
                //Search catalogue
                cat.viewItem();
                break;
            case 4:
                System.out.println("Returning to menu.");
                break;
            default:
                System.out.println("Invalid number entered, enter a number between 1 and 4.");

        }
    }


    private static void registerChoice(int num){
        switch (num){
            case 1:
                reg.casualRegister();
                ser.Serialization();
                break;
            case 2:
                reg.memberRegister();
                ser.Serialization();
                break;
            case 3:
                reg.vipRegister();
                ser.Serialization();
                break;
            case 4:
                System.out.println("Returning to menu.");
                break;
            default:
                System.out.println("Invalid number entered, enter a number between 1 and 4.");


        }

    }

    private static void createUserChoice(int num){
        switch(num){
            case 1:
                //Create VIP member
                editUser.addVip();
                break;
            case 2:
                //Create member
                editUser.addMember();
                break;
            case 3:
                //Create casual user
                editUser.addCasual();
                break;
            case 4:
                System.out.println("Returning to admin menu.");
                break;
            default:
                System.out.println("Invalid number entered, enter a number between 1 and 4.");
        }
    }

    private static void createItem(int num){
        switch (num){
            case 1:
                //Create new book
                editItem.addBook();
                break;
            case 2:
                //Create new cd
                editItem.addCD();
                break;
            case 3:
                //Create new journal
                editItem.addJournal();
                break;
            case 4:
                //Create new video
                editItem.addVideo();
                break;
            case 5:
                System.out.println("Returning to admin menu");
                break;
            default:
                System.out.println("Invalid number entered, enter a number between 1 and 5.");
        }
    }

    private static void editAnItem(int num){
        switch (num){
            case 1:
                //edit book
                editItem.editBook();
                break;
            case 2:
                //edit cd
                editItem.editCD();
                break;
            case 3:
                //edit journal
                editItem.editJournal();
                break;
            case 4:
                //edit video
                editItem.editVideo();
                break;
            case 5:
                System.out.println("Returning to admin menu");
                break;
            default:
                System.out.println("Invalid number entered, enter a number between 1 and 5.");
        }
    }
}
