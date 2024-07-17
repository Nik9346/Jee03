<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registrazione Prodotto</title>
</head>
<body>
	<form action="registrazione" method="post">
		<input type= "number" name="id" required>
		<br>
		<input type ="text" name="descrizione"  required>
		<br>
		<input type="number" step="any" name="prezzo" required>
		<br>
		<input type="submit" value="Registra">
	</form>
</body>
</html>