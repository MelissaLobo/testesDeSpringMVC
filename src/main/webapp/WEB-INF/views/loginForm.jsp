<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>
</head>
<body>

<div align="center"><h3><a href="http://localhost:8080/index">Inicio</a></h3></div>

	<c:if test="${not empty erro}"> ${erro}<br /></c:if>
	
	
	<form:errors path="usuario"/>
	
	
	<h3>Login:</h3>
	<form action="http://localhost:8080/login" method="POST">
		Email:<input type="text" name="email" /> 
		Senha:<input type="password" name="senha" /> 
		<input type="submit" value="efetuar login" />
	</form>
	

<div align="center"><a href="http://localhost:8080/formCadastro">Cadastre-se</a></div>
</body>
</html>