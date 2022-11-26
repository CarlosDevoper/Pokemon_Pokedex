package Jogo_Pokemon;

public class PokemonEstagio1 extends Pokemon {


    PokemonEstagio1(String nome){
        this.nome = nome;
        estagio = 1;
        level = getRandomLevel();
        Treinador.Pokemons_Capturados.add(this);
    }


}
