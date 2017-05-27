package it.polito.tdp.bar.model;

public class GruppoClienti {

	private String nomeGruppo;
	private int numPersone;
	private int durata;
	private float tolleranza;

	public GruppoClienti(String nomeGruppo, int numPersone, int durata, float tolleranza) {
		super();
		this.nomeGruppo = nomeGruppo;
		this.numPersone = numPersone;
		this.durata = durata;
		this.tolleranza = tolleranza;
	}

	public String getNomeGruppo() {
		return nomeGruppo;
	}

	public void setNomeGruppo(String nomeGruppo) {
		this.nomeGruppo = nomeGruppo;
	}

	public int getNumPersone() {
		return numPersone;
	}

	public void setNumPersone(int numPersone) {
		this.numPersone = numPersone;
	}

	public int getDurata() {
		return durata;
	}

	public void setDurata(int durata) {
		this.durata = durata;
	}

	public float getTolleranza() {
		return tolleranza;
	}

	public void setTolleranza(float tolleranza) {
		this.tolleranza = tolleranza;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nomeGruppo == null) ? 0 : nomeGruppo.hashCode());
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
		GruppoClienti other = (GruppoClienti) obj;
		if (nomeGruppo == null) {
			if (other.nomeGruppo != null)
				return false;
		} else if (!nomeGruppo.equals(other.nomeGruppo))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "GruppoClienti [nomeGruppo=" + nomeGruppo + "]";
	}



}
