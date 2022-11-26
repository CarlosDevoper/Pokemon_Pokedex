package Jogo_Pokemon;

import java.io.IOException;

public class Main {

	public static void limparTela() throws IOException, InterruptedException {
		new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
	}

	public static void main(String[] args) throws IOException, InterruptedException {
		
		limparTela();
		System.out.println("Testando Segundo commit");
		apresentaçãoInicial();
	}

	private static void apresentaçãoInicial() {
	}

}
