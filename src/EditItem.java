// Edit item class
// Created by Mark McAllister
// Last update 10/02/2020
import java.util.Map;
import java.util.Scanner;

public class EditItem {
    Scanner input = new Scanner(System.in);
    private static int stockID;
    private static String title;
    private static String costPrice;
    private static double price;
    private static String publisher;
    private static boolean available = true;
    private static String isbn;
    private static String author;
    private static String subjectArea;
    private static String pageNo;
    private static int pages;
    private static String runtime;
    private static String cdType;
    private static String tracks;
    private static int numTracks;
    private static String artist;
    private static String caseType;
    private static String issue;
    private static int issueNo;
    private static String issueDate;
    private static String format;
    private static String genre;
    private static String choice;

    Validators val = new Validators();

    public void addBook(){

        System.out.println("Add book");
        System.out.println("Please enter the title of the book");
        title = input.nextLine();
        title = val.multiWordValidate(title);
        System.out.println("Please enter the price in £");
        costPrice = input.nextLine();
        price = val.doubleValidate(costPrice);
        System.out.println("Please enter the publisher");
        publisher = input.nextLine();
        val.singleWordValidate(publisher);
        System.out.println("Please enter the ISBN");
        isbn = input.nextLine();
        System.out.println("Please enter the author");
        author = input.nextLine();
        author = val.multiWordValidate(author);
        System.out.println("Please enter the subject area");
        subjectArea = input.nextLine();
        subjectArea = val.multiWordValidate(subjectArea);
        System.out.println("Please enter the number of pages");
        pageNo = input.nextLine();
        pages = val.menuValidate(pageNo);
        stockID = 1000 + Control.books.size() + Control.cds.size() + Control.journals.size() + Control.videos.size() + 1;

        Book newBook = new Book(stockID, title, price, publisher, available, isbn, author, subjectArea, pages);

        Control.books.put(newBook.getStockID(), newBook);
        System.out.println("Book: " + title + " added to system");

    }

    public void addCD(){
        System.out.println("Add cd");
        System.out.println("Please enter the title of the cd");
        title = input.nextLine();
        title = val.multiWordValidate(title);
        System.out.println("Please enter the price in £");
        costPrice = input.nextLine();
        price = val.doubleValidate(costPrice);
        System.out.println("Please enter the publisher");
        publisher = input.nextLine();
        val.singleWordValidate(publisher);
        System.out.println("Please enter the runtime HH:mm:ss");
        runtime = input.nextLine();
        runtime = val.runtimeValidate(runtime);
        System.out.println("Please enter the CD type");
        cdType = input.nextLine();
        cdType = val.singleWordValidate(cdType);
        System.out.println("Please enter the number of tracks");
        tracks = input.nextLine();
        numTracks = val.menuValidate(tracks);
        System.out.println("Please enter the artist");
        artist = input.nextLine();
        artist = val.multiWordValidate(artist);
        System.out.println("Please enter the case type");
        caseType = input.nextLine();
        val.singleWordValidate(caseType);
        stockID = 1000 + Control.books.size() + Control.cds.size() + Control.journals.size() + Control.videos.size() + 1;

        CD newCD = new CD(stockID, title, price, publisher, available, runtime, cdType, numTracks, artist, caseType);

        Control.cds.put(newCD.getStockID(), newCD);
        System.out.println("CD: " + title + " added to system");
    }

    public void addJournal(){


        System.out.println("Add journal");
        System.out.println("Please enter the title of the journal");
        title = input.nextLine();
        title = val.multiWordValidate(title);
        System.out.println("Please enter the price in £");
        costPrice = input.nextLine();
        price = val.doubleValidate(costPrice);
        System.out.println("Please enter the publisher");
        publisher = input.nextLine();
        val.singleWordValidate(publisher);
        System.out.println("Please enter the ISSN");
        isbn = input.nextLine();
        System.out.println("Please enter the issue number");
        issue = input.nextLine();
        issueNo = val.menuValidate(issue);
        System.out.println("Please enter the issue date ddmmyyyy");
        issueDate = input.nextLine();
        issueDate = val.dateValidate(issueDate);
        System.out.println("Please enter the subject area");
        subjectArea = input.nextLine();
        subjectArea = val.multiWordValidate(subjectArea);
        System.out.println("Please enter the number of pages");
        pageNo = input.nextLine();
        pages = val.menuValidate(pageNo);
        stockID = 1000 + Control.books.size() + Control.cds.size() + Control.journals.size() + Control.videos.size() + 1;

        Journal newJournal = new Journal(stockID, title, price, publisher, available, isbn, issueNo, issueDate, subjectArea, pages);

        Control.journals.put(newJournal.getStockID(), newJournal);
        System.out.println("Journal: " + title + " added to system");
    }

