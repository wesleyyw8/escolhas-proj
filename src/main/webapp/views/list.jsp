<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script src="<c:url value="/assets/js/my-script.js" />"></script>
<script>

var lista = new Array();

<c:forEach items="${lista}" var="entry" varStatus="provinceStatus">
lista.push({
	idade: '${entry.age}',
	nome: '${entry.name}',
	profissao: '${entry.profession}'
});
   
</c:forEach>
console.log(lista);
</script>
</head>
<body>

<c:forEach var="entry" items="${lista}">
Name:  ${entry.name} <br/>
idade: ${entry.age} <br/>
</c:forEach>
</body>
</html>