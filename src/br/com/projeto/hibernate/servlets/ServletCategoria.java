package br.com.projeto.hibernate.servlets;

import java.io.IOException;

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
@WebServlet("/categoriacontroller")
public class ServletCategoria extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletCategoria() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    


	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
			try{
				Categoria categoria = null;
				
				DAOCategoria dao = (DAOCategoria) DAOFactory.getInstancia().getDAOCategorias();
				String acao = request.getParameter("acao");
				
				
			if (acao.equalsIgnoreCase("inserir")) {
				
				
				categoria = new Categoria();
				
				categoria.setDescricao(request.getParameter("descricao"));
				categoria.setNome(request.getParameter("nome"));
				dao.salvar(categoria);
				
				RequestDispatcher dispatcher = request.getRequestDispatcher("formCadCategorias.jsp");
				dispatcher.forward(request, response);
				
				
				

			}
			
			if (acao.equalsIgnoreCase("excluir")){

				dao.remover(categoria);
			}
			
			if (acao.equalsIgnoreCase("alterar")){

				dao.alterar(categoria);
			
			
		}
			}
			catch(Exception e){
				
			}
		
	}

}
