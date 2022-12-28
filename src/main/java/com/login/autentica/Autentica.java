package com.login.autentica;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.login.models.User;

/**
 * Servlet implementation class Autentica
 */
@WebServlet(name="Login", urlPatterns = {"/login"} )
public class Autentica extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Autentica() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @throws IOException 
	 * @throws ServletException 
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void solicitacao(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		List<String> erros = new ArrayList<String>();
		System.out.println("Entrei aqui");
			System.out.println("Passei no botao");
			String uname = request.getParameter("uname");
			String pass = request.getParameter("pass");
		if(uname == null || uname.isEmpty()) {
			erros.add("Usuario vazio");
		}
		if(pass == null || uname.isEmpty()) {
			erros.add("Senha vazia");
		}
		if(erros.size() == 0) {
			User u = new User();
			u.setId(0);
			u.setUser("admin");
			u.setPass("1234");
			if(u != null) {
			if(u.getPass().equalsIgnoreCase(pass)) {
				request.getSession().setAttribute("autenticado", u);
				response.sendRedirect("auth/menu");
				return;
			}else {
				erros.add("Senha invalida");
			}
			}

		}
		request.getSession().invalidate();
		request.setAttribute("erros", erros);
		RequestDispatcher rdisp = request.getRequestDispatcher("/index.jsp");
		rdisp.forward(request, response);
    }

		

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	solicitacao(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	solicitacao(request, response);
	}

}
