import java.util.*;

// Loan class
// Created by Mark McAllister
// Last update 11/02/2020

public class Loan {
    //Admin enters the username of the person that is loaning out an item, if vip they have 28 days loan out if member 14 days
    //can only loan items if they have not hit max items loaned out already
    Scanner input = new Scanner(System.in);
    Validators val = new Validators();

    public void loanOut(){
        System.out.println("Loan out");
        String loanUsername;
        String loanStock;
        int loanitemID;



        System.out.println("Record loans");
        System.out.println("Current requests by users");
        System.out.println(Control.loanrequests);
        System.out.println("Current items loaned out");
        System.out.println(Control.loans);
        System.out.println("Please enter the username you would like to accept a loan for");

        loanUsername = input.nextLine();
        loanUsername = val.singleWordValidate(loanUsername);

        if (Control.vipmembers.containsKey(loanUsername) && Control.loans.get(loanUsername).size() < 6) {
            Date returnDate = returnDays(28);
            System.out.println("Please enter the item you wish to loan");
            loanStock = input.nextLine();
            loanitemID = val.menuValidate(loanStock);
            if (Control.loanrequests.get(loanUsername).contains(loanitemID)) {
                Control.loanrequests.get(loanUsername).removeFirstOccurrence(loanitemID);
                Control.loans.get(loanUsername).add(loanitemID);
                Control.loanouts.put(loanitemID, returnDate);
                Control.loanhistories.get(loanUsername).add(loanitemID);
                System.out.println("Item " + loanitemID + " loaned successfully to " + loanUsername);
            }
            else if (Control.books.containsKey(loanitemID)) {
                if (Control.books.get(loanitemID).isAvailable()) {
                    Control.loans.get(loanUsername).add(loanitemID);
                    Control.loanouts.put(loanitemID, returnDate);
                    Control.loanhistories.get(loanUsername).add(loanitemID);
                    Control.books.get(loanitemID).setAvailable(false);
                    System.out.println("Item " + loanitemID + " loaned successfully to " + loanUsername);
                }
                else {
                    System.out.println("Item unavailable");
                }
            }
            else if (Control.cds.containsKey(loanitemID)) {
                if (Control.cds.get(loanitemID).isAvailable()) {
                    Control.loans.get(loanUsername).add(loanitemID);
                    Control.loanouts.put(loanitemID, returnDate);
                    Control.loanhistories.get(loanUsername).add(loanitemID);
                    Control.cds.get(loanitemID).setAvailable(false);
                    System.out.println("Item " + loanitemID + " loaned successfully to " + loanUsername);
                }
                else{
                    System.out.println("Item unavailable");
                }
            }
            else if (Control.journals.containsKey(loanitemID)) {
                if (Control.journals.get(loanitemID).isAvailable()) {
                    Control.loans.get(loanUsername).add(loanitemID);
                    Control.loanouts.put(loanitemID, returnDate);
                    Control.loanhistories.get(loanUsername).add(loanitemID);
                    Control.journals.get(loanitemID).setAvailable(false);
                    System.out.println("Item " + loanitemID + " loaned successfully to " + loanUsername);
                }
                else{
                    System.out.println("Item unavailable");
                }
            }
            else if (Control.videos.containsKey(loanitemID)) {
                if (Control.videos.get(loanitemID).isAvailable()) {
                    Control.loans.get(loanUsername).add(loanitemID);
                    Control.loanouts.put(loanitemID, returnDate);
                    Control.loanhistories.get(loanUsername).add(loanitemID);
                    Control.videos.get(loanitemID).setAvailable(false);
                    System.out.println("Item " + loanitemID + " loaned successfully to " + loanUsername);

                }
                else{
                    System.out.println("Item unavailable");
                }
            }
            else {
                System.out.println("Invalid itemID entered");
            }
        }
        else if (Control.members.containsKey(loanUsername) && Control.loans.get(loanUsername).size() < 4){
            Date returnDate = returnDays(14);
            System.out.println("Please enter the item you wish to loan");
            loanStock = input.nextLine();
            loanitemID = val.menuValidate(loanStock);
            if (Control.loanrequests.get(loanUsername).contains(loanitemID)) {
                Control.loanrequests.get(loanUsername).removeFirstOccurrence(loanitemID);
                Control.loans.get(loanUsername).add(loanitemID);
                Control.loanouts.put(loanitemID, returnDate);
                Control.loanhistories.get(loanUsername).add(loanitemID);
                System.out.println("Item " + loanitemID + " loaned successfully to " + loanUsername);
            }
            else if (Control.books.containsKey(loanitemID)) {
                if (Control.books.get(loanitemID).isAvailable()) {
                    Control.loans.get(loanUsername).add(loanitemID);
                    Control.loanouts.put(loanitemID, returnDate);
                    Control.loanhistories.get(loanUsername).add(loanitemID);
                    Control.books.get(loanitemID).setAvailable(false);
                    System.out.println("Item " + loanitemID + " loaned successfully to " + loanUsername);
                }
                else {
                    System.out.println("Item unavailable");
                }
            }
            else if (Control.cds.containsKey(loanitemID)) {
                if (Control.cds.get(loanitemID).isAvailable()) {
                    Control.loans.get(loanUsername).add(loanitemID);
                    Control.loanouts.put(loanitemID, returnDate);
                    Control.loanhistories.get(loanUsername).add(loanitemID);
                    Control.cds.get(loanitemID).setAvailable(false);
                    System.out.println("Item " + loanitemID + " loaned successfully to " + loanUsername);
                }
                else{
                    System.out.println("Item unavailable");
                }
            }
            else if (Control.journals.containsKey(loanitemID)) {
                if (Control.journals.get(loanitemID).isAvailable()) {
                    Control.loans.get(loanUsername).add(loanitemID);
                    Control.loanouts.put(loanitemID, returnDate);
                    Control.loanhistories.get(loanUsername).add(loanitemID);
                    Control.journals.get(loanitemID).setAvailable(false);
                    System.out.println("Item " + loanitemID + " loaned successfully to " + loanUsername);
                }
                else{
                    System.out.println("Item unavailable");
                }
            }
            else if (Control.videos.containsKey(loanitemID)) {
                if (Control.videos.get(loanitemID).isAvailable()) {
                    Control.loans.get(loanUsername).add(loanitemID);
                    Control.loanouts.put(loanitemID, returnDate);
                    Control.loanhistories.get(loanUsername).add(loanitemID);
                    Control.videos.get(loanitemID).setAvailable(false);
                    System.out.println("Item " + loanitemID + " loaned successfully to " + loanUsername);

                }
                else{
                    System.out.println("Item unavailable");
                }
            }
            else {
                System.out.println("Invalid itemID entered");
            }
        }
        else {
            System.out.println("Invalid data entered");
        }
    }

