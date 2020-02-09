import java.io.Serializable;
import java.util.*;

import static java.lang.Integer.parseInt;

public class Catalogue {
    private static Scanner input = new Scanner(System.in); //Setup user input
    private static Validators val = new Validators();
    private static Serialize ser = new Serialize();


    public void viewItem(){

        System.out.println("View item menu");
        System.out.println("These are the books we have");
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

        searchItem();
    }

    private void searchItem(){
        String choice;
        int selection = 0;

        System.out.println("View details on item");
        while (selection != 5) {
            System.out.printf("%1s %n %1s %n %1s %n %1s %n %1s %n %1s %n %1s %n %1s %n %1s %n",
                    "",
                    "Please enter the number for the type of item you wish to view information of",
                    "",
                    "1: Book",
                    "2: CD",
                    "3: Journal",
                    "4: Video",
                    "5: Cancel",
                    "");

            choice = input.next();
            selection = val.menuValidate(choice);

            processItem(selection);
            ser.Serialization();
        }

    }

    private void processItem(int num){
        boolean found;
        switch(num){
            case 1:
                //View book info
                String bookInput;

                found = false;
                System.out.println("View book info");
                System.out.println("Please enter the item ID or title to view information of the book");
                input.nextLine();
                bookInput = input.nextLine();
                while (!found) {
                    for (Map.Entry<Integer, Book> entry : Control.books.entrySet()) {
                        if (bookInput.equals(entry.getValue().getTitle()) || bookInput.equals(entry.getKey().toString())) {
                            System.out.println("Title: " + entry.getValue().getTitle());
                            System.out.println("Item ID: " + entry.getValue().getStockID());
                            System.out.println("Author: " + entry.getValue().getAuthor());
                            System.out.println("Publisher: " + entry.getValue().getPublisher());
                            System.out.println("Subject: " + entry.getValue().getSubjectArea());
                            System.out.println("Number of pages: " + entry.getValue().getNumPages());
                            System.out.println("Cost: " + entry.getValue().getCost());
                            System.out.println("ISBN: " + entry.getValue().getIsbn());
                            System.out.println("Available: " + entry.getValue().isAvailable());
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
                //View CD info
                String cdInput;
                found = false;
                System.out.println("View CD info");
                System.out.println("Please enter the item ID or title to view information of the CD");
                input.nextLine();
                cdInput = input.nextLine();
                while (!found) {
                    for (Map.Entry<Integer, CD> entry : Control.cds.entrySet()) {
                        if (cdInput.equals(entry.getValue().getTitle()) || cdInput.equals(entry.getKey().toString())) {
                            System.out.println("Title: " + entry.getValue().getTitle());
                            System.out.println("Item ID: " + entry.getValue().getStockID());
                            System.out.println("Artist: " + entry.getValue().getArtist());
                            System.out.println("Publisher: " + entry.getValue().getPublisher());
                            System.out.println("Number of tracks: " + entry.getValue().getNumTracks());
                            System.out.println("Runtime: " + entry.getValue().getRunTime());
                            System.out.println("Case type: " + entry.getValue().getCaseType());
                            System.out.println("Cost: " + entry.getValue().getCost());
                            System.out.println("CD type: " + entry.getValue().getCdType());
                            System.out.println("Available: " + entry.getValue().isAvailable());
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
                //View journal info
                String journalInput;
                found = false;
                System.out.println("View journal info");
                System.out.println("Please enter the item ID or title to view information of the journal");
                input.nextLine();
                journalInput = input.nextLine();
                while (!found) {
                    for (Map.Entry<Integer, Journal> entry : Control.journals.entrySet()) {
                        if (journalInput.equals(entry.getValue().getTitle()) || journalInput.equals(entry.getKey().toString())) {
                            System.out.println("Title: " + entry.getValue().getTitle());
                            System.out.println("Item ID: " + entry.getValue().getStockID());
                            System.out.println("Issue number: " + entry.getValue().getIssueNo());
                            System.out.println("Publisher: " + entry.getValue().getPublisher());
                            System.out.println("Number of pages: " + entry.getValue().getNumPages());
                            System.out.println("Subject area: " + entry.getValue().getSubjectArea());
                            System.out.println("Issue date: " + entry.getValue().getIssueDate());
                            System.out.println("Cost: " + entry.getValue().getCost());
                            System.out.println("ISSN: " + entry.getValue().getIssn());
                            System.out.println("Available: " + entry.getValue().isAvailable());
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
                //View video info
                String videoInput;
                found = false;
                System.out.println("View video info");
                System.out.println("Please enter the item ID or title to view information of the video");
                input.nextLine();
                videoInput = input.nextLine();
                while (!found) {
                    for (Map.Entry<Integer, Video> entry : Control.videos.entrySet()) {
                        if (videoInput.equals(entry.getValue().getTitle()) || videoInput.equals(entry.getKey().toString())) {
                            System.out.println("Title: " + entry.getValue().getTitle());
                            System.out.println("Item ID: " + entry.getValue().getStockID());
                            System.out.println("Run time: " + entry.getValue().getRunTime());
                            System.out.println("Publisher: " + entry.getValue().getPublisher());
                            System.out.println("Video format: " + entry.getValue().getVideoFormat());
                            System.out.println("Genre: " + entry.getValue().getGenre());
                            System.out.println("Cost: " + entry.getValue().getCost());
                            System.out.println("Case type: " + entry.getValue().getCaseType());
                            System.out.println("Available: " + entry.getValue().isAvailable());
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
                System.out.println("Invalid number entered, please enter between 1 and 5");
        }
    }
}
