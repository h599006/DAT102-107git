package no.hvl.dat102.adt;

import no.hvl.dat102.*;

public interface FilmarkivADT {

	/** 
	  * Viser en film 
	  * @param nr nummer p� film som skal vises. Om nummeret ikke finnes, 
	  * skrives en feilmelding. 
	  */ 
	 void visFilm(int nr); 
	 
	 /** 
	  * Legger til en ny film. 
	  * @param nyFilm 
	  */ 
	 void leggTilFilm(Film nyFilm); 
	 
	 /** 
	  * Sletter en fil med gitt nr 
	  * @param filmnr nr p� film som skal slettes 
	  * @return true dersom filmen ble slettet, false ellers 
	  */ 
	 boolean slettFilm(int filmnr);  
	 
	/** 
	  * S�ker og henter Filmer med en gitt delstreng i tittelen. 
	  * @param delstreng som m� v�re i tittel 
	  * @return tabell med filmer som har delstreng i tittel 
	  */ 
	 Film[] soekTittel(String delstreng); 
	 
	 /**
	  * S�ker og henter Filmer med en gitt delstreng for produsenten.
	  * @param delstreng som m� v�re i produsentnavn
	  * @return tabell med produsenter som har delstrengen
	  */
	 Film[] soekProdusent(String delstreng); 
	 
	 /** 
	  * Finner antall filmer med gitt sjanger 
	  * @param sjanger  
	  * @return antall filmer av gitt sjanger. 
	  */ 
	 int antall(Sjanger sjanger); 
	 
	 /** 
	  *  
	  * @return antall filmer i arkivet 
	  */ 
	 int antall(); 
	 

}
