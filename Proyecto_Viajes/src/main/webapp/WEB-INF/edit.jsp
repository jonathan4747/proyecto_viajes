<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Edit my stack</title>
		<link rel="stylesheet" href="/css/index1.css"/>
	</head>
	<body>
		<div class="titulo">
			<h1>
				Add an Expense
			</h1>
			<div>
				<form action="/logout" method="GET" class="form1">
					<button type="submit" class="button1">
						<strong>Go back</strong>
					</button>
				</form>
			</div>
		</div>
		<div class="registro">
			<form:form method="POST" action="/expenses/edit/${id}" modelAttribute="viaje" class="form2">
				<input type="hidden" name="_method" value="PUT" />
				<div>
					<form:label path="nombregasto" for="nombregasto">
						Expense Name:
					</form:label>
					<form:input path="nombregasto" type="text" name="nombregasto" id="nombregasto" placeholder="${nombregasto}"  />
					<form:errors path="nombregasto" class="error"/>
				</div>
				<div>
					<form:label path="vendedor" for="vendedor">
						Vendor:
					</form:label>
					<form:input path="vendedor" type="text" name="vendedor" id="vendedor" placeholder="${vendedor}"  />
					<form:errors path="vendedor" class="error" />
				</div>
				<div>
					<form:label path="monto" for="monto">
						Amount:
					</form:label>
					<form:input path="monto" type="number" name="monto" id="monto" value="null" placeholder="${monto}" min="1"/>
					<form:errors path="monto"/>
				</div>
				<div>
					<form:label path="descripcion" for="descripcion">
						Description:
					</form:label>
					<form:textarea path="descripcion" type="text" name="descripcion" id="descripcion"  placeholder="${descripcion}" value="null"/>
					<form:errors path="descripcion"  class="error"/>
				</div>
				<button type="submit" class="button2">
					Submit
				</button>
			</form:form>
		</div>
	</body>
</html>