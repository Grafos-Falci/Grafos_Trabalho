package br.com.davesmartins.grafo_api;

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

    private ArrayList<Vertice> Aresta_vertice(Vertice v) {
        ArrayList<Aresta> aresta = Busca_aresta(v);
        ArrayList<Vertice> vertice = new ArrayList<Vertice>();
        vertice.add(v);
        controle_vertice.add(v);
        for (Aresta a : aresta) {
            if ((a.getV1() == v) && (a.getV2() == v)) {

            } else {
                if (a.getV1() == v) {
                    if (!(controle_vertice.contains(a.getV2()))) {
                        vertice.add(a.getV2());
                        vertice.addAll(Aresta_vertice(a.getV2()));
                    } else {
                        if (!(controle_vertice.contains(a.getV1()))) {
                            vertice.add(a.getV1());
                            vertice.addAll(Aresta_vertice(a.getV1()));
                        }
                    }
                }
            }

        }
        return vertice;
    }

    public boolean Verifica_conexao() {
        controle_vertice.removeAll(controle_vertice);
        ArrayList<Vertice> vertice = Aresta_vertice(lista_vert.get(0));
        vertice = new ArrayList<Vertice>(new HashSet<Vertice>(vertice));
        System.out.println(vertice.size());
        if (vertice.size() == lista_vert.size()) {
            return true;
        } else {
            return false;
        }
    }
}
