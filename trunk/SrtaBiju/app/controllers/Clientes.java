package controllers;

import play.*;
import play.mvc.*;
import play.data.validation.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

import models.*;

public class Clientes extends Application {

	@Before
	static void checaCliente() {
		if (connected() == null) {
			flash.error("Por favor, realize o Login primeiro.");
			Application.index_cliente();
		}
	}

	public static void clienteLogado() {
		Pessoa cliente = connected();
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Date date = new Date();
		String data = dateFormat.format(date);
		Integer size = 6;
		boolean pedidoEmAberto = false;
		String valorTotalPedido = null;
		Long idPedido = null;

		List<Produto> produtos = null;
		List<Produto> produtosPedidos = null;
		List<ItemDesejado> itensPedidos = null;
		List nomesProdutos = new ArrayList<>();
		List idsProdutos = new ArrayList<>();
		List quantidades = new ArrayList<>();
		List valores = new ArrayList<>();
		List valoresUnitarios = new ArrayList<>();
		List valoresItens = new ArrayList<>();
		List contador = new ArrayList<>();
		List contadorPedidos = new ArrayList<>();
		produtos = Produto.find("order by id desc, id").fetch(size);
		Integer i = 0;
		for (Produto produto : produtos) {

			String valor = floatToString(produto.valor);
			valores.add(valor);
			contador.add(i);
			i = i + 1;
		}

		Pedido pedido = Pedido.find("byCliente_idAndStatus", cliente.id,
				"aberto").first();
		if (pedido != null) {
			pedidoEmAberto = true;
			valorTotalPedido = floatToString(pedido.valorTotal);

			itensPedidos = ItemDesejado.find("byPedido_id", pedido.id).fetch();
			Integer a = 0;
			for (ItemDesejado item : itensPedidos) {

				String valorUnitario = floatToString(item.valorNaHoraPedido);
				String valorItem = floatToString(item.valorNaHoraPedido
						* item.quantidade);
				valoresUnitarios.add(valorUnitario);
				valoresItens.add(valorItem);
				contadorPedidos.add(a);

				Produto produtoDaLista = Produto.findById(item.produto.id);
				idsProdutos.add(item.id);
				nomesProdutos.add(produtoDaLista.nome);
				quantidades.add(item.quantidade);
				a = a + 1;

			}

			idPedido = pedido.id;
		}

		render(produtos, valores, contador, cliente, data, pedidoEmAberto,
				valorTotalPedido, valoresUnitarios, valoresItens,
				contadorPedidos, produtosPedidos, nomesProdutos, quantidades, idsProdutos, idPedido);

	}

	public static String floatToString(float valorFloat) {
		String valor = Float.toString(valorFloat);

		valor = valor.replace(".", ",");
		String[] split = valor.split(",");
		String centavos = split[1];
		if (centavos.length() < 2) {
			valor = valor + "0";
		}

		if (centavos.length() > 2) {
			valor = split[0] + "," + centavos.substring(0, 2);
		}
		return valor;
	}

	public static void salvarCadastro(@Valid Cliente cliente,
			String confirmaSenha) {

		// Verifica se as senhas estão combinado
		validation.required(cliente.senha);
		validation.required(confirmaSenha);
		validation.equals(cliente.senha, confirmaSenha).message(
				"Suas senhas não estão combinando");

		// Verifica Mínimo e Maximo de caracteres das senhas
		validation.minSize(cliente.senha, 4);
		validation.maxSize(cliente.senha, 12);

		// Verifica se o email é válido
		validation.email(cliente.email).message(
				"Email inválido, por favor, verifique seu email!");

		// Verifica se há Logins iguais

		Pessoa pessoa = Pessoa.find("usuario", cliente.usuario).first();
		if (pessoa != null) {

			validation.addError("usuario", "Nome de usuário já cadastrado!");
		}

		if (pessoa != null) {
			System.out.println(pessoa.email);

			validation.addError("email", "Email já cadastrado!");
		}

		// envia de volta ao formulario se houver erros..
		if (validation.hasErrors()) {
			params.flash();
			validation.keep();
			Application.cadCliente();
		}

		// Cadastra

		Date dataCadastro = new Date();
		cliente.dataCadastro = dataCadastro;
		cliente.quantidadeDeAcessos = cliente.quantidadeDeAcessos + 1;
		cliente.create();

		flash.success("Bem vindo, " + cliente.usuario);
		Application.login(cliente.usuario, cliente.senha);

	}

	public static void editCliente(Long id) {

		Cliente cliente = Cliente.findById(id);
		render(cliente);

	}

	public static void edita(Cliente cliente) {

		cliente.save();
		flash.success("Cadastro atualizado com sucesso!");
		Clientes.clienteLogado();

	}

	public static void listaClientes() {
		List<Cliente> clientes = Cliente.findAll();
		render(clientes);

	}

	public static void addProduto(Long idProduto, Integer quantidade) {
		Produto produto = Produto.findById(idProduto);
		Cliente cliente = (Cliente) connected();
		Pedido pedido = Pedido.find("byCliente_idAndStatus", cliente.id,
				"aberto").first();
		if (pedido == null) {
			Date dataCadastro = new Date();
			float valorTotal = quantidade * produto.valor;
			pedido = new Pedido(dataCadastro, "aberto", valorTotal);
			pedido.cliente = cliente;
			pedido.create();


		} else {
			pedido.valorTotal = pedido.valorTotal + quantidade * produto.valor;
			pedido.save();


		}

		ItemDesejado itemDesejado = new ItemDesejado(quantidade, produto.valor);
		itemDesejado.pedido = pedido;
		itemDesejado.produto = produto;
		itemDesejado.create();


		Produtos.listaProdutosCliente();

	}
	
	public static void excluiProduto(Long id){
		ItemDesejado item = ItemDesejado.findById(id);

		Pedido pedido = Pedido.findById(item.pedido.id);
		
		pedido.valorTotal = pedido.valorTotal - item.valorNaHoraPedido*item.quantidade;
		item._delete();
		pedido.save();
		flash.success("Item excluido com sucesso!");
		clienteLogado();
		
	}
	
	public static void finalizaPedido(Long id){
		
		Pedido pedido = Pedido.findById(id);
		pedido.status = "fechado";
		pedido.save();
		
		flash.success("Caixinha de desejos enviada com sucesso! Aguarde, logo logo entraremos em contato!");
		clienteLogado();
		
	}
}