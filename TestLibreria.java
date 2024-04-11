package Libreria;

import java.util.List;

import Anagrafiche.Libro;
import Anagrafiche.Scaffale;

public class TestLibreria {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Libro libroUno = new Libro("Piccolo Principe", "", "", 10);
		
		Libro libroDue = new Libro("Due vite", "", "", 20);
		
		Libro libroTre = new Libro("Conte di monte Cristo", "", "", 35);

		Libro libroQuattro = new Libro("Divina Commedia", "", "", 20);
		
		Libro libroCinque = new Libro("Moby Dick", "", "", 33);
		
		Scaffale scaffaleUno = new Scaffale(5);
		
		scaffaleUno.aggiungiLibro(libroUno);
		scaffaleUno.aggiungiLibro(libroDue);
		scaffaleUno.aggiungiLibro(libroTre);
		scaffaleUno.aggiungiLibro(libroQuattro);
		scaffaleUno.aggiungiLibro(libroCinque);
		
		System.out.println(scaffaleUno);
		
		Libro libroSei = new Libro("Amleto", "","", 33);

		scaffaleUno.aggiungiLibro(libroSei);
		System.out.println(scaffaleUno);
		
		//System.out.println(scaffaleUno.cercaLibriPerTitolo("DIVINA commedia"));
		List<Libro> risultato = scaffaleUno.cercaLibriPerTitolo("DIVINA commedia");
		
		for (Libro l : risultato) {
			System.out.println(l);
		}
		
		
		if(scaffaleUno.saveToFile())
			System.out.println("Scaffale salvato con successo \n\n\n ");
		
		
		Scaffale scaffaleDue = new Scaffale(7);
		
		System.out.println("Importa libri da file: \n ");
		
		String percorso = "/Users/matteopesacane/eclipse-workspace/LibreriaComponibile/src/libri.txt";
		scaffaleDue.importFromFile(percorso);
		
		System.out.println(scaffaleDue);
		
		
	}

}
