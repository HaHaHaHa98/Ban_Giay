package business;

import java.io.Serializable;



public class Shoes implements Serializable {

    private String code;
    private String name;
    private String brand;
    private double price;
    private String type;
    private String object;
    private String image;

    public Shoes() {
    }

    public Shoes(String code, String name, String brand, double price, String type, String object, String image) {
        this.code = code;
        this.name = name;
        this.brand = brand;
        this.price = price;
        this.type = type;
        this.object = object;
        this.image = image;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getObject() {
        return object;
    }

    public void setObject(String object) {
        this.object = object;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "Shoes{" + "code=" + code + ", name=" + name + ", brand=" + brand + ", price=" + price + ", type=" + type + ", object=" + object + ", image=" + image + '}';
    }

}
