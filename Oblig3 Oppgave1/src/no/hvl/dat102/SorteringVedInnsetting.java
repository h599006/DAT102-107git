package no.hvl.dat102;

public class SorteringVedInnsetting {
	
	public static <T extends Comparable<? super T>> void sorteringVedInnsetting(T[] a, int n) {
		sorteringVedInssetting(a, 0, n - 1);
	}

	public static <T extends Comparable<? super T>> void sorteringVedInssetting(T[] a, int start, int slutt) {
		
		for (int i = start + 1; i <= slutt; i++) {
			T temp = a[i];
			int j = i - 1;
			
			while (j >= 0) { //Fjerner boolean fordi da er det en ting mindre å sjekke, å sjekke ting tar tid
				if (temp.compareTo(a[j]) < 0) {
					a[j + 1] = a[j];
					j--;
				} else {
					break;
				}
			}
			a[j + 1] = temp;
		}
	}
	
	
	public static <T extends Comparable<? super T>> void sorteringVedInnsettingToTall(T[] a, int n) {
		sorteringVedInssettingToTall(a, 0, n - 1);
	}
	
	public static <T extends Comparable<? super T>> void sorteringVedInssettingToTall(T[] a, int start, int slutt) {
	
		for (int i = start + 1; i < slutt; i+=2) {
			
			if (i + 1 < slutt) {
				i--;
			}
			
			T temp = a[i];
			T temp2 = a[i + 1];
			int j = i - 1;
			
			
			if (temp.compareTo(temp2) < 0) {
				temp = a[i + 1];
				temp2 = a[i];
			} 
			
			while (j >= 0) { 
				if (temp.compareTo(a[j]) < 0) {
					a[j + 2] = a[j];
					j--;
				} else {
					break;
				}	
			}
			a[j + 2] = temp;
			
			while (j >= 0) { 
				if (temp2.compareTo(a[j]) < 0) {
					a[j + 1] = a[j];
					j--;
				} else {
					break;
				}
			}
			a[j + 1] = temp2;
			
		} 
		
	}
}
