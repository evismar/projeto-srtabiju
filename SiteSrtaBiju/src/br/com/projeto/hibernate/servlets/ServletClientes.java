package br.com.projeto.hibernate.servlets;

import java.io.IOException;
//import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

//import java.text.SimpleDateFormat;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.projeto.hibernate.dao.*;
import br.com.projeto.hibernate.entidades.*;

//import java.util.List;
/**
 * Servlet implementation class ServletClientes
 */
@WebServlet("/controladordeclientes")
public class ServletClientes extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletClientes() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
			try{

				Cliente cliente = null;
				Endereco endereco = null;
				
				DAOEndereco dao2 = (DAOEndereco) DAOFactory.getInstancia().getDAOEnderecos();
				DAOCliente dao = (DAOCliente) DAOFactory.getInstancia().getDAOClientes();
				String acao = request.getParameter("acao");
				
				
				
				
				
				if (acao.equalsIgnoreCase("inserir")) {
					
					endereco = getDadosEndereco(request);
					dao2.salvar(endereco);
					cliente = getDadosCliente(request);
					dao.salvar(cliente);
					cliente.setEndereco(endereco);
					System.out.println(cliente.getCpf());
					enviarLista(request, response, dao);
				}
				
				if (acao.equalsIgnoreCase("excluir")){
					String id = request.getParameter("cliente_selecionado");
					cliente = dao.buscar(new Integer(id));
					dao.remover(cliente);

				}
				
				if (acao.equalsIgnoreCase("alterar"))
					cliente = getDadosCliente(request);
					dao.alterar(cliente);

					

				
				
			}
			catch (Exception e){
				e.printStackTrace();
			}
		
		
		
		
		

		

		

		
	}

	private Endereco getDadosEndereco(HttpServletRequest request) {
		Endereco endereco;
		endereco = new Endereco();
		endereco.setBairro(request.getParameter("bairro"));
		endereco.setCep(request.getParameter("cep"));
		endereco.setCidade(request.getParameter("cidade"));
		endereco.setComplemento(request.getParameter("complemento"));
		endereco.setEstado(request.getParameter("estado"));
		endereco.setNumero(request.getParameter("numero"));
		endereco.setRua(request.getParameter("rua"));
		
		return endereco;
	}

	private Cliente getDadosCliente(HttpServletRequest request)
			throws ParseException {
		Cliente cliente;
		cliente = new Cliente();
		cliente.setNome(request.getParameter("nome"));
		cliente.setCpf(request.getParameter("cpf"));
		cliente.setDataNascimento(new SimpleDateFormat("dd/MM/yyyy").parse(request.getParameter("dataNascimento")));
		cliente.setCelular(request.getParameter("celular"));
		cliente.setEmail(request.getParameter("email"));
		cliente.setLogin(request.getParameter("login"));
		cliente.setSenha(request.getParameter("senha"));
		cliente.setTelefone(request.getParameter("telefone"));
		
		return cliente;
	}
		
		
		private void enviarLista(HttpServletRequest request, HttpServletResponse response, DAOCliente dao)
				throws ServletException, IOException{
		
			List<Cliente> lista = dao.listarTodos();
			request.setAttribute("lista_clientes", lista);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("formCadClientes.jsp");
			
			dispatcher.forward(request, response);
		}



}
