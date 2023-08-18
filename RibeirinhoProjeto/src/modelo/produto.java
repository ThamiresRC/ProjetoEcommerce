package modelo;

import util.utils;

public class produto {
	
	private static int count = 1;
	 
	 private int id;
	 private String nome;
	 private double preco;
	 
	 
	public produto(String nome, double preco) {
		this.id = count;
		this.nome = nome;
		this.preco = preco;
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}


	 
	public String toString() {
		return "Id: " +this.getId() + "\nNome: " +this.getNome()+ "\nPreço: " + utils.doubleToString(this.getPreco());
		

				
	 

}
}
