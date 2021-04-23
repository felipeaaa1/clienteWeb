<!DOCTYPE html>
<%@page import="br.com.teste.Cliente"%>
<%@page import="java.util.List"%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>


<body>

<form method="post" action="cliente">

	E- mail:
	<input type="text" value="" name="email" />
	<input type="submit" value="save">

</form>


<%
//o obg request vem como OBJ e temos que transformar-lo pra List
List<Cliente> listaJsp = (List<Cliente>)request.getAttribute("listaReq");
for (Cliente c: listaJsp){
	out.print(c.getEmail()+"<br>");
}


%>




</body>
</html>