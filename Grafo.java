import java.io.FileOutputStream;
import java.io.File;
import java.io.*; 
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.BufferedReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.LinkedList;
import java.util.Queue;


public class Grafo{
      private int linhas;
      private int colunas;
      private int matriz[][];
      private int visitado[]; //vertice visitado
      private int predecessor[];
  
    public Grafo(int linhas,int colunas)
    {
        this.linhas = linhas;
        this.colunas = colunas;
        this.matriz = new int[this.linhas+1][this.colunas+1];
        this.visitado = new int[this.linhas+1];
        this.predecessor = new int[this.linhas+1];
       this.gerarMatriz();
      
      
    }

      // Preenche a matriz
    public void gerarMatriz(){
        for ( int i = 0 ; i < this.linhas ; i++ ) {
            for ( int j = 0 ; j < this.colunas ; j++ ) {
                this.matriz[i][j] = 0;
            }
        }
    }



    public void printMatriz(){
        for ( int i = 1 ; i < this.linhas+1 ; i++ ) {
            for ( int j = 1 ; j < this.colunas+1 ; j++ ) {
                     System.out.printf("%d -", matriz[i][j]);
            }
           System.out.printf("%n");
        }
    }


 public void Insere_ligacao(int m,int n)//passa vertices e arestas
  {
    this.matriz[m][n] = 1; //preenche o dado
  }

  
 public  void verifica_sucessor(int vertice)
  {
    int cont = 0;

    for(int i = 1;i< colunas; i++)
      {
       
        if(matriz[vertice][i] == 1)
        {
       
          System.out.printf("Sucessores do vertice:%d ->vertice:%d \n",vertice,i);
             cont++;
        }

     
        
      }

      if(cont == 0)
        {
          System.out.printf("Não possui sucessores,grau 0");
        }
        else
      {
           System.out.printf("nVertice sucessor - Grau Saida:%d -",cont);
      }
      
   
    
  }

  public  void verifica_antessesor(int vertice)
  {
    int cont = 0;
  
    
    for(int i=1;i<linhas;i++)
      {
          if(matriz[i][vertice] == 1)
          {
               System.out.printf("\nAntecessor do vertice:%d ->vertice:%d \n",vertice,i);
            cont++;
          }
       
        
      }

         if(cont == 0)
          {
               System.out.printf("\nNão possui Antecessores,grau 0\n");
            
          }
          else
         {
            System.out.printf("nVertice Antessesor - Grau Entrada:%d -",cont);
         }

    
  }


  public void Inicializa_visitado()
  {

        for ( int i = 1 ; i < this.linhas+1 ; i++ )
          {
                    this.visitado[i] = 0; //vertice visitado
        
          }

  }
  

  
  public void Busca_Largura(int selecao)
  {

   
     Inicializa_visitado(); //inicializa com 0
     this.visitado[selecao] = 1; //inicializa a posicao visitado com 1

    Queue<Integer> fila = new LinkedList<>(); //cria fila vasia
    fila.add(selecao);//enfilera o selecao
    
   
    while(fila.peek() != null) //enquanto a fila n for vasia
      {
         
      Integer k = fila.poll();
      int u = k != null ? k.intValue() : 0; //converte pra inteiro
      System.out.println(k); //Desenfilera a posicao
        
        
        for(int i=1;i<this.linhas+1;i++) //vai percorrer a matriz
          {
             if(this.matriz[u][i] == 1) //ele roda na posicao 2 - visualiza as posicoens que foram visitadas
             {  
                if(this.visitado[i] == 0) //verifica se a posicao ainda n foi visitada 
                {
                    //se nao foi salva
                  this.visitado[i] = 1;
                  this.predecessor[i] = u; //saber o pai

                  fila.add(i); //adiciona na fila pra rodar
                  
                }
        
             }
           
          }
        
        
      }


    
    
  
  }


  public void Busca_largura(int selecao)
  {
      Inicializa_visitado(); //inicializa com 0
      this.visitado[selecao] = 1; //inicializa a posicao visitado com 1

      Queue<Integer> fila = new LinkedList<>(); //cria fila vasia
      System.out.println(fila);
    
      //fila.add(selecao);//enfilera o selecao
      Integer k = fila.poll();
      int u = k != null ? k.intValue() : 0;
      System.out.println(k);
        
    

    

    
  }

  public void chama_menu()
  {
    menu();
  }
  

  private void menu() { // menu principal
	int opcao = 0;
  int vertice;
	do {

     Scanner myInput = new Scanner( System.in );

		System.out.println("\n                  =========================");
		System.out.println("                  |     1 - Print Matriz  |");
		System.out.println("                  |     2 - Sucessor      |");
		System.out.println("                  |     3 - antecessor    |");
    System.out.println("                  |     4 - Busca Largura |");
		System.out.println("                  |     0 - Sair          |");
		System.out.println("                  =========================\n");

		opcao = myInput.nextInt();
		System.out.print("\n");
		switch (opcao) {
		case 1:
        printMatriz();
			break;
		case 2:
      System.out.println("Digite um Vertice");
      vertice = myInput.nextInt();
			verifica_sucessor(vertice);
			break;
    case 3:
      System.out.println("Digite um Vertice");
      vertice = myInput.nextInt();
			verifica_antessesor(vertice);
			break;
    case 4:
    System.out.println("Digite um Vertice");
    vertice = myInput.nextInt();
    Busca_Largura(vertice);
			break;  
		case 5:
			//cliente();
			break;
		case 0:
			break;
		default:
			System.out.println("Opção Inválida!");
			break;
		}
	} while (opcao != 0);
}


  

  
}



    
  