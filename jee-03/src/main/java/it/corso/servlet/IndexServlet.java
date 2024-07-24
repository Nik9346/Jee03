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

// localhost:8080/jee-03
@WebServlet("/")
public class IndexServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
	
	@EJB //particolare classe java che implementa metodi atti a soddisfare la logica di business di un'applicazione, deve gestire: Persistenza, Concorrenza, Sicurezza.
	private ProdottoServiceLocal prodottoServiceLocal;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		if(request.getParameter("id") != null) //se nella richiesta che arriva abbiamo un parametro richiesta id, invochiamo elimina prodotto
			prodottoServiceLocal.eliminaProdotto(request.getSession(), 
					Integer.parseInt(request.getParameter("id")));
		
		List<Prodotto> prodotti = prodottoServiceLocal.getProdotti(
									request.getSession());
									request.setAttribute("prodotti", prodotti);
		request
		.getServletContext()
		.getRequestDispatcher("/WEB-INF/view/index.jsp")
		.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		doGet(request, response);
	}
}