<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lista de pedidos</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet">

</head>
<body>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
	<div class="container">
		<h2 class="text-primary text-center">Lista de pedidos</h2>
		
		
		<table class="table table-striped">
			<thead>
				<tr>
					<th>CPF</th>
					<th>NOME</th>
					<th>PEDIDO</th>
					<th>DATA</th>		
	
				</tr>
			</thead>
			<tbody>
			
				<c:forEach var="ped" items="${lista_pedidos}">
					<tr>
						<td>${ped.cpf}</td>
						<td>${ped.nome}</td>
						<td>${ped.numeroPedido}</td>
						<td>
							<fmt:formatDate value="${ped.data}" pattern="dd/MM/yyyy"/>
						</td>

					</tr>
				</c:forEach>
			
			</tbody>
		</table>
	</div>

</body>
</html>