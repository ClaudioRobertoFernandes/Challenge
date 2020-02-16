<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isErrorPage="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Algo deu Errado</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
</head>
<body class="p-3 mb-2 bg-info text-white">
	<div class="container p-3 mb-2 bg-light text-dark">
		<div align="center">
			<h1>Ah! Desculpa Algo deu Errado</h1>
			<h2 id="err"><%=exception.getMessage()%></h2>
			<h3>Ou verifique se</h3>
			<h3> O valor de Peso Liquido é Menor que Peso Bruto</h3>
			<div>
				<input type="button" class="btn btn-primary" value="Voltar"
					onClick="history.go(-1)">
			</div>
		</div>

	</div>
</body>
</html>