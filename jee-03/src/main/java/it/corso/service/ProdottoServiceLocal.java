package it.corso.service;

import java.util.List;

import it.corso.model.Prodotto;
import jakarta.ejb.Local;
import jakarta.servlet.http.HttpSession;

@Local
public interface ProdottoServiceLocal {

	
	List<Prodotto> getProdotti(HttpSession session);
	
	void eliminaProdotto(HttpSession session, int id);
}
