<%@page import="java.util.List"%>
<%@page import="com.org.dao.UserDao"%>
<%@page import="com.org.dto.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="components/bootstrapCss.jsp"%>
</head>
<body>


	<%
	User user = (User) session.getAttribute("userobj");
	if (user == null) {
		response.sendRedirect("Login.jsp");
	} else {
	%>
	<%@ include file="components/homeNavbar.jsp"%>
	<h1 style="text-align: center;color:blue"> Welcome to user Management System <%=user.getName() %></h1>
	<% String msg = (String) session.getAttribute("add"); 
						if(msg != null){
						%>
						<p class = "text-center text-success fs-4"> <%= msg %></p>
						
						<%
						session.removeAttribute("add");
						}%>
	<div class="container-fluid p-3">
		<div class="row">
			<div class="col-md-12">
				<div class="card paint-card">
					<div class="card-body">
						<p class="fs-3 text-center">User Details</p>
						<a href="Add.jsp" class="text-decoration-none btn btn-primary">Add
							User</a>
						<table class="table">
							<thead>
								<tr>
									<th>Name</th>
									<th>Age</th>
									<th>Email</th>
									<th>Mobile</th>
									<th>Action</th>
								</tr>
							</thead>

							<%
							UserDao dao = new UserDao();
							List<User> list = dao.fetchAllUser();
							for (User u : list) {
								
								if (u.getId() == user.getId()) {
									
									continue;
								}
							%>

							<tr>
								<td><%=u.getName()%></td>
								<td><%=u.getAge()%></td>
								<td><%=u.getEmail()%></td>
								<td><%=u.getMobile()%></td>
								<td><a href="update.jsp?id=<%=u.getId()%>" class="btn btn-success text-decoration-none"> Update</a> <a
									href="delete?id=<%=u.getId()%>" class="btn btn-danger text-decoration-none">Delete</a></td>

							</tr>


							<%
							}
							%>

							<tbody>
						</table>

					</div>
				</div>


			</div>

		</div>


	</div>
	<%
	}
	%>
</body>
</html>