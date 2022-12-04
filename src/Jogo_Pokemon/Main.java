package Jogo_Pokemon;

import java.io.IOException;
import java.util.Scanner;

public class Main {

	
	public static Boolean validarString(String s){
		boolean validade = false;
		if(s.trim().isEmpty()){
			validade = true;
		}else{
			validade= false;
		}
		return validade;
	}

	public static Boolean validarInteiro(String s){
		
		char[] c = s.toCharArray();
		boolean d = true;

		for ( int i = 0; i < c.length; i++ )
   			// verifica se o char não é um dígito
    		if ( !Character.isDigit( c[ i ] ) ) {
        		d = false;
        	break;
    	}
		return d;
}



	public static void voltarMenu() throws IOException{
		System.out.print(">> Pressione ENTER para voltar ao menu...");
		System.in.read();
	}

	public static void limparTela() throws IOException, InterruptedException {
		new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
	}

	public static void main(String[] args) throws IOException, InterruptedException {
		
		limparTela();
		apresentaçãoInicial();
		Treinador iniciante = new Treinador();
		Scanner scan = new Scanner(System.in);
		int opcaoMenu = 0;

		cadastroTreinador(scan, iniciante);
		escolhaInicial(scan, iniciante);
		
		do {
			limparTela();
			menuPrincipal();
			opcaoMenu = lerOpcaoMenu(scan);
			
			if(!processarOpcaoMenu(scan, opcaoMenu, iniciante)){
				System.out.println("Opção inválida. Tente novamente");
				Thread.sleep(2000);

			}

		} while (opcaoMenu != 8);
		scan.close();
    }

	private static void menuPrincipal() {
		System.out.println("=================================");
		System.out.println("        O QUE DESEJA FAZER?");
		System.out.println("=================================");
		System.out.println("1 - Mostrar Perfil");
		System.out.println("2 - Meu Time");
        System.out.println("3 - Capturar Pokemon");
		System.out.println("4 - Meus Pokemons");
		System.out.println("5 - Upar Level de Pokemon");
		System.out.println("6 - Evoluir Pokemon");
		System.out.println("7 - Pokemons Existentes");
		System.out.println("8 - Sair");
		System.out.println("=================================");
	}

	private static boolean processarOpcaoMenu(Scanner scan, int opcaoMenu, Treinador iniciante) throws IOException, InterruptedException {
		switch (opcaoMenu){
			case 1:
				mostrarPerfil(iniciante);
				return true;
			case 2:
				mostrarTime(iniciante);
				return true;
			case 3:
				capturarPokemon(scan, iniciante);
				return true;

            case 4:
                mostrarPokemons(iniciante);
                return true;

			case 5:
                uparLevel(scan, iniciante);
                return true;
			
			case 6:
                evoluirPokemon(scan, iniciante);
                return true;
			
			case 7:
                mostrarPokedex();
                return true;
				
			case 8:
                mostrarPokedex();
                return true;

			default:
			return false;	
		}
	}

	private static void escolhaInicial(Scanner scan, Treinador iniciante) throws IOException, InterruptedException {
		
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
		
		int num = 0;
		String numStr;
		do{
		System.out.print("        >> Pokemon:");
		numStr = scan.nextLine();
		
		if(validarString(numStr)){
			System.out.println("        Opção Inválida");

			} else if(validarInteiro(numStr)){
			num = Integer.parseInt(numStr);
			
				if (num == 1){
            		PokemonEstagio0 inicial = new PokemonEstagio0("Squirtle", 1, iniciante);
					iniciante.time.add(inicial);
					break;
        		}else if (num == 2){
            		PokemonEstagio0 inicial = new PokemonEstagio0("Bulbasaur", 1, iniciante);
					iniciante.time.add(inicial);
					break;
        		}else if (num == 3){
            		PokemonEstagio0 inicial = new PokemonEstagio0("Charmander", 1, iniciante);
					iniciante.time.add(inicial);
					break;
        		} else{
					System.out.println("        Opção Inválida");
				}

			} else {
			System.out.println("        Opção Inválida");
			}
		
		} while(num !=1 || num !=2 || num !=3);
		
	}

	private static void cadastroTreinador( Scanner scan, Treinador iniciante) throws IOException, InterruptedException {
		
		limparTela();
		System.in.read();
		System.out.println("=================================");
		System.out.println("\n    Como quer ser chamado?");
		
		String nome;
		do{
		System.out.print("    >> Nome:");
		nome = scan.nextLine();

		if(validarString(nome)){
			System.out.println("    Por favor, insira seu nome");
		}
	
		} while(nome.length()<=2);

		String genero;
		do{
		System.out.print("    >> Gênero:");
		genero = scan.nextLine();

		if(validarString(genero)){
			System.out.println("    Por favor, insira seu Gênero");
		}
		} while(genero.length()<1);

		String idadeSTR;
		Integer idade = 0;
		do{
		System.out.print("    >> Idade:");
		idadeSTR = scan.nextLine();
		
		if(validarString(idadeSTR)){
			System.out.println("    Idade inválida, por favor tente novamente");
		} else if(validarInteiro(idadeSTR)){
			idade = Integer.parseInt(idadeSTR);
		} else {
			System.out.println("    Idade inválida, por favor tente novamente");
		}
	
		} while(idade<=0);
		
		iniciante.setNome(nome);
		iniciante.setIdade(idade);
		iniciante.setGenero(genero);

		System.out.println("\n=================================");
		Thread.sleep(1000);
		apresentacao(iniciante);
	}

