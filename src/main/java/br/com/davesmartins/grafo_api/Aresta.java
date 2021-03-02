package br.com.davesmartins.grafo_api;

public class Aresta {

    private Vertice v1;
    private Vertice v2;
    private double valor;
    String cor_seta;

    public Aresta(Vertice v1, Vertice v2) {
        this.v1 = v1;
        this.v2 = v2;
    }
    public Aresta(Vertice v1, Vertice v2, double valor) {
        this.v1 = v1;
        this.v2 = v2;
        this.valor = valor;
    }
    
    public Vertice getV1() {
        return v1;
    }

    public void setV1(Vertice v1) {
        this.v1 = v1;
    }

    public Vertice getV2() {
        return v2;
    }

    public void setV2(Vertice v2) {
        this.v2 = v2;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getLabel() {
        if(this.valor == 0){
        return "";
        }else{
            return "[label=" + this.valor + ",weight=" + this.valor + ",color=" + this.cor_seta + "]";
        }    
    }

    public String getCor_seta() {
        return cor_seta;
    }

    public void setCor_seta(String cor_seta) {
        this.cor_seta = cor_seta;
    }    
}