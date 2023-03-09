package br.com.escola.beans;

// extends Pessoa para a propriedade Aluno herdar os atributos da propriedade Pessoa
public class Aluno extends Pessoa {
	private int rm;
	private double media;
	private String situacao; 

	public int getRm() {
		return rm;
	}

	public void setRm(int rm) {
		this.rm = rm;
	}
	
	public double getMedia() {
		return media;
	}
	
	public void setMedia(double media) {
		this.media = media;
	}
	
	public String getSituacao() {
		return situacao;
	}
	
	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}
}
