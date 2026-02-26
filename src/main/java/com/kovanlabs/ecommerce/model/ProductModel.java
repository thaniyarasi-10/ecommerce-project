package com.kovanlabs.ecommerce.model;

public class ProductModel{

    private Long id;
    private String name;
    private String category;
    private Double amount;

    public ProductModel(){
    }

    public ProductModel(Long id,String name,String category, Double amount){
        this.id=id;
        this.name=name;
        this.category=category;
        this.amount=amount;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }
    public Double getAmount() {
        return amount;
    }
    public void setAmount(Double amount) {
        this.amount = amount;
    }
    @Override
    public String toString(){
        return "ProductModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", amount=" + amount +
                '}';
    }
}
