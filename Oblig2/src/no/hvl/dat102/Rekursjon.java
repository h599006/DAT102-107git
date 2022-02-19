package no.hvl.dat102;

public class Rekursjon {
	
	//a)
	public static int sum(int n) {
		if (n == 1) {
			return 1;
		} else {
			return n + sum(n - 1);
		}
	}
	
	//b)
	
	public static int an(int n) {
		if (n == 0) {
			return 2;
		} 
		if (n == 1) {
			return 5;
		}
		return 5*(an(n-1)) - 6*(an(n-2)) + 2;

	} 
	
	//c)
	public static int fibonacci(int n) {
		if (n == 0) {
			return 0;
		} 
		if (n == 1 || n == 2) {
			return 1;
		}
		return fibonacci(n - 2) + fibonacci(n - 1);
	}
	
	//d)
	public static int fibonacciUtenRekursjon(int n) {
		int i = 0;
		int forrigeTall = 0;
		int nesteTall = 1;
		int temp = 0;
		
		while (i < n) {
			temp = forrigeTall + nesteTall;
			forrigeTall = nesteTall;
			nesteTall = temp;
			
			i++;
		}
		return forrigeTall;
	}
}

