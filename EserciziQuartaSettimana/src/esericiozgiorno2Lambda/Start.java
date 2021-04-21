package esericiozgiorno2Lambda;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Start {

	public static void main(String[] args) {
		List<Transaction> transazioni = new ArrayList<>();
		List<Customer> clienti = new ArrayList<>();

		clienti.add(new Customer(123456, "Mario", "Rossi", LocalDate.of(1976, 2, 29), Gender.M));
		clienti.add(new Customer(456789, "Ariana", "Bianchi", LocalDate.of(1979, 4, 25), Gender.F));
		clienti.add(new Customer(789123, "Luca", "Verdi", LocalDate.of(1982, 12, 25), Gender.M));

		transazioni.add(new Transaction(LocalDate.now(), 10000, TypeTransfer.DEPOSITO, "Vendita moto", clienti.get(0)));
		transazioni.add(new Transaction(LocalDate.now(), 100000, TypeTransfer.BONIFICO, "Acconto per la lambo", clienti.get(1)));
		transazioni.add(new Transaction(LocalDate.now(), 1500, TypeTransfer.PRELIEVO, "Affitto barca per weekend", clienti.get(2)));
		transazioni.add(new Transaction(LocalDate.now(), 6000, TypeTransfer.PRELIEVO, "Acquisto scooter", clienti.get(0)));
		transazioni.add(new Transaction(LocalDate.now(), 25000, TypeTransfer.DEPOSITO, "Accredito fattura xxxyyy000", clienti.get(2)));



		VideoTerminal terminaleOperatore = new VideoTerminal(transazioni);

		System.out.println(terminaleOperatore.sumAllAmounts(transazioni) + "\n");

		System.out.println(terminaleOperatore.sumAmountsBefore1980(transazioni) + "\n");

		System.out.println(terminaleOperatore.avarageFemaleTransactions(transazioni) + "\n");

		System.out.println(terminaleOperatore.getBestCustomerName(transazioni) + "\n");

		System.out.println(terminaleOperatore.amountTransazioneMediana(transazioni) + "\n");


	}

}