    public void loanReturn(){
        //user enters the item id of item loaned out and it removes from loans and adds to loanreturns with current date and time.
        String item;
        int itemID;
        Date returnDate = new Date();
        System.out.println("Loan return");
        System.out.println("Theses are the items you have loaned out: ");
        System.out.println(Control.loans.get(Menu.userName));
        System.out.println();
        System.out.println("Please enter the item ID for the item you wish to return.");
        item = input.nextLine();
        itemID = val.menuValidate(item);
        if (Control.loans.get(Menu.userName).contains(itemID)){
            Control.loanreturns.put(itemID, returnDate);
            Control.loans.get(Menu.userName).removeFirstOccurrence(itemID);
            System.out.println("Item returned successfully.");
        }
        else{
            System.out.println("Invalid item entered.");
        }
    }

    public void acceptReturn(){
        //Checks if item in loanreturns, calculates if late fee is needed and removes from loanreturns and loans
        //Sets item back to available
        String item;
        int itemID;
        System.out.println("Accept return");
        System.out.println("These are the items being returned");
        System.out.println(Control.loanreturns.keySet());
        System.out.println();
        System.out.println("Enter the ID for the item you wish to accept the return of");
        item = input.nextLine();
        itemID = val.menuValidate(item);
        if (Control.loanreturns.containsKey(itemID)){
            long lateDays = ((Control.loanreturns.get(itemID).getTime() - (Control.loanouts.get(itemID).getTime()))  / (1000*60*60*24));
            if (lateDays > 0){
                double lateFee = 0.5 * lateDays;
                System.out.println("Item should have been returned on: " + Control.loanouts.get(itemID) + ". Item was returned on: " + Control.loanreturns.get(itemID));
                System.out.println("Item is " + lateDays + " late and latefee is £" + lateFee);
            }
            else {
                System.out.println("Item returned on time");
            }
            Control.loanreturns.remove(itemID);
            if (Control.books.containsKey(itemID)) {
                Control.books.get(itemID).setAvailable(true);
            }
            else if (Control.cds.containsKey(itemID)) {
                Control.cds.get(itemID).setAvailable(true);
            }
            else if (Control.journals.containsKey(itemID)) {
                Control.journals.get(itemID).setAvailable(true);
            }
            else if (Control.videos.containsKey(itemID)) {
                Control.videos.get(itemID).setAvailable(true);
            }


            for (Map.Entry<String, LinkedList<Integer>> entry : Control.loans.entrySet()) {
                if (entry.getValue().contains(itemID)) {
                    entry.getValue().removeFirstOccurrence(itemID);
                }
            }
        }
        else {
            System.out.println("Invalid item entered");
        }

    }

