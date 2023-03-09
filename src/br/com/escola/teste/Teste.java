package br.com.escola.teste;

import java.text.DecimalFormat;

import javax.swing.JOptionPane;

import br.com.escola.beans.Aluno;
import br.com.escola.beans.Professor;

public class Teste {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// INSTANCIANDO A CLASSE ALUNO
		Aluno aluno = new Aluno();
		// INSTANCIANDO A CLASSE PROFESSOR
		Professor professor = new Professor();
		// INSTANCIANDO FORMATACAO DE CASAS DECIMAIS
		DecimalFormat df = new DecimalFormat();
		// Para forçar 2 casas decimais, mas em compensação se o número antes da vírgula for 0,ele não traz o 0, exemplo: ,##
		//DecimalFormat df = new DecimalFormat("#,###.00");

		int i = 1;

		while (i <= 5) {

			//int rmAluno = Integer.parseInt(JOptionPane.showInputDialog("Informe o RM do aluno"));
			int rmAluno = i;
			String nomeAluno = JOptionPane.showInputDialog("Informe o nome do aluno " + i);
			int idadeAluno = Integer.parseInt(JOptionPane.showInputDialog("Informe a idade do aluno " + nomeAluno));
			double n1 = Double.parseDouble(JOptionPane.showInputDialog("Informe a nota da primeira prova do aluno " + nomeAluno));
			double n2 = Double.parseDouble(JOptionPane.showInputDialog("Informe a nota da segunda prova do aluno " + nomeAluno));
			String situacaoAluno;
			boolean maiorIdade;
			double mediaAluno;

			mediaAluno = (n1 + n2) / 2;

			aluno.setRm(rmAluno);
			aluno.setNome(nomeAluno);
			aluno.setIdade(idadeAluno);
			aluno.setMedia(mediaAluno);

			if (idadeAluno >= 18)
				maiorIdade = true;

			else
				maiorIdade = false;

			if (mediaAluno >= 5)
				situacaoAluno = "APROVADO";
			else
				situacaoAluno = "REPROVADO";

			aluno.setSituacao(situacaoAluno);

			System.out.println("RM aluno: " + rmAluno);
			System.out.println("Nome aluno: " + nomeAluno);
			System.out.println("Idade aluno: " + idadeAluno);
			System.out.println("Situacao aluno: " + situacaoAluno + " com " + mediaAluno + " de media");

			if (maiorIdade == true)
				System.out.println("Aluno assina o boletim (Aluno maior de 18 anos)");
			else
				System.out.println("Responsavel assina o boletim (Aluno menor de 18 anos)");

			System.out.println("-----------------------------------------------------");

			String nomeProf = JOptionPane.showInputDialog("Informe o nome do professor " + i);
			int idadeProf = Integer.parseInt(JOptionPane.showInputDialog("Informe a idade do professor " + nomeProf));
			double salarioProf = Double.parseDouble(JOptionPane.showInputDialog("Informe o salario do professor " + nomeProf));
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
			double descInss;

			professor.setNome(nomeProf);
			professor.setIdade(idadeProf);
			professor.setSalario(salarioProf);

			System.out.println("Nome professor: " + nomeProf);
			System.out.println("Idade professor: " + idadeProf);
			System.out.println("Salario professor: R$" + salarioProf);

			if (salarioProf >= fx1Min && salarioProf <= fx1Max) {
				descInss = salarioProf * aliqFx1Inss;
			} else if (salarioProf >= fx2Min && salarioProf <= fx2Max) {
				dedInss = salarioProf - dedFx1Inss;
				descInss = (dedInss * aliqFx2Inss) + descFx1Inss;
			} else if (salarioProf >= fx3Min && salarioProf <= fx3Max) {
				dedInss = salarioProf - dedFx1Inss - dedFx2Inss;
				descInss = (dedInss * aliqFx3Inss) + descFx1Inss + descFx2Inss;
			} else if (salarioProf >= fx4Min && salarioProf <= fx4Max) {
				dedInss = salarioProf - dedFx1Inss - dedFx2Inss - dedFx3Inss;
				descInss = (dedInss * aliqFx4Inss) + descFx1Inss + descFx2Inss + descFx3Inss;
			} else {
				descInss = descFx1Inss + descFx2Inss + descFx3Inss + descFx4Inss;
			}
			
			professor.setInss(descInss);
			
			System.out.println("INSS previsto: R$" + df.format(descInss));
			System.out.println("-----------------------------------------------------");
			
			i++;
		}
	}
}