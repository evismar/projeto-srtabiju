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
 * Servlet implementation class ServletFormaDePagamento
 */
@WebServlet("/produtoscontroller")
public class ServletProduto extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletProduto() {
        super();
        // TODO Auto-generated constructor stub
    }

    
	private void enviarListaCategorias(final HttpServletRequest request, final HttpServletResponse response, final DAOCategoria dao) throws ServletException, IOException{
		
		List<Categoria> lista = dao.listarTodos();
		request.setAttribute("lista_categorias", lista);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("formCadCategorias.jsp");
		
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
			try{
				Produto produto = null;
				
				DAOProduto dao = (DAOProduto) DAOFactory.getInstancia().getDAOProdutos();
				String acao = request.getParameter("acao");
				
				
			if (acao.equalsIgnoreCase("inserir")) {
				
				
				produto = new Produto();
			//	float valor = Float.valueOf("10.2");
				System.out.println(request.getParameter("descricao"));
				System.out.println(request.getParameter("nome"));
				System.out.println(request.getParameter("valor"));
				System.out.println(request.getParameter("categoria"));
				

				produto.setDescricao(request.getParameter("descricao"));
				produto.setPreco(request.getParameter("nome"));
				produto.setPreco(request.getParameter("valor"));
				produto.setPreco(request.getParameter("categoria"));
				


				
				

				dao.salvar(produto);
				
				
				

			}
			
			if (acao.equalsIgnoreCase("excluir")){

				dao.remover(produto);
			}
			
			if (acao.equalsIgnoreCase("alterar")){

				dao.alterar(produto);
			
			
		}
			}
			catch(Exception e){
				
			}
		
	}

}
