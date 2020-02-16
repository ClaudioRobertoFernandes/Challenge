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
		<div align="center">
			<div class="p-3 col-md-8 mb-2 text-white">
				<h1 class="text-secondary">Lista de Peças</h1>
				<h2>
					<a href="new">Adicionar novo item</a> &nbsp;&nbsp;&nbsp;&nbsp; <a
						href="list">Listar todos os itens</a>
				</h2>
			</div>
			<div class="p-3 col-md-8 mb-2 bg-info text-white">
				<c:if test="${item!=null}">
					<form action="update" method="post">
				</c:if>
				<c:if test="${item==null}">
					<form action="insert" method="post">
				</c:if>
				<c:if test="${item != null }">Editar Item</c:if>
				<c:if test="${item == null }">Adicionar novo item</c:if>

			</div>

			<!-- Inicio do formulario -->
			<div
				class="col-xs-8 col-sm-8 col-md-8 col-lg-8  col-xs-offset-2 col-sm-offset-2 col-md-offset-2 col-lg-offset-2 text-center ">
				<form class="needs-validation" novalidate>
					<c:if test="${item!=null }">
						<input type="hidden" name="id"
							value="<c:out value='${item.id}' />" />
					</c:if>
					<div class="form-row">
						<div class="col-md-12 mb-3">
							<label for="name">Item:</label> <input type="text"
								class="form-control" id="name" required name="name"
								value="<c:out value='${item.name}'/>"
								placeholder="Vela de Ignição,Disco de Freio,..." />
						</div>
					</div>
					<div class="form-row">
						<div class="col-md-12 mb-3">
							<label for="vehicle">Veículo de Aplicação:</label> <input
								class="form-control" type="text" id="vehicle"
								required="required" name="vehicle"
								value="<c:out value='${item.vehicleAply}'/>"
								placeholder="Gol, Uno,Civic,..." />
						</div>
					</div>
					<div class="form-row">
						<div class="col-md-12 mb-3">
							<label for="netWeight">Peso Líquido:</label> <input type="text"
								class="form-control" id="netWeight" required="required"
								name="netWeight" value="<c:out value='${item.pesoLiquido}'/>"
								placeholder="Digite apena Numeros ..." />
						</div>
					</div>
					<div class="form-row">
						<div class="col-md-12 mb-3">
							<label for="grossWeight">Peso Bruto:</label> <input type="text"
								class="form-control" id="grossWeight" required="required"
								name="grossWeight" value="<c:out value='${item.pesoBruto}'/>"
								placeholder="Digite apena Numeros ..." />
						</div>
					</div>
					<button class="btn btn-primary" type="submit">Salvar</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>
