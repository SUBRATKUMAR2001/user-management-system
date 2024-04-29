package com.org.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.org.dto.User;

public class UserDao {
	
 public static void saveUser(User user) {
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
	
	
	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/user_mgmt","root","root");
	
	PreparedStatement pst = con.prepareStatement("insert into user(name,age,email,password,mobile)values(?,?,?,?,?)");
 
	pst.setString(1, user.getName());
	pst.setInt(2, user.getAge());
	pst.setString(3, user.getEmail());
	pst.setString(4, user.getPassword());
	pst.setLong(5, user.getMobile());
	
	pst.executeUpdate();
	
	con.close();
	
 

} catch (ClassNotFoundException | SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
} 
 }
 public User fetchUserByEmailAndPassword(String email,String password) {
	 
	 try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/user_mgmt","root","root");
		
		PreparedStatement pst = con.prepareStatement("select * from user where email=? and password=?");
	 
		pst.setString(1, email);
		pst.setString(2, password);
		
		ResultSet rst = pst.executeQuery();
		
		if(rst.next()) {
			
			User user = new User();
			user.setName(rst.getString("name"));
			user.setAge(rst.getInt("age"));
			user.setEmail(rst.getString("email"));
			user.setPassword(rst.getString("password"));
			user.setMobile(rst.getLong("mobile"));
			user.setId(rst.getInt("id"));
		
			 return user;
		}
		
		
		con.close(); 
	} catch (ClassNotFoundException | SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return null;
 }
 public User fetchUserById(int id) {
	 try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/user_mgmt","root","root");
		PreparedStatement pst = con.prepareStatement("select * from user where id=?");
		pst.setInt(1, id);
		ResultSet rst = pst.executeQuery();
		
      if(rst.next()) {
			
			User user = new User();
			user.setName(rst.getString("name"));
			user.setAge(rst.getInt("age"));
			user.setEmail(rst.getString("email"));
			user.setPassword(rst.getString("password"));
			user.setMobile(rst.getLong("mobile"));
		
			 return user;
		}
		con.close();
		
	} catch (ClassNotFoundException | SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 return null;
 }
 public List<User>fetchAllUser(){
	 
	 List<User> list = new ArrayList<User>();
	 
	 try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/user_mgmt","root","root");
			PreparedStatement pst = con.prepareStatement("select * from user");
			
			ResultSet rst = pst.executeQuery();
			
			while(rst.next()) {
				User user = new User();
				user.setName(rst.getString("name"));
				user.setAge(rst.getInt("age"));
				user.setEmail(rst.getString("email"));
				user.setPassword(rst.getString("password"));
				user.setMobile(rst.getLong("mobile"));
				user.setId(rst.getInt("id"));
				list.add(user);
			}
	 } catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
	
	 } 
	 return list;
 
 }
 public void updateUser(User user) {
	 try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/user_mgmt","root","root");
			PreparedStatement pst = con.prepareStatement("update user set name=?,age=?,email=?,mobile=? where id=?");
			
			
			System.out.println(user.getName());
			System.out.println(user.getAge());
			System.out.println(user.getEmail());
			System.out.println( user.getMobile());
			System.out.println(user.getId());
			
			
			
			
			
			pst.setString(1, user.getName());
			pst.setInt(2, user.getAge());
			pst.setString(3, user.getEmail());
			pst.setLong(4, user.getMobile());
			pst.setInt(5, user.getId());
			 pst.executeUpdate();
			
			con.close();
	 } catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
	
	 } 
 }
 public void DeleteUserById(int id) {
	   try {
	
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306","root","root");
		PreparedStatement pst = con.prepareStatement("delete from user_mgmt.user where id=?");
		pst.setInt(1, id);
		pst.executeUpdate();
		con.close();
		
	} catch (ClassNotFoundException | SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
 }
 public void ChangepwdById(int id ,String newpwd) {
	   try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306","root","root");
			PreparedStatement pst = con.prepareStatement("update user_mgmt.user set password=? where id=?");
			pst.setString(1, newpwd);
			pst.setInt(2, id);
			pst.executeUpdate();
			con.close();
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 }

}