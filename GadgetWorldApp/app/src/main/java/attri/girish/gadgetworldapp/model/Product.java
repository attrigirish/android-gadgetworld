package attri.girish.gadgetworldapp.model;

import java.util.ArrayList;

public class Product
{
    private int productid;
    private int brandid;
    private int categoryid;
    private String name;
    private double price;
    private ArrayList<Image> images;

    public Product(int productid, int brandid, int categoryid, String name, double price, ArrayList<Image> images) {
        this.productid = productid;
        this.brandid = brandid;
        this.categoryid = categoryid;
        this.name = name;
        this.price = price;
        this.images = images;
    }

    public Product() {
    }

    public int getProductid() {
        return productid;
    }

    public void setProductid(int productid) {
        this.productid = productid;
    }

    public int getBrandid() {
        return brandid;
    }

    public void setBrandid(int brandid) {
        this.brandid = brandid;
    }

    public int getCategoryid() {
        return categoryid;
    }

    public void setCategoryid(int categoryid) {
        this.categoryid = categoryid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public ArrayList<Image> getImages() {
        return images;
    }

    public void setImages(ArrayList<Image> images) {
        this.images = images;
    }
}
