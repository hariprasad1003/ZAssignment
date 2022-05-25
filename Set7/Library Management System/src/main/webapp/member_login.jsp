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
		window.location.href="/Library_Management_System/index.html";
	}
	
}

</script>

<body>
	<%		
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		
		// System.out.println("Name: " + name);
		// System.out.println("Password: " + password);
		
		try{
			Connection con=null;
			PreparedStatement pst=null;
			ResultSet result=null;	
			try{
				Class.forName("com.mysql.cj.jdbc.Driver");
				con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Library","root","rootuser");
				pst=con.prepareStatement("select * from member where Name='"+name+"' limit 1");
				result=pst.executeQuery();
				if(result.next()){
					if(password.equals(result.getString("Password"))){
						session.setAttribute("currentMember", result.getString("MemberID"));
						%>
						
						<script type="text/javascript"> 
							window.onload = function(){
								display_message("Login Successful", 1); 
							}
						</script>							
						<%
					}
					else{
						%>
							
						<script type="text/javascript"> 
							window.onload = function(){
								display_message("Invalid Name or Password", 0); 
							}
						</script>
						
						<%
					
					}
				}
				else{
					%>
					<script type="text/javascript"> 
						window.onload = function(){
							display_message("User not found, Please Signup", 0); 
						}
					</script>
					<%
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