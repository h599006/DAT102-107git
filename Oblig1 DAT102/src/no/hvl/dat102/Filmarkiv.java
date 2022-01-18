package no.hvl.dat102;

import no.hvl.dat102.adt.FilmarkivADT;
//import no.hvl.dat102.Sjanger;
//import no.hvl.dat102.Film;

public class Filmarkiv implements FilmarkivADT {
	private Film[] filmtab;
	private int antall;
	
	public Filmarkiv(int lengde) {
		filmtab = new Film[lengde];
		antall = 0;
	}
	
	public void visFilm(int filmnr) {
		boolean filmFunnet = false;
		for (int i = 0; i < antall; i++) {
			if(filmtab[i].getFilmnr() == filmnr) {
				System.out.println(filmtab[i]);
				filmFunnet = true;
			}
		}
		if (filmFunnet == false) {
			System.out.println("Nummeret finnes ikke");
		}
		
	}

	@Override
	public void leggTilFilm(Film nyFilm) {
		if(!(antall < filmtab.length)) {
			utvid();
		}
		filmtab[antall] = nyFilm;
		antall++;
		
	}
	private void utvid() {
		Film[] temp =  new Film[antall * 2];
		
		for (int i = 0; i < filmtab.length; i++) {
			temp[i] = filmtab[i];
		}
		filmtab = temp;
	}

	@Override
	public boolean slettFilm(int filmnr) {
		for (int i = 0; i < antall; i++) {
			if (filmtab[i].getFilmnr() == filmnr) {
				filmtab[i] = null;
				antall--;
				return true;
			}
		}
		return false;
	}

	@Override
	public Film[] soekTittel(String delstreng) {
		Film[] inneholder = new Film[antall];
		int antallEl = 0;
		
		for (int i = 0; i < antall; i++) {
			if (filmtab[i].getTittel().contains(delstreng)) {
				inneholder[i] = filmtab[i];
				antallEl++;
			}
		}
		inneholder = trimTab(inneholder, antallEl);
		return inneholder;
	}
	
	public Film[] soekProdusent(String delstreng) {
		Film[] inneholder = new Film[antall];
		int antallEl = 0;
		
		for (int i = 0; i < antall; i++) {
			if (filmtab[i].getFilmselskap().contains(delstreng)) {
				inneholder[i] = filmtab[i];
				antallEl++;
			}
		}
		inneholder = trimTab(inneholder, antallEl);
		return inneholder;
	}
	
	private Film[] trimTab(Film[] tab, int n) { 
		// n er antall elementer 
		Film[] nytab = new Film[n]; 
		int i = 0; 
		while (i < n) { 
			nytab[i] = tab[i]; 
			i++; 
		} 
		return nytab; 
	} 

	@Override
	public int antall(Sjanger sjanger) {
		int antallFilmer = 0;
		for (int i = 0; i < antall; i++) {
			if (filmtab[i].getSjanger() == sjanger) {
				antallFilmer++;
			}
		}
		return antallFilmer;
	}

	@Override
	public int antall() {
		return antall;
	}
}
