import java.util.Scanner;
import java.io.*; 
import java.util.LinkedList;
import java.util.Queue;


class Main {
  
  
  public static void main(String[] args) throws FileNotFoundException, IOException{    
    Grafo grafo = new Grafo(0,0);
    // leitura do arquivo

     Scanner myInput = new Scanner( System.in );
     
		System.out.println("\n                  =========================");
    System.out.println("                  |  Selecione o arquivo desejado |");
		System.out.println("                  |     1 - Arquivo de 100        |");
		System.out.println("                  |     2 - Arquivo de 50.000     |");
    System.out.println("                  |     3 - Arquivo de 5          |");
		System.out.println("                  =========================\n");
    
    int selecao = myInput.nextInt();

    if(selecao == 1)
    {
      selecao = 100;
    }
    else if(selecao == 2)
    {
      selecao = 50000;
    }
    else if(selecao == 3)
    {
      selecao = 5;
    }
    





    


    
    File file = new File("graph-test-"+selecao+".txt");
		Scanner scan = new Scanner(file);  //passar linha por linha  
    
    // Pulando cabeçalho
    if(scan.hasNextLine()){ //se tiver uma linha ele lé o arquivo
      int tam = Integer.parseInt(scan.next());
      System.out.println("TAMANHO:" +tam);
      grafo = new Grafo(tam,tam);
        scan.nextLine();
    }
    // Lendo o restante do arquivo
    while(scan.hasNextLine()){
      int pred = Integer.parseInt(scan.next());
      int suc = Integer.parseInt(scan.next());  
      grafo.Insere_ligacao(pred,suc);
      scan.nextLine();
      //break;
    }
  /* 
      String fileName = "/graph-test-100.txt";
      Scanner in = new Scanner(new FileReader(fileName));
      while (in.hasNextLine()) {      
        String line = in.nextLine();
        System.out.println(line);
      }    
      grafo.Insere_ligacao(4,1); //coluna linha
      grafo.Insere_ligacao(4,2); //coluna linha
      grafo.Insere_ligacao(1,4); //coluna linha
  */
    grafo.chama_menu();
    
    //grafo.printMatriz();

    //grafo.verifica_sucessor(4);
    // grafo.verifica_antessesor(4);


    
  }
}