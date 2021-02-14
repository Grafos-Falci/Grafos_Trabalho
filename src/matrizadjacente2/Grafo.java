package matrizadjacente2;

import java.util.ArrayList;

public class Grafo {

    private ArrayList<Vertice> lista_vert = new ArrayList<Vertice>();
    private ArrayList<Aresta> lista_arest = new ArrayList<Aresta>();

    public void imprimeMatriz() {
        String matrix;
        matrix = "";
        for (Vertice linha : lista_vert) {
            matrix = matrix + linha.getVertice() + " ";
            for (Vertice coluna : lista_vert) {

                if (verificaAresta(coluna, linha)) {
                    matrix = matrix + "1 ";
                } else {
                    matrix = matrix + "0 ";
                }
            }
            matrix = matrix + "\n";
        }
        System.out.println(matrix);
    }

    public void addAresta(Aresta a) {
        lista_arest.add(a);
    }

    public void addVertice(Vertice v) {
        lista_vert.add(v);
    }

    public boolean verificaAresta(Vertice v1, Vertice v2) {
        for (Aresta a : lista_arest) {
            if ((a.getV1() == v1 && a.getV2() == v2) || (a.getV1() == v2 && a.getV2() == v1)) {
                return true;
            }
        }
        return false;
    }

    public int Ordem() {
        return lista_vert.size();
    }

    public int Grau(Vertice v) {
        int cont = 0;
        for (Aresta a : lista_arest) {
            if (v == a.getV1() || v == a.getV2()) {
                cont++;
            }
        }
        return cont;
    }

    public void removeAresta(Aresta a) {
        lista_arest.remove(a);
    }

    public void removeVertice(Vertice v) {
        for(Aresta a: lista_arest){
        if(a.getV1() == v || a.getV2() == v){
            this.removeAresta(a);
        }
        }
        lista_vert.remove(v);
    }
}
