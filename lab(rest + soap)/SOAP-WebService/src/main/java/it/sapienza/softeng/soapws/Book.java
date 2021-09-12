package it.sapienza.softeng.soapws;

public class Book{

    private String ID;
    private float price;
    private String[] sellers;
    private String[] etas;

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String[] getSellers() {
        return sellers;
    }

    public void setSellers(String[] sellers) {
        this.sellers = sellers;
    }

    public String[] getEtas() {
        return etas;
    }

    public void setEtas(String[] etas) {
        this.etas = etas;
    }
    
    
}