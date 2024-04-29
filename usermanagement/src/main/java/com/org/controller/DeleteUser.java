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

	@WebServlet("/delete")
	public class DeleteUser extends HttpServlet {
	  @Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		  HttpSession session = req.getSession(false);
		  
		  if(session!=null) {
			  String id1 = req.getParameter("id");
		int id = Integer.parseInt(id1);
		UserDao dao=new UserDao();
		dao.DeleteUserById(id);
		
		session.setAttribute("delmsg","Delete successfull");
		resp.sendRedirect("home.jsp");
		
		  }else {
			  resp.sendRedirect("login.jsp");
		  }
		
	}
	}

