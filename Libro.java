package Anagrafiche;

public class Libro {
	
	private String titolo;
	private String autore;
	private String categoria;
	private double prezzo; 
	boolean letto;
	
	public Libro(String t, String a, String c, double p) {
		this.titolo = t;
		this.autore = a;
		this.categoria = c;
		this.prezzo = p;
		this.letto = false;
	}
	
	public Libro(String t, String a, String c, double p, boolean l) { //overloadin, stesso nome ma parametri diversi
		this(t, a, c, p);
		this.letto = l;
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public String getAutore() {
		return autore;
	}

	public void setAutore(String autore) {
		this.autore = autore;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public double getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
		
	}

	public boolean isLetto() {
		return letto;
	}

	public void setLetto(boolean letto) {
		this.letto = letto;
	}
	
	public String toString() {
		if(this.prezzo > 0) {
			return this.titolo + " - " + this.autore + " - " + this.categoria + " - " + this.prezzo + " € ";	
		}
		else {
			return this.titolo + " - " + this.autore + " - " + this.categoria + " " ;
		}
		
		}

}

