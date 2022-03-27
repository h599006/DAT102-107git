package no.hvl.dat107;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(schema = "oblig3")

public class Avdeling {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int avdelingId;
	private String avdeling;
	private int sjef;
	
	
	@OneToMany(mappedBy = "avdeling", fetch = FetchType.EAGER)
	List<Ansatt> ansatte;
	
	public Avdeling() {
		
	}

	public Avdeling(String avdeling, int sjef) {
		this.avdeling = avdeling;
		this.sjef = sjef;
	}

	public int getAvdelingId() {
		return avdelingId;
	}

	public void setAvdelingId(int avdelingId) {
		this.avdelingId = avdelingId;
	}

	public String getAvdeling() {
		return avdeling;
	}

	public void setAvdeling(String avdeling) {
		this.avdeling = avdeling;
	}

	public int getSjef() {
		return sjef;
	}

	public void setSjef(int sjef) {
		this.sjef = sjef;
	}

	@Override
	public String toString() {
		String ansattString = "";
		for (Ansatt a : ansatte) {
			ansattString += "\n\t" + a;
		}
		
		return "Avdeling [avdelingId=" + avdelingId + ", avdeling=" + avdeling + ", sjef=" + sjef + ", ansatte="
				+ ansattString + "\n]";
	}
	
	public void fjernAnsatt(Ansatt ansatt) {
		ansatte.remove(ansatt);
		ansatt.setAvdeling(null);
	}
	
	public void leggTilAnsatt(Ansatt ansatt) {
        ansatte.add(ansatt);
        ansatt.setAvdeling(this);
    }
	
}
