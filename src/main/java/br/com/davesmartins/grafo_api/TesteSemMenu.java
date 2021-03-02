package br.com.davesmartins.grafo_api;

import br.com.davesmartins.api.Graph;
import java.io.IOException;
import java.util.Scanner;

public class TesteSemMenu {

    public static void main(String[] args) throws IOException {
        GrafoOrientado grafo = new GrafoOrientado();
        Grafo grafinho = new Grafo();

        Vertice v1 = new Vertice("v1");
        Vertice v2 = new Vertice("v2");
        Vertice v3 = new Vertice("v3");
        Vertice v4 = new Vertice("v4");
        Vertice v5 = new Vertice("v5");

        grafinho.addVertice(v1);
        grafinho.addVertice(v2);
        grafinho.addVertice(v3);
        grafinho.addVertice(v4);
        grafinho.addVertice(v5);

        Aresta a1 = new Aresta(v1, v2, 4);
        Aresta a2 = new Aresta(v2, v3, 3);
        Aresta a3 = new Aresta(v3, v4, 5);
        Aresta a4 = new Aresta(v4, v5, 1);
        Aresta a5 = new Aresta(v2, v5, 11);

        grafinho.addAresta(a1);
        grafinho.addAresta(a2);
        grafinho.addAresta(a3);
        grafinho.addAresta(a4);
        grafinho.addAresta(a5);

        System.out.println(grafinho.getDistMinVertices(v1, v5));
        System.out.println(grafinho.DOT_simples());
        Graph.createStringDotToPng(grafinho.DOT_simples(), "teste.png");
    }
}
