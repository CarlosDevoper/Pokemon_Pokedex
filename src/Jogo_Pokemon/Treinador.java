package Jogo_Pokemon;

import java.util.ArrayList;

public class Treinador extends Pessoa {
    
    protected ArrayList<Pokemon> time = new ArrayList<>();
    protected ArrayList<Pokemon> Pokemons_Capturados = new ArrayList<>();
    String nome;
    int idade;

    @Override
    public void apresentacao(){
        System.out.printf("Olá, me chamo %s tenho %d, sou um novo treinador da região de Kanto", getNome(), getIdade());
    }

    public void mostrarTime(){
        int n = time.size();
        int v = 1;

        System.out.printf("%-7s|%-15s|%-12s\n", "ID", "Nome", "Level");
        for(int i = 0; i<n; i++ ){
            System.out.printf("%06d |%-15s| %s\n",v, time.get(i).nome, time.get(i).level);
            v++;
        }
    }

    public void mostrarPokemons(){
        int n = Pokemons_Capturados.size();
        int v = 1;

        System.out.printf("%-7s|%-15s|%-12s\n", "ID", "Nome", "Level");
        for(int i = 0; i<n; i++ ){
            System.out.printf("%06d |%-15s| %s\n",v, Pokemons_Capturados.get(i).nome, Pokemons_Capturados.get(i).level);
            v++;
        }
    }

    public void mostrarPokemon(int num){
        
        
        System.out.printf("\n    %-7s|%-15s|%-12s\n", "ID", "Nome", "Level");
       
        System.out.printf("    %06d |%-15s| %s\n",num, Pokemons_Capturados.get(num-1).nome, Pokemons_Capturados.get(num-1).level);
        
    }

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
}
