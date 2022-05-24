<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.sql.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Library Management System</title>
</head>
<body>
	<%
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		System.out.println("Name: "  + name);
		System.out.println("Password: " + password);
		
		try{
			Connection con=null;
			PreparedStatement pst=null;
			int result;
			try{
				Class.forName("com.mysql.cj.jdbc.Driver");
				con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Library","root","rootuser");
				pst=con.prepareStatement("insert into member (Name, Password) Values ('"+name+"', '"+password+"')");
				result=pst.executeUpdate();
				// System.out.println(result);
				if(result == 1){
					out.println("Signin Successful");
					response.sendRedirect("index.html");					
				}
				else{
					out.println("Error Occurred");
				}

			}
			catch(ClassNotFoundException e){
				System.out.println("Driver Class not found Exception: " + e.getMessage());
			}
		catch(SQLException e){
			System.out.println("SQL Exception: " + e.getMessage());
		}
		finally{
			try{
				if(con!=null)
					con.close();
				}
				catch(SQLException e){
					System.out.println("Connection Closing Exception:" + e.getMessage());
				}
			}
		}
		catch(Exception e){
			out.println("Error" + e.getMessage());
		}
	%>
</body>
</html>