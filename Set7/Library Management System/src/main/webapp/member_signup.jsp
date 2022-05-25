<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page contentType="text/html; charset=UTF-8"%>
<%@page import="java.sql.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Library Management System</title>
</head>

<script type="text/javascript">

function display_message(message){
	alert(message);
	window.location.href="/Library_Management_System/index.html";	
}

</script>

<body>
	<%
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		
		// System.out.println("Name: "  + name);
		// System.out.println("Password: " + password);
		
		try{
			Connection con=null;
			PreparedStatement pst=null;
			int result_status;
			ResultSet result=null;
			
			try{
				Class.forName("com.mysql.cj.jdbc.Driver");
				con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Library","root","rootuser");
				pst=con.prepareStatement("insert ignore into member (Name, Password) Values ('"+name+"', '"+password+"')");
				result_status=pst.executeUpdate();
				if(result_status == 1){
				%>
					<script type="text/javascript"> 
						window.onload = function(){
							display_message("Signup Successful"); 
						}
					</script>
				<%					
				}
				else{
				%>
					<script type="text/javascript"> 
						window.onload = function(){
							display_message("Error Occurred"); 
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