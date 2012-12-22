<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Pagina Inicial</title>
</head>
<script type="text/javascript">

function getComboBox()

{

	
acao = document.form_principal.comboBoxMenu.value;
document.form_principal.acao.value = acao;
document.form_principal.submit();





}

</script>




<body>
	<form id="form_principal" name="form_principal" action="paginascontroller" method="post">
		<input type="hidden" id="acao" name="acao" value="" />


		<div align="center">
			<h1>Página inicial</h1>
			<br />
			<h3>Gestor</h3>

		</div>



Cadastro: <select name="comboBoxMenu">

<option value="1">Clientes</option>

<option value="2">Produtos</option>

<option value="3">Categorias</option>

</select>

</form>



<button onclick="getComboBox()">Ok</button>

</body>

</html>
