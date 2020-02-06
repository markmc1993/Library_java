public class Video extends Item {

    private String runTime;
    private String videoFormat;
    private String genre;
    private String caseType;

    public Video(int stockID, String title, double cost, String publisher, boolean available, String runTime, String videoFormat, String genre, String caseType) {
        super(stockID, title, cost, publisher, available);
        this.runTime = runTime;
        this.videoFormat = videoFormat;
        this.genre = genre;
        this.caseType = caseType;
    }

    public String getRunTime() {
        return runTime;
    }

    public void setRunTime(String runTime) {
        this.runTime = runTime;
    }

    public String getVideoFormat() {
        return videoFormat;
    }

    public void setVideoFormat(String videoFormat) {
        this.videoFormat = videoFormat;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getCaseType() {
        return caseType;
    }

    public void setCaseType(String caseType) {
        this.caseType = caseType;
    }
}
