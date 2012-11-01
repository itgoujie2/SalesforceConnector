<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="com.sf.LocalAccount" %>
<%@page import="java.util.List" %>
<%@page import="java.util.ArrayList" %>
<%List<LocalAccount> accounts = (ArrayList) session.getAttribute("accounts"); %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<table>
		<tr>
			<td>Name</td>
		</tr>
		<%if (session.getAttribute("accounts")!=null)
			System.out.println("true");
			else System.out.println("false");
			%>
		<%
			for (int i=0;i<accounts.size();i++){
				%><tr><td><%=accounts.get(i).getName()%></td></tr><%
			}
		%>
		
		
		<%-- <c:forEach items="${accounts}" var="account">
			<tr>
				<td>${account.name}</td>
			</tr>
		</c:forEach> --%>
		
		
	</table>
</body>
</html>