package br.com.projeto.hibernate.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.projeto.hibernate.dao.*;
import br.com.projeto.hibernate.entidades.*;

/**
 * Servlet implementation class ServletTransicaoPaginas
 */
@WebServlet("/paginascontroller")
public class ServletTransicaoPaginas extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletTransicaoPaginas() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String acao = request.getParameter("acao");
		
		if (acao.equalsIgnoreCase("1")) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("formCadClientes.jsp");
			
			dispatcher.forward(request, response);
	
		}
		if (acao.equalsIgnoreCase("2")) {
			DAOCategoria dao = (DAOCategoria) DAOFactory.getInstancia().getDAOCategorias();
			List<Categoria> lista = dao.listarTodos();
			request.setAttribute("lista_categorias", lista);

			
			RequestDispatcher dispatcher = request.getRequestDispatcher("formCadProdutos.jsp");
			dispatcher.forward(request, response);
	
		}
		if (acao.equalsIgnoreCase("3")) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("formCadCategorias.jsp");
			
			dispatcher.forward(request, response);
	
		}
		
		
	}


}
