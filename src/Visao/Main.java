package Visao;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import Validacao.ValidarCPF;

public class Main {

	/*
	 * Trata se de um exercicio da época da faculdade que o professor Vicente (vpcamargo.com.com.br)
	 * passou que nunca esqueço.(sofri ate rs). O exercício trata-se de ler um arquivo .txt (supertring)
	 * sem formatação e validação alguma, a saída deverá formatar nomes e sobrenomes com a primeira letra maíusculas,
	 * formatar a data de nascimento com barras, o cpf com os pontos e o traço padrão e ainda verificar se é válido ou não, por fim
	 * mostrar os nomes e sobrenomes dos dependentes formatados tambem.
	 */
	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new FileReader("d:/ArquivoTXT.txt"));//Caminho onde esta meu arquivo .txt
			String[] elementos;
			String[] nome;
			String data;
			String cpf;
			String[] dependente;

			// LEANDRO MACHADO MOREIRA;01061981;50693092009;
			while (br.ready()) {
				String linha = br.readLine();
				linha = linha.toLowerCase();
				elementos = linha.split(";");

				// NOME
				nome = elementos[0].split(" ");
				for (int i = 0; i < nome.length; i++) {
					nome[i] = nome[i].substring(0, 1).toUpperCase().concat(nome[i].substring(1));
				}
				// PARA PULAR PARA OUTRA LINHA
				System.out.println();// PARA PULAR PARA OUTRA LINHA
				// DATA
				data = elementos[1].substring(0, 2) + "/" + elementos[1].substring(2, 4) + "/"
						+ elementos[1].substring(4, 8);
				// CPF
				cpf = ValidarCPF.escreveCPF(elementos[2]);
				// PARA ESCREVER O NOME
				for (int i = 0; i < nome.length; i++) {
					System.out.print(nome[i] + " ");

				}
				// PARA IMPRIMIR A DATA E CPF
				System.out.print("- " + data + " - " + cpf);

				// DEPENDENTES
				for (int i = 3; i < elementos.length; i++) {

					dependente = elementos[i].split(" ");
					dependente[0] = dependente[0].substring(0, 1).toUpperCase().concat(dependente[0].substring(1));
					System.out.print(" - " + dependente[0]);

					dependente[1] = dependente[1].substring(0, 1).toUpperCase().concat(dependente[1].substring(1));
					System.out.print(" " + dependente[1]);
				}
			}
			br.close();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}
}