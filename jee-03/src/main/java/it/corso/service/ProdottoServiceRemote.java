package it.corso.service;
import jakarta.ejb.Remote;
import jakarta.servlet.http.HttpSession;

@Remote
public interface ProdottoServiceRemote 
{
	void registraProdotto(HttpSession session, String... datiForm); //funzione che ci permette la registrazione di un prodotto accettato un array varargs di String
}