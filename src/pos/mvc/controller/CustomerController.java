/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pos.mvc.controller;

import pos.mvc.model.CustomerModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import pos.mvc.db.DBConnection;
/**
 *
 * @author hp
 */
public class CustomerController {
    
        public String saveCustomer(CustomerModel customerModel) throws SQLException{
        Connection connection = DBConnection.getInstance().getConnection();
        
        String query = "INSERT INTO Customer VALUES(?,?,?,?,?,?,?,?,?)";
        
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, customerModel.getCustId());
        statement.setString(2, customerModel.getTitle());
        statement.setString(3, customerModel.getName());
        statement.setString(4, customerModel.getDob());
        statement.setDouble(5, customerModel.getSalary());
        statement.setString(6, customerModel.getAddress());
        statement.setString(7, customerModel.getCity());
        statement.setString(8, customerModel.getProvince());
        statement.setString(9, customerModel.getZip());
        
        if(statement.executeUpdate() > 0){
            return "Success";
        } else{
            return "Fail";
        }
    }
    
    
}
