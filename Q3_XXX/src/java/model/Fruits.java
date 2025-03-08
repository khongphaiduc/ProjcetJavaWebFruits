/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Admin
 */
public class Fruits {

    int fruitsID;
    String nameFuirt;
    double price;
    int stock;
    String origin;
    String country;
    double sum;
    int soluong;
    FruitImage fruitsImageUrl;
    String pathURL;

    int quantity;

    public String getPathURL() {
        return pathURL;
    }

    public void setPathURL(String pathURL) {
        this.pathURL = pathURL;
    }

    // lấy danh sách fruits k ảnh 
    public Fruits(int fruitsID, String nameFuirt, double price, int stock, String origin, String country) {
        this.fruitsID = fruitsID;
        this.nameFuirt = nameFuirt;
        this.price = price;
        this.stock = stock;
        this.origin = origin;
        this.country = country;
    }

    // lưu sản phẩm trong hóa đơn
    public Fruits(int fruitsID, String nameFuirt, double price, int soluong, String orgin, String country, double sum) {
        this.fruitsID = fruitsID;
        this.nameFuirt = nameFuirt;
        this.price = price;
        this.origin = orgin;
        this.country = country;
        this.sum = sum;
        this.soluong = soluong;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    // lấy danh sách fruits kèm ảnh 
    public Fruits(int fruitsID, String nameFuirt, double price, int stock, String origin, String country, FruitImage fruitsImageUrl) {
        this.fruitsID = fruitsID;
        this.nameFuirt = nameFuirt;
        this.price = price;
        this.stock = stock;
        this.origin = origin;
        this.country = country;
        this.fruitsImageUrl = fruitsImageUrl;
    }
    // lấy top fruit bán chạy 

    public Fruits(int fruitsID, String nameFuirt, double price, String pathImage) {
        this.fruitsID = fruitsID;
        this.nameFuirt = nameFuirt;
        this.price = price;
        this.pathURL = pathImage;

    }

    public Fruits(int fruitsID, String nameFuirt, double price, String pathImage, int quantity) {
        this.fruitsID = fruitsID;
        this.nameFuirt = nameFuirt;
        this.price = price;
        this.pathURL = pathImage;
        this.quantity = quantity;
    }

    
    
    public Fruits(int fruitsID, String nameFuirt,int stock) {
        this.fruitsID = fruitsID;
        this.nameFuirt = nameFuirt;
        this.stock=stock;
    }
    public FruitImage getFruitsImageUrl() {
        return fruitsImageUrl;
    }

    public void setFruitsImageUrl(FruitImage fruitsImageUrl) {
        this.fruitsImageUrl = fruitsImageUrl;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public double getSum() {
        return sum;
    }

    public void setSum(double sum) {
        this.sum = sum;
    }

    public int getFruitsID() {
        return fruitsID;
    }

    public void setFruitsID(int fruitsID) {
        this.fruitsID = fruitsID;
    }

    public String getNameFuirt() {
        return nameFuirt;
    }

    public void setNameFuirt(String nameFuirt) {
        this.nameFuirt = nameFuirt;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "Fruits{" + "fruitsID=" + fruitsID + ", nameFuirt=" + nameFuirt + ", price=" + price + ", stock=" + stock + '}';
    }

    
    

}
