/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.quancuahang;

/**
 *
 * @author syn74
 */
public class Customer {
    private int id ;
    private String name ;
    private String address;
    private String numberphone;
    private boolean stastus;

    public void setNumberphone(String numberphone) {
        this.numberphone = numberphone;
    }

    public String getNumberphone() {
        return numberphone;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Customer(int id, String name, String address,String numberphone,boolean status) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.numberphone = numberphone;
        this.stastus = status;
    }

    public boolean isStastus() {
        return stastus;
    }

    public void setStastus(boolean stastus) {
        this.stastus = stastus;
    }
    
    
    
    public Customer(){
        
    }
    
    public void process(){
        if(stastus == false){
            System.out.println("errol");
            return ;
        }
        System.out.println("in4 cus "+ id);
        System.out.println("name: "+name);
        System.out.println("address: " +address);
        System.err.println("numberphone :"+numberphone);

    }
}
