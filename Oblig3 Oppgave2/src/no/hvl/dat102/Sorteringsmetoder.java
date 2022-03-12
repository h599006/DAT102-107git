package no.hvl.dat102;

public class Sorteringsmetoder {
	
	private static <T extends Comparable<? super T>> void bytt(T[] a, int i, int j) {
		T temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	private static <T extends Comparable<? super T>> void sortFirstMiddleLast(T[] a, int first, int mid, int last) {
		if (a[first].compareTo(a[mid]) > 0) {
			bytt(a, first, mid);
		}
		if (a[mid].compareTo(a[last]) > 0) {
			bytt(a, mid, last);
		}
		if (a[first].compareTo(a[mid]) > 0) {
			bytt(a, first, mid);
		}
	} 
	
	
	public static <T extends Comparable<? super T>> void sorteringVedInnsetting(T[] a, int n) {
		sorteringVedInssetting(a, 0, n - 1);
	}
	public static <T extends Comparable<? super T>> void sorteringVedInssetting(T[] a, int start, int slutt) {
		
		for (int i = start + 1; i <= slutt; i++) {
			T temp = a[i];
			int j = i - 1;
			
			while (j >= 0) { 
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
	
	public static <T extends Comparable<? super T>> void utvalgssortering(T[] a, int n) {
		for (int neste = 0; neste < n - 1; neste++) {
			int minstePos = neste;
			
			for (int sok = neste + 1; sok < n; sok++) {
				if (a[sok].compareTo(a[minstePos]) < 0) {
					minstePos = sok;
				}
			}
			if (minstePos != neste) { //Bytter plass på siste og nest-siste element hvis den siste ikke allerede er størst
				bytt(a, neste, minstePos);
			}
		}
	}
	
	public static <T extends Comparable<? super T>> void quickSort(T[] array, int n) {
		kvikksortering(array, 0, n - 1);
		sorteringVedInnsetting(array, n);
	}
	public static <T extends Comparable<? super T>> void kvikksortering(T[] a, int forste, int siste) {
		if (siste - forste + 1 >= 3) {
			int p = partition(a, forste, siste);
			kvikksortering(a, forste, p - 1);
			kvikksortering(a, p + 1, siste);
		}
	}
	private static <T extends Comparable<? super T>> int partition(T[] a, int forste, int siste) {
		int midten = (forste + siste) / 2;
		
		//Bytter plass så første, midten og siste er sortert
		sortFirstMiddleLast(a, forste, midten, siste);
		
		// Flytter pivot til nest-siste plass
		bytt(a, midten, siste - 1);
		int pivotIndex = siste - 1;
		T pivotValue = a[pivotIndex];
		
		// Finn første i venstre del som er mindre større enn pivot
		// siste i høgre del som er mindre enn pivot

		int fraVenstre = forste + 1;
		int fraHogre = siste - 2;

		boolean ferdig = false;
		while (!ferdig) {
			
			while (a[fraVenstre].compareTo(pivotValue) < 0) {
				fraVenstre++;
			}
			
			while (a[fraHogre].compareTo(pivotValue) > 0) {
				fraHogre--;
			} 
			
			if (fraVenstre < fraHogre) {
				bytt(a, fraVenstre, fraHogre);
				fraVenstre++;
				fraHogre--;
			} else
				ferdig = true;
		} 

		//Setter pivotVerdien mellom de to undertabellene
		bytt(a, pivotIndex, fraVenstre);
		pivotIndex = fraVenstre;

		return pivotIndex;
	}
	
	public static <T extends Comparable<? super T>> void flettesortering(T[] a, int n) {
		flettesortering(a, 0, n - 1);
	}

	public static <T extends Comparable<? super T>> void flettesortering(T[] a, int first, int last) {
		// The cast is safe because the new array contains null entries
		@SuppressWarnings("unchecked")
		T[] tempArray = (T[]) new Comparable<?>[a.length]; // unchecked cast
		flettesortering(a, tempArray, first, last);
	}
	private static <T extends Comparable<? super T>> void flettesortering(T[] a, T[] tempTab, int forste, int siste) {
		if (forste >= siste) { //basis: 0 eller 1 element
			//gjør ingenting
		} else {
			int midten = (forste + siste) / 2;
			flettesortering(a, tempTab, forste, midten);
			flettesortering(a, tempTab, midten + 1, siste);
			flette(a, tempTab, forste, midten, siste);
		}
	}
	private static <T extends Comparable<? super T>> void flette(T[] a, T[] tempTab, int forste, int midten, int siste) {
		// Flettar saman to deler som ligg ved sida av hverandre
		// forste, ..., midten og midten + 1, ..., siste
		int fV = forste;
		int sluttV = midten;
		int fH = midten + 1;
		int sluttH = siste;

		// Så lenge det er ett element i begge delene, flytt over den minste til tempTab
		int index = fV; 
		for (; (fV <= sluttV) && (fH <= sluttH); index++) {
			if (a[fV].compareTo(a[fH]) < 0) {
				tempTab[index] = a[fV];
				fV++;
			} else {
				tempTab[index] = a[fH];
				fH++;
			}
		}

		// No vil ein av delane vere to. Kopierer over resten i den andr eedelen

		// Venstre del, kan vere tom
		for (; fV <= sluttV; fV++, index++) {
			tempTab[index] = a[fV];
		}

		// Høgre del, kan vere tom
		for (; fH <= sluttH; fH++, index++) {
			tempTab[index] = a[fH];
		}

		// Kopier den sorterte delen tilbake
		for (index = forste; index <= siste; index++) {
			a[index] = tempTab[index];
		}
	}
}
