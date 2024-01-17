package it.polito.tdp.itunes.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


import org.jgrapht.Graphs;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleWeightedGraph;

import it.polito.tdp.itunes.db.ItunesDAO;

public class Model {
	private ItunesDAO dao;
	private SimpleWeightedGraph<Track, DefaultWeightedEdge> grafo;
	private Map<Integer, Track> idMap;
	
	public Model() {
		this.dao = new ItunesDAO();
		this.idMap = this.dao.getAllTracks(idMap);
	}
	
	public void creaGrafo(Genre genere) {
		
		//CREO IL GRAFO
		this.grafo = new SimpleWeightedGraph<Track, DefaultWeightedEdge> (DefaultWeightedEdge.class);
		
		//VERTICI
		Graphs.addAllVertices(this.grafo, this.dao.getVertici(genere));
		
		//ARCHI
		for (Arco a: this.archi(genere)) {
			Graphs.addEdgeWithVertices(this.grafo, a.getT1(), a.getT2(), a.getPeso());
		}

	}
	
	public List<Arco> trovaCollegate() {
		List<Arco> collegate = new ArrayList<Arco>();
		int durata = 0;
		for (DefaultWeightedEdge e: this.grafo.edgeSet()) {
			int peso = (int) this.grafo.getEdgeWeight(e);
			if (peso > durata) {
				collegate.clear();
				collegate.add(new Arco(this.grafo.getEdgeSource(e), this.grafo.getEdgeTarget(e), peso));
				durata = peso;
			}
			else if(peso==durata) {
				collegate.add(new Arco(this.grafo.getEdgeSource(e), this.grafo.getEdgeTarget(e), peso));
			}
			
		}
		return collegate;
		
	}

	public List<Genre> getGeneri() {
		return this.dao.getAllGenres();
	}

	public int vertexSet() {
		return this.grafo.vertexSet().size();
	}
	public int EdgeSet() {
		return this.grafo.edgeSet().size();
	}
	
	public List<Arco> archi(Genre genere){
		return this.dao.getArco(genere, idMap);
	}
	
}
