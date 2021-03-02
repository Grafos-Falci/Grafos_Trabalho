package br.com.davesmartins.grafo_api;

public class Vertice {

    private String vertice;
    private double distancia;
 
    private Vertice pai;

    private int q_aresta;

    Vertice(String v) {
        this.vertice = v;

    }

    public String getVertice() {
        return vertice;
    }

    public void setVertice(String vertice) {
        this.vertice = vertice;
    }

    public int getQ_aresta() {
        return q_aresta;
    }

    public void setQ_aresta(int q_aresta) {
        this.q_aresta = q_aresta;
    }

    public double getDistancia() {
        return distancia;
    }

    public void setDistancia(double distancia) {
        this.distancia = distancia;
    }

    public Vertice getPai() {
        return pai;
    }

    public void setPai(Vertice pai) {
        this.pai = pai;
    }
    
}
