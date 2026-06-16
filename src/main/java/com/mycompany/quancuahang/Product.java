/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.quancuahang;
import java.math.BigDecimal; 
/**
 *
 * @author syn74
 */
public class Product {
    private int id;
    private String name;
    private int idcom;
    private BigDecimal price ;
    private int count ;

    public Product() {
    }

    public Product(int id, String name, int idcom, BigDecimal price, int count) {
        this.id = id;
        this.name = name;
        this.idcom = idcom;
        this.price = price;
        this.count = count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getCount() {
        return count;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getIdcom() {
        return idcom;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setIdcom(int idcom) {
        this.idcom = idcom;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
    
    
    public void Process(){
        System.out.println("infor product: "+ this.id );
        System.out.println("name of product: "+ this.name);
        System.out.println("idcompany of product: "+ this.idcom);
        System.out.println("Price of product: "+ this.price);
        System.out.println("Count: "+this.count);
    }
}
