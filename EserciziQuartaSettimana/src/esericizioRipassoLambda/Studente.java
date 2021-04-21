package esericizioRipassoLambda;

import java.time.LocalDate;

public class Studente {

	protected String nome;
	protected String cognome;
	protected Sesso sesso;
	protected CorsoStudi corso;
	protected LocalDate dataDiNascita;

	public Studente(String nome, String cognome, Sesso sesso, CorsoStudi corso, LocalDate dataDiNascita) {
		this.nome = nome;
		this.cognome = cognome;
		this.sesso = sesso;
		this.corso = corso;
		this.dataDiNascita = dataDiNascita;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public Sesso getSesso() {
		return sesso;
	}

	public void setSesso(Sesso sesso) {
		this.sesso = sesso;
	}

	public CorsoStudi getCorso() {
		return corso;
	}

	public void setCorso(CorsoStudi corso) {
		this.corso = corso;
	}

	public LocalDate getDataDiNascita() {
		return dataDiNascita;
	}

}
