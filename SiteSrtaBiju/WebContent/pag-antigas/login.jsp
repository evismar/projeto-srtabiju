<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
</head>
<script type="text/javascript">
	function submeterFormulario(pAcao) {
		
		document.form_principal.acao.value = pAcao;

		document.form_principal.submit();
	}
</script>
<body>
	<form id="form_principal" name="form_principal"
		action="servletLogin" method="post">
		<input type="hidden" id="acao" name="acao" value="" />
						<div align="center">
		<h1>Login</h1>
		<br />
	</div>
	<div align="center">
		<table>
			<tbody>


				<tr>
					<td>Login:</td>
					<td><input type="text" name="login" /><br /></td>
				</tr>

				<tr>
					<td>Senha:</td>
					<td><input type="text" name="senha" /><br /></td>
				</tr>

			</tbody>
		</table>
		</div>
		<div align="center">
		<input type="button" onclick="submeterFormulario('login')"
			value="Login" /> <input type="button"
			onclick="submeterFormulario('cancelar')" value="Cancelar" /> 


		<input type="reset" value="Limpar" />
</div>

	</form>

</body>
</html>