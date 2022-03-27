package no.hvl.dat107;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(schema = "oblig3")

public class Ansatt {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ansattId;
	private String brukernavn;
	private String fornavn;
	private String etternavn;
	private LocalDate ansattDato;
	private String stilling;
	private int mndLonn;
	
	@ManyToOne
	@JoinColumn(name = "Avdeling", referencedColumnName = "AvdelingId")
	private Avdeling avdeling;
	
	public Ansatt() {}
	
	public Ansatt(String brukernavn, String fornavn, String etternavn, LocalDate ansattDato,
			String stilling, int mndLonn, Avdeling avdeling) {
		this.brukernavn = brukernavn;
		this.fornavn = fornavn;
		this.etternavn = etternavn;
		this.ansattDato = ansattDato;
		this.stilling = stilling;
		this.mndLonn = mndLonn;
		this.avdeling = avdeling;
	}

	public int getAnsattId() {
		return ansattId;
	}

	public void setAnsattId(int ansattId) {
		this.ansattId = ansattId;
	}

	public String getBrukernavn() {
		return brukernavn;
	}

	public void setBrukernavn(String brukernavn) {
		this.brukernavn = brukernavn;
	}

	public String getFornavn() {
		return fornavn;
	}

	public void setFornavn(String fornavn) {
		this.fornavn = fornavn;
	}

	public String getEtternavn() {
		return etternavn;
	}

	public void setEtternavn(String etternavn) {
		this.etternavn = etternavn;
	}

	public LocalDate getAnsattDato() {
		return ansattDato;
	}

	public void setAnsattDato(LocalDate ansattDato) {
		this.ansattDato = ansattDato;
	}

	public String getStilling() {
		return stilling;
	}

	public void setStilling(String stilling) {
		this.stilling = stilling;
	}

	public int getMndLonn() {
		return mndLonn;
	}

	public void setMndLonn(int mndLonn) {
		this.mndLonn = mndLonn;
	}

	public Avdeling getAvdeling() {
		return avdeling;
	}

	public void setAvdeling(Avdeling avdeling) {
		this.avdeling = avdeling;
	}

	@Override
	public String toString() {
		return "Ansatt [ansattId=" + ansattId + ", brukernavn=" + brukernavn + ", fornavn=" + fornavn + ", etternavn="
				+ etternavn + ", ansattDato=" + ansattDato + ", stilling=" + stilling + ", mndLonn=" + mndLonn
				+ ", avdeling=" + avdeling.getAvdeling() + "]";
	}
	
	
	
}
