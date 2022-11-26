package Jogo_Pokemon;

public class PokemonEstagio2 extends Pokemon {
    
    PokemonEstagio2(String nome){
        this.nome = nome;
        estagio = 2;
        level = getRandomLevel();
        Treinador.Pokemons_Capturados.add(this);
    }

}
