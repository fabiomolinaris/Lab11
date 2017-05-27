package it.polito.tdp.bar.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

import it.polito.tdp.bar.model.Event.EventType;

public class Model {

	List<Tavolo> tavoli;
	PriorityQueue<Event> eventi = new PriorityQueue<Event>();
	// PriorityQueue<Event> clientiTavolo = new PriorityQueue<Event>();
	// PriorityQueue<Event> clientiBancone = new PriorityQueue<Event>();
	private Map<GruppoClienti, Tavolo> clientiTavolo = new HashMap<>();
	private List<GruppoClienti> clientiBancone = new ArrayList<GruppoClienti>();
	private List<GruppoClienti> clientiInsoddisfatti = new ArrayList<GruppoClienti>();

	int time = 0;

	public Model() {
		super();
	}

	public void creaTavoli() {
		tavoli = new ArrayList<>();
		tavoli.add(new Tavolo(1, 10));
		tavoli.add(new Tavolo(2, 10));
		tavoli.add(new Tavolo(3, 8));
		tavoli.add(new Tavolo(4, 8));
		tavoli.add(new Tavolo(5, 8));
		tavoli.add(new Tavolo(6, 8));
		tavoli.add(new Tavolo(7, 6));
		tavoli.add(new Tavolo(8, 6));
		tavoli.add(new Tavolo(9, 6));
		tavoli.add(new Tavolo(10, 6));
		tavoli.add(new Tavolo(11, 4));
		tavoli.add(new Tavolo(12, 4));
		tavoli.add(new Tavolo(13, 4));
		tavoli.add(new Tavolo(14, 4));
		tavoli.add(new Tavolo(15, 4));
	}

	public void genereArrivoClienti(int i) {
		Event e = new Event(creaGruppoClienti(i), time + creaTime(), EventType.ARRIVO_GRUPPO_CLIENTI);
		time += e.getTime();
		eventi.add(e);
	}

	private GruppoClienti creaGruppoClienti(int i) {
		GruppoClienti gc = new GruppoClienti("gruppo" + i, (int) (1 + Math.random() * 10), // numero
																							// di
																							// persone
																							// casuale
																							// tra
																							// 1
																							// e
																							// 10
				(int) (60 + Math.random() * 60), // tempo di permanenza casuale
													// tra 60 e 120
				(float) Math.random()); // valore di pazienza dei clienti
		return gc;
	}

	private int creaTime() {
		return (int) (1 + Math.random() * 10); // tempo di interarrivo tra i
												// clienti
	}

	public void run() {
		while (!eventi.isEmpty()) {
			Event e = eventi.poll();

			switch (e.getType()) {
			case ARRIVO_GRUPPO_CLIENTI:
				gestisciNuoviClienti(e);

			case CLIENTE_AL_BANCONE:
				break;
			case CLIENTE_AL_TAVOLO:
				eventi.add(new Event(e.getGruppoClienti(), e.getTime() + e.getGruppoClienti().getDurata(),
						EventType.TAVOLO_LIBERO));
				break;
			case TAVOLO_LIBERO:
				clientiTavolo.get(e.getGruppoClienti()).setOccupato(false);
				System.out.println("il tavolo " + clientiTavolo.get(e.getGruppoClienti()).getNumTavolo() + " è libero");
				break;
			default:
				break;
			}
		}
	}

	private void gestisciNuoviClienti(Event e) {
		for (Tavolo t : tavoli) {
			if (!t.isOccupato() && t.getNumPosti() >= e.getGruppoClienti().getNumPersone()) {
				t.setOccupato(true);
				clientiTavolo.put(e.getGruppoClienti(), t);
				eventi.add(new Event(e.getGruppoClienti(), e.getTime(), EventType.CLIENTE_AL_TAVOLO));
				System.out.println(
						e.getGruppoClienti().getNomeGruppo() + " assegnati al tavolo " + t.getNumTavolo());
				return;
			}
		}
		if (e.getGruppoClienti().getTolleranza() > 0.5) {
			clientiBancone.add(e.getGruppoClienti());
			eventi.add(new Event(e.getGruppoClienti(), e.getTime(), EventType.CLIENTE_AL_BANCONE));
			System.out.println(e.getGruppoClienti().getNomeGruppo() + " clienti al bancone");
			return;
		} else {
			clientiInsoddisfatti.add(e.getGruppoClienti());
			System.out.println(e.getGruppoClienti().getNomeGruppo() + " Questi se ne sono andati");
			return;
		}
		
	}

}
