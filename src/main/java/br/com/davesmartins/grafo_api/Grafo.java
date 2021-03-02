package br.com.davesmartins.grafo_api;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.util.ArrayList;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;

public class Grafo {

    protected ArrayList<Vertice> lista_vert = new ArrayList<Vertice>();
    protected ArrayList<Aresta> lista_arest = new ArrayList<Aresta>();
    private ArrayList<Vertice> controle_vertice = new ArrayList<Vertice>();

    public void addAresta(Aresta a) {
        lista_arest.add(a);
    }

    public void addVertice(Vertice v) {
        lista_vert.add(v);
    }

    public int Ordem() {
        return lista_vert.size();
    }

    public int Grau(String v) {
        int cont = 0;
        for (Aresta a : lista_arest) {
            if (v.equals(a.getV1().getVertice()) || v.equals(a.getV2().getVertice())) {
                cont++;
            }
        }
        return cont;
    }

    public void removeAresta(Aresta a) {
        lista_arest.remove(a);
    }

    public void removeVertice(Vertice v) {
        for (Aresta a : lista_arest) {
            if (a.getV1() == v || a.getV2() == v) {
                this.removeAresta(a);
            }
        }
        lista_vert.remove(v);
    }

    public String DOT_simples() {
        String DOT;
        DOT = "graph{\n";
        for (Aresta aresta : lista_arest) {
            DOT = DOT + aresta.getV1().getVertice() + " -- " + aresta.getV2().getVertice() + aresta.getLabel() + ";\n";
        }
        DOT = DOT + "}";
        return DOT;
    }

    public String Gravar_arquivo(String nome) {

        try (FileWriter fw = new FileWriter(nome + ".txt")) {
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(DOT_simples());
            bw.flush();
            System.out.println("Gravacao realizada com sucesso");
        } catch (IOException ex) {
            System.out.println("Gravacao realizada com sucesso");
        }
        return null;
    }

    public String Ler_arquivo(String nome) {

        try (FileReader fr = new FileReader(nome + ".txt")) {
            BufferedReader br = new BufferedReader(fr);
            String content;
            while ((content = br.readLine()) != null) {
                System.out.println(content);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public boolean verificaAresta(Vertice v1, Vertice v2) {
        for (Aresta a : lista_arest) {
            if ((a.getV1() == v1 && a.getV2() == v2) || (a.getV1() == v2 && a.getV2() == v1)) {
                return true;
            }
        }
        return false;
    }

    public boolean Grafo_regular() {

        int grauReferencia = Grau(lista_vert.get(0).getVertice());
        for (Vertice v : lista_vert) {

            if (grauReferencia != Grau(v.getVertice())) {
                return false;
            }
        }
        return true;
    }

    public int[][] Matriz_adjc() {

        int matriz[][] = new int[lista_vert.size()][lista_vert.size()];
        for (Vertice linha : lista_vert) {

            for (Vertice coluna : lista_vert) {
                if (verificaAresta(linha, coluna)) {
                    matriz[lista_vert.indexOf(linha)][lista_vert.indexOf(coluna)] = 1;
                } else {
                    matriz[lista_vert.indexOf(linha)][lista_vert.indexOf(coluna)] = 0;
                }
            }
        }
        return matriz;
    }

    public boolean Grafo_completo() {
        int matriz[][] = Matriz_adjc();
        for (int linha = 0; linha < lista_vert.size(); linha++) {
            for (int coluna = 0; coluna < lista_vert.size(); coluna++) {
                if (linha == coluna && matriz[linha][coluna] != 0) {
                    return false;
                } else {
                    if (linha != coluna && matriz[linha][coluna] != 1) {
                        return false;
                    }
                }
            }
        }
        return true;
    }



    public ArrayList<Aresta> Busca_todos(Vertice v1) {
        ArrayList<Aresta> aresta = new ArrayList<Aresta>();
        for (Aresta a : lista_arest) {
            if (a.getV1() == v1 || a.getV2() == v1) {
                aresta.add(a);
            }
        }
        return aresta;
    }

    public ArrayList<Vertice> ListaConexaoAresta(Vertice v) {
        controle_vertice.add(v);
        ArrayList<Vertice> vertice = new ArrayList<Vertice>();
        ArrayList<Aresta> aresta = Busca_todos(v);
        for (Aresta a : aresta) {
            Vertice vertref;
            if(v == a.getV2()){
            vertref = a.getV1();
            }else{
            vertref = a.getV2();
            }
            vertice.add(vertref);
            if (!(controle_vertice.contains(vertref))) {
                vertice.addAll(ListaConexaoAresta(vertref));
            }
        }
        return vertice;
    }

    public ArrayList<Aresta> Busca_aresta(Vertice v) {
        ArrayList<Aresta> aresta = new ArrayList<Aresta>();
        for (Aresta a : lista_arest) {
            if (a.getV1() == v || a.getV2() == v) {
                aresta.add(a);
            }
        }
        return aresta;
    }

    public ArrayList<Vertice> Aresta_vertice(Vertice v) {
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
        public void setCorAresta(Vertice v1, Vertice v2) {
        do {
            for (Aresta a : lista_arest) {
                if (a.getV1().equals(v2.getPai()) && a.getV2().equals(v2)) {
                    a.setCor_seta("red");
                }
            }
            v2 = v2.getPai();
        } while (v2 != v1);
    }
    

    public void dijkstra(Vertice s) {
        for (Vertice v : lista_vert) {
            v.setDistancia(Double.POSITIVE_INFINITY);
            v.setPai(null);
        }

        s.setDistancia(0);
        ArrayList<Vertice> S = new ArrayList<Vertice>();
        ArrayList<Vertice> Q = new ArrayList<Vertice>();
        Q.addAll(lista_vert);

        while (!Q.isEmpty()) {
            Vertice u = extrairMinimo(Q);
            Q.remove(u);
            S.add(u);

            for (Vertice v : ListaConexaoAresta(u)) {
                
                    if (v.getDistancia() > (u.getDistancia() + getPesoAresta(u, v))) {

                        v.setDistancia(u.getDistancia() + getPesoAresta(u, v));
                        v.setPai(u);
                    }
                

            }
        }
    }

    public double getPesoAresta(Vertice v1, Vertice v2) {
        if (v1.equals(v2)) {
            return 0;
        }
        for (Aresta aresta : lista_arest) {
            if (aresta.getV1().equals(v1) && aresta.getV2().equals(v2)) {
                return aresta.getValor();
            }
        }
        return Double.POSITIVE_INFINITY;
    }

    public Vertice extrairMinimo(ArrayList<Vertice> list) {

        Vertice v1 = list.get(0);
        for (Vertice v : list) {
            if (v1.getDistancia() > v.getDistancia()) {
                v1 = v;
            }
        }
        return v1;
    }

    public double getDistMinVertices(Vertice v1, Vertice v2) {
        dijkstra(v1);
        setCorAresta(v1, v2);
        return v2.getDistancia();
    }
}
