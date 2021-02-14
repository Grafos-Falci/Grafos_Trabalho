package matrizadjacente2;

import java.util.Scanner;

public class Teste_Grafo {

    public static void main(String[] args) {
        Grafo grafo = new Grafo();
        
        Scanner leitor = new Scanner(System.in);
        
        int op = 0;
        
        while (op != 4) {
            System.out.println("---------------MENU---------------");
            System.out.println("1 - Ler Grafo Manual");
            System.out.println("2 - Ler Grafo de Arquivo");
            System.out.println("3 - Mostrar dados");
            System.out.println("4 - Sair");

            op = leitor.nextInt();
            
            switch (op) {

                case 1:
                    int op1 = 0;
                    while (op1 != 3) {
                        
                        System.out.println("---------------Operacoes---------------");
                        System.out.println("1 - Inserir Vertice");
                        System.out.println("2 - Inserir Aresta");
                        System.out.println("3 - Sair");
                        op1 = leitor.nextInt();

                        switch (op1) {
                            case 1:
                                System.out.println("Vertice: ");
                                String v = leitor.next();
                                Vertice vertice = new Vertice(v);
                                grafo.addVertice(vertice);
                                break;
                            case 2:
                                if (grafo.Ordem() < 2) {
                                    System.out.println("Operacao Invalida! (vertices insuficientes)");
                                    break;
                                }
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
                                break;
                        }
                        
                    }
                    break;

                case 2:
                    break;

                case 3:
                    int op3 = 0;
                    while(op != 4){
                    System.out.println("---------------Matriz---------------");
                    System.out.println("1 - Mostrar Ordem");
                    System.out.println("2 - Mostrar Grau");
                    System.out.println("3 - Mostrar Matriz");
                    System.out.println("4 - Sair");
                    op3 = leitor.nextInt();

                    switch (op3) {
                        case 1:
                            System.out.println("Ordem: "+ grafo.Ordem());
                            break;
                        case 2:
                            System.out.println("Informe o vertice: ");
                                String v = leitor.next();
                                Vertice vertice = new Vertice(v);
                            System.out.println("Grau: "+ grafo.Grau(vertice));
                            break;
                        case 3: 
                            grafo.imprimeMatriz();                          
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
