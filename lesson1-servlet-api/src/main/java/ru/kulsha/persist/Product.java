package ru.kulsha.persist;

public class Product {

    private Long id;
    private String productName;
    private int cost;

    public Product(String productName, int cost) {
        this.productName = productName;
        this.cost = cost;
    }

    public Long getId() {
        return id;
    }

    public String getProductName() {
        return productName;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }
}
