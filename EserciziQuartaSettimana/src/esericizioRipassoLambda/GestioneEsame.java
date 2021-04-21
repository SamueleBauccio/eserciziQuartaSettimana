package esericizioRipassoLambda;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GestioneEsame {

	public void stampaStudentiConProva(List<ProvaDiEsame> listaEsami) {

		List<String> nomiECognomi = listaEsami.stream()
				.map(p -> p.getStudente().getNome() + " " + p.getStudente().getCognome()).distinct()
				.collect(Collectors.toList());
		// .collect(Collectors.joining(", ")); ritorna un unica stringa
		// in cui gli elementi sono separati da virgola

		System.out.println(nomiECognomi);

	}

	public void studentiAppartCorsoStudi(List<ProvaDiEsame> listaEsami) {
		long stem = listaEsami.stream().filter(p -> p.getStudente().getCorso().getArea().equals(Area.STEM)).count();
		long artistica = listaEsami.stream().filter(p -> p.getStudente().getCorso().getArea().equals(Area.ARTISTICA))
				.count();
		long letteraria = listaEsami.stream().filter(p -> p.getStudente().getCorso().getArea() == Area.LETTERARIA)
				.count();
		// le ENUM sono valori singoli quindi
		// si posssono comparare anche le reference
		System.out.println(stem + " " + artistica + " " + letteraria);

	}

	public void areaConMaxMedia(List<ProvaDiEsame> listaEsami) { // non mettiamo le parentesi perche' non stiamo
																	// invocando il metodo
//		double averageForStem = listaEsami.stream().filter( p -> p.getStudente().getCorso().getArea()== Area.STEM) 
//										  		   .mapToInt(ProvaDiEsame::getPunteggio) //successivamente andiamo a mappare perche' da uno stream 
//										  		   .average().orElse(0.0); 		 		//	di ProvaDiEsame, passiamo a uno stream di int
		// il metodo average e' presente solo su una mapDiIn. orElse lo aggiungiamo
		// perche' nel caso in cui la lista sia vuota, non da errore.

//		listaEsami.stream().filter( p -> p.getStudente().getCorso().getArea()== Area.STEM)
//							.map(ProvaDiEsame::getPunteggio) NON USARE MAI .map  SE LAVORIAMO CON LE PRIMITIVE. USIAMO .mapToInt
//							.
//		double averageForArtistica = listaEsami.stream().filter( p -> p.getStudente().getCorso().getArea()== Area.ARTISTICA) 
//		  		   .mapToInt(ProvaDiEsame::getPunteggio)
//		  		   .average().orElse(0.0); 

		double averageForStem = calcolaMediaInArea(listaEsami, Area.STEM);
		double averageForArt = calcolaMediaInArea(listaEsami, Area.ARTISTICA);
		double averageForLett = calcolaMediaInArea(listaEsami, Area.LETTERARIA);

		System.out.printf(
				"L' average per lo STEM e' %.2f,L' average per l' ARTE e'%.2f,L' average per la LETTERATURA e' %.2f",
				averageForStem, averageForArt, averageForLett);
	}

//questa fiunzione la creaiamo per evitare che nella funzione precende riscriviamo 3 volte lo stesso codice. a sua volta se nel tempo vogliamo 
//	modificare qualche parametro, possiamo farlo direttamente una volta da qui
	public double calcolaMediaInArea(List<ProvaDiEsame> listaEsami, Area area) {
		double average = listaEsami.stream().filter(p -> p.getStudente().getCorso().getArea() == area)
				.mapToInt(ProvaDiEsame::getPunteggio).average().orElse(0.0);
		return average;
	}
	// 4) a quale delle tre aree appartiene lo studente con il voto piu alto?

	public Area findAreaWithBestStudent(List<ProvaDiEsame> listaEsami) { // quello che ritorna max e' un opzionale di
																			// prova di esame e se
																			// voglio estrarre la provas di esame dall
																			// opzionale devo usare get
		return listaEsami.stream().max((p1, p2) -> p1.getPunteggio() - p2.getPunteggio()).get().getStudente().getCorso()
				.getArea();

		// operatori terminali che obbligano ad avere un risultato per esempio = .max()
		// .count()
		// operatori come .stream() .map() vengono definiti lazy

	}
	// non si puo' riutilizzare lo stesso stream.
	// i dati in uno stream passano una volta sola.
	// per permetterci di lavorare piu' volte con lo stesso stream, inseriamo cio'
	// che ci serve all interno di una lista

	public void gliStreamNonSonoRiutilizzabili(List<ProvaDiEsame> listaEsami) {
		// listaEsami e' uno stream di prove di esami dove stream e' proprio una classe
		Stream<Studente> ss = listaEsami.stream().map(ProvaDiEsame::getStudente).filter(s -> s.getSesso() == Sesso.F);// operazione
																														// lazy

//		Optional<Studente> studentessaSeniorOpt = ss
//				.min((s1, s2) -> s1.getDataDiNascita().compareTo(s2.getDataDiNascita()));
//
//		if (studentessaSeniorOpt.isPresent()) {
//			System.out.println(studentessaSeniorOpt.get().getNome());
//		}
		List<Studente> ls = listaEsami.stream().map(ProvaDiEsame::getStudente).filter(s -> s.getSesso() == Sesso.F) // esegue
																													// subito
				.collect(Collectors.toList());
//		ls.stream().max(null)
//		ls.stream().min(null)
//LAVORIAMO PIU' VOLTE CON LO STESSO RISULTATO DI UNO STREAM
	}
	/*
	 * 5) verificare che tutti i quiz abbiano un punteggio superiore a 40 e che
	 * tutte le prove scritte degli studenti in area STEM di livello difficolta'
	 * avanzato abbiano registrato un punteggio superiore al 70 ( le prove possono
	 * essere orali, scritte o quiz)
	 */

	public void verificaPunteggi(List<ProvaDiEsame> listaEsami) {// allMatch CONTROLLA CHE PER TUTTI I MEMBRI IL
																	// PREDICATO RESTITUISCA TRUE (boolean)
		boolean nonCiSonoScarsi = listaEsami.stream().filter(p -> p.getTipo() == TipoEsame.QUIZ)
				.allMatch(p -> p.getPunteggio() > 40);
		boolean nonCISonoStemAvanzatiScarsi = listaEsami.stream()
				.filter(p -> p.getStudente().getCorso().getLivello() == Difficolta.AVANZATO
						&& p.getStudente().getCorso().getArea() == Area.STEM && p.getTipo() == TipoEsame.SCRITTA)
				.allMatch(p -> p.getPunteggio() > 70);
		System.out.println(nonCiSonoScarsi);
		System.out.println(nonCISonoStemAvanzatiScarsi);

	}

	/*
	 * 6) stampare le prove di esame (nel formato
	 * "nome e cognome studente - data - tipo prova - punteggio" ordinate in modo da
	 * vedere prima le prove degli studenti in area letteraria, poi quelli in
	 * artistica e poi quelli STEM. A parita'di area le prove devono essere stampate
	 * per punteggio decrescente, e a parita'di punteggio per ordine alfabetico del
	 * cognome.
	 */
	public void stampaProveDiEsame(List<ProvaDiEsame> listaEsami) {
		listaEsami.stream().sorted(this::comparatoreDiEsami)
				.forEach(p -> System.out.printf(
						"Nome: %s,Cognome: %s, Data: %s, Tipologia della prova: %s, Punteggio: %d, Area: %s%n",
						p.getStudente().getNome(), p.getStudente().getCognome(), p.getDataEsame(), p.getTipo(),
						p.getPunteggio(), p.getStudente().getCorso().getArea()));
	}

	/*
	 * creiamo una funzione che compara 2 prove di esame in modo tale da riportare,
	 * direttamente alla funzione di sopra, questa funzione.
	 */

	private int comparatoreDiEsami(ProvaDiEsame p1, ProvaDiEsame p2) {
		Area a1 = p1.getStudente().getCorso().getArea();
		Area a2 = p2.getStudente().getCorso().getArea();
		if (a1 != a2) {
			if (a1 == Area.LETTERARIA) {
				return -1;
			}
			if (a1 == Area.ARTISTICA) {
				if (a2 == Area.LETTERARIA) {
					return 1;
				} else {
					return -1;
				}
			}
			return 1;
		}
		if (p1.getPunteggio() != p2.getPunteggio()) {
			return p2.getPunteggio() - p1.getPunteggio();
		}
		return p1.getStudente().getCognome().compareTo(p2.getStudente().getCognome());

	}

}
