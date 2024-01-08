package fr.dawan.genericite;

import java.io.Serializable;

public class Product implements Serializable {

    private static final long serialVersionUID = 1L;
    private int id;
    private String description;
    private double prix;

    public Product() {
    }

    public Product(int id, String description, double prix) {
        this.id = id;
        this.description = description;
        this.prix = prix;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", prix=" + prix +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }
}
