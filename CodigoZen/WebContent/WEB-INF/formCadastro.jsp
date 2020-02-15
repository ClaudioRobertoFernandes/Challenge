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
		<c:if test="${item!=null}">
			<form action="update" method="post">
		</c:if>
		<c:if test="${item==null}">
			<form action="insert" method="post">
		</c:if>
		<table border="1" cellpadding="5">
			<caption>
				<h2>
					<c:if test="${item != null }">Editar Item</c:if>
					<c:if test="${item == null }">Adicionar novo item</c:if>
				</h2>
			</caption>
			<c:if test="${item!=null }">
				<input type="text" name="id" value="<c:out value='${item.id}' />" />
			</c:if>
			<tr>
				<th>Item:</th>
				<td><input type="text" name="name" size="100"
					value="<c:out value='${item.name}'/>" /></td>
			</tr>
			<tr>
				<th>Veiculo de Aplicação:</th>
				<td><input type="text" name="vehicle" size="200"
					value="<c:out value='${item.vehicleAply}'/>" /></td>
			</tr>
			<tr>
				<th>Peso Liquido:</th>
				<td><input type="text" name="netWeight" size="200"
					value="<c:out value='${item.pesoLiquido}'/>" /></td>
			</tr>
			<tr>
				<th>Peso Bruto:</th>
				<td><input type="text" name="grossWeight" size="200"
					value="<c:out value='${item.pesoBruto}'/>" /></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit"
					value="Salvar"/>
					</td>
			</tr>
			
		</table>
	</div>

</body>
</html>