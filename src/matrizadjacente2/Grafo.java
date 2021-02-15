package matrizadjacente2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.util.ArrayList;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.JOptionPane;

public class Grafo {

    private ArrayList<Vertice> lista_vert = new ArrayList<Vertice>();
    private ArrayList<Aresta> lista_arest = new ArrayList<Aresta>();

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

    public String matrizsiples() {
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
            bw.write(matrizsiples());
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
}
