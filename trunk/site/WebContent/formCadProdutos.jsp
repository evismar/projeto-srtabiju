
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
<title>Cadastro Produto</title>
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
		action="produtoscontroller" method="post">
		<input type="hidden" id="acao" name="acao" value="" />
		<h1>Dados do Produto</h1>
		<br />

		<table>
			<tbody>


				<tr>
					<td>Nome:</td>
					<td><input type="text" name="nome" /><br /></td>
				</tr>

				<tr>
 				<td>Categoria:</td>
					<td><SELECT name = "categoria" id = "categoria" style="width: 150px" title = "Selecione uma categoria">
						<c:forEach var="categoria" items = "${lista_categorias}">
							<option value="${categoria.nome}">${categoria.nome}</option>
						
						</c:forEach>

					</SELECT>	
				</tr>
				<tr>
					<td>Valor: R$</td>
					<td><input type="text" name="valor" /><br /></td>
				</tr>
				<tr>
					<td>Descrição:</td>
					<td><input type="text" name="descricao" /><br /></td>
				</tr>
				<tr>

			</tbody>
		</table>
		<input type="button" onclick="submeterFormulario('inserir')"
			value="Inserir" /> 


		<input type="reset" value="Limpar" />






	
	</form>
</body>
</html>