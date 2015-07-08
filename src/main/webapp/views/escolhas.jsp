<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="../assets/css/icones.css">
<link rel="stylesheet" type="text/css" href="../assets/css/escolhas.css">

<script src="<c:url value="/assets/js/jquery-1.11.1.min.js" />"></script>
<script src="<c:url value="/assets/js/my-script.js" />"></script>
<script>
var _self = this;
_self.lista = new Array();
_self.currentItem = 0;
<c:forEach items="${listaLivros}" var="entry" varStatus="count">
lista.push('${entry.titulo}');
</c:forEach>
</script>
</head>
<body>
<div class="quadro">
	<div class="quadroDentroEsquerda quadroDentro">
		<div class="tituloLivro" >
			<span></span>
			<div class="posicao"></div>
		</div>
		<div class="imgEsquerda"></div>
		<div class="btn">
			<button type="button">Prefiro esse!</button>
		</div>
	</div>
	<div class="versus"><i class="demo-icon icon-cancel">&#xe803;</i></div>
	<div class="quadroDentroDireita quadroDentro">
		<div class="tituloLivro">
			<span></span>
			<div class="posicao"></div>
		</div>
		<div class="imgDireita"></div>
		<div class="btn">
			<button type="button">Prefiro esse!</button>
		</div>
	</div>
</div>
<script>
	populaTela();
</script>
</body>
</html>