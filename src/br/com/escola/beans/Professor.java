package br.com.escola.beans;

public class Professor extends Pessoa {
	private double salario;
	private double inss;
	private double liquido;
	
	public double getSalario() {
		return salario;
	}
	
	public void setSalario(double salario) {
		// Colocando validação no set do salário (Só é possível se utilizarmos public?):
		if (setSalario < 1212) {
			System.out.println("Salário não pode ser menor que salário mínimo");
		}
		this.salario = salario;
	}
	
	public double getInss() {
		return inss;
	}
	
	public void setInss(double inss) { this.inss = inss; }

	public double getLiquido() {
		return liquido;
	}

	public void setLiquido(double liquido) { this.liquido = liquido; }
}
