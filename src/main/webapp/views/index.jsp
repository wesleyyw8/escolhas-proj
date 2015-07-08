<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>Cadastro de Clientes</title>
<link rel="stylesheet" href="<c:url value="/assets/css/bootstrap.min.css" />">
<script src="<c:url value="/assets/js/jquery-1.11.1.min.js" />"></script>
<script src="<c:url value="/assets/js/my-script.js" />"></script>
</head>
<body>
	<h2>Cadastro de Clientes</h2>
	<br />
	<input type="text" id="nome" class="form-control">
	<br />
	<input type="number" id="idade" class="form-control">
	<br />
	<c:if test="${profession}">
		<input type="text" id="profession" class="form-control">
		<br />
	</c:if>
	<button type="button"
		onclick="saveClient()" class="btn btn-primary">Cadastrar!</button>
	<br />
	<jsp:include page="result.jsp"></jsp:include>
</body>
</html>
