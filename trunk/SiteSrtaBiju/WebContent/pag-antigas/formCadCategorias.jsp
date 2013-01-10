<%@page import="java.text.SimpleDateFormat"%>
<%@page import="br.com.projeto.hibernate.entidades.Cliente, java.util.*"%>
<%@page import="br.com.projeto.hibernate.dao.*"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri = "http://java.sun.com/jsp/jstl/functions"%>




<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadastro Categorias</title>
</head>
<script type="text/javascript">
	function submeterFormulario(pAcao) {

		document.form_principal.acao.value = pAcao;
		if (pAcao == "inserir") {
			if (document.form_principal.nome.value == "") {
				window.alert('Nome do Produto obrigatório');
				return;
			}
		}
		//....

		document.form_principal.submit();
	}
</script>
<body>

	<form id="form_principal" name="form_principal"
		action="categoriacontroller" method="post">
		<input type="hidden" id="acao" name="acao" value="" />
		<h1>Dados da Categoria</h1>
		<br />

		<table>
			<tbody>


				<tr>
					<td>Nome:</td>
					<td><input type="text" name="nome" /><br /></td>
				</tr>

				<tr>

					<td>Descrição:</td>
					<td><input type="text" name="descricao" /><br /></td>
				</tr>
				<tr>

			</tbody>
		</table>
		<input type="button" onclick="submeterFormulario('inserir')"
			value="Inserir" /> <input type="button"
			onclick="submeterFormulario('excluir')" value="Excluir" /> <input
			type="button" onclick="submeterFormulario('alterar')" value="Alterar" />


		<input type="reset" value="Limpar" />


		<h1>TODOS AS CATEGORIAS CADASTRADAS</h1>
<!--  
	<table>
	<tbody>
	<c:forEach var="cliente" items = "${lista_clientes}">
	<tr>
	<td>Nome: ${cliente.nome}</td>
	<td>Nome: ${cliente.cpf}</td>
	<td>Nome: ${cliente.email}</td>
	</tr>
	</c:forEach>
	</tbody>
	</table>

		<h2>Data e hora</h2>
-->
		<%
	
	out.println(new SimpleDateFormat("dd/MM/yyyy - HH:mm:ss").format(new java.util.Date()));
	
	%>

	
	</form>
</body>
</html>