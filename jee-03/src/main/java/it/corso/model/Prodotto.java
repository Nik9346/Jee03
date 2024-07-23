package it.corso.model;

public class Prodotto
{ 	
	//attributi dell'oggetto
	private int id;
	private String descrizione;
	private double prezzo;
	
	//getter e setter
	public int getId()
	{
		return id;
	}
	public void setId(int id)
	{
		this.id = id;
	}
	public String getDescrizione()
	{
		return descrizione;
	}
	public void setDescrizione(String descrizione)
	{
		this.descrizione = descrizione;
	}
	public double getPrezzo()
	{
		return prezzo;
	}
	public void setPrezzo(double prezzo)
	{
		this.prezzo = prezzo;
	}
}