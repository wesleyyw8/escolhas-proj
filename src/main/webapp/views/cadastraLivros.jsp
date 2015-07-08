<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script src="<c:url value="/assets/js/jquery-1.11.1.min.js" />"></script>
<script src="<c:url value="/assets/js/my-script.js" />"></script>
</head>
<body>
	Título: <input type="text" id="titulo">
	<button type="button"onclick="saveLivro()" >Cadastrar livro!</button>
</body>
</html>