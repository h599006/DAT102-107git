package no.hvl.dat102;

import java.util.Random;

import no.hvl.dat102.SorteringVedInnsetting;

public class Main {

	public static void main(String[] args) {
		
		Random tilfeldig = new Random(); 
		int n = 10; 
		int antall = 10; 
		 
		Integer[][] a = new Integer[antall][n]; 
		 
		// sett inn tilfeldige heltall i alle rekker 
		for (int i = 0; i < antall; i++){ 
			for (int j = 0; j < n; j++){ 
				a[i][j] = tilfeldig.nextInt(10); 
			} 
		} 
		 
		long startTid = System.currentTimeMillis();
		for (int i = 0; i < antall; i++){ 
			//SorteringVedInnsetting.sorteringVedInnsetting(a[i], a[i].length); // blir en endimensjonal tabell 
			SorteringVedInnsetting.sorteringVedInnsettingToTall(a[i], a[i].length);
		} 
		
		long sluttTid = System.currentTimeMillis();
		long tid = sluttTid - startTid;
		
		System.out.println("Millisekunder: " + tid);
		System.out.println("Sekunder: " + tid/1000);
		
		
		for (int i = 0;  i < a.length; i++) {
			for (Integer e : a[i]) {
				System.out.print(e + " ");
			}
			System.out.println();
		}  
	}

}