    public void addVideo(){
        System.out.println("Add video");
        System.out.println("Please enter the title of the video");
        title = input.nextLine();
        title = val.multiWordValidate(title);
        System.out.println("Please enter the price in £");
        costPrice = input.nextLine();
        price = val.doubleValidate(costPrice);
        System.out.println("Please enter the publisher");
        publisher = input.nextLine();
        val.singleWordValidate(publisher);
        System.out.println("Please enter the runtime HH:mm:ss");
        runtime = input.nextLine();
        runtime = val.runtimeValidate(runtime);
        System.out.println("Please enter the video format");
        format = input.nextLine();
        format = val.singleWordValidate(format);
        System.out.println("Please enter the genre");
        genre = input.nextLine();
        genre = val.multiWordValidate(genre);
        System.out.println("Please enter the case type");
        caseType = input.nextLine();
        val.singleWordValidate(caseType);
        stockID = 1000 + Control.books.size() + Control.cds.size() + Control.journals.size() + Control.videos.size() + 1;

        Video newVideo = new Video(stockID, title, price, publisher, available, runtime, format, genre, caseType);

        Control.videos.put(newVideo.getStockID(), newVideo);
        System.out.println("Video: " + title + " added to system");
    }

    public void editBook(){
        //Menu for edit book
        System.out.println("Edit book");
        int selection = 0;
        System.out.println("Enter book title or stock ID");
        boolean found = false;
        String bookInput = input.nextLine();
        while(!found) {
            for (Map.Entry<Integer, Book> entry : Control.books.entrySet()) {
                if (bookInput.equals(entry.getValue().getTitle()) || bookInput.equals(entry.getKey().toString())) {
                    while (selection != 8) {
                        System.out.println("Please enter a number to select what you wish to edit");
                        System.out.printf("%1s %n %1s %n %1s %n %1s %n %1s %n %1s %n %1s %n %1s %n %1s %n %1s %n",
                                "",
                                "1: Edit title",
                                "2: Edit price",
                                "3: Edit publisher",
                                "4: Edit isbn",
                                "5: Edit author",
                                "6: Edit subject area",
                                "7: Edit page number",
                                "8: Cancel",
                                "");
                        choice = input.nextLine();
                        selection = val.menuValidate(choice);
                        processBook(selection, entry.getKey());
                        found = true;
                    }
                }
            }
            if (!found) {
                System.out.println("Invalid item name or ID number");
                found = true;
            }
        }
    }

    public void editCD(){
        //Menu for edit cd
        System.out.println("Edit cd");
        int selection = 0;
        boolean found = false;
        System.out.println("Enter CD title or stock ID");
        String cdInput = input.nextLine();
        while (!found) {
            for (Map.Entry<Integer, CD> entry : Control.cds.entrySet()) {
                if (cdInput.equals(entry.getValue().getTitle()) || cdInput.equals(entry.getKey().toString())) {
                    while (selection != 9) {
                        System.out.println("Please enter a number to select what you wish to edit");
                        System.out.printf("%1s %n %1s %n %1s %n %1s %n %1s %n %1s %n %1s %n %1s %n %1s %n %1s %n %1s %n",
                                "",
                                "1: Edit title",
                                "2: Edit price",
                                "3: Edit publisher",
                                "4: Edit runtime",
                                "5: Edit cd type",
                                "6: Edit number of tracks",
                                "7: Edit artist",
                                "8: Edit case type",
                                "9: Cancel",
                                "");
                        choice = input.nextLine();
                        selection = val.menuValidate(choice);
                        processCD(selection, entry.getKey());
                        found = true;
                    }
                }
            }
            if (!found) {
                System.out.println("Invalid item name or ID number");
                found = true;
            }
        }
    }

    public void editJournal(){
        //Menu for edit journal
        System.out.println("Edit journal");
        int selection = 0;
        boolean found = false;
        System.out.println("Enter journal title or stock ID");
        String journalInput = input.nextLine();
        while (!found) {
            for (Map.Entry<Integer, Journal> entry : Control.journals.entrySet()) {
                if (journalInput.equals(entry.getValue().getTitle()) || journalInput.equals(entry.getKey().toString())) {
                    while (selection != 9) {
                        System.out.println("Please enter a number to select what you wish to edit");
                        System.out.printf("%1s %n %1s %n %1s %n %1s %n %1s %n %1s %n %1s %n %1s %n %1s %n %1s %n %1s %n",
                                "",
                                "1: Edit title",
                                "2: Edit price",
                                "3: Edit publisher",
                                "4: Edit issn",
                                "5: Edit issue number",
                                "6: Edit issue date",
                                "7: Edit subject area",
                                "8: Edit number of pages",
                                "9: Cancel",
                                "");
                        choice = input.nextLine();
                        selection = val.menuValidate(choice);
                        processJournal(selection, entry.getKey());
                        found = true;
                    }
                }
            }
            if (!found) {
                System.out.println("Invalid item name or ID number");
                found = true;
            }
        }
    }

