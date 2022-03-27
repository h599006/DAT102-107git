package no.hvl.dat107;

import java.util.List;
import java.time.LocalDate;  

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {


	public static void main(String[] args) {
		AnsattDAO daoAnsatt = new AnsattDAO();
		AvdelingDAO daoAvdeling = new AvdelingDAO();
		
		//Finn ansatt med id
		//System.out.println(daoAnsatt.finnAnsattMedId(2));
		
		//Finn ansatt med brukernavn
		//System.out.println(daoAnsatt.finnAnsattMedBrukernavn("PeP"));
		
		//List ut alle ansatte
		List<Ansatt> ansatte = daoAnsatt.skrivUtAlleAnsatte();
		//ansatte.forEach(System.out::println);
		
		//Oppdater Stilling
		daoAnsatt.oppdaterStilling(2, "Daglig Leder");
		//System.out.println(daoAnsatt.finnAnsattMedId(2));
		
		//Oppdater Lønn
		daoAnsatt.oppdaterLonn(2, 50000);
		//System.out.println(daoAnsatt.finnAnsattMedId(2));
		
		//Oppretter ny ansatt
		//Avdeling nyAvdeling = daoAvdeling.finnAvdelingMedId(1);
		//Ansatt nyA = new Ansatt("JoE", "Jonas", "Engen",LocalDate.parse("2020-08-21"), "Ansatt", 30000, nyAvdeling);
		//daoAnsatt.leggTilAnsatt(nyA);
		//System.out.println(daoAnsatt.finnAnsattMedId(11));
		
		//Finn avdeling med id
		//System.out.println(daoAvdeling.finnAvdelingMedId(2));
		
		//Skriv ut alle ansatte på avdeling
		//System.out.println(daoAvdeling.skrivUtAlleAnsatteFraAvdeling(1));
		
		//Oppdater avdeling
		System.out.println(daoAvdeling.oppdaterAvdeling(2, 2));
		
		//Lage ny avdeling
		//Avdeling renhold = daoAvdeling.lagreNyAvdeling("Renhold", nyA);
		//System.out.println(daoAvdeling.finnAvdelingMedId(4));
	}
	
	
}
