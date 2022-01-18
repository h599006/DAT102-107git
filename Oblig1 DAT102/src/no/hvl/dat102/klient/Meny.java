package no.hvl.dat102.klient;

import no.hvl.dat102.*;
import no.hvl.dat102.adt.FilmarkivADT;

public class Meny {
	private Tekstgrensesnitt tekstgr;  
	private FilmarkivADT filmarkiv;  
	  
	 public Meny(FilmarkivADT filmarkiv){ 
		 tekstgr = new Tekstgrensesnitt();  
		 this.filmarkiv = filmarkiv; 
	 } 
	  
	 public void start(){ 
		 Film nyFilm = new Film(1, "David Heyman", "Harry Potter og de vises stein", 2001, Sjanger.FANTASY, "Warner Bros");
		 filmarkiv.leggTilFilm(nyFilm);
	 } 
}
