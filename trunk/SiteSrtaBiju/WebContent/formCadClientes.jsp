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
<title>Cadastro</title>
</head>
<script type="text/javascript">
	function submeterFormulario(pAcao) {

		document.form_principal.acao.value = pAcao;
		if (pAcao == "inserir") {
			if (document.form_principal.nome.value == "") {
				window.alert('Nome do Cliente obrigatório');
				return;
			}
		}
		//....

		document.form_principal.submit();
	}
</script>
<body>

	<form id="form_principal" name="form_principal"
		action="controladordeclientes" method="post">
		<input type="hidden" id="acao" name="acao" value="" />
		<h1>Dados Cadastrais</h1>
		<br />

		<table>
			<tbody>


				<tr>
					<td>Nome:</td>
					<td><input type="text" name="nome" /><br /></td>
				</tr>

				<tr>
					<td>CPF:</td>
					<td><input type="text" name="cpf" /><br /></td>
				</tr>
				<tr>
					<td>Email:</td>
					<td><input type="text" name="email" /><br /></td>
				</tr>
				<tr>
					<td>Telefone:</td>
					<td><input type="text" name="telefone" /><br /></td>
				</tr>
				<tr>
					<td>Celular:</td>
					<td><input type="text" name="celular" /><br /></td>
				</tr>
				<tr>
					<td>Data Nascimento:</td>
					<td><input type="text" name="dataNascimento" /><br /></td>
				</tr>
				<tr>
					<td>Login:</td>
					<td><input type="text" name="login" /><br /></td>
				</tr>
				<tr>
					<td>Senha:</td>
					<td><input type="password" name="senha" /><br /></td>
				</tr>

				<tr>
					<td>Rua:</td>
					<td><input type="text" name="rua" /><br /></td>
				</tr>
				<tr>
					<td>Número:</td>
					<td><input type="text" name="numero" /><br /></td>
				</tr>
				<tr>
					<td>Complemento:</td>
					<td><input type="text" name="complemento" /><br /></td>
				</tr>
				<tr>
					<td>Bairro:</td>
					<td><input type="text" name="bairro" /><br /></td>
				</tr>
				<tr>
					<td>Cidade:</td>
					<td><input type="text" name="cidade" /><br /></td>
				</tr>
				<tr>
					<td>Estado:</td>
					<td><input type="text" name="estado" /><br /></td>
				</tr>
				<tr>
					<td>CEP:</td>
					<td><input type="text" name="cep" /><br /></td>
				</tr>

			</tbody>
		</table>
		<input type="button" onclick="submeterFormulario('inserir')"
			value="Inserir" /> <input type="button"
			onclick="submeterFormulario('excluir')" value="Excluir" /> <input
			type="button" onclick="submeterFormulario('alterar')" value="Alterar" />


		<input type="reset" value="Limpar" />


		<h1>TODOS OS CLIENTES CADASTRADOS</h1>

	<table>
	<tbody>
	<c:forEach var="cliente" items = "${lista_clientes}">
	<tr>
	<td>Nome: ${cliente.nome}</td>
	<td>CPF: ${cliente.cpf}</td>
	<td>Email: ${cliente.email}</td>
	</tr>
	</c:forEach>
	</tbody>
	</table>

		<h2>Data e hora</h2>
		<%
	
	out.println(new SimpleDateFormat("dd/MM/yyyy - HH:mm:ss").format(new java.util.Date()));
	
	%>

	
	</form>
</body>
</html>