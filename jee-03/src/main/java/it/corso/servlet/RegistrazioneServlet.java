package it.corso.servlet;
import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import it.corso.service.ProdottoServiceRemote;

// localhost:8080/jee-03/registrazione
@WebServlet("/registrazione")
public class RegistrazioneServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
	
	@EJB
	private ProdottoServiceRemote prodottoServiceRemote;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		request
		.getServletContext()
		.getRequestDispatcher("/WEB-INF/view/registrazione.jsp")
		.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		prodottoServiceRemote.registraProdotto(
				request.getSession(), 
				request.getParameter("id"),
				request.getParameter("descrizione"),
				request.getParameter("prezzo"));
		response.sendRedirect("/jee-03");
	}
}