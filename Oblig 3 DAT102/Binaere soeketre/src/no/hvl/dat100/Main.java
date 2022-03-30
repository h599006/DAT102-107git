package no.hvl.dat100;

import java.util.*;

public class Main {

	public static void main(String[] args) {
		
		int N = 1023;
		int Antall = 100;
		
		Random terning = new Random();
		BS_Tre[] tabell = new BS_Tre[Antall];
		
		for (int i = 0; i < Antall; i++) {
			int tall = terning.nextInt();
			BS_Tre tre = new BS_Tre();
			
			for (int j = 0; j < N; j++) {
				tre.leggTil(terning.nextInt());
			}
			tabell[i] = tre;
		}
		
		//i) Antall noder
		for (int i = 0; i < tabell.length; i++) {
			System.out.println(tabell[i].antallNoder(tabell[i].getRot()));
		}
		
		//ii) Minimale teoretiske høyden
		for (int i = 0; i < tabell.length; i++) {
			System.out.println(tabell[i].minimalTeoHoyde(N));
		}
		
		//iii) Maksimale teoretiske høyden
		for (int i = 0; i < tabell.length; i++) {
			System.out.println(tabell[i].maksimalTeoHoyde(N));
		}
		
		//iv) Minste høyde i løpet av kjøringene
		
		//v) Største høyde i løpet av kjøringene
		
		//vi) Gjennomsnittlig høyde av alle kjøringene
	}

}
