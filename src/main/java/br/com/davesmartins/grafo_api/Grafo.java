package br.com.davesmartins.grafo_api;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.util.ArrayList;
import java.io.FileWriter;
import java.io.IOException;

public class Grafo {

    protected ArrayList<Vertice> lista_vert = new ArrayList<Vertice>();
    protected ArrayList<Aresta> lista_arest = new ArrayList<Aresta>();

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
            DOT = DOT + aresta.getV1().getVertice() + " -- " + aresta.getV2().getVertice() + ";\n";
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

}
