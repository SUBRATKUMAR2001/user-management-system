package com.org.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.org.dao.UserDao;
import com.org.dto.User;
@WebServlet("/changepwd")
public class ChangePassword extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		User u = new User();
		int id = u.getId();
		String password = u.getPassword();
		String currentpassword = req.getParameter("currentpwd");
	String newpassword = req.getParameter("newpwd");
	String conformpassword = req.getParameter("confirmpwd");
	
	if(password.equals(currentpassword)&&newpassword.equals(conformpassword)) {
		UserDao user =new UserDao();
		user.ChangepwdById(id,newpassword);
		resp.sendRedirect("home.jsp");
	}
	else {
		resp.sendRedirect("Change.jsp");
	}
	}
}
