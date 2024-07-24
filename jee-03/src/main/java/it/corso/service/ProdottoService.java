package it.corso.service;
import java.util.ArrayList;
import java.util.List;
import it.corso.model.Prodotto;
import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateless;
import jakarta.servlet.http.HttpSession;

//per aggiungere un ejb dobbiamo andare su crea other e digitare ejb, noi abbiamo scelto SessionBean
@Stateless  //ejb di tipo stateless
@LocalBean
public class ProdottoService implements ProdottoServiceRemote, ProdottoServiceLocal  //normale classe java che implementa le due interfacce create con la creazione dell'ejb
{
	@SuppressWarnings("unchecked")
	@Override
	public void registraProdotto(HttpSession session, String... datiForm)
	{
		List<Prodotto> prodotti = session.getAttribute("prodotti") == null ? 
				new ArrayList<>() : (List<Prodotto>) session.getAttribute("prodotti"); //prendiamo l'attributo prodotti dalla sessione, se è null, generiamo un new ArrayList di prodotti, altrimenti generiamo una List Prodotti ottenuti dalla Session
		try
		{
			Prodotto prodotto = new Prodotto();
			prodotto.setId(Integer.parseInt(datiForm[0]));
			prodotto.setDescrizione(datiForm[1]);
			prodotto.setPrezzo(Double.parseDouble(datiForm[2]));
			prodotti.add(prodotto);
			session.setAttribute("prodotti", prodotti); //Settiamo l'attributo nella session con nome prodotti e contenuto l'array dei prodotti.
		} catch (Exception e)
		{
			System.out.println(e.getMessage()); //ci stampiamo il messaggio di eccezione
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Prodotto> getProdotti(HttpSession session)
	{
		if(session.getAttribute("prodotti") != null) //se la sessione non è vuota andiamo a ritornare la lista presa dall'attributo
			return (List<Prodotto>) session.getAttribute("prodotti");
		return new ArrayList<Prodotto>(); //altrimenti ritorniamo una new ArrayList.
	}

	@SuppressWarnings("unchecked")
	@Override
	public void eliminaProdotto(HttpSession session, int id)
	{
		List<Prodotto> prodotti = (List<Prodotto>) session.getAttribute("prodotti"); //recuperiamo dalla sessione la lista dei prodotti
		prodotti = prodotti //filtriamo la lista dei prodotti escludendo dalla lista il prodotto con l'id indicato per eliminarlo
				.stream()
				.filter(p -> p.getId() != id)
				.toList();
		session.setAttribute("prodotti", prodotti); //salviamo la nuova lista prodotti filtrata dell'elemento eliminato sulla sessione
	}
}