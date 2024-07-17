package it.corso.service;

import java.util.ArrayList;
import java.util.List;

import it.corso.model.Prodotto;
import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateless;
import jakarta.servlet.http.HttpSession;

@Stateless
@LocalBean
public class ProdottoService implements ProdottoServiceRemote, ProdottoServiceLocal {

	@SuppressWarnings("unchecked")
	@Override
	public void registraProdotto(HttpSession session, String... datiForm) {
		
		List<Prodotto> prodotti = session.getAttribute("prodotti") == null ? new ArrayList<>() : (List<Prodotto>) session.getAttribute("prodotti"); //se non c'è già l'attributo nella sessione andiamo a crearlo, altrimenti lo recuperiamo facendo il casting dell'object
		
		try {
			Prodotto prodotto = new Prodotto();
			prodotto.setId(Integer.parseInt(datiForm[0]));
			prodotto.setDescrizione(datiForm[1]);
			prodotto.setPrezzo(Double.parseDouble(datiForm[2]));
			prodotti.add(prodotto);
			session.setAttribute("prodotti", prodotti);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Prodotto> getProdotti(HttpSession session) {
		if(session.getAttribute("prodotti") != null) // se la lista presente nella sessione è diversa da null allora la ritorniamo
			return (List<Prodotto>) session.getAttribute("prodotti");
		return new ArrayList<Prodotto>(); // se non c'è iteriamo lo stesso su un array prodotto ma vuoto.
	}

	@Override
	public void eliminaProdotto(HttpSession session, int id) {
		@SuppressWarnings("unchecked")
		List<Prodotto> prodotti = (List<Prodotto>) session.getAttribute("prodotti");
		prodotti = prodotti.stream().filter(p ->p.getId() != id).toList();//aperto il flusso con lo stream passano il filtro solo i prodotti che hanno un id diverso rispetto a quello richiesto di cancellare
	session.setAttribute("prodotti", prodotti);
	}

  

}
