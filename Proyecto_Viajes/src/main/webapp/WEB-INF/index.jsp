<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Read Share</title>
		<link rel="stylesheet" href="/css/pagina.css"/>
	</head>
	<body>
		<div >
			<h1>
				Save Travels
			</h1>
			<div class="lista">
				<table>
				    <thead>
				        <tr>
				            <th>Expense</th>
				            <th>Vendor</th>
				            <th>Amount</th>
				            <th>Actions</th>
				        </tr>
				    </thead>
			    <tbody>
			         <c:forEach var="viajes" items="${listaViajes}">
			         	<tr>		
									<th><a href="/expenses/${viajes.getId()}"><c:out value="${viajes.getNombregasto()}"/></a></th> 
									<th><c:out value="${viajes.getVendedor()}"/></th> 
									<th>$<c:out value="${viajes.getMonto()}"/></th>
									<th class="actions">
										<a href="/expenses/edit/${viajes.getId()}">Edit</a>
										<form action="/expenses/eliminar/${viajes.getId()}" method="POST" class="form2">
											<input type="hidden" name="_method" value="DELETE" />
											<button type="submit" class="button2">
														<Strong>Delete</Strong> 
											</button>
										</form>
									</th>
						</tr>
			         </c:forEach>
			    </tbody>
			   </table>
			</div>
		</div>
		<div>
			<h1>
				Add an Expense
			</h1>
			<div class="registro">
				<form:form method="POST" action="/expenses" modelAttribute="viaje" class="form1">
					<div>
						<form:label path="nombregasto" for="nombregasto">
							Expense Name:
						</form:label>
						<form:input path="nombregasto" type="text" name="nombregasto" id="nombregasto" />
						<form:errors path="nombregasto" class="error"/>
					</div>
					<div>
						<form:label path="vendedor" for="vendedor">
							Vendor:
						</form:label>
						<form:input path="vendedor" type="text" name="vendedor" id="vendedor" />
						<form:errors path="vendedor" class="error"/>
					</div>
					<div>
						<form:label path="monto" for="monto">
							Amount:
						</form:label>
						<form:input path="monto" type="number" name="monto" id="monto" value="null" min="1" />
						<form:errors path="monto"/>
					</div>
					<div>
						<form:label path="descripcion" for="descripcion">
							Description:
						</form:label>
						<form:textarea path="descripcion" type="text" name="descripcion" id="descripcion" />
						<form:errors path="descripcion" class="error"/>
					</div>
					<button type="submit" class="button1">
						Submit
					</button>
				</form:form>
			</div>
		</div>
	</body>
</html>