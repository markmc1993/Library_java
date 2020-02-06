public class CD extends Item {

    private String runTime;
    private String cdType;
    private int numTracks;
    private String artist;
    private String caseType;

    public CD(int stockID, String title, double cost, String publisher, boolean available, String runTime, String cdType, int numTracks, String artist, String caseType) {
        super(stockID, title, cost, publisher, available);
        this.runTime = runTime;
        this.cdType = cdType;
        this.numTracks = numTracks;
        this.artist = artist;
        this.caseType = caseType;
    }

    public String getRunTime() {
        return runTime;
    }

    public void setRunTime(String runTime) {
        this.runTime = runTime;
    }

    public String getCdType() {
        return cdType;
    }

    public void setCdType(String cdType) {
        this.cdType = cdType;
    }

    public int getNumTracks() {
        return numTracks;
    }

    public void setNumTracks(int numTracks) {
        this.numTracks = numTracks;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getCaseType() {
        return caseType;
    }

    public void setCaseType(String caseType) {
        this.caseType = caseType;
    }
}