	private static void apresentacao(Treinador iniciante) throws InterruptedException, IOException {
		limparTela();
		System.out.println("=================================");
		System.out.printf("\n        Parabéns, %s", iniciante.getNome());
		System.out.printf("\n     Você acaba de se tornar");
		System.out.printf("\n      um treinador Pokemon! \n\n");
		System.out.printf("      -- Precione ENTER -- \n");
		System.out.println("=================================");
		System.in.read();
	}


	private static void uparLevel(Scanner scan, Treinador iniciante) throws IOException, InterruptedException {
		limparTela();
		System.out.println("=================================");
		System.out.println("      Escolha o Pokemon:");
		System.out.println("=================================");
		
		String IDSTR;
		int ID = 0;
		do{
		System.out.print("    >> ID:");
		IDSTR = scan.nextLine();
		
		if(validarString(IDSTR)){
			System.out.println("    Opção inválida, por favor tente novamente");
		} else if(validarInteiro(IDSTR)){
			ID = Integer.parseInt(IDSTR);
			if (ID> iniciante.Pokemons_Capturados.size()){
				System.out.println("  este Pokemon não existe, por favor");
				System.out.println("      insira um ID existente");
				ID = 0;
			}
		} else{
			System.out.println("    Opção inválida, por favor tente novamente");
		}
		
		} while(ID<=0);

		
		System.out.println("\n       Pokemon Escolhido:");
		iniciante.mostrarPokemon(ID);
		
		System.out.println("\n Quantos Levels quer subir?");
		String LevelStr;
		int Level = 0;
		
		do{
		System.out.print("    >> Level(s):");
		LevelStr = scan.nextLine();

		if(validarString(LevelStr)){
			System.out.println("    Opção inválida, por favor tente novamente");
		} else if(validarInteiro(LevelStr)){
			Level = Integer.parseInt(LevelStr);
			limparTela();
			if(Level>1){
				System.out.printf("\n Seu %s vai está evoluindo %s leveis\n", iniciante.Pokemons_Capturados.get(ID-1).getNome(), LevelStr);
				Thread.sleep(2000);
				
			} else{
				System.out.printf("\nSeu %s está evoluindo %s level\n", iniciante.Pokemons_Capturados.get(ID-1).getNome(), LevelStr);
				Thread.sleep(2000);
			}
			iniciante.Pokemons_Capturados.get(ID-1).setLevel(Level);
		    iniciante.mostrarPokemon(ID);
			voltarMenu();
		} else{
			System.out.println("    Opção inválida, por favor tente novamente");
		}
		} while(Level==0);


	}

	private static void mostrarPokedex() throws IOException, InterruptedException {
		limparTela();
		System.out.println("=================================");
		System.out.println("            Pokemons:");
		System.out.println("=================================");
		Pokemon.Pokedex();
		System.out.println("=================================");
		voltarMenu();
	}

	private static void evoluirPokemon(Scanner scan, Treinador iniciante) throws IOException, InterruptedException {
		limparTela();
		System.out.println("=================================");
		System.out.println("      Escolha o Pokemon:");
		System.out.println("=================================");
		
		String IDSTR;
		int ID = 0;
		do{
		System.out.print("    >> ID:");
		IDSTR = scan.nextLine();
		
		if(validarString(IDSTR)){
			System.out.println("    Opção inválida, por favor tente novamente");
		} else if(validarInteiro(IDSTR)){
			ID = Integer.parseInt(IDSTR);
			if (ID> iniciante.Pokemons_Capturados.size()){
				System.out.println("  este Pokemon não existe, por favor");
				System.out.println("      insira um ID existente");
				ID = 0;
			}
		} else{
			System.out.println("    Opção inválida, por favor tente novamente");
		}
		} while(ID<=0);
		iniciante.Pokemons_Capturados.get(ID-1).evoluir(iniciante.Pokemons_Capturados.get(ID-1));
		voltarMenu();

	}

	private static void mostrarPokemons(Treinador iniciante) throws IOException, InterruptedException {
		limparTela();
		System.out.println("=================================");
		System.out.println("       Pokemons Capturados:");
		System.out.println("=================================");
		iniciante.mostrarPokemons();
		System.out.println("=================================");
		voltarMenu();
	}

	private static void mostrarPerfil(Treinador iniciante) throws IOException, InterruptedException {
		limparTela();
		iniciante.mostrarPerfil();
		voltarMenu();
	}


	private static void capturarPokemon(Scanner scan, Treinador iniciante) throws IOException, InterruptedException {
		limparTela();
		System.out.println("=================================");
		System.out.println("    Qual Pokemon quer capturar?:");
		System.out.println("=================================");
		System.out.print("    >> Nome:");
		String nome = scan.nextLine();
		if(Pokemon.validarPokemon(nome)){
			if(Pokemon.validarCaptura(nome, iniciante)){
				System.out.println("    Capturando...");
        		Thread.sleep(3000);
        		System.out.println("    Pokemon capturado com Sucesso!\n");
				if(iniciante.time.size()>6){
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
		voltarMenu();


	}

	private static void mostrarTime(Treinador iniciante) throws IOException, InterruptedException {
		limparTela();
		System.out.println("=================================");
		System.out.println("          Meu Time:");
		System.out.println("=================================");
		iniciante.mostrarTime();
		System.out.println("=================================");
		voltarMenu();

	}

	private static int lerOpcaoMenu(Scanner scan) {
		System.out.print(">> Opção desejada: ");
		int opcaoEscolhida = scan.nextInt();
		scan.nextLine();
		return opcaoEscolhida;
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
		System.out.printf("\n      Pronto para começar? \n");
		System.out.printf("\n      -- Precione ENTER -- \n\n");
		System.out.println("=================================");
		System.in.read();

	}

}

