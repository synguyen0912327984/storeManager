/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.quancuahang;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

/**
 *
 * @author syn74
 */
public class CustomerSQL {
    public Customer FindId(int id, Connection conn){
         String sql = "select ten_khach,dia_chi,numberphone,status from khach_hang where id =?";
         
         try(PreparedStatement ps = conn.prepareStatement(sql)){
             ps.setInt(1, id);
             try(ResultSet rs = ps.executeQuery()){
                 if(rs.next()){
                     return new Customer(
                             id,
                             rs.getString("ten_khach"),
                             rs.getString("dia_chi"),
                             rs.getString("numberphone"),
                             rs.getBoolean("status")
                     );
                     
                 }
             }
         } catch (SQLException ex) {
            System.getLogger(CustomerSQL.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
         return null;
    }
    
    public void addCus(Connection conn){
        
        boolean check = false;
        Scanner sc = new Scanner(System.in);
        String sql ="Insert into Khach_hang(id,ten_khach,dia_chi,numberphone,status) Values(?,?,?,?,?)";
        String sql2="Select max(id) from Khach_hang";
        System.out.print("name :");
        String name = sc.nextLine();
        System.out.print("address:");                          
        String address = sc.nextLine();
        String numberphone ="";
        int id = 0;
        
        // tìm id lơn nhất
        try (PreparedStatement ps = conn.prepareStatement(sql2);
            ResultSet rs = ps.executeQuery()){
            
            if(rs.next()){
                id = rs.getInt(1)+1;
            }   
            
        } catch (SQLException ex) {
            System.getLogger(CustomerSQL.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
        
        
        
        
        
        // nhập dữ liệu vào sql
       do{
            System.out.print("numberphone :");
            numberphone = sc.nextLine();
            try (PreparedStatement ps = conn.prepareStatement(sql)){
                ps.setInt(1,id);
                ps.setString(2,name);
                ps.setString (3,address);
                ps.setString(4, numberphone);
                ps.setBoolean(5,true);
                int row = ps.executeUpdate();
                if (row > 0){
                    System.out.println("corect");
                    check = false;
                }
            } catch (SQLException ex) {

                if (ex.getErrorCode() == 2627 || ex.getErrorCode() == 2601) {
                    System.out.println("Phone number already exists!");
                    check = true;
                } else {
                    ex.printStackTrace();
                }
                
            }
        }while(check);
    }
    
    
    public void deleteCus(Connection conn,int id){
        String sql ="update khach_hang set status = ? where id = ?";
        
        try(PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setBoolean(1,false);
            ps.setInt(2, id);
            int rows = ps.executeUpdate();
            if(rows > 0){
                System.out.println("deleted");
            }else{
                System.out.println("errol");
            }
              
            
        } catch (SQLException ex) {
            System.getLogger(CustomerSQL.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
                        
    }
}
