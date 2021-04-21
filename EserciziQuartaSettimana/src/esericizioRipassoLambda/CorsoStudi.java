package esericizioRipassoLambda;

import java.time.LocalDate;

public class CorsoStudi {
	
	protected String titolo;
	protected LocalDate dataFormazione;
	protected Difficolta livello;
	protected Area area;
	
	public CorsoStudi(String titolo, LocalDate dataFormazione, Difficolta livello, Area area) {
		this.titolo = titolo;
		this.dataFormazione = dataFormazione;
		this.livello = livello;
		this.area = area;
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public LocalDate getDataFormazione() {
		return dataFormazione;
	}

	public void setDataFormazione(LocalDate dataFormazione) {
		this.dataFormazione = dataFormazione;
	}

	public Difficolta getLivello() {
		return livello;
	}

	public void setLivello(Difficolta livello) {
		this.livello = livello;
	}

	public Area getArea() {
		return area;
	}

	public void setArea(Area area) {
		this.area = area;
	}
	
	
	
	

}