    public void requestLoan(int num){
        //request loan where user enters the title or item id of the type of item they wish to loan out
        boolean found = false;
        System.out.println("Request loan");

        switch (num){
            case 1:
                //request book loan
                System.out.println("These are our available books");
                for (Map.Entry<Integer, Book> entry : Control.books.entrySet()) {
                    if (entry.getValue().isAvailable()) {
                        System.out.println("Book ID: " + entry.getKey() + ". Book title: " + entry.getValue().getTitle());
                    }
                }
                System.out.println("Please enter the item ID or title of the book you wish to loan out");
                String bookInput = input.nextLine();
                while (!found) {
                    for (Map.Entry<Integer, Book> entry : Control.books.entrySet()) {
                        if ((bookInput.equals(entry.getValue().getTitle()) || bookInput.equals(entry.getKey().toString())) && entry.getValue().isAvailable()) {
                            Control.loanrequests.get(Menu.userName).add(entry.getKey());
                            entry.getValue().setAvailable(false);
                            found = true;
                        }
                    }
                    if (!found) {
                        System.out.println("Invalid item name or ID number");
                        found = true;
                    }

                }
                break;
            case 2:
                //request cd loan
                System.out.println("These are our available CDs");
                for (Map.Entry<Integer, CD> entry : Control.cds.entrySet()) {
                    if (entry.getValue().isAvailable()) {
                        System.out.println("CD ID: " + entry.getKey() + ". CD title: " + entry.getValue().getTitle());
                    }
                }
                System.out.println("Please enter the item ID or title of the cd you wish to loan out");
                String cdInput = input.nextLine();
                while (!found) {
                    for (Map.Entry<Integer, CD> entry : Control.cds.entrySet()) {
                        if ((cdInput.equals(entry.getValue().getTitle()) || cdInput.equals(entry.getKey().toString())) && entry.getValue().isAvailable()) {
                            Control.loanrequests.get(Menu.userName).add(entry.getKey());
                            entry.getValue().setAvailable(false);
                            System.out.println("Item request accepted");
                            found = true;
                        }
                    }
                    if (!found) {
                        System.out.println("Invalid item name or ID number");
                        found = true;
                    }

                }
                break;
            case 3:
                //request journal loan
                System.out.println("These are our available journals");
                for (Map.Entry<Integer, Journal> entry : Control.journals.entrySet()) {
                    if (entry.getValue().isAvailable()) {
                        System.out.println("Journal ID: " + entry.getKey() + ". Journal title: " + entry.getValue().getTitle());
                    }
                }
                System.out.println("Please enter the item ID or title of the journal you wish to loan out");
                String journalInput = input.nextLine();
                found = false;
                while (!found) {
                    for (Map.Entry<Integer, Journal> entry : Control.journals.entrySet()) {
                        if ((journalInput.equals(entry.getValue().getTitle()) || journalInput.equals(entry.getKey().toString())) && entry.getValue().isAvailable()) {
                            Control.loanrequests.get(Menu.userName).add(entry.getKey());
                            entry.getValue().setAvailable(false);
                            System.out.println("Item request accepted");
                            found = true;
                        }
                    }
                    if (!found) {
                        System.out.println("Invalid item name or ID number");
                        found = true;
                    }

                }
                break;
            case 4:
                //request video loan
                System.out.println("These are our available videos");
                for (Map.Entry<Integer, Video> entry : Control.videos.entrySet()) {
                    if (entry.getValue().isAvailable()) {
                        System.out.println("Video ID: " + entry.getKey() + ". Video title: " + entry.getValue().getTitle());
                    }
                }
                System.out.println("Please enter the item ID or title of the video you wish to loan out");
                String videoInput = input.nextLine();
                found = false;
                while (!found) {
                    for (Map.Entry<Integer, Video> entry : Control.videos.entrySet()) {
                        if ((videoInput.equals(entry.getValue().getTitle()) || videoInput.equals(entry.getKey().toString())) && entry.getValue().isAvailable()) {
                            Control.loanrequests.get(Menu.userName).add(entry.getKey());
                            entry.getValue().setAvailable(false);
                            System.out.println("Item request accepted");
                            found = true;
                        }
                    }
                    if (!found) {
                        System.out.println("Invalid item name or ID number");
                        found = true;
                    }

                }
                break;
            case 5:
                System.out.println("Returning to previous menu");
                break;
            default:
                System.out.println("Invalid number entered, please enter a number between 1 and 5");
        }
    }

    private Date returnDays(int days){
        //Method to get date item should be returned
        Date currentDate = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(currentDate);
        calendar.add(Calendar.DAY_OF_YEAR, days);

        return calendar.getTime();
    }
}
