package Anagrafiche;

import java.io.File;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Scaffale {
	
	private final int capienzaMassima;
	private List<Libro> libri;
	
	public Scaffale(int capienzaMassima) {
		this.capienzaMassima = capienzaMassima;
		this.libri = new ArrayList<>();
	}
	
	/* Scorro la lista (cioè lo scaffale) alla ricerca del libro avente il titolo richiesto.
	 * Se lo trovo restituisco la posizione, altrimenti -1 */
	
	private int indexOf(String titolo) {
		for(int i=0; i<libri.size(); i++)
			if(libri.get(i).getTitolo().equals(titolo))
				return i;
		return -1;
	}
	
	//Il metodo aggiungiLibro controlla se c'è spazio prima di aggiungere un libro, altrimenti torna false
    public boolean aggiungiLibro(Libro libro) {
    	// se libri è inferiore a capienzaMassima torna vero
        if (libri.size() < capienzaMassima) {
        	// .add() restituisce sempre true
            libri.add(libro);
            return true;
        } else {
            System.out.println("Scaffale pieno. Impossibile aggiungere il libro: " + libro.getTitolo());
            return false;
        }
    }
    
    
    // La funzione equalsIgnoreCase è usata per ignorare le differenze tra il titolo cercato e quello dei libri presenti nella lista
    // Questo metodo consente di cercare e rimuovere un libro specifico basandosi sul suo titolo
    public boolean rimuoviLibroPerTitolo(String titolo) {
    	 // Inizia a iterare sulla lista dei libri dalla prima posizione (indice 0)
        for (int i = 0; i < libri.size(); i++) {
        	// Controlla se il titolo del libro corrente (libri.get(i).getTitolo())
            // è uguale al titolo fornito come parametro
            if (libri.get(i).getTitolo().equalsIgnoreCase(titolo)) {
            	// Se viene trovato un libro con il titolo corrispondente,
                // lo rimuove dalla lista
                libri.remove(i);
                // Dopo aver rimosso il libro, esce dal metodo restituendo true,
                return true;
            }
        }
     // Se il ciclo termina senza aver trovato un libro con il titolo corrispondente, il metodo restituisce false.
        return false;
    }
    
    // Questo metodo cerca tutti i libri che hanno un titolo corrispondente a quello fornito
    public List<Libro> cercaLibriPerTitolo(String titolo) {
        List<Libro> risultato = new ArrayList<>();
       // si ripete manualmente su ogni Libro nella lista libri
        for (Libro libro : libri) {
        	// Se il titolo del libro corrisponde al titolo fornito, quel libro viene aggiunto alla lista risultato
            if (libro.getTitolo().equalsIgnoreCase(titolo)) {
                risultato.add(libro);
            }
        }
        return risultato;
    }

    
    // Questo metodo trova tutti i libri nella lista che non sono stati ancora letti
    public List<Libro> cercaLibriNonLetti() {
        List<Libro> nonLetti = new ArrayList<>();
        // si procede ripetendo su ciascun elemento della lista libri
        for (Libro libro : libri) {
        	// Se il metodo isLetto() del libro corrente restituisce false, il libro viene aggiunto alla lista nonLetti
            if (!libro.isLetto()) {
                nonLetti.add(libro);
            }
        }
        return nonLetti;
    }
    
    
    public String toString() {
    	
    	String app = "";
    	
    	for(Libro libro : libri) {
    		
    		//app += libro.getTitolo() + "\n";
    		app += libro.toString() + "\n";
    		
    	}
    	
    	return app;
    }
    
    
    public boolean saveToFile() {
    	File f = new File("Lista_libri.txt");
    	
    	try {
    		PrintWriter out = new PrintWriter(f);
    		out.println("Lista libri delllo scaffale");
    		
        	for(Libro libro : libri) {
        		
        		out.println(libro.getTitolo());
        		
        	}
        	out.close();
        	
        	return true;
        	
    	}
    	catch(FileNotFoundException e) {
    		e.printStackTrace();
    		
    	}
    	
		return false;
    	
    }
    
    // il percorso del file è assoluto, quindi è definito dalla cartella root(radice) del sistema operativo
    public void importFromFile(String percorso) {
    	// FileReader serve ad aprire i file di testo
    	// BufferedReader serve a leggere i file di testo
    	try (BufferedReader br = new BufferedReader(new FileReader(percorso))) {
    		//creazione oggetto riga con nulla dentro
            String riga = "";
            // legge ogni riga del file finche non si trova una vuota(non esiste)
			while ((riga = br.readLine()) != null) {
                // divisione di righe ogni , (virgola)
                String[] libro = riga.split(",");
	
	    		//Libro libroDaAggiungere = new Libro(titolo, autore, categoria, prezzo, letto);
	        	// i libri importati sono tutti nuovi (non letti)
	    		Libro libroDaAggiungere = new Libro(libro[0], libro[1], libro[2], Double.parseDouble(libro[3]));
	        	aggiungiLibro(libroDaAggiungere);
        	
            }
    	} 
    	catch (IOException e) {
    		// chiama la lista dei metodi che hanno dato errore
    		e.printStackTrace();
    	}
    }

}


