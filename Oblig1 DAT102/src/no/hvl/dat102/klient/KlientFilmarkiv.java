package no.hvl.dat102.klient;

import no.hvl.dat102.*;
import no.hvl.dat102.adt.*;

public class KlientFilmarkiv {

	public static void main(String[] args) {
		FilmarkivADT filmer = new Filmarkiv(100);
		Meny meny = new Meny(filmer);
		meny.start();

	}

}