    public void editVideo(){
        //Menu for edit video
        System.out.println("Edit video");
        int selection = 0;
        boolean found = false;
        System.out.println("Enter CD title or stock ID");
        String videoInput = input.nextLine();
        while (!found) {
            for (Map.Entry<Integer, Video> entry : Control.videos.entrySet()) {
                if (videoInput.equals(entry.getValue().getTitle()) || videoInput.equals(entry.getKey().toString())) {
                    while (selection != 8) {
                        System.out.println("Please enter a number to select what you wish to edit");
                        System.out.printf("%1s %n %1s %n %1s %n %1s %n %1s %n %1s %n %1s %n %1s %n %1s %n %1s %n",
                                "",
                                "1: Edit title",
                                "2: Edit price",
                                "3: Edit publisher",
                                "4: Edit runtime",
                                "5: Edit format",
                                "6: Edit genre",
                                "7: Edit case type",
                                "8: Cancel",
                                "");
                        choice = input.nextLine();
                        selection = val.menuValidate(choice);
                        processVideo(selection, entry.getKey());
                        found = true;
                    }
                }
            }
            if (!found){
                System.out.println("Invalid item name or ID number");
                found = true;
            }
        }
    }

    private void processBook(int num, int id){
        switch(num){
            case 1:
                //edit title
                System.out.println("Please enter the new title");
                title = input.nextLine();
                title = val.multiWordValidate(title);
                Control.books.get(id).setTitle(title);
                break;
            case 2:
                //edit price
                System.out.println("Please enter the new price");
                costPrice = input.nextLine();
                price = val.doubleValidate(costPrice);
                Control.books.get(id).setCost(price);
                break;
            case 3:
                //edit publisher
                System.out.println("Please enter the new publisher");
                publisher = input.nextLine();
                publisher = val.singleWordValidate(publisher);
                Control.books.get(id).setPublisher(publisher);
                break;
            case 4:
                //edit isbn
                System.out.println("Please enter the new ISBN");
                isbn = input.nextLine();
                isbn = val.singleWordValidate(isbn);
                Control.books.get(id).setIsbn(isbn);
                break;
            case 5:
                //edit author
                System.out.println("Please enter the new author");
                author = input.nextLine();
                author = val.multiWordValidate(author);
                Control.books.get(id).setAuthor(author);
                break;
            case 6:
                //edit subject area
                System.out.println("Please enter the new subject area");
                subjectArea = input.nextLine();
                subjectArea = val.multiWordValidate(subjectArea);
                Control.books.get(id).setSubjectArea(subjectArea);
                break;
            case 7:
                //edit number of pages
                System.out.println("Please enter the new number of pages");
                pageNo = input.nextLine();
                pages = val.menuValidate(pageNo);
                Control.books.get(id).setNumPages(pages);
                break;
            case 8:
                System.out.println("Returning to previous menu");
                break;
            default:
                System.out.println("Invalid number entered, please enter a number between 1 and 8");
        }
    }

    private void processCD(int num, int id){
        switch(num){
            case 1:
                //edit title
                System.out.println("Please enter the new title");
                title = input.nextLine();
                title = val.multiWordValidate(title);
                Control.journals.get(id).setTitle(title);
                break;
            case 2:
                //edit price
                System.out.println("Please enter the new price");
                costPrice = input.nextLine();
                price = val.doubleValidate(costPrice);
                Control.journals.get(id).setCost(price);
                break;
            case 3:
                //edit publisher
                System.out.println("Please enter the new publisher");
                publisher = input.nextLine();
                publisher = val.singleWordValidate(publisher);
                Control.journals.get(id).setPublisher(publisher);
                break;
            case 4:
                //edit runtime
                System.out.println("Please enter the new runtime");
                runtime = input.nextLine();
                runtime = val.runtimeValidate(runtime);
                Control.cds.get(id).setRunTime(runtime);
                break;
            case 5:
                //edit cd type
                System.out.println("Please enter the new cd type");
                cdType = input.nextLine();
                cdType = val.singleWordValidate(cdType);
                Control.cds.get(id).setCdType(cdType);
                break;
            case 6:
                //edit number of tracks
                System.out.println("Please enter the new number of tracks");
                tracks = input.nextLine();
                numTracks = val.menuValidate(tracks);
                Control.cds.get(id).setNumTracks(numTracks);
                break;
            case 7:
                //edit artist
                System.out.println("Please enter the new artist");
                artist = val.multiWordValidate(artist);
                Control.cds.get(id).setArtist(artist);
                break;
            case 8:
                //edit case type
                System.out.println("Please enter the new case type");
                caseType = input.nextLine();
                caseType = val.singleWordValidate(cdType);
                Control.cds.get(id).setCaseType(caseType);
                break;
            case 9:
                System.out.println("Returning to previous menu");
                break;
            default:
                System.out.println("Invalid number entered, please enter a number between 1 and 9");
        }
    }

