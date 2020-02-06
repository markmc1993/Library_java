import java.io.*;

public class Item implements Serializable{
    private int stockID;
    private String title;
    private double cost;
    private String publisher;
    private boolean available;

    public Item(int stockID, String title, double cost, String publisher, boolean available) {
        this.stockID = stockID;
        this.title = title;
        this.cost = cost;
        this.publisher = publisher;
        this.available = available;
    }

    public String getTitle() {
        return title;
    }

    public int getStockID() {
        return stockID;
    }

    public void setStockID(int stockID) {
        this.stockID = stockID;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
}
