package Jogo_Pokemon;

public class PokemonEstagio0 extends Pokemon{
    

    PokemonEstagio0(String nome){
        this.nome = nome;
        estagio = 0;
        level = getRandomLevel();
        Treinador.Pokemons_Capturados.add(this);
    }

    PokemonEstagio0(String nome, int level){
        this.nome = nome;
        estagio = 0;
        this.level = level;
        Treinador.Pokemons_Capturados.add(this);
    }
}
