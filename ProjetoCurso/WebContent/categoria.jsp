<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadastro</title>
</head>
<script type="text/javascript">
	function submeterFormulario(pAcao) {
		
		document.form_principal.acao.value = pAcao;

		document.form_principal.submit();
	}
</script>
<body>
	<form id="form_principal" name="form_principal"
		action="ServletCategoria" method="post">
		<input type="hidden" id="acao" name="acao" value="" />
		<h1>Categoria</h1>
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

			</tbody>
		</table>
		<input type="button" onclick="submeterFormulario('inserir')"
			value="Inserir" /> <input type="button"
			onclick="submeterFormulario('excluir')" value="Excluir" /> <input
			type="button" onclick="submeterFormulario('alterar')" value="Alterar" />


		<input type="reset" value="Limpar" />


	</form>
</body>
</html>