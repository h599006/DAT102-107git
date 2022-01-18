package no.hvl.dat102;

public class Film {
	private int filmnr;
	private String navn;
	private String tittel;
	private int aar;
	private Sjanger sjanger;
	private String filmselskap;
	
	public Film() {
		Film film = new Film();
	}
	public Film(int filmnr, String navn, String tittel, int aar, Sjanger sjanger, String filmselskap) {
		this.filmnr = filmnr;
		this.navn = navn;
		this.tittel = tittel;
		this.aar = aar;
		this.sjanger = sjanger;
		this.filmselskap = filmselskap;
	}
	
	public int getFilmnr() {
		return filmnr;
	}
	public void setFilmnr(int filmnr) {
		this.filmnr = filmnr;
	}
	public String getNavn() {
		return navn;
	}
	public void setNavn(String navn) {
		this.navn = navn;
	}
	
	public String getTittel() {
		return tittel;
	}
	public void setTittel(String tittel) {
		this.tittel = tittel;
	}
	public int getAar() {
		return aar;
	}
	public void setAar(int aar) {
		this.aar = aar;
	}
	public Sjanger getSjanger() {
		return sjanger;
	}
	public void setSjanger(Sjanger sjanger) {
		this.sjanger = sjanger;
	}
	public String getFilmselskap() {
		return filmselskap;
	}
	public void setFilmselskap(String filmselskap) {
		this.filmselskap = filmselskap;
	}
	
	
	public boolean equals(Film film) {
		if (filmnr == film.getFilmnr()) {
			return true;
		}
		return false;
	}
	@Override
	public int hashCode() {
		Integer temp = filmnr;
		return temp.hashCode();
	}
}
