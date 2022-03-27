package no.hvl.dat100;

import java.util.Iterator;

public class BS_Tre<T extends Comparable<? super T>> implements SoektreInterface<T> {
	
	private BinaerTreNode<T> rot;
	
	public BS_Tre() {
		rot = null;
	}
	
	public BinaerTreNode<T> getRot() {
		return rot;
	}

	public BS_Tre(T element) {
		rot = new BinaerTreNode<T>(element);
	}
	
	/**
	 * Søker etter et gitt element i treet.
	 * 
	 * @param element elementet vi søker etter.
	 * @return true om elementet finst, false elles.
	 */
	public boolean inneholder(T element) {
		return false;
	}

	/**
	 * Henter et element i treet.
	 * 
	 * @param element elementet vi leiter etter.
	 * @return Elementet dersom det finst, elles null.
	 */
	public T finn(T element) {
		return finn(element, rot);
	}

	private T finn(T element, BinaerTreNode<T> p) {
		T svar = null;
		
		// p == null  -> tomt tre som er basistille og svar blir null
		if (p != null) {
			int sml = element.compareTo(p.getElement());
			if (sml == 0) {
				svar = p.getElement();
			} else if (sml < 0) {
				svar = finn(element, p.getVenstre());
			} else {
				svar = finn(element, p.getHogre());
			}
		}
		return svar;
	}
	/**
	 * Legg eit element til treet dersom det ikkje finst frå før. Elles etstattar
	 * blir det gamle elementet erstatta med det nye.
	 * 
	 * @param nyElement elementet som skal leggast til
	 * @return null om elementet ikkje finst frå før. Elles det element som var i
	 *         treet frå før.
	 */
	public void leggTil(T nyElement) {
		rot = leggTil(rot, nyElement);
	}

	private BinaerTreNode<T> leggTil(BinaerTreNode<T> p, T element){
		if (p == null) {
			return new BinaerTreNode<T>(element);
		} else {
			if (element.compareTo(p.getElement()) < 0) {
				p.setVenstre(leggTil(p.getVenstre(), element));
			} else {
				// Alternativ med to kodelinjer
				BinaerTreNode<T> q = leggTil(p.getHogre(), element);
				p.setHogre(q);
			}
		}
		return p;
	}
	/**
	 * Fjernar eit element frå treet.
	 * 
	 * @param element elementet som skal fjernast.
	 * @return elementet som vart fjerna eller null om det ikkje finst.
	 */
	public T fjern(T element) {
		return null;
	}

	/**
	 * Lagar ein iterator som går gjennom alle element i treet i inorden.
	 * 
	 * @return ein iterator som elementa i sortert rekkefølge.
	 */
	public Iterator<T> getInordenIterator() {
		return null;
	}
	
	public int hoyde(BinaerTreNode<T> t) {
		return hoydeRek(t);
	}
	private int hoydeRek(BinaerTreNode<T> t) {
		if (t == null) {
			return 0;
		}
		
		int hVenstreUndertre = hoydeRek(t.getVenstre());
		int hHogreUndertre = hoydeRek(t.getHogre());
		
		//Math.max finner den største av de to undertrærne. Legger til 1 pga rota
		return 1 + Math.max(hVenstreUndertre, hHogreUndertre);
	}
	
	public int antallNoder(BinaerTreNode<T> t) {
		
		if (t == null) {
			return 0;
		}
		return 1 + antallNoder(t.getVenstre()) + antallNoder(t.getHogre());
	}
	
	public int minimalTeoHoyde(int n) {
		int resultat = (int) (Math.log(n)/Math.log(2));
		return resultat;
	}
	public int maksimalTeoHoyde(int n) {
		return n;
	}

}
