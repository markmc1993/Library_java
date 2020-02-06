public class Journal extends Item {

    private String issn;
    private int issueNo;
    private String issueDate;
    private String subjectArea;
    private int numPages;

    public Journal(int stockID, String title, double cost, String publisher, boolean available, String issn, int issueNo, String issueDate, String subjectArea, int numPages) {
        super(stockID, title, cost, publisher, available);
        this.issn = issn;
        this.issueNo = issueNo;
        this.issueDate = issueDate;
        this.subjectArea = subjectArea;
        this.numPages = numPages;
    }

    public String getIssn() {
        return issn;
    }

    public void setIssn(String issn) {
        this.issn = issn;
    }

    public int getIssueNo() {
        return issueNo;
    }

    public void setIssueNo(int issueNo) {
        this.issueNo = issueNo;
    }

    public String getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(String issueDate) {
        this.issueDate = issueDate;
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
