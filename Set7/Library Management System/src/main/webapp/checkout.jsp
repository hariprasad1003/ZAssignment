<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.sql.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Library Management System</title>
</head>

<script type="text/javascript">

function display_message(message, success_status){
	alert(message);
	if(success_status == 1){
		window.location.href="/Library_Management_System/menus.html";	
	}else{
		window.location.href="/Library_Management_System/search.html";
	}
	
}

</script>

<body>
	<% 
		String bookidStr = request.getParameter("bookid");
		int bookId=Integer.parseInt(bookidStr);
		int memberId;
		
		try{
			Connection con=null;
			PreparedStatement pst=null;	
			ResultSet resultMember = null;
			ResultSet resultBook = null;
			int resultStatus = 0;
			try{
				Class.forName("com.mysql.cj.jdbc.Driver");
				con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Library","root","rootuser");
				
				pst=con.prepareStatement("SELECT * FROM book WHERE BookID="+ bookId);
				resultBook=pst.executeQuery();
				System.out.println(resultBook);
				
				pst=con.prepareStatement("SELECT * FROM member WHERE MemberID="+ session.getAttribute("currentMember"));
				System.out.println(pst);
				resultMember=pst.executeQuery();
				System.out.println(resultMember);
				
				if(resultBook.next() && resultMember.next()){
					
					int bookCount = Integer.parseInt(resultBook.getString("NoOfBookItems"));
					System.out.println(bookCount);

					memberId = Integer.parseInt(resultMember.getString("MemberID"));
					int memberCheckoutCount =  Integer.parseInt(resultMember.getString("CheckOutCount"));
					
					System.out.println(memberId);
					System.out.println(memberCheckoutCount);
					
					if(bookCount != 0 && memberCheckoutCount <= 5){
						pst=con.prepareStatement("UPDATE book SET NoOfBookItems=" + (bookCount - 1) + " WHERE BookID="+ bookId);
						pst.executeUpdate();
						
						pst=con.prepareStatement("UPDATE member SET CheckOutCount=" + (memberCheckoutCount + 1) + " WHERE memberID="+ memberId);
						pst.executeUpdate();
						
						pst=con.prepareStatement("INSERT INTO checkout(MemberID, BookID, DueDate) VALUES (" + memberId + ", " + bookId + ", curdate())");
						resultStatus=pst.executeUpdate();
				
						if(resultStatus == 1){
								%>
								
								<script type="text/javascript"> 
									window.onload = function(){
										display_message("Book Checkout Successful", 1); 
									}
								</script>							
								<%
						}
						else{
								%>
									
								<script type="text/javascript"> 
									window.onload = function(){
										display_message("Error Occurred", 0); 
									}
								</script>
								
								<%
							
						}
					}else{
						out.println("<p>Book not Available, Do you want to Reserve the Book?</p>");
						out.println("<a href='/Library_Management_System/reserve.jsp'>Okay</a>");
						out.println("<a href='/Library_Management_System/search.jsp'>Go Back</a>");
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
	
	%>
</body>
</html>