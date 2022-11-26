package Jogo_Pokemon;

import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void limparTela() throws IOException, InterruptedException {
		new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
	}

	public static void main(String[] args) throws IOException, InterruptedException {
		limparTela();
		Scanner scan = new Scanner(System.in);
		int opcaoMenu = 0;
		
		apresentaçãoInicial();

		cadastroTreinador(scan);

		escolhaInicial(scan);

		do {
			limparTela();
			menuPincipal();
			opcaoMenu = lerOpcaoMenu(scan);
			
			if(!processarOpcaoMenu(scan, opcaoMenu)){
				System.out.println("Opção inválida. Tente novamente");
				Thread.sleep(2000);

			}

		} while (opcaoMenu != 4);
		scan.close();
    }

	private static void escolhaInicial(Scanner scan) throws IOException, InterruptedException {
		limparTela();
		System.in.read();
		System.out.println("=================================");
		System.out.printf("\n    Está na hora de escolher \n");
		System.out.printf("\n       seu pokemon inicial \n\n");
		System.out.println("=================================");
		Thread.sleep(3000);
		limparTela();

		System.out.println("=================================");
		System.out.println("        ESCOLHA SEU INICIAL:");
		System.out.println("=================================");
		System.out.println("           1 - Squirtle");
		System.out.println("           2 - Bulbasaur");
        System.out.println("           3 - Charmander");
		System.out.println("=================================");
		
		System.out.print("        >> Pokemon:");
		String numStr = scan.nextLine();
		int num = Integer.parseInt(numStr);

		if (num == 1){
            PokemonEstagio0 inicial = new PokemonEstagio0("Squirtle", 1);
			Treinador.Pokemons_Capturados.add(inicial);
			Treinador.time.add(inicial);
        }else if (num == 2){
            PokemonEstagio0 inicial = new PokemonEstagio0("Bulbasaur", 1);
			Treinador.Pokemons_Capturados.add(inicial);
			Treinador.time.add(inicial);
        }else if (num == 3){
            PokemonEstagio0 inicial = new PokemonEstagio0("Charmander", 1);
			Treinador.Pokemons_Capturados.add(inicial);
			Treinador.time.add(inicial);
        }else{
            limparTela();
            System.out.println("Opção inválida");
            Thread.sleep(300);
        }



	}

	private static void cadastroTreinador( Scanner scan) throws IOException, InterruptedException {
		limparTela();
		System.in.read();
		System.out.println("=================================");
		System.out.println("\n    Como quer ser chamado?");
		
		System.out.print("    >> Nome:");
		String nome = scan.nextLine();

		System.out.print("    >> Gênero:");
		String genero = scan.nextLine();

		System.out.print("    >> Idade:");
		String idadeSTR = scan.nextLine();
		int idade = Integer.parseInt(idadeSTR);
		Treinador iniciante = new Treinador(nome, genero, idade);
		System.out.println("\n=================================");
		Thread.sleep(1000);
		apresentacao();
	}

	private static void apresentacao() throws InterruptedException, IOException {
		limparTela();
		System.out.println("=================================");
		System.out.printf("\n        Parabéns, %s", Pessoa.getNome());
		System.out.printf("\n     Você acaba de se tornar");
		System.out.printf("\n      um treinador Pokemon! \n\n");
		System.out.printf("      -- Precione ENTER -- \n");
		System.out.println("=================================");
		System.in.read();
	}

	private static boolean processarOpcaoMenu(Scanner scan, int opcaoMenu) throws IOException, InterruptedException {
		switch (opcaoMenu){
			case 1:
				//mostrarDocumentos();
				return true;
			case 2:
				mostrarTime();
				return true;
			case 3:
				//processarDoc(scan);
				return true;

            case 4:
                //sairDoPrograma();
                return true;
			default:
			return false;	
		}
	}

	private static void mostrarTime() throws IOException, InterruptedException {
		limparTela();
		System.out.println("=================================");
		System.out.println("          Meu Time:");
		System.out.println("=================================");
		Treinador.mostrarTime();
		System.out.println("=================================");
		System.out.print(">> Pressione ENTER para voltar ao menu...");
		System.in.read();

	}

	private static int lerOpcaoMenu(Scanner scan) {
		System.out.print(">> Opção desejada: ");
		int opcaoEscolhida = scan.nextInt();
		scan.nextLine();
		return opcaoEscolhida;
	}

	private static void menuPincipal() {
		System.out.println("=================================");
		System.out.println("        O QUE DESEJA FAZER?");
		System.out.println("=================================");
		System.out.println("1 - Mostrar Perfil");
		System.out.println("2 - Meu Time");
        System.out.println("3 - Capturar Pokemon");
		System.out.println("4 - Meus Pokemons");
		System.out.println("5 - Evoluir Pokemon");
		System.out.println("=================================");
	}

	private static void apresentaçãoInicial() throws InterruptedException, IOException {
		System.out.println("=================================");
		System.out.printf("\n          Olá iniciante \n");
		System.out.printf("\n         Seja bem vindo \n\n");
		System.out.println("=================================");
		
		Thread.sleep(3000);
		limparTela();
		
		System.out.println("=================================");
		System.out.printf("\n    Espero que esteja pronto \n");
		System.out.printf("\n    para essa nova aventura... \n\n");
		System.out.println("=================================");
		
		Thread.sleep(3000);
		limparTela();

		System.out.println("=================================");
		System.out.printf("\n      Pornto para começar? \n");
		System.out.printf("\n      -- Precione ENTER -- \n\n");
		System.out.println("=================================");
		System.in.read();

	}

}

