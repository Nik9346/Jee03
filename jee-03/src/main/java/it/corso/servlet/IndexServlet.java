package it.corso.servlet;

import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import it.corso.model.Prodotto;
import it.corso.service.ProdottoServiceLocal;


@WebServlet("/")
public class IndexServlet extends HttpServlet {
	
	@EJB
	private ProdottoServiceLocal prodottoServiceLocal;
		
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(request.getParameter("id") != null)
			prodottoServiceLocal.eliminaProdotto(request.getSession(), Integer.parseInt(request.getParameter("id"))); // se la richiesta di id non è vuota, andiamo a parsare l'id in integer in quanto il ritorno di request è sempre una stringa
		List<Prodotto> prodotti = prodottoServiceLocal.getProdotti(request.getSession());
		request.setAttribute("prodotti", prodotti);
		
		request
		.getServletContext()
		.getRequestDispatcher("/WEB-INF/view/index.jsp")
		.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
