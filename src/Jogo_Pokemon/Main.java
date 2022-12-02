package Jogo_Pokemon;

import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void limparTela() throws IOException, InterruptedException {
		new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
	}

	public static void main(String[] args) throws IOException, InterruptedException {
		
		
		limparTela();
		apresentaçãoInicial();

		Scanner scan = new Scanner(System.in);
		int opcaoMenu = 0;

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

		} while (opcaoMenu != 5);
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
		
		int num;
		String numStr = null;
		do{
		System.out.print("        >> Pokemon:");
		numStr = scan.nextLine();
		
			System.out.println("Opção Inválida");

		} while(numStr.equals(numStr != "1") ||numStr.equals(numStr != "2") || numStr.equals(numStr != "3"));
		num = Integer.parseInt(numStr);

		if (num == 1){
            PokemonEstagio0 inicial = new PokemonEstagio0("Squirtle", 1);
			Treinador.time.add(inicial);
        }else if (num == 2){
            PokemonEstagio0 inicial = new PokemonEstagio0("Bulbasaur", 1);
			Treinador.time.add(inicial);
        }else if (num == 3){
            PokemonEstagio0 inicial = new PokemonEstagio0("Charmander", 1);
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
		String nome;
		do{
		System.out.print("    >> Nome:");
		nome = scan.nextLine();

		if(nome == null || nome =="" || nome == " "){
			System.out.println("    Por favor, insira seu nome");
		}
		} while(nome.length()<=2);
		String genero;
		
		do{
		System.out.print("    >> Gênero:");
		genero = scan.nextLine();

		if(genero == null || genero =="" || genero == " "){
			System.out.println("    Por favor, insira seu Gênero");
		}
		} while(genero.length()<1);

		String idadeSTR;
		Integer idade = null;
		do{
		System.out.print("    >> Idade:");
		idadeSTR = scan.nextLine();
		if (idadeSTR == null|| idadeSTR.compareTo("")==0||  idadeSTR.length()>=60 || idadeSTR.compareTo(" ")==0){
			System.out.println("    Idade inválida, por favor tente novamente");
			continue;
		}
		idade = Integer.parseInt(idadeSTR);
		
		} while(idade == null);

		
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
				mostrarPerfil();
				return true;
			case 2:
				mostrarTime();
				return true;
			case 3:
				capturarPokemon(scan);
				return true;

            case 4:
                mostrarPokemons();
                return true;

			case 5:
                evoluirPokemon(scan);
                return true;
			default:
			return false;	
		}
	}

	private static void evoluirPokemon(Scanner scan) {
	}

	private static void mostrarPokemons() throws IOException, InterruptedException {
		limparTela();
		System.out.println("=================================");
		System.out.println("       Pokemons Capturados:");
		System.out.println("=================================");
		Treinador.mostrarPokemons();
		System.out.println("=================================");
		System.out.print(">> Pressione ENTER para voltar ao menu...");
		System.in.read();


	}

	private static void mostrarPerfil() throws IOException, InterruptedException {
		limparTela();
		Treinador.mostrarPerfil();
		System.out.print(">> Pressione ENTER para voltar ao menu...");
		System.in.read();
	}


	private static void capturarPokemon(Scanner scan) throws IOException, InterruptedException {
		limparTela();
		System.out.println("=================================");
		System.out.println("    Qual Pokemon quer capturar?:");
		System.out.println("=================================");
		System.out.print("    >> Nome:");
		String nome = scan.nextLine();
		if(Pokemon.validarPokemon(nome)){
			if(Pokemon.validarCaptura(nome)){
				System.out.println("    Capturando...");
        		Thread.sleep(3000);
        		System.out.println("    Pokemon capturado com Sucesso!\n");
				if(Treinador.time.size()>6){
				System.out.println("Você já possui 6 pokemons em seu time");
				System.out.println("      esse foi enviado para o pc");
				}
			} else{
				System.out.println("    Capturando...");
        		Thread.sleep(3000);
        		System.out.printf("    O %s fugiu\n", nome);
			}	
		} else {
			Thread.sleep(2000);
			System.out.println("    Pokemon não econtrado");
		}
		System.out.println("=================================");
		System.out.print(">> Pressione ENTER para voltar ao menu...");
		System.in.read();


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

