package main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import Utilc.Cores1;
import modelo.produto;
import ribeirinho.util.Cores;
import util.utils;


public class deposito {

	private static Scanner leia = new Scanner(System.in);
	private static ArrayList<produto>Produtos;
	private static Map<produto, Integer>Carrinho;
	
	
	public static void main(String[] args) {
		Produtos = new ArrayList<>();
		Carrinho = new HashMap<>();
		menu();

	}
	private static void menu() {
		
		System.out.println(Cores1.TEXT_BLUE_BOLD_BRIGHT + Cores1.ANSI_BLACK_BACKGROUND
			       +   "                                                             ");
	System.out.println("                                                             ");
	System.out.println("     BEM VINDO A NOSSA LOJA DE MATERIAIS DE CONSTRUÇÃO       ");
	System.out.println("                                                             \r\n"
			+ "  _____  _ _          _      _       _                       \r\n"
			+ " |  __ \\(_) |        (_)    (_)     | |                      \r\n"
			+ " | |__) |_| |__   ___ _ _ __ _ _ __ | |__   ___              \r\n"
			+ " |  _  /| | '_ \\ / _ \\ | '__| | '_ \\| '_ \\ / _ \\             \r\n"
			+ " | | \\ \\| | |_) |  __/ | |  | | | | | | | | (_) |            \r\n"
			+ " |_|  \\_\\_|_.__/ \\___|_|_|  |_|_| |_|_| |_|\\___/             \r\n"
			+ "                                                             \r\n"
			+ "                                                             \r\n"
			+ "                                                             ");
	System.out.println("                1 - Cadastrar Produtos                       ");
	System.out.println("                2 - Listar Produtos                          ");
	System.out.println("                3 - Comprar                                  ");
	System.out.println("                4 - Adicionar no Carrinho                    ");
	System.out.println("                5 - Sair                                     ");
	System.out.println("                                                             ");
	System.out.println("                                                             ");
	System.out.println("-------------------------------------------------------------");
	System.out.println(" Entre com a opção desejada:                                 ");
	System.out.println("-------------------------------------------------------------");
	System.out.println("                                                             "+ Cores1.TEXT_RESET);
	
	int opcao = leia.nextInt();
	
    switch (opcao) {
		
	 case 1:
		 cadastrarProdutos();
		 	 
		 break;
	 case 2:
		 listarProdutos();
		 
		 break;
	 case 3:
		 comprarProdutos();
		
		 break;
	 case 4:
		 verCarrinho();
		 
		 break;
	 case 5:
	  System.out.println(Cores1.TEXT_BLUE_BOLD_BRIGHT+ Cores1.ANSI_BLACK_BACKGROUND +"Deposito Ribeirinho agrade pela preferencia!                 ");
 	   System.exit(0);
 	   
	 default:
 	   System.out.println("Opção invalida!");
 	   menu();
 	break; 
  }		
		
	}		
     private static void cadastrarProdutos() {
	 System.out.println(Cores1.TEXT_BLUE_BOLD_BRIGHT+ Cores1.ANSI_BLACK_BACKGROUND + "Nome do produto:                                             ");
		String nome = leia.next();
		
		System.out.println(Cores1.TEXT_BLUE_BOLD_BRIGHT+ Cores1.ANSI_BLACK_BACKGROUND + "Preço do produto:                                            ");
		Double preco = leia.nextDouble();
		
		produto produto = new produto(nome, preco);
		Produtos.add(produto);
		
		System.out.println(produto.getNome() + Cores1.TEXT_BLUE_BOLD_BRIGHT+ Cores1.ANSI_BLACK_BACKGROUND + " cadastrado com sucesso!                                    ");
		menu();
 }
      public static void listarProdutos() {
	  if (Produtos.size() > 0) {
		  
		  for (produto p : Produtos) {
			  System.out.println(p);			  
		  }
	  }else {
		  
	  System.out.println(Cores1.TEXT_WHITE_BOLD+ "Nenhum produto cadastrado!");	
	  
	  }
	  
 	  menu();	
	}
      private static void comprarProdutos() {
	  if (Produtos.size() > 0) {
		  
      System.out.println(Cores1.TEXT_WHITE_BOLD+ "\nCodigo do produto: ");
			
	  System.out.println(Cores1.TEXT_WHITE_BOLD+ "--------------------Produtos Disponiveis---------------------");	
	  
			for (produto p : Produtos) {
				System.out.println(p + "\n");				
			}
			
			int id = Integer.parseInt(leia.next());
			boolean isPresent = false;
			
			for (produto p : Produtos) {
				if (p.getId() == id) {
					int qtd = 0;
					try {
						qtd = Carrinho.get(p);
						Carrinho.put(p, qtd +1);
						
					}catch (NullPointerException e){
						Carrinho.put(p, 1);				
					}
	  System.out.println(p.getNome() + " adicionar ao carrinho.");
					isPresent = true;
					
					if (isPresent) {
						
	  System.out.println(Cores1.TEXT_WHITE_BOLD+ "\nDeseja adicionar outro produto ao carrinho? ");
	  
		 System.out.println(Cores1.TEXT_WHITE_BOLD+ "\nDigite 1 pasa sim, ou 0 para finalizar a compra");
						int option = Integer.parseInt(leia.next());
						
						if(option == 1) {
							comprarProdutos();
		}else {
							finalizarCompra();		
				    }
					}
					
		 }else {
			 
	    System.out.println(Cores1.TEXT_WHITE_BOLD+ "Produto nao encontrado.");
				    	   menu();
				}
				}
			
		 }else {
			 
		System.out.println(Cores1.TEXT_WHITE_BOLD+ "Não existe produtos cadstrado");
		
	    	menu();
			
	  }
	  }
            private static void verCarrinho() {
       System.out.println(Cores1.TEXT_WHITE_BOLD+ "------------------Produtos no seu carrinho!------------------");
            	
        		if (Carrinho.size() > 0) {
        			for (produto p: Carrinho.keySet()) {
        				System.out.println("produto: " + p + "\nQuantidade: " + Carrinho.get(p));
        			}
        			
        		}else {
        			
        			System.out.println(Cores1.TEXT_WHITE_BOLD+ "Carrinho vazio");
        		}
        		menu();
            	}
            private static void finalizarCompra() {
            	Double valorTotal = 0.0;
        		System.out.println("Seus produtos!");
        		
        		for (produto p : Carrinho.keySet()) {
        			int qtd = Carrinho.get(p);
        			valorTotal += p.getPreco()*qtd;
        			System.out.println("Quantidade: " + qtd);
        			
        		}
        System.out.println(Cores1.TEXT_WHITE_BOLD+ "O valor total da sua compra é: " + utils.doubleToString(valorTotal));
        		
        		Carrinho.clear();
        		
        System.out.println(Cores1.TEXT_WHITE_BOLD+"Volte Sempre, agradecemos a preferencia!");
        		menu();
            	
            }
}





























