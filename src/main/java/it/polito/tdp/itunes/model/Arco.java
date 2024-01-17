package it.polito.tdp.itunes.model;

public class Arco {
	private Track t1;
	private Track t2;
	private Integer peso;
	public Arco(Track t1, Track t2, Integer peso) {
		super();
		this.t1 = t1;
		this.t2 = t2;
		this.peso = peso;
	}
	public Track getT1() {
		return t1;
	}
	public Track getT2() {
		return t2;
	}
	public Integer getPeso() {
		return peso;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((peso == null) ? 0 : peso.hashCode());
		result = prime * result + ((t1 == null) ? 0 : t1.hashCode());
		result = prime * result + ((t2 == null) ? 0 : t2.hashCode());
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
		Arco other = (Arco) obj;
		if (peso == null) {
			if (other.peso != null)
				return false;
		} else if (!peso.equals(other.peso))
			return false;
		if (t1 == null) {
			if (other.t1 != null)
				return false;
		} else if (!t1.equals(other.t1))
			return false;
		if (t2 == null) {
			if (other.t2 != null)
				return false;
		} else if (!t2.equals(other.t2))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "TITOLO CANZONI DELTA MASSIMO: \n"
				+ t1.getName() + "***" + t2.getName() + "--> " + peso;
	}
	
	
	

}