    private void processJournal(int num, int id){
        switch(num){
            case 1:
                //edit title
                System.out.println("Please enter the new title");
                title = val.multiWordValidate(title);
                Control.journals.get(id).setTitle(title);
                break;
            case 2:
                //edit price
                System.out.println("Please enter the new price");
                costPrice = input.nextLine();
                price = val.doubleValidate(costPrice);
                Control.journals.get(id).setCost(price);
                break;
            case 3:
                //edit publisher
                System.out.println("Please enter the new publisher");
                publisher = input.nextLine();
                publisher = val.singleWordValidate(publisher);
                Control.journals.get(id).setPublisher(publisher);
                break;
            case 4:
                //edit issn
                System.out.println("Please enter the new ISSN");
                isbn = input.nextLine();
                isbn = val.singleWordValidate(isbn);
                Control.journals.get(id).setIssn(isbn);
                break;
            case 5:
                //edit issue number
                System.out.println("Please enter the new issue number");
                issue = input.nextLine();
                issueNo = val.menuValidate(issue);
                Control.journals.get(id).setIssueNo(issueNo);
                break;
            case 6:
                //edit issue date
                System.out.println("Please enter the new issue date ddmmyyyy");
                issueDate = input.nextLine();
                issueDate = val.dateValidate(issueDate);
                Control.journals.get(id).setIssueDate(issueDate);
                break;
            case 7:
                //edit subject area
                System.out.println("Please enter the new subject area");
                subjectArea = input.nextLine();
                subjectArea = val.singleWordValidate(subjectArea);
                Control.journals.get(id).setSubjectArea(subjectArea);
                break;
            case 8:
                //edit number of pages
                System.out.println("Please enter the new number of pages");
                pageNo = input.nextLine();
                pages = val.menuValidate(pageNo);
                Control.books.get(id).setNumPages(pages);
                break;
            case 9:
                System.out.println("Returning to previous menu");
                break;
            default:
                System.out.println("Invalid number entered, please enter a number between 1 and 9");
        }
    }

    private void processVideo(int num, int id){
        switch(num){
            case 1:
                //edit title
                System.out.println("Please enter the new title");
                title = input.nextLine();
                title = val.multiWordValidate(title);
                Control.videos.get(id).setTitle(title);
                break;
            case 2:
                //edit price
                System.out.println("Please enter the new price");
                costPrice = input.nextLine();
                price = val.doubleValidate(costPrice);
                Control.videos.get(id).setCost(price);
                break;
            case 3:
                //edit publisher
                System.out.println("Please enter the new publisher");
                publisher = input.nextLine();
                publisher = val.singleWordValidate(publisher);
                Control.videos.get(id).setPublisher(publisher);
                break;
            case 4:
                //edit runtime
                System.out.println("Please enter the new runtime");
                runtime = input.nextLine();
                runtime = val.runtimeValidate(runtime);
                Control.videos.get(id).setRunTime(runtime);
                break;
            case 5:
                //edit format
                System.out.println("Please enter the new format");
                format = input.nextLine();
                format = val.singleWordValidate(format);
                Control.videos.get(id).setVideoFormat(format);
                break;
            case 6:
                //edit genre
                System.out.println("Please enter the new genre");
                genre = input.nextLine();
                genre = val.multiWordValidate(genre);
                Control.videos.get(id).setGenre(genre);
                break;
            case 7:
                //edit case type
                System.out.println("Please enter the new case type");
                caseType = input.nextLine();
                caseType = val.singleWordValidate(cdType);
                Control.videos.get(id).setCaseType(caseType);
                break;
            case 8:
                System.out.println("Returning to previous menu");
                break;
            default:
                System.out.println("Invalid number entered, please enter a number between 1 and 8");
        }
    }
}
