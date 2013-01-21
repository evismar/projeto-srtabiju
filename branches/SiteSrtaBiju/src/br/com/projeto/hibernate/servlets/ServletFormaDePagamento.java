package br.com.projeto.hibernate.servlets;

import java.io.IOException;
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
@WebServlet("/ServletFormaDePagamento")
public class ServletFormaDePagamento extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletFormaDePagamento() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
			try{
				FormaDePagamento forma = null;
				
				DAOFormaDePagamento dao = (DAOFormaDePagamento) DAOFactory.getInstancia().getDAOFormasDePagamentos();
				String acao = request.getParameter("acao");
				
				
			if (acao.equalsIgnoreCase("inserir")) {
				
				
				forma = new FormaDePagamento();
				
				forma.setFormaDePagamento(request.getParameter("formaDePagamento"));
				forma.setVezes(request.getParameter("vezes"));
				dao.salvar(forma);
				
				
				

			}
			
			if (acao.equalsIgnoreCase("excluir")){

				dao.remover(forma);
			}
			
			if (acao.equalsIgnoreCase("alterar")){

				dao.alterar(forma);
			
			
		}
			}
			catch(Exception e){
				
			}
		
	}

}
