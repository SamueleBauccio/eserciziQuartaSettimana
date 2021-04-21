package esericiozgiorno2Lambda;

import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

public class VideoTerminal {
	List<Transaction> list;

	public VideoTerminal(List<Transaction> list) {
		this.list = list;
	}

	public List<Transaction> getList() {
		return list;
	}

	public double sumAllAmounts(List<Transaction> listT) {

		// METODO CON COLLECTORS
//			return listT.stream()
//					   .collect(Collectors
//					   .summingDouble(Transaction::getAmount));

//			return listT.stream().mapToDouble(Transaction::getAmount);
		// LA PRECEDENTE EQUIVALE A SCRIVERE QUANTO SEGUE:
		return listT.stream().mapToDouble(t -> t.getAmount()).sum();
	}

	public double sumAmountsBefore1980(List<Transaction> listT) {

		return listT.stream().filter(t -> t.getCustomer().getDob().getYear() < 1980).mapToDouble(t -> t.getAmount())
				.sum();
	}

	public OptionalDouble avarageFemaleTransactions(List<Transaction> listT) {

		return listT.stream().filter(t -> t.getCustomer().getGender().equals(Gender.F)).mapToDouble(t -> t.getAmount())
				.average();
	}

	public String getBestCustomerName(List<Transaction> listT) {

//			return listT.stream()
//						.max((t1, t2) -> (int)(Math.signum(t1.getAmount() - t2.getAmount()))).get().getCustomer().getName();
		// LA PRECEDENTE EQUIVALE A SCRIVERE QUANTO SEGUE:
		return listT.stream().max((t1, t2) -> {
			double dif = t1.getAmount() - t2.getAmount();
			double sign = Math.signum(dif);
			int result = (int) sign;
			return result;
		}).get().getCustomer().getName();
	}

	public boolean isTransfer100k(List<Transaction> listT) {

		// long c = listT.stream().filter(t -> t.getAmount() >= 100000).count();

		// return c > 0 ? true:false;
		// RITORNA DIRETTAMENTE LA BOOLEANA DELL'ESPRESSIONE C > 0 SENZA RIPETERE IL
		// RETURN TRUE/FALSE CON UN IF o con UN OPERATORE TERNARIO
		// return c > 0;

		return listT.stream().anyMatch(t -> t.getAmount() >= 100000);
	}

	public double amountTransazioneMediana(List<Transaction> listT) {
		double mediana = 0;

		// IL METODO BOXED TRASFORMA LO STREAM DI double PRIMITIVI IN UNO STREAM DI
		// "OGGETTI DOUBLE" DA POTER INSERIRE IN UNA LISTA
		List<Double> sortedList = listT.stream().mapToDouble(Transaction::getAmount).sorted().boxed()
				.collect(Collectors.toList());

		if (sortedList.size() % 2 != 0) {
			mediana = sortedList.get(sortedList.size() / 2);
		} else {
			mediana = (sortedList.get(sortedList.size() / 2) + sortedList.get(sortedList.size() / 2 - 1)) / 2;
		}

		return mediana;
	}

}
