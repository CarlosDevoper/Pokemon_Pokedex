package Jogo_Pokemon;

import java.util.ArrayList;

public class Treinador extends Pessoa {
    
    /*Arryas de objetos Pokemon onde são armazenados os pokemnos que fazem
    parte do time do treinador
    */
    protected ArrayList<Pokemon> time = new ArrayList<>();
    
    /*Arryas de objetos Pokemon onde são armazenados todos os pokemons
    capturados pelo treinador
    */
    protected ArrayList<Pokemon> Pokemons_Capturados = new ArrayList<>();

    /* Método que mostra os pokemons que fazem parte do time
    do treinador, percorrendo o array referente ao time
    */
    public void mostrarTime(){
        int n = time.size();
        int v = 1;

        System.out.printf("%-7s|%-15s|%-12s\n", "ID", "Nome", "Level");
        for(int i = 0; i<n; i++ ){
            System.out.printf("%06d |%-15s| %s\n",v, time.get(i).nome, time.get(i).level);
            v++;
        }
    }

    /* Método que mostra todos os pokemons que o treinador
    capturou, percorrendo o array referente aos pokemons capturados
    */
    public void mostrarPokemons(){
        int n = Pokemons_Capturados.size();
        int v = 1;

        System.out.printf("%-7s|%-15s|%-12s\n", "ID", "Nome", "Level");
        for(int i = 0; i<n; i++ ){
            System.out.printf("%06d |%-15s| %s\n",v, Pokemons_Capturados.get(i).nome, Pokemons_Capturados.get(i).level);
            v++;
        }
    }

    /* Método que mostra os dados de um pokemon, ID, Nome e Level
    passando como parâmetro o ID do pokemon escolhido
    */
    public void mostrarPokemon(int num){
        
        System.out.printf("\n    %-7s|%-15s|%-12s\n", "ID", "Nome", "Level"); 
        System.out.printf("    %06d |%-15s| %s\n",num, Pokemons_Capturados.get(num-1).nome, Pokemons_Capturados.get(num-1).level);
        
    }

    /* Método que mostra o perfil do Treinador, mostrando os dados
    básicos e a quantidade de pokemons que ele ja capturou
    */
    public void mostrarPerfil(){
		System.out.println("=================================");
		System.out.println("             PERFIL:");
		System.out.println("=================================");
		System.out.printf("\n          Nome: %s", getNome());
		System.out.printf("\n          Idade: %s", getIdade());
        System.out.printf("\n          Cidade: %s\n", "Kanto");
        System.out.printf("\n      Pokemons Capturados: %d\n", Pokemons_Capturados.size());
		System.out.println("=================================");
    }
    
    Treinador(){
        Pessoa.Pessoas.add(this);
    }
}
