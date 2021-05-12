<!DOCTYPE html>
<%@page import="br.com.teste.Cliente"%>
<%@page import="java.util.List"%>
<html>
<head>
<meta charset="UTF-8">
<title>tela cadastro de cliente</title>
<script>

	function confirma(pi){
		
		if (window.confirm("tem certeza que deseja excluir?"))
		location.href="cliente?i="+pi+"&acao=exc"
	 }


</script>


</head>


<body>

<div>
	<%
		if (request.getAttribute("reqMensagem") != null){
			out.print(request.getAttribute("reqMensagem"));
		}
	
	Cliente cli = (Cliente) request.getAttribute("cli");
	Object iCli = request.getAttribute("iCli");
	
	%>
</div>

<form method="post" action="cliente">

	<input type="hidden" name="i" value="<%=iCli%>"/>
	E- mail:
	<input type="text" value="<%=cli.getEmail()%>" name="email" />
	<input type="submit" value="save"/>

</form>


<%
//o obg request vem como OBJ e temos que transformar-lo pra List
List<Cliente> listaJsp = (List<Cliente>)request.getAttribute("listaReq");
int i =0;
for (Cliente c: listaJsp){
// 	detalhe que ao chamar como referência uma função js precisa expecificar (javascript:) pq se n vai fazer uma requisição ao servidor
%>  


	<%=c.getEmail()%>  
	<a href="javascript:confirma (<%=i%>)"> excluir</a>
	<a href="cliente?i=<%=i%>&acao=edit"> editar</a> <br>
<%
	i++;
}
%>




</body>
</html>