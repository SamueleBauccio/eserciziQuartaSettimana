package esericizioRipassoLambda;

import java.time.LocalDate;



public class ProvaDiEsame {


	protected LocalDate dataEsame;
	protected int punteggio;
	protected Studente studente;
	protected TipoEsame tipo;

	public ProvaDiEsame(LocalDate dataEsame, int punteggio, Studente studente, TipoEsame tipo) {
		this.dataEsame = dataEsame;
		this.punteggio = punteggio;
		this.studente = studente;
		this.tipo = tipo;
	}

	public LocalDate getDataEsame() {
		return dataEsame;
	}

	public void setDataEsame(LocalDate dataEsame) {
		this.dataEsame = dataEsame;
	}

	public int getPunteggio() {
		return punteggio;
	}

	public void setPunteggio(int punteggio) {
		this.punteggio = punteggio;
	}

	public Studente getStudente() {
		return studente;
	}

	public void setStudente(Studente studente) {
		this.studente = studente;
	}

	public TipoEsame getTipo() {
		return tipo;
	}

	public void setTipo(TipoEsame tipo) {
		this.tipo = tipo;
	}

}
