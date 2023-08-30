<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lista de Clientes</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet">
<style>
	.margem-botao {
		margin-top: 10px;
		margin-bottom: 10px;
	}

</style>
</head>
<body>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	<div class="container">
		<h2 class="text-primary text-center">Lista de Clientes</h2>
		
		<div class="margem-botao">
			<a href="/clientes/novo" class="btn btn-primary">Novo Cliente</a>
		</div>
		
		<table class="table table-striped">
			<thead>
				<tr>
					<th>CPF</th>
					<th>NOME</th>
					<th>EMAIL</th>
					<th>TELEFONE</th>		
					<th></th>
				</tr>
			</thead>
			<tbody>
			
				<c:forEach var="cliente" items="${listagem_clientes}">
					<tr>
						<td>${cliente.cpf}</td>
						<td>${cliente.nome}</td>
						<td>${cliente.email}</td>
						<td>${cliente.telefone}</td>
						<td>
							<a href="/clientes/alterar/${cliente.cpf}">Alterar</a> |
							<a href="/clientes/remover/${cliente.cpf}">Remover</a> |
							<a href="/pedidos/lista/${cliente.cpf}">Ver Pedidos</a>
						</td>
					</tr>
				</c:forEach>
			
			</tbody>
		</table>
	</div>

</body>
</html>