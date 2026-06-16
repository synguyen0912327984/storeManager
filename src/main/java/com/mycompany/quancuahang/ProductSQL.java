/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.quancuahang;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.math.BigDecimal;
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
    
    public void addProduct(){
       String sql ="sel";
    }
}
