package esericizioRipassoLambda;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Start {

	public static void main(String[] args) {
		
		List<ProvaDiEsame> listaEsami = new  ArrayList<>();
		
		CorsoStudi c1 = new CorsoStudi("Elettronica", LocalDate.of(2020, 04, 21), Difficolta.BASE, Area.ARTISTICA);
		CorsoStudi c2 = new CorsoStudi("Informatica", LocalDate.of(2020, 03, 6), Difficolta.AVANZATO, Area.STEM);
		CorsoStudi c3 = new CorsoStudi("Letteratura", LocalDate.of(2020, 02, 27), Difficolta.INTERMEDIO, Area.STEM);
		CorsoStudi c4 = new CorsoStudi("Fisica", LocalDate.of(2020, 01, 31), Difficolta.INTERMEDIO, Area.LETTERARIA);
		
		Studente s1 = new Studente("Gina", "Bracco", Sesso.F, c1,LocalDate.of(1994, 2, 15));
		Studente s2 = new Studente("Lollo", "Cisco", Sesso.M, c2,LocalDate.of(1994, 2, 15));
		Studente s3 = new Studente("Brigida", "Price", Sesso.F, c3,LocalDate.of(1994, 2, 15));
		Studente s4 = new Studente("Frensis", "Codex", Sesso.M, c4,LocalDate.of(1994, 2, 15));
		
		ProvaDiEsame p1 = new ProvaDiEsame(LocalDate.of(2020, 6, 12), 80, s1, TipoEsame.ORALE);
		listaEsami.add(p1);
		ProvaDiEsame p2 = new ProvaDiEsame(LocalDate.of(2020, 8, 28), 71, s2, TipoEsame.SCRITTA);
		listaEsami.add(p2);
		ProvaDiEsame p3 = new ProvaDiEsame(LocalDate.of(2020, 7, 17), 71, s3, TipoEsame.QUIZ);
		listaEsami.add(p3);
		ProvaDiEsame p4 = new ProvaDiEsame(LocalDate.of(2020, 11, 1), 99, s4, TipoEsame.SCRITTA);
		listaEsami.add(p4);
		ProvaDiEsame p5 = new ProvaDiEsame(LocalDate.of(2020, 6, 12), 80, s1, TipoEsame.ORALE);
		listaEsami.add(p5);
		
		GestioneEsame esame= new GestioneEsame();
		
//		esame.stampaStudentiConProva(listaEsami);
//		esame.areaConMaxMedia(listaEsami);
//		esame.studentiAppartCorsoStudi(listaEsami);
//		esame.verificaPunteggi(listaEsami);
		esame.stampaProveDiEsame(listaEsami);
		
	}

}
