package com.login.menu;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


import java.io.IOException;

import com.login.models.User;

/**
 * Servlet implementation class Menu
 */
@WebServlet(urlPatterns = {"/auth/menu"})
public class Menu extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Menu() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @throws IOException 
	 * @throws ServletException 
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
    protected void solicitacao(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	RequestDispatcher rdisp = request.getRequestDispatcher("/auth/menu.jsp");
    	User u = (User) request.getSession().getAttribute("autenticado");
    	request.setAttribute("usuario", u);
    	rdisp.forward(request, response);
    }
    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		solicitacao(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		solicitacao(request, response);
	}

}
