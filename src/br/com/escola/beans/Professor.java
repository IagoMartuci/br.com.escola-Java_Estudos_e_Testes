package br.com.escola.beans;

public class Professor extends Pessoa {
	private double salario;
	private double inss;
	
	public double getSalario() {
		return salario;
	}
	
	public void setSalario(double salario) {
		this.salario = salario;
	}
	
	public double getInss() {
		return inss;
	}
	
	public void setInss(double inss) {
		this.inss = inss;
	}

}
