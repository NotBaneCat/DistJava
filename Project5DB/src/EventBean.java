import java.text.ParseException;
import java.text.SimpleDateFormat;

public class EventBean {

    private String name;
    private String description;
    private double price;
    private Boolean isFeatured;
    private String image;
    private int productNumber;

    public EventBean(int productNumber, String name, String description, double price, Boolean isFeatured, String image) {
        this.productNumber = productNumber;
        this.name = name;
        this.description = description;
        this.price = price;
        this.isFeatured = isFeatured;
        this.image = image;
    }
    public String getName() {
        return name;
    }
    public String getDescription() {
        return description;
    }
    public double getPrice() {
        return price;
    }
    public Boolean getIsFeatured() {return isFeatured;}
    public String getImage() {
        return "images/" + image + ".jpg";
    }
    public int getProductNumber() {
        return productNumber;
    }

    @Override
    public String toString(){
        return price + name;
    }
}
