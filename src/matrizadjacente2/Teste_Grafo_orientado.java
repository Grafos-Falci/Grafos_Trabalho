package matrizadjacente2;

import java.util.Scanner;

public class Teste_Grafo_orientado {

    public static void main(String[] args) {
        Grafo_Orientado grafo = new Grafo_Orientado();

        Vertice v1 = new Vertice("v1");
        Vertice v2 = new Vertice("v2");
        Vertice v3 = new Vertice("v3");

        grafo.addVertice(v1);
        grafo.addVertice(v2);
        grafo.addVertice(v3);

        Aresta a1 = new Aresta(v1, v2);
        Aresta a2 = new Aresta(v2, v3);
        Aresta a3 = new Aresta(v3, v1);
        

        grafo.addAresta(a1);
        grafo.addAresta(a2);
        grafo.addAresta(a3);
      

        System.out.println(grafo.Verifica_conexao());
    }

}
