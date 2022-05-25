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

<form action="search.jsp" method="post">
		<label for="search_by">Search By:</label>
		  <select name="search_by">
		    <option value="Title">Title</option>
		    <option value="Author">Author</option>
		    <option value="SubjectCategory">Subject Category</option>
		    <option value="PublicationDate">Publication Date</option>
		  </select>
		<!-- <p>Enter your Search Query: </p> -->
		<input type="text" name="search_query" />
  		<input type="submit" value="Search">
  		<a href='/Library_Management_System/menus.html'> Go Back </a>
</form>

<%
	String searchBy = request.getParameter("search_by");
	String searchQuery = request.getParameter("search_query");
	
	/* 	System.out.println(searchBy);
	System.out.println(searchQuery); */
	
	if(searchBy != null && searchQuery != null){
		try{
			Connection con=null;
			PreparedStatement pst=null;
			ResultSet result=null;	
			try{
				Class.forName("com.mysql.cj.jdbc.Driver");
				con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Library","root","rootuser");
				searchQuery = searchQuery.toLowerCase();
				if(searchBy.equals("Title")){
					pst=con.prepareStatement("select * from book where lower("+searchBy+")='"+searchQuery+"'");
				}
				else if(searchBy.equals("Author")){
					pst=con.prepareStatement("select * from book where lower("+searchBy+")='"+searchQuery+"'");
				}
				else if(searchBy.equals("SubjectCategory")){
					pst=con.prepareStatement("select * from book");
				}
				else if(searchBy.equals("PublicationDate")){
					pst=con.prepareStatement("select * from book where lower("+searchBy+")='"+searchQuery+"'");
				}
				result=pst.executeQuery();
				ResultSetMetaData rsmd = result.getMetaData();
				int columnsNumber = rsmd.getColumnCount();
				if(!(searchBy.equals("SubjectCategory"))){
					if(result.next()){
						out.println("<div style=\"border: 1px solid black;\">");
						out.println("<p> <b>Book Unique Number:</b> " + result.getString("BookID") + "</p>");
						out.println("<p> <b>Book Title:</b> " + result.getString("Title") + "</p>");
						out.println("<p> <b>Author:</b> " +result.getString("Author") + "</p>");
						out.println("<p> <b>Subject Category:</b> " + result.getString("SubjectCategory") + "</p>");
						out.println("<p> <b>Publication Date:</b> " + result.getString("PublicationDate") + "</p>");
						out.println("<p> <b>Rack Number:</b> " + result.getString("RackNumber") + "</p>");
						out.println("<p> <b>No Of Book Items:</b> " + result.getString("NoOfBookItems") + "</p>");
						out.println("<a href='/Library_Management_System/checkout.jsp?bookid=" + result.getString("BookID") + "'> Checkout </a>");
						out.println("</div>");
					}else{
						out.println("No Results Found");
					}
					
				}else{
					int resultStatus = 0;
					while(result.next()){
						String[] subjectCategories=result.getString(searchBy).split(",");
						for(int j = 0; j < subjectCategories.length; j++){
	                        if((subjectCategories[j]).equalsIgnoreCase(searchQuery)){
	                        	resultStatus = 1;
	                        	out.println("<div style=\"border: 1px solid black;\">");
	                        	out.println("<p> <b>Book Unique Number:</b> " + result.getString("BookID") + "</p>");
								out.println("<p> <b>Book Title:</b> " + result.getString("Title") + "</p>");
								out.println("<p> <b>Author:</b> " +result.getString("Author") + "</p>");
								out.println("<p> <b>Subject Category:</b> " + result.getString("SubjectCategory") + "</p>");
								out.println("<p> <b>Publication Date:</b> " + result.getString("PublicationDate") + "</p>");
								out.println("<p> <b>Rack Number:</b> " + result.getString("RackNumber") + "</p>");
								out.println("<p> <b>No Of Book Items:</b> " + result.getString("NoOfBookItems") + "</p>");	
								out.println("<a href='/Library_Management_System/checkout.jsp?bookid=" + result.getString("BookID") + "'> Checkout </a>");
								out.println("</div>");
	                        }
	                    }
					}
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
	}
	
%>

</body>
</html>