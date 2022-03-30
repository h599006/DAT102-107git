package no.hvl.dat102;

import java.util.Random;

public class Main {

	public static void main(String[] args) {
		
		Random tilfeldig = new Random(); 
		int n = 32000; 
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
			//Sorteringsmetoder.sorteringVedInnsetting(a[i], a[i].length);
			//Sorteringsmetoder.utvalgssortering(a[i], a[i].length);
			//Sorteringsmetoder.quickSort(a[i], a[i].length);
			Sorteringsmetoder.flettesortering(a[i], a[i].length);
		} 
		
		long sluttTid = System.currentTimeMillis();
		long tid = sluttTid - startTid;
		
		System.out.println("Millisekunder: " + tid);
		System.out.println("Sekunder: " + tid/1000);
		
		/*
		for (int i = 0;  i < a.length; i++) {
			for (Integer e : a[i]) {
				System.out.print(e + " ");
			}
			System.out.println();
		}  */
	}

}
