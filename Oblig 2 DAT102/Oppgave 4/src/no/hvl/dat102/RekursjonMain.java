package no.hvl.dat102;

public class RekursjonMain {

	public static void main(String[] args) {
		//a)
		System.out.println(Rekursjon.sum(10));
		System.out.println("--------------------");
		
		//b)
		for (int i = 0; i <= 10; i++) {
			System.out.println(Rekursjon.an(i));
		}
		System.out.println("--------------------");
		
		//c)
		for (int i = 0; i <= 10; i++) {
			System.out.println(Rekursjon.fibonacci(i));
		}
		System.out.println("--------------------");
		
		//d)
		for (int i = 0; i <= 10; i++) {
			System.out.println(Rekursjon.fibonacciUtenRekursjon(i) + " ");
		}
		System.out.println("--------------------");
		
	}

}


