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
		 Film nyFilm1 = new Film(1, "David Heyman", "Harry Potter og de vises stein", 2001, Sjanger.FANTASY, "Warner Bros");
		 Film nyFilm2 = new Film(2, "David Heyman", "Harry Potter og mysterikammeret", 2002, Sjanger.FANTASY, "Warner Bros");
		 filmarkiv.leggTilFilm(nyFilm1);
		 filmarkiv.leggTilFilm(nyFilm2);
		 
		 Film bruker = tekstgr.lesFilm();
		 filmarkiv.leggTilFilm(bruker);
		 tekstgr.visFilm(bruker);
		 
		 System.out.println("---------");
		 tekstgr.skrivUtFilmDelstrengITittel(filmarkiv, "vises");
		 System.out.println("---------");
		 tekstgr.skrivUtFilmProdusent(filmarkiv, "Warner");
		 System.out.println("---------");
		 tekstgr.skrivUtStatistikk(filmarkiv);
	 } 
}
