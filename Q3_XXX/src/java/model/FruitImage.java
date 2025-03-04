
package model;

public class FruitImage {
    
    Fruits fruitOject;
    String url;

    public FruitImage( String url) {
        this.fruitOject = fruitOject;
        this.url = url;
    }

    public Fruits getFruitOject() {
        return fruitOject;
    }

    public void setFruitOject(Fruits fruitOject) {
        this.fruitOject = fruitOject;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "FruitImage{ url=" + url + '}';
    }
      
}
