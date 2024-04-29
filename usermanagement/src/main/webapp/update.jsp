<%@page import="com.org.dto.User"%>
<%@page import="com.org.dao.UserDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="components/bootstrapCss.jsp" %>
<style type="text/css">
.paint-card {
	box-shadow: 0 0 10px 0 rgba(0, 0, 0, 0.3);
}
</style>
</head>
<body>
 
  <% String id1=request.getParameter("id"); 
     int id=Integer.parseInt(id1);
    
     UserDao dao=new UserDao();
      User user=dao.fetchUserById(id);
      
      User userde=(User)session.getAttribute("userobj");;
      
  %>
  <% if(userde==null) {
	  response.sendRedirect("Login.jsp");
  }else{
  %>
  
  <%@ include file="components/homeNavbar.jsp" %>
<div class="container p-5">
		<div class="row">
			<div class="col-md-4 offset-md-4">
				<div class="card paint-card">
					<div class="card-body">
						<p class="fs-4 text-center">Update <%=user.getName() %> Details</p>
						
						<%  String mgs=(String)session.getAttribute("updatemsg");
						  
						if(mgs!=null){
						%>
							<p class="text-center text-success fs-4"><%= mgs %></p>
				    	<%	
					  session.removeAttribute("updatemsg");
						}
						%>
						
						<form action="update" method="post">
							<div class="mb-3">
								<label class="form-label">Name</label> <input name="name"
									type="text" class="form-control"  value="<%=user.getName()%>" required>
							</div>
							<div class="mb-3">
								<label class="form-label">Age</label> <input name="age"
									type="tel" class="form-control" value="<%=user.getAge() %>" required>
							</div>
							<div class="mb-3">
								<label class="form-label">Mobile</label> <input name="mobile"
									type="tel" class="form-control" value="<%=user.getMobile() %>" required>
							</div>
							<div class="mb-3">
								<label class="form-label">Email Address</label> <input
									name="email" type="email" class="form-control" value="<%=user.getEmail()%>"required>
							</div>
							<input type="hidden" name="id" value="<%= user.getId()%>">
							<button type="submit" class="btn bg-primary text-white col-md-12">Update</button>
						</form>
                      <br>



					</div>
				</div>
			</div>
		</div>
	</div>
	<%} %>
</body>
</html>