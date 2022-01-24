package no.hvl.dat102;

import no.hvl.dat102.adt.FilmarkivADT;
import no.hvl.dat102.LinearNode;

public class Filmarkiv2 implements FilmarkivADT {
	private int antall;
	private LinearNode<Film> start;
	
	@Override
	public void leggTilFilm(Film nyFilm) {
		LinearNode<Film> nyNode = new LinearNode<Film>(nyFilm);
		nyNode.setNeste(start);
		start = nyNode;
		antall++;
		
	}
	@Override
	public boolean slettFilm(int filmnr) {
		boolean slettet = false;
		if (antall == 0) {
			return slettet;
		}
		LinearNode<Film> node = finnNodeFilmNr(filmnr);
		if (node != null) {
			Film forsteEl = start.getElement();
			node.setElement(forsteEl);
			start = start.getNeste();
			antall--;
			slettet = true;
		}
		return slettet;
	}
	@Override
	public Film[] soekTittel(String delstreng) {
		LinearNode<Film> denne = start;
		Film[] filmFunnet = new Film[antall];
		int antallEl = 0;
		
		for (int i = 0; i < antall; i++) {
			if (denne.getElement().getTittel().contains(delstreng)) {
				filmFunnet[antallEl] = denne.getElement();
				antallEl++;
			}
			else {
				denne = denne.getNeste();
			}
		}
		return filmFunnet;
	}
	@Override
	public Film[] soekProdusent(String delstreng) {
		LinearNode<Film> denne = start;
		Film[] filmFunnet = new Film[antall];
		int antallEl = 0;
		
		for (int i = 0; i < antall; i++) {
			if (denne.getElement().getNavn().contains(delstreng)) {
				filmFunnet[antallEl] = denne.getElement();
				antallEl++;
			}
			else {
				denne = denne.getNeste();
			}
		}
		return filmFunnet;
	}
	@Override
	public int antall(Sjanger sjanger) {
		int antallFilmer = 0;
		LinearNode<Film> denne = start;
		
		for (int i = 0; i < antall; i++) {
			if (denne.getElement().getSjanger() == sjanger) {
				antallFilmer++;
			}
			else {
				denne = denne.getNeste();
			}
		}
		return antallFilmer;
	}
	@Override
	public int antall() {
		return antall;
	}
	@Override
	public Film finnFilm(int nr) {
		boolean funnet = false;
		LinearNode<Film> denne = start;
		Film filmFunnet = null;
		
		while (denne != null && !funnet) {
			if (denne.getElement().getFilmnr() == nr) {
				funnet = true;
				filmFunnet = denne.getElement();
			}
			else {
				denne = denne.getNeste();
			}
		}
		return filmFunnet;
	}
	
	private LinearNode<Film> finnNodeFilmNr(int filmNr) {
		boolean funnet = false;
		LinearNode<Film> node = null;
		LinearNode<Film> aktuell = start;
		
		for (int soek = 0; soek < antall && !funnet; soek++) {
			if (aktuell.getElement().getFilmnr() == filmNr) {
				funnet = true;
				node = aktuell;
			} else {
				aktuell = aktuell.getNeste();
			}
		}
		return node;
	}
	
}
