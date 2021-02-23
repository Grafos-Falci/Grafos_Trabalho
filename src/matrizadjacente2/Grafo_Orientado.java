package matrizadjacente2;

import java.util.ArrayList;
import java.util.HashSet;

public class Grafo_Orientado extends Grafo {

    private ArrayList<Vertice> controle_vertice = new ArrayList<Vertice>();

    public String DOT_orientado() {
        String DOT;
        DOT = "digraph{\n";
        for (Aresta aresta : lista_arest) {
            DOT = DOT + aresta.getV1().getVertice() + " -> " + aresta.getV2().getVertice() + ";\n";
        }
        DOT = DOT + "}";
        return DOT;
    }

    private ArrayList<Aresta> Busca_v1(Vertice v1) {
        ArrayList<Aresta> aresta = new ArrayList<Aresta>();
        for (Aresta a : lista_arest) {
            if (a.getV1() == v1) {
                aresta.add(a);
            }
        }
        return aresta;
    }

    private ArrayList<Aresta> Busca_v2(Vertice v2) {
        ArrayList<Aresta> aresta = new ArrayList<Aresta>();
        for (Aresta a : lista_arest) {
            if (a.getV2() == v2) {
                aresta.add(a);
            }
        }
        return aresta;
    }

    private ArrayList<Vertice> Transitivo_direto(Vertice v) {
        controle_vertice.add(v);
        ArrayList<Vertice> vertice = new ArrayList<Vertice>();
        ArrayList<Aresta> aresta = Busca_v1(v);
        for (Aresta a : aresta) {
            vertice.add(a.getV2());
            if (!(controle_vertice.contains(a.getV2()))) {
                vertice.addAll(Transitivo_direto(a.getV2()));
            }
        }
        return vertice;
    }

    private ArrayList<Vertice> Transitivo_indireto(Vertice v) {
        controle_vertice.add(v);
        ArrayList<Vertice> vertice = new ArrayList<Vertice>();
        ArrayList<Aresta> aresta = Busca_v2(v);
        for (Aresta a : aresta) {
            vertice.add(a.getV1());
            if (!(controle_vertice.contains(a.getV1()))) {
                vertice.addAll(Transitivo_indireto(a.getV1()));
            }
        }
        return vertice;
    }

    public ArrayList<Vertice> Busca_TD(Vertice v) {
        controle_vertice.removeAll(controle_vertice);
        return Transitivo_direto(v);
    }

    public ArrayList<Vertice> Busca_TI(Vertice v) {
        controle_vertice.removeAll(controle_vertice);
        return Transitivo_indireto(v);
    }

    private ArrayList<Aresta> Busca_aresta(Vertice v) {
        ArrayList<Aresta> aresta = new ArrayList<Aresta>();
        for (Aresta a : lista_arest) {
            if (a.getV1() == v || a.getV2() == v) {
                aresta.add(a);
            }
        }
        return aresta;
    }


}
