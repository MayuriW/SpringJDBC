<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

</head>
<body>
<%-- <script language="JavaScript">
function call(name,email,age,country)
//function call()
 {
	//alert(name);
	//document.location.href =
		var param = location.search.substring(1).split("&");
		var temp = param[0].split("=");
		alert(temp);
	
 }
 
/*  call(); */

</script>
<%
String var1 = request.getParameter("name");
String var2 = request.getParameter("email");
String var3 = request.getParameter("age");
String var4 = request.getParameter("country");
String path = "/SpringMVCRequestParamWebApp/registerSuccess1/"+var1+"/"+var2+"/"+var3+"/"+var4;
%>
 --%>	
 
 <form action="/SpringMVCRequestParamWebApp/StringServlet/" method="get">
		<table>

			<tr>
				<td>User Name</td>
				<td><input type="text" name="name"></td>				
			</tr>

			<tr>
				<td>Email</td>
				<td><input type="text" name="email"></td>
			</tr>


			<tr>
				<td>Age</td>
				<td><input type="text" name="age"></td>
			</tr>

			<tr>
				<td>Country</td>
				<td><select name="country">
						<option value="India">India</option>
						<option value="US">US</option>
						<option value="Other">Other</option>
				</select></td>
			</tr>

			<tr>
				<td>
				<input type="submit" value="Register">
				
				<a href="/SpringMVCRequestParamWebApp/welcomeMayuri/"> welcome</a>
				
				<a href="/SpringMVCRequestParamWebApp/welcomeAgain/"> welcomeAgain </a>
				
				
				</td>
			</tr>
			

		</table>
		
	</form>
</body>
</html>