<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 <%@ taglib uri="http://www.springframework.org/tags/form" prefix="div" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Chamados</title>
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/style.css" rel="stylesheet">
</head>
<body>
<form action="listar_chamados_exibir" method="get">
<div class="jumbotron">
	<h3>${fila.nome}</h3>
	<table class= "table-table-striped">
	<tr>
		<th>Nome</th>
		<th>Descrição</th>
		<th>Status</th>
	</tr>
	<tr>
	<c:forEach var="chamado" items="${chamados}">
		<td>${chamado.nome}</td>
		<td>${chamado.descricao}</td>
		<td>${chamado.status}</td>
	</c:forEach>
	</tr>
	
	
	</table>
	
   <div class="col-md-12">
                    <a href="index" class="btn btn-default">Cancelar</a>
                </div>
</div>
</form>
    <script src="js/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>

</body>
</html>