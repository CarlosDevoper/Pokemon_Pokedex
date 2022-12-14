package Jogo_Pokemon;

import java.io.IOException;
import java.util.Scanner;

public class Main {

	
	// método para validar se uma string é nula ou espaoço em branco
	public static Boolean validarString(String s){
		boolean validade = false;
		if(s.trim().isEmpty()){
			validade = true;
		}else{
			validade= false;
		}
		return validade;
	}

	// Método para validar se a strig é formada por números
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

	// Método de chamada para o menu, muito utilizado nas "telas"
	public static void voltarMenu() throws IOException{
		System.out.print(">> Pressione ENTER para voltar ao menu...");
		System.in.read();
	}

	/*  Método que lima a tela, tendo em vista que  o programa foi
	feito para rodar no terminal, caso utiliza uma IDE ou outro leitor 
	de texto, é necessário alteração desse método.
	*/
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

	// Método que chama que mostra o menu principal
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

	/* Método que le e retorna qual foi a opção do menu
	selecionada pelo usuário
	 */
	private static int lerOpcaoMenu(Scanner scan) {
		System.out.print(">> Opção desejada: ");
		int opcaoEscolhida = scan.nextInt();
		scan.nextLine();
		return opcaoEscolhida;
	}
	/*  Método que processa o que foi passado para o meu principal
	e chama os métodos referentes as opções do menu principal 
	*/
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
                sairPrograma();
                return true;

			default:
			return false;	
		}
	}

	/*  Método que chama a primeira função do menu, mostrando o
	perfil do Treinador(Objeto) iniciante, feito na classe treinador
	*/
	private static void mostrarPerfil(Treinador iniciante) throws IOException, InterruptedException {
		limparTela();
		iniciante.mostrarPerfil();
		voltarMenu();
	}

	/* Método que chama a segunda função do menu, onde mostra o 
	time do Treinador(Objeto) iniciante, feito na classe Treinador
	 */
	private static void mostrarTime(Treinador iniciante) throws IOException, InterruptedException {
		limparTela();
		System.out.println("=================================");
		System.out.println("          Meu Time:");
		System.out.println("=================================");
		iniciante.mostrarTime();
		System.out.println("=================================");
		voltarMenu();

	}

	/* Método que chama a terceira função do menu, onde o menu de
	captura de pokemons do Treinador(Objeto) iniciante, feito na classe Pokemon
	onde foram criados vários métodos auxiliares
	 */
	private static void capturarPokemon(Scanner scan, Treinador iniciante) throws IOException, InterruptedException {
		limparTela();
		System.out.println("=================================");
		System.out.println("    Qual Pokemon quer capturar?:");
		System.out.println("=================================");
		String nome;
		do{
		System.out.print("    >> Nome:");
		nome = scan.nextLine();
		if(validarString(nome)){
			System.out.println("    Pokemon não econtrado");
		}else{
			nome = nome.toLowerCase();
			nome = nome.substring(0,1).toUpperCase().concat(nome.substring(1));
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
				System.out.println("    Pokemon não econtrado");
			}
			System.out.println("=================================");
			voltarMenu();
		}
		} while(validarString(nome));
	}

	/* Método que chama a quarta função do menu, onde mostra todos
	os pokemons que o Treinador(Objeto) iniciante, capturou
	 */
	private static void mostrarPokemons(Treinador iniciante) throws IOException, InterruptedException {
		limparTela();
		System.out.println("=================================");
		System.out.println("       Pokemons Capturados:");
		System.out.println("=================================");
		iniciante.mostrarPokemons();
		System.out.println("=================================");
		voltarMenu();
	}

	/* Método que chama a quinta função do menu, onde mostra o menu para
	subir os leveis dos pokemons do Treinador(Objeto) iniciante, feito na
	classe Pokemon onde foram criados vários métodos auxiliares
	 */
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

		limparTela();
		System.out.println("=================================");
		System.out.println("       Pokemon Escolhido:");
		iniciante.mostrarPokemon(ID);
		
		System.out.println("\n   Quantos Levels quer subir?");
		System.out.println("=================================");
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
				System.out.println("=========================================");
				System.out.printf(" Seu %s vai está evoluindo %s leveis\n", iniciante.Pokemons_Capturados.get(ID-1).getNome(), LevelStr);
				Thread.sleep(2000);
				
			} else{
				System.out.println("=========================================");
				System.out.printf("\nSeu %s está evoluindo %s level\n", iniciante.Pokemons_Capturados.get(ID-1).getNome(), LevelStr);
				Thread.sleep(2000);
			}
			iniciante.Pokemons_Capturados.get(ID-1).setLevel(Level);
		    iniciante.mostrarPokemon(ID);
			System.out.println("=========================================\n");
			voltarMenu();

		} else{
			System.out.println("    Opção inválida, por favor tente novamente");
		}
		} while(Level==0);
	}

	/* Método que chama a sexta função do menu, onde mostra o menu para
	evoluir os pokemons do Treinador(Objeto) iniciante, feito na
	classe Pokemon onde foram criados vários métodos auxiliares
	 */
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
		limparTela();
		System.out.println("===========================================");
		iniciante.Pokemons_Capturados.get(ID-1).evoluir(iniciante.Pokemons_Capturados.get(ID-1), ID-1, iniciante);
		System.out.println("===========================================\n");
		voltarMenu();

	}

	/* Método que chama a sétima função do menu, onde mostra todos os
	pokemons possíveis de serem capturados, referente a 1º geração do
	jogo
	 */
	private static void mostrarPokedex() throws IOException, InterruptedException {
		limparTela();
		System.out.println("=================================");
		System.out.println("            Pokemons:");
		System.out.println("=================================");
		Pokemon.Pokedex();
		System.out.println("=================================");
		voltarMenu();
	}

	/* Método que chama a oitava função do menu, onde mostra uma
	mensagem de saída do jogo, e faz com que o laço de repetição
	que mostra o menu principal, pare e encerre.
	 */
	private static void sairPrograma() throws InterruptedException, IOException {
		limparTela();
		System.out.println("Saindo do Jogo...");
		Thread.sleep(2000);
		limparTela();
		System.out.println("=================================");
		System.out.printf("  Espero que tenha gostado, sua\n");
		System.out.printf("    aventura ainda não acabou. \n");
		System.out.printf("        Até a próxima... \n");
		System.out.println("=================================");
		
		Thread.sleep(3000);
		limparTela();
		
		
	}

	/* Método que faz a apresentação incial do jogo
	ao usuário do sistema, um conjunto de prints ordenados
	 */
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


	/* Método que mostra o menu da escolha do pokemon inicial do
	Treinador(objeto) iniciante, feito na classe Pokemon e utilizando
	métodos auxiliares das outras classes
	 */
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

	/* Método que mostra o menu de cadastro do Treinador(objeto)
	iniciante, feito na classe Treinador e utilizando métodos auxiliares
	 */
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
		apresentacaoTreinador(iniciante);
	}

	/* Método que faz a apresentação do
	Treinador(Objeto) iniciante na tela do jogo
	 */
	private static void apresentacaoTreinador(Treinador iniciante) throws InterruptedException, IOException {
		limparTela();
		System.out.println("=================================");
		System.out.printf("\n        Parabéns, %s", iniciante.getNome());
		System.out.printf("\n     Você acaba de se tornar");
		System.out.printf("\n      um treinador Pokemon! \n\n");
		System.out.printf("      -- Precione ENTER -- \n");
		System.out.println("=================================");
		System.in.read();
	}

}

