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
	
	@EJB //particolare classe java che implementa metodi atti a soddisfare la logica di business di un'applicazione, deve gestire: Persistenza, Concorrenza, Sicurezza.
	private ProdottoServiceRemote prodottoServiceRemote; // ci agganciamo in remoto questo componente (Attenzione alla blacklist system.properties, se mettiamo in tomee.serialization.class.blacklist = - al posto di * escludiamo tutto)
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		request
		.getServletContext()
		.getRequestDispatcher("/WEB-INF/view/registrazione.jsp") //deleghiamo la richiesta al file jsp
		.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		prodottoServiceRemote.registraProdotto( // recuperiamo tutti i parametri passati in post dal fomr e li registriamo
				request.getSession(), 
				request.getParameter("id"),
				request.getParameter("descrizione"),
				request.getParameter("prezzo"));
		response.sendRedirect("/jee-03");
	}
}