package Jogo_Pokemon;

import java.util.ArrayList;

public class Treinador extends Pessoa {
    
    public static ArrayList<Pokemon> time = new ArrayList<>();
    public static ArrayList<Pokemon> Pokemons_Capturados = new ArrayList<>();



    @Override
    public void apresentacao(){
        System.out.printf("Olá, me chamo %s tenho %d, sou um novo treinador da região de Kanto", getNome(), getIdade());
    }

    Treinador(String nome, String genero, int idade){
        Pessoa.nome = setNome(nome);
        this.genero = setGenero(genero);
        this.idade = setIdade(idade);

        Pessoas.add(this);
    }

    public static void mostrarTime(){
        int n = time.size();
        int v = 1;

        System.out.printf("%-7s|%-15s|%-12s\n", "ID", "Nome", "Level");
        for(int i = 0; i<n; i++ ){
            System.out.printf("%06d |%-15s| %s\n",v, time.get(i).nome, time.get(i).level);
            v++;
        }

    }
}
