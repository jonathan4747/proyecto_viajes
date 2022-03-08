<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Show Expense</title>
		<link rel="stylesheet" href="/css/vista.css"/>
	</head>
	<body>
		<div class="titulo">
			<h1>Expense Details</h1>
			<div>
				<form action="/logout" method="GET">
					<button type="submit" class="button1">
						<strong>Go back</strong>
					</button>
				</form>
			</div>
		</div>
		<div class="informacion">
		 	<div class="cuadro">
				<p> <strong>Expense Name:</strong> <c:out value="${nombregasto}"/></p>
				<p> <strong>Expense Description:</strong> <c:out value="${descripcion}"/></p>
				<p> <strong>Vendor:</strong> <c:out value="${vendedor}"/></p>
				<p> <strong>Amount Spent:</strong> $<c:out value="${monto}"/></p>
			</div>
		</div>
	</body>
</html>