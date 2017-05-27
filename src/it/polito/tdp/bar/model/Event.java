package it.polito.tdp.bar.model;

public class Event implements Comparable<Event>{

	public enum EventType {
		ARRIVO_GRUPPO_CLIENTI,
		CLIENTE_AL_TAVOLO,
		CLIENTE_AL_BANCONE,
		TAVOLO_LIBERO,
	};

	private GruppoClienti gruppoClienti;
	private int time;
	private EventType type;

	public Event(GruppoClienti gruppoClienti, int time, EventType type) {
		super();
		this.gruppoClienti = gruppoClienti;
		this.time = time;
		this.type = type;
	}

	public GruppoClienti getGruppoClienti() {
		return gruppoClienti;
	}

	public void setGruppoClienti(GruppoClienti gruppoClienti) {
		this.gruppoClienti = gruppoClienti;
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}

	public EventType getType() {
		return type;
	}

	public void setType(EventType type) {
		this.type = type;
	}

	@Override
	public int compareTo(Event other) {
		return this.time-other.time;
	}

	@Override
	public String toString() {
		return "Event [gruppoClienti=" + gruppoClienti + ", time=" + time + ", type=" + type + "]";
	}
	
	

}
