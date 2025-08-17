/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.Account;
import model.khachHang;
/**
 *
 * @author AN THANH
 */
public class khachHangDAO extends DAO {
    public khachHangDAO(){
        super();
    }
    
    public boolean checkLogin(Account ac){
        boolean rs = false;
        String sql = "SELECT account_id FROM Account WHERE username = ? AND password = ?";
        
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, ac.getUsername());
            ps.setString(2, ac.getPassword());
            ResultSet r = ps.executeQuery();
            if(r.next()) {
                rs = true;
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return rs;
    }
    
public int register(khachHang kh) {
    String sql = "INSERT INTO account (khachhang_id, username, password) VALUES (?, ?, ?)";
    try {
        PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        ps.setInt(1, kh.getId());
        ps.setString(2, kh.getAccount().getUsername());
        ps.setString(3, kh.getAccount().getPassword());
        int rows = ps.executeUpdate();
        System.out.println(rows);
        if (rows > 0) {
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                return rs.getInt(1);
            }
        }
    } catch(Exception e) {
        e.printStackTrace();
    }
        return -1;
    }

public int KHregister(khachHang kh){
    String sql = "INSERT INTO khachhang (ten, email, sdt, diachi) VALUES (?, ?, ?, ?)";
    try{
        PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        ps.setString(1, kh.getName());
        ps.setString(2, kh.getEmail());
        ps.setString(3, kh.getTel());
        ps.setString(4, kh.getAddress());
        int rows = ps.executeUpdate();
        if(rows > 0){
            ResultSet rs = ps.getGeneratedKeys();
            if(rs.next()){
                return rs.getInt(1);
            }
        }
        
    }catch(Exception e) {
        e.printStackTrace();
    }
    return -1;
}
}


