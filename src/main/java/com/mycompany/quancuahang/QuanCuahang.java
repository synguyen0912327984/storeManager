/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.quancuahang;
import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import java.sql.Connection;

import com.microsoft.sqlserver.jdbc.SQLServerException;
import java.sql.SQLException;
/**
 *
 * @author syn74
 */
public class QuanCuahang {

    private static SQLServerDataSource getDataSource(){
        SQLServerDataSource ds = new SQLServerDataSource();
        ds.setUser("sa");
        ds.setPassword("123456");
        ds.setDatabaseName("bt1");
        ds.setServerName("MSI\\SQLEXPRESS");
        ds.setPortNumber(1433);
        ds.setTrustServerCertificate(true);
        return ds;
    }
    
    public static void main(String[] args) throws SQLException {
        SQLServerDataSource ds = getDataSource();
        
        CustomerSQL l1 = new CustomerSQL();
        ProductSQL l2 = new ProductSQL();
        
        try(Connection conn = ds.getConnection()){
           l2.addProduct(conn);
        
        } catch (SQLServerException ex) {
            ex.printStackTrace();
        }
    }
}
