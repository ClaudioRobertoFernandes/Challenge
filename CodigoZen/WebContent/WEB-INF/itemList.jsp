<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Desafio Zen</title>
</head>
<body>
	<center>
		<h1>Lista de Peças</h1>
		<h2>
			<a href="new">Adicionar novo item</a> &nbsp;&nbsp;&nbsp;&nbsp; <a
				href="list">Listar todas os itens</a>
		</h2>
	</center>
	<div align="center">
		<table>
			<caption>
				<h2>Lista de Peças</h2>
			</caption>
			<tr>
				<th>Id</th>
				<th>Nome</th>
				<th>Veiculo de Aplicação</th>
				<th>Peso Liquiddo</th>
				<th>Peso Bruto</th>
			</tr>
			<c:forEach var="itens" items="${listItem}">
				<tr>
					<td><c:out value="${itens.id}" /></td>
					<td><c:out value="${itens.name}" /></td>
					<td><c:out value="${itens.vehicleAply}" /></td>
					<td><c:out value="${itens.pesoLiquido}" /></td>
					<td><c:out value="${itens.pesoBruto}" /></td>
					<td><a href="editar?id=<c:out value='${itens.id}' />">Editar</a>
						&nbsp;&nbsp;&nbsp;&nbsp; 
						<a href="deletar?id=<c:out value='${itens.id}' />">Deletar</a></td>
				</tr>
			</c:forEach>
		</table>

	</div>
</body>
</html>