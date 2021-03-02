package br.com.davesmartins.grafo_api;

import br.com.davesmartins.api.Graph;
import java.io.IOException;
import java.util.Scanner;

public class TesteMenu {

    public static void main(String[] args) throws IOException {
        Grafo grafo = new Grafo();
        GrafoOrientado grafo_orientado = new GrafoOrientado();

        Scanner leitor = new Scanner(System.in);

        int op = 0;

        while (op != 4) {
            System.out.println("---------------MENU---------------");
            System.out.println("1 - Montar Grafo");
            System.out.println("2 - Ler/Gravar Arquivo");
            System.out.println("3 - Mostrar Dados do Grafo");
            System.out.println("4 - Sair");

            op = leitor.nextInt();

            switch (op) {

                case 1:
                    int op1 = 0;
                    while (op1 != 3) {
                        System.out.println("---------------Grafo---------------");
                        System.out.println("1 - Montar Grafo nao Orientado");
                        System.out.println("2 - Montar Grafo Orientado");
                        System.out.println("3 - Sair");
                        op1 = leitor.nextInt();
                        switch (op1) {
                            case 1:
                                int op11 = 0;
                                while (op11 != 4) {

                                    System.out.println("---------------Operacoes---------------");
                                    System.out.println("1 - Inserir Vertice");
                                    System.out.println("2 - Inserir Aresta");
                                    System.out.println("3 - Inserir Aresta(Valorada)");
                                    System.out.println("4 - Sair");
                                    op11 = leitor.nextInt();

                                    switch (op11) {
                                        case 1:
                                            System.out.println("Vertice: ");
                                            String v = leitor.next();
                                            Vertice vertice = new Vertice(v);
                                            grafo.addVertice(vertice);
                                            break;
                                        case 2:
                                            System.out.println("Vertice 1: ");
                                            String v1 = leitor.next();
                                            Vertice vertice1 = new Vertice(v1);

                                            System.out.println("Vertice 2: ");
                                            String v2 = leitor.next();
                                            Vertice vertice2 = new Vertice(v2);
                                            Aresta aresta = new Aresta(vertice1, vertice2);
                                            grafo.addAresta(aresta);
                                            break;
                                        case 3:
                                            System.out.println("Vertice 1: ");
                                            v1 = leitor.next();
                                            Vertice vertice3 = new Vertice(v1);

                                            System.out.println("Vertice 2: ");
                                            v2 = leitor.next();
                                            Vertice vertice4 = new Vertice(v2);

                                            System.out.println("Insira o valor da Aresta: ");
                                            double valor = leitor.nextDouble();
                                            Aresta aresta1 = new Aresta(vertice3, vertice4, valor);
                                            grafo.addAresta(aresta1);
                                            break;
                                    }
                                }

                                break;
                            case 2:
                                int op12 = 0;
                                while (op12 != 4) {

                                    System.out.println("---------------Operacoes---------------");
                                    System.out.println("1 - Inserir Vertice");
                                    System.out.println("2 - Inserir Aresta");
                                    System.out.println("3 - Inserir Aresta(Valorada)");
                                    System.out.println("4 - Sair");
                                    op12 = leitor.nextInt();

                                    switch (op12) {
                                        case 1:
                                            System.out.println("Vertice: ");
                                            String v = leitor.next();
                                            Vertice vertice = new Vertice(v);
                                            grafo_orientado.addVertice(vertice);
                                            break;
                                        case 2:
                                            System.out.println("Vertice de origem: ");
                                            String v1 = leitor.next();
                                            Vertice vertice1 = new Vertice(v1);

                                            System.out.println("Vertice de chegada: ");
                                            String v2 = leitor.next();
                                            Vertice vertice2 = new Vertice(v2);
                                            Aresta aresta = new Aresta(vertice1, vertice2);
                                            grafo_orientado.addAresta(aresta);
                                            break;
                                        case 3:
                                            System.out.println("Vertice 1: ");
                                            v1 = leitor.next();
                                            Vertice vertice3 = new Vertice(v1);

                                            System.out.println("Vertice 2: ");
                                            v2 = leitor.next();
                                            Vertice vertice4 = new Vertice(v2);

                                            System.out.println("Insira o valor da Aresta: ");
                                            double valor = leitor.nextDouble();
                                            Aresta aresta1 = new Aresta(vertice3, vertice4, valor);
                                            grafo.addAresta(aresta1);
                                            break;
                                    }
                                    break;
                                }

                                break;
                            case 3:
                                break;
                        }

                    }
                    break;

                case 2:
                    int op2 = 0;
                    while (op2 != 5) {
                        System.out.println("---------------Matriz---------------");
                        System.out.println("1 - Gravar Arquivo (texto)");
                        System.out.println("2 - Ler Arquivo (texto)");
                        System.out.println("3 - Gerar Imagem via arquivo");
                        System.out.println("4 - Gerar Imagem via strin1g");
                        System.out.println("5 - Sair");
                        op2 = leitor.nextInt();

                        switch (op2) {
                            case 1:
                                System.out.println("Informe o nome do arquivo para criar: ");
                                String nome = leitor.next();
                                grafo.Gravar_arquivo(nome);
                                break;
                            case 2:
                                System.out.println("Informe o nome do arquivo para criar: ");
                                nome = leitor.next();
                                grafo.Ler_arquivo(nome);
                                break;
                            case 3:
                                System.out.println("Informe o nome do arquivo a ser lido: ");
                                String arquivo = leitor.next();
                                System.out.println("Informe o nome da imagem a ser criada: ");
                                String imagem = leitor.next();
                                 {
                                    try {
                                        Graph.createFileDotToPng(arquivo, imagem);
                                    } catch (IOException ex) {
                                        System.out.println("ERRO");
                                    }
                                }
                                break;

                            case 4:
                                System.out.println("Informe o nome do arquivo (texto) a ser lido: ");
                                nome = leitor.next();
                                System.out.println("Informe o nome da imagem a ser criada: ");
                                imagem = leitor.next();
                                 {
                                    try {
                                        Graph.createStringDotToPng(nome, imagem);
                                    } catch (IOException ex) {
                                        System.out.println("ERRO");
                                    }
                                }
                                break;

                            case 5:
                                break;
                        }

                    }
                    break;

                case 3:
                    int op3 = 0;
                    while (op != 12) {
                        System.out.println("---------------Matriz---------------");
                        System.out.println("1 - Mostrar Ordem");
                        System.out.println("2 - Mostrar Grau");
                        System.out.println("3 - Mostrar Matriz Orientado");
                        System.out.println("4 - Mostrar DOT nao Orientado");
                        System.out.println("5 - Mostrar DOT Orientado");
                        System.out.println("6 - Grafo Regular?");
                        System.out.println("7 - Grafo Completo?");
                        System.out.println("8 - Mostrar Fecho Transitivo Direto");
                        System.out.println("9 - Mostrar Fecho Transitivo Inverso");
                        System.out.println("10 -Mostrar conexidade");
                        System.out.println("11 -Gerar menor caminho (orientado)");
                        System.out.println("12 -Gerar menor caminho (nao orientado)");
                        System.out.println("13 - Sair");
                        op3 = leitor.nextInt();

                        switch (op3) {
                            case 1:
                                System.out.println("Ordem: " + grafo.Ordem());
                                break;
                            case 2:
                                System.out.println("Informe o vertice: ");
                                String v = leitor.next();
                                System.out.println("Grau: " + grafo.Grau(v));
                                break;
                            case 3:
                                System.out.println(grafo.Matriz_adjc());
                                break;
                            case 4:
                                System.out.println(grafo.DOT_simples());
                                break;
                            case 5:
                                System.out.println(grafo_orientado.DOT_orientado());
                                break;
                            case 6:
                                if (grafo.Grafo_regular()) {
                                    System.out.println("Regular");
                                } else {
                                    System.out.println("Nao Regular");
                                }
                                break;
                            case 7:
                                if (grafo_orientado.Grafo_completo()) {
                                    System.out.println("Completo");
                                } else {
                                    System.out.println("Nao Completo");
                                }
                                break;
                            case 8:
                                System.out.println("Fecho Transitivo Direto(Informe o Vertice): ");
                                v = leitor.next();
                                Vertice vertice_ftd = new Vertice(v);
                                grafo_orientado.Busca_TD(vertice_ftd);
                                break;
                            case 9:
                                System.out.println("Fecho Transitivo Inverso(Informe o Vertice): ");
                                v = leitor.next();
                                Vertice vertice_fti = new Vertice(v);
                                grafo_orientado.Busca_TD(vertice_fti);
                                break;
                            case 10:
                                if (grafo_orientado.Verifica_conexao()) {
                                    System.out.println("Conexo");
                                } else {
                                    System.out.println("Nao Conexo");
                                }
                                break;
                            case 11:
                                System.out.println("Informe o vertice de origem");
                                String v1 = leitor.next();
                                Vertice vert1 = new Vertice(v1);

                                System.out.println("Informe o vertice de destino");
                                String v2 = leitor.next();
                                Vertice vert2 = new Vertice(v2);

                                System.out.println("Ditancia menor caminho = " + grafo_orientado.getDistMinVertices(vert1, vert2));
                                System.out.println(grafo_orientado.DOT_orientado());
                                System.out.println(grafo_orientado.getDistMinVertices(vert1, vert2));
                                Graph.createStringDotToPng(grafo_orientado.DOT_orientado(), "orientadoDistancia.png");

                                break;

                            case 12:
                                System.out.println("Informe o vertice de origem");
                                String v3 = leitor.next();
                                Vertice vert3 = new Vertice(v3);

                                System.out.println("Informe o vertice de destino");
                                String v4 = leitor.next();
                                Vertice vert4 = new Vertice(v4);

                                System.out.println("Ditancia menor caminho = " + grafo_orientado.getDistMinVertices(vert3, vert4));
                                System.out.println(grafo.DOT_simples());
                                System.out.println(grafo.getDistMinVertices(vert3, vert4));
                                Graph.createStringDotToPng(grafo.DOT_simples(), "orientadoDistancia.png");
                                break;


                        }
                    }
                    break;

                case 4:
                    System.exit(0);

            }
        }

    }
}
