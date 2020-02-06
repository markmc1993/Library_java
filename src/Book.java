public class Book extends Item {

    private String isbn;
    private String author;
    private String subjectArea;
    private int numPages;

    public Book(int stockID, String title, double cost, String publisher, boolean available, String isbn, String author, String subjectArea, int numPages) {
        super(stockID, title, cost, publisher, available);
        this.isbn = isbn;
        this. author = author;
        this.subjectArea = subjectArea;
        this.numPages = numPages;
    }



    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getSubjectArea() {
        return subjectArea;
    }

    public void setSubjectArea(String subjectArea) {
        this.subjectArea = subjectArea;
    }

    public int getNumPages() {
        return numPages;
    }

    public void setNumPages(int numPages) {
        this.numPages = numPages;
    }
}
