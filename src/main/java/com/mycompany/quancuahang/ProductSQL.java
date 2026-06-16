/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.quancuahang;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;
/**
 *
 * @author syn74
 */
public class ProductSQL {
    public Product findcus(Connection conn , int id){
        String sql = "Select ten , id_ct, gia_tri,so_luong from san_pham where id = ?";
        
        try(PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setInt(1, id);
             try(ResultSet rs = ps.executeQuery()){
                 
                 if(rs.next()){
                     return new Product(
                             id,
                             rs.getString("ten"),
                             rs.getInt("id_ct"),
                             rs.getBigDecimal("gia_tri"),
                             rs.getInt("so_luong")
                     );
                     
                 }
             }
        } catch (SQLException ex) {
            System.getLogger(ProductSQL.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
        
        return null;
    }
    
    public void addProduct(Connection conn){
       Scanner sc = new Scanner(System.in);
       String sql ="ínert into san_pham(id,ten,id_ct,gia_tri,so_luong) values(?,?,?,?,?)";
       String takeid = "select max(id) from san_pham";
       int id = 0;
       
       // lay id
       
       try(PreparedStatement ps = conn.prepareStatement(takeid)){
           ResultSet rs = ps.executeQuery();
           if(rs.next()){
               id = rs.getInt(1) +1;
           }else{
               System.out.println("error 1");
               return;
           }
               
       } catch (SQLException ex) {
            System.getLogger(ProductSQL.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
       
       // nhap du lieu san pham moi 
       
       System.out.print("ten sp: ");
       String name = sc.nextLine();
       
       
       
    }
}
