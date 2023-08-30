<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Pedidos</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet">
<style>
	.margem-botao {
		margin-top: 10px;
		margin-bottom: 10px;
	}
	.borda {
		margin: auto;
		max-width: 400px;
	}

</style>
</head>
<body>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	<div class="container borda">
		<h2 class="text-primary text-center">Efetuar Pedido</h2>

		<form action="/pedidos/novo" method="post" >
		
			<div class="mb-3">
				<label class="form-label">Cliente:</label>
				<select name="cpf" class="form-select">
					<option value="0">SELECIONE UM CLIENTE</option>
					<c:forEach var="cliente" items="${lista_clientes}">
						<option value="${cliente.cpf}">${cliente.nome}</option>
					</c:forEach>
				</select>
			</div>	
			
			<div class="mb-3">
				<label class="form-label">Num. Pedido:</label>
				<input type="text" name="numeroPedido" class="form-control" />
			</div>	
			
			<div class="mb-3">
				<label class="form-label">Data:</label>
				<input type="date" name="dataPedido" class="form-control" />
			</div>	
			

			
	
			<button type="submit" class="btn btn-primary">Incluir</button>
			
		</form>
	
	</div>
	
</body>
</html>