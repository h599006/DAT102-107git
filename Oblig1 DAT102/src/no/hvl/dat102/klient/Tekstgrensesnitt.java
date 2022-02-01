package no.hvl.dat102.klient;

import no.hvl.dat102.*;
import no.hvl.dat102.adt.*;
import javax.swing.JOptionPane;

public class Tekstgrensesnitt {
	// lese opplysningene om en FILM fra tastatur  
	 public int lesFilm(){ //Film
		 /*
		 int filmnr = Integer.parseInt(JOptionPane.showInputDialog("Filmnr: "));
		 String navn = JOptionPane.showInputDialog("Navn: ");
		 String tittel = JOptionPane.showInputDialog("Tittel: ");
		 int aar = Integer.parseInt(JOptionPane.showInputDialog("År: "));
		 String s = JOptionPane.showInputDialog("Sjanger: ");
		 Sjanger sjanger = Sjanger.valueOf(s);
		 String filmselskap = JOptionPane.showInputDialog("Filmselskap: "); 
		 return new Film(filmnr, navn, tittel, aar, sjanger, filmselskap);*/
		
		
		 int filmNrBruker = Integer.parseInt(JOptionPane.showInputDialog("Filmnr: "));
		 return filmNrBruker;
		 
	 } 
	 
	 // vise en film med alle opplysninger på skjerm (husk tekst for sjanger) 
	 public void visFilm(Film film) { 
		 if (film == null) {
			 System.out.println("Filmen finnes ikke");
			 return;
		 }
		 System.out.println("Filmnr: " + film.getFilmnr());
		 System.out.println("Navn: " + film.getNavn());
		 System.out.println("Tittel: " + film.getTittel());
		 System.out.println("År: " + film.getAar());
		 System.out.println("Sjanger: " + film.getSjanger().toString());
		 System.out.println("Filmselskap: " + film.getFilmselskap());
	 } 
	 
	 // Skrive ut alle Filmer med en spesiell delstreng i tittelen 
	 public void skrivUtFilmDelstrengITittel(FilmarkivADT filma,  
	                                                           String delstreng) { 
		 Film[] filmer = filma.soekTittel(delstreng);
		 for (int i  = 0; i < filmer.length; i++) {
			 visFilm(filmer[i]);
			 if (i != filmer.length - 1) {
				 System.out.println("************");
			 }
		 }
	 } 
	 
	 // Skriver ut alle Filmer av en produsent / en gruppe 
	 public void skrivUtFilmProdusent(FilmarkivADT filma, String delstreng) { 
		 Film[] filmer = filma.soekProdusent(delstreng);
		 for (int i  = 0; i < filmer.length; i++) {
			 visFilm(filmer[i]);  
			 if (i != filmer.length - 1) {
				 System.out.println("************");
			 }
		 }
	 } 
	 
	 // Skrive ut en enkel statistikk som inneholder antall Filmer totalt 
	 // og hvor mange det er i hver sjanger 
	 public void skrivUtStatistikk(FilmarkivADT filma) { 
		 System.out.println("Antall filmer: " + filma.antall());
		 
		 Sjanger[] sjangerTab = Sjanger.values();
		 for (int i = 0; i < sjangerTab.length; i++) {
			 System.out.println("Antall filmer i sjangeren " + sjangerTab[i] +": " + filma.antall(sjangerTab[i]));
		 }
	 } 
	 // ... Ev. andre metoder 
}
