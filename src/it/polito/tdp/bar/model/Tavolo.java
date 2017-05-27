package it.polito.tdp.bar.model;

public class Tavolo {

	private int numTavolo;
	private int numPosti;
	private boolean isOccupato;

	public Tavolo(int numTavolo, int numPosti) {
		super();
		this.numTavolo = numTavolo;
		this.numPosti = numPosti;
		this.isOccupato = false;
	}

	public boolean isOccupato() {
		return isOccupato;
	}

	public void setOccupato(boolean isOccupato) {
		this.isOccupato = isOccupato;
	}

	public int getNumTavolo() {
		return numTavolo;
	}

	public int getNumPosti() {
		return numPosti;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + numTavolo;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tavolo other = (Tavolo) obj;
		if (numTavolo != other.numTavolo)
			return false;
		return true;
	}



}
