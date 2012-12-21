package br.com.projeto.hibernate.servlets;

import java.io.IOException;
//import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
@WebServlet("/servletLogin")
public class ServletLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletLogin() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		try {

			// String acao = request.getParameter("acao");

			String login = request.getParameter("login");
			String senha = request.getParameter("senha");

			DAOCliente dao = (DAOCliente) DAOFactory.getInstancia()
					.getDAOClientes();
			Cliente logado = dao.buscarClientePorLoginESenha(login, senha);

			if (logado != null) {
				// invalida a sessão anterior
				request.getSession().invalidate();
				// cria uma nova sessão e insere o usuário na mesma
				request.getSession(true).setAttribute("usuario_logado", logado);

				if (logado.getGestor() > 0) {
					response.sendRedirect("pagIniGestor.jsp");
					
				} else {

					response.sendRedirect("pagIniCliente.jsp");
				}
			} else {
				response.sendRedirect("login.jsp");

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
