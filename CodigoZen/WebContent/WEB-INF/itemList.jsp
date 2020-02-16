<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Desafio Zen</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
</head>
<body>
	<div class="container p-3 mb-2 bg-light text-dark">
		<div>
			<ul class="nav justify-content-center">
				<li class="nav-item"><a class="nav-link active" href="new"><h3>Adicionar
							novo item</h3></a></li>
				<li class="nav-item"><a class="nav-link" href="list"><h3>Listar
							todos os itens</h3></a></li>
			</ul>
		</div>
		<div align="center">
			<div
				class="col-xs-8 col-sm-8 col-md-8 col-lg-8  col-xs-offset-2 col-sm-offset-2 col-md-offset-2 col-lg-offset-2 ">
				<div class="table-responsive">
					<table class="table table-bordered  table-sm">
						<caption>
							<h2 class="text-secondary">Lista de Peças</h2>
						</caption>
						<thead>
							<tr>
								<th class="text-dark" scope="col">Id:</th>
								<th class="text-dark" scope="col">Nome:</th>
								<th class="text-dark" scope="col">Veiculo de Aplicação:</th>
								<th class="text-dark" scope="col">Peso Liquido:</th>
								<th class="text-dark" scope="col">Peso Bruto:</th>
								<th class="text-dark" scope="col">Ações:</th>
							</tr>
						</thead>
						<thead>
							<c:forEach var="itens" items="${listItem}">
								<tr>
									<td class="text-secondary"><c:out value="${itens.id}" /></td>
									<td class="text-secondary"><c:out value="${itens.name}" /></td>
									<td class="text-secondary"><c:out
											value="${itens.vehicleAply}" /></td>
									<td class="text-secondary"><c:out
											value="${itens.pesoLiquido}" /></td>
									<td class="text-secondary"><c:out
											value="${itens.pesoBruto}" /></td>
									<td class="text-primary"><a
										href="editar?id=<c:out value='${itens.id}' />">Editar</a>
										&nbsp;&nbsp;&nbsp;&nbsp; <a
										href="deletar?id=<c:out value='${itens.id}' />">Deletar</a></td>
								</tr>
							</c:forEach>
						</thead>
					</table>
				</div>
			</div>
		</div>
	</div>

</body>
</html>