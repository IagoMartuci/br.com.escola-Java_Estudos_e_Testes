package br.com.escola.teste;

import java.text.DecimalFormat;

import javax.swing.JOptionPane;

import br.com.escola.beans.Aluno;
import br.com.escola.beans.Professor;

public class Teste {

	public static void main(String[] args) {
		Menu();
	}

	public static void Menu() {
		int opcao = Integer.parseInt(JOptionPane.showInputDialog(
				"INFORME A OPÇÃO DESEJADA \n1 - Calcular média dos alunos \n2 - Calcular salário líquido dos professores \n0 - Sair"));

		switch (opcao) {
		case 1:
			MediaAluno();
			break;
		case 2:
			SalarioLiquidoProfessor();
			break;
		case 0:
			JOptionPane.showMessageDialog(null, "Obrigado por utilizar o sistema!");
			break;
		default:
			Menu();
			break;
		}
	}

	public static void MediaAluno() {
		// INSTANCIANDO A CLASSE ALUNO
		Aluno aluno = new Aluno();

		aluno.setRm(Integer.parseInt(JOptionPane.showInputDialog("Informe o RM do aluno")));
		aluno.setNome(JOptionPane.showInputDialog("Informe o nome do aluno " + aluno.getRm()));
		double n1 = Double.parseDouble(
				JOptionPane.showInputDialog("Informe a nota da primeira prova do aluno " + aluno.getNome()));
		double n2 = Double.parseDouble(
				JOptionPane.showInputDialog("Informe a nota da segunda prova do aluno " + aluno.getNome()));

		aluno.setMedia((n1 + n2) / 2);

		if (aluno.getMedia() >= 5)
			aluno.setSituacao("Aprovado");
		else
			aluno.setSituacao("Reprovado");

		System.out.println(
				"RM aluno: " + aluno.getRm()
				+ "\nNome aluno: " + aluno.getNome() 
				+ "\nSituacao aluno: " + aluno.getSituacao() + " com " + aluno.getMedia() + " de media");

		String nomeAluno = aluno.getNome();
		VerificarIdadeAluno(nomeAluno);
	}

	public static void VerificarIdadeAluno(String nomeAluno) {
		Aluno aluno = new Aluno();

		aluno.setIdade(Integer.parseInt(JOptionPane.showInputDialog("Informe a idade do aluno " + nomeAluno)));

		boolean maiorIdade;

		if (aluno.getIdade() >= 18)
			maiorIdade = true;
		else
			maiorIdade = false;

		if (maiorIdade == true)
			// Formatação de Strings % + o tipo do dado que está na variável que irá compor o texto nesse caso "s" string e "d" int
			System.out.println(String.format("O aluno %s assina o boletim, idade do aluno %d anos.", nomeAluno, aluno.getIdade()));
		else
			System.out.println(String.format("O responsavel do aluno %s assina o boletim, idade do aluno %d anos.", nomeAluno, aluno.getIdade()));
	}

	public static void SalarioLiquidoProfessor() {
		// INSTANCIANDO A CLASSE PROFESSOR
		Professor professor = new Professor();
		// INSTANCIANDO FORMATACAO DE CASAS DECIMAIS
		DecimalFormat df = new DecimalFormat();
		// Para forçar 2 casas decimais, mas em compensação se o número antes da vírgula for 0, ele não traz o 0, exemplo: ,##
		// DecimalFormat df = new DecimalFormat("#,###.00");

		professor.setNome(JOptionPane.showInputDialog("Informe o nome do professor"));
		professor.setIdade(
				Integer.parseInt(JOptionPane.showInputDialog("Informe a idade do professor " + professor.getNome())));
		professor.setSalario(Double
				.parseDouble(JOptionPane.showInputDialog("Informe o salario do professor " + professor.getNome())));

		// VARIAVEIS PARA CALCULO DO INSS
		float aliqFx1Inss = 0.075F;
		float aliqFx2Inss = 0.09F;
		float aliqFx3Inss = 0.12F;
		float aliqFx4Inss = 0.14F;
		double fx1Min = 0.01;
		double fx1Max = 1212.00;
		double fx2Min = 1212.01;
		double fx2Max = 2427.35;
		double fx3Min = 2427.36;
		double fx3Max = 3641.03;
		double fx4Min = 3641.04;
		double fx4Max = 7087.22;
		double dedFx1Inss = 1212.00;
		double dedFx2Inss = 1215.35;
		double dedFx3Inss = 1213.68;
		double dedInss;
		double descFx1Inss = 90.90;
		double descFx2Inss = 109.38;
		double descFx3Inss = 145.64;
		double descFx4Inss = 482.46;

		if (professor.getSalario() < 1212.00) {
			return;
		} else {
			if (professor.getSalario() >= fx1Min && professor.getSalario() <= fx1Max) {
				professor.setInss(professor.getSalario() * aliqFx1Inss);
			} 
			else if (professor.getSalario() >= fx2Min && professor.getSalario() <= fx2Max) {
				dedInss = professor.getSalario() - dedFx1Inss;
				professor.setInss((dedInss * aliqFx2Inss) + descFx1Inss);
			} 
			else if (professor.getSalario() >= fx3Min && professor.getSalario() <= fx3Max) {
				dedInss = professor.getSalario() - dedFx1Inss - dedFx2Inss;
				professor.setInss((dedInss * aliqFx3Inss) + descFx1Inss + descFx2Inss);
			} 
			else if (professor.getSalario() >= fx4Min && professor.getSalario() <= fx4Max) {
				dedInss = professor.getSalario() - dedFx1Inss - dedFx2Inss - dedFx3Inss;
				professor.setInss((dedInss * aliqFx4Inss) + descFx1Inss + descFx2Inss + descFx3Inss);
			} 
			else {
				professor.setInss(descFx1Inss + descFx2Inss + descFx3Inss + descFx4Inss);
			}
		}

		professor.setLiquido(professor.getSalario() - professor.getInss());

		System.out.println("Nome professor: " + professor.getNome()
			+ "\nIdade professor: " + professor.getIdade()
			+ "\nSalario professor: R$" + professor.getSalario()
			+ "\nDesconto INSS: R$" + df.format(professor.getInss())
			+ "\nSalario liquido: R$" + df.format(professor.getLiquido()));
	}
}
