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
	
	try{
		int isResultFound = 0;
		Connection con=null;
		PreparedStatement pst=null;
		ResultSet result=null;	
		ResultSet resultMember=null;
		ResultSet resultBook=null;
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Library","root","rootuser");
			
			pst=con.prepareStatement("SELECT * FROM reserve WHERE MemberID=" + session.getAttribute("currentMember"));				
			result=pst.executeQuery();
			while(result.next()){
					isResultFound = 1;
					int ReserveId = Integer.parseInt(result.getString("ReserveID"));
					int MemberId = Integer.parseInt(result.getString("MemberID"));
					int BookId = Integer.parseInt(result.getString("BookID"));
					
					pst=con.prepareStatement("SELECT * FROM member WHERE MemberID=" + MemberId);
					resultMember=pst.executeQuery();
					
					pst=con.prepareStatement("SELECT * FROM book WHERE BookID=" + BookId);
					resultBook=pst.executeQuery();
					
					if(resultMember.next() && resultBook.next()){
						out.println("<div style=\"border: 1px solid black;\">");
						out.println("<p> <b>Reserve ID: </b> " + ReserveId + "</p>");
						out.println("<p> <b>Member ID: </b> " + resultMember.getString("MemberID") + "</p>");
						out.println("<p> <b>Member Name: </b> " + resultMember.getString("Name") + "</p>");
						out.println("<p> <b>Book ID: </b> " + resultBook.getString("BookID") + "</p>");
						out.println("<p> <b>Book Title: </b> " + resultBook.getString("Title") + "</p>");
						out.println("<p> <b>Member Checkout Count: </b> " + resultMember.getString("CheckOutCount") + "</p>");
						out.println("<p> <b>Book Items Left: </b> " + resultBook.getString("NoOfBookItems") + "</p>");
						out.println("<a href='/Library_Management_System/menus.html'> Go Back </a>");
						out.println("</div>");
					}
					
				}
			if(isResultFound == 0){
				out.println("No Results Found");
				out.println("<a href='/Library_Management_System/menus.html'> Go Back </a>");
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