package com.org.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.org.dao.UserDao;
import com.org.dto.User;
@WebServlet("/register")
public class RegisterServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		String name= req.getParameter("name");
		String age= req.getParameter("age");
		String email= req.getParameter("email");
		String password= req.getParameter("password");
		String mobile= req.getParameter("mobile");
		
		int age1 = Integer.parseInt(age);
		long mob = Long.parseLong(mobile);
		
		
		User u= new User();
		u.setName(name);
		u.setAge(age1);
		u.setEmail(email);
		u.setPassword(password);
		u.setMobile(mob);
		UserDao dao = new UserDao();
		dao.saveUser(u);
		
		HttpSession session = req.getSession();
		session.setAttribute("success","REGISTRATION SUCCESSFULL");
		
		resp.sendRedirect("Register.jsp");
	}
	
	
}
