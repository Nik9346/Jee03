<%@page import="it.corso.model.Prodotto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home Page</title>
</head>
<body>
	<a href="registrazione">Nuovo Prodotto</a>
	<table>
		<%
			@SuppressWarnings ("unchecked")
			List<Prodotto> prodotti = (List<Prodotto>) request.getAttribute("prodotti");
			for(Prodotto p: prodotti) {	
		%>
		<tr>
			<td><%=p.getDescrizione()%></td>
			<td><%=p.getPrezzo() %></td>
			<td>
				<a href="jee-03?id=<%=p.getId()%>">Elimina Prodotto</a>
			</td>
		</tr>
		<%} %>
	</table>
</body>
</html>