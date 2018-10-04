package us.seanlewis.game.model;

public class GameItem {
    private int productNumber;
    private String name;
    private double price;
    private String genre;
    private boolean featured;
    private String description;
    private String image;
    //private String image; To be added

    public GameItem(int productNumber, String name, double price, boolean featured, String genre, String description, String image) {
        this.productNumber = productNumber;
        this.name = name;
        this.price = price;
        this.featured = featured;
        this.genre = genre;
        this.description = description;
        this.image = image;
    }

    public int getProductNumber() {
        return productNumber;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public boolean isFeatured() {
        return featured;
    }

    public String getDescription() {
        return description;
    }

    public String getImage() {
        return image;
    }
}
