package Jogo_Pokemon;

import java.util.ArrayList;
import java.util.Arrays;

public class PokemonEstagio2 extends Pokemon {
    
    public static ArrayList<String> PokemonsEstagio2 = new ArrayList<>(Arrays.asList("Venusaur", "Charizard", "Blastoise", "Butterfree", "Beedrill",
    "Pidgeot", null, null, null, "Raichu", null, "Nidoqueen", "Nidoking", null, null, null, null, "Vileplume", null, null, null, null, null, null, null,
    "Poliwrath", "Alakazam", "Machamp", "Victreebel", null, "Golem", null, null, null, null, null, null, null, null, "Gengar", null, null, null, null,
    null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
    null, null, null, null, null, null,  "Dragonite", null, null));


    public static Boolean validarPokemon(String pokemon){
        
        boolean existe;
        if(PokemonsEstagio2.contains(pokemon)){
            existe = true;
        }else{
            existe = false;
        }
        return existe;
    }

    @Override
    public void evoluir(Pokemon pokemon, int ID, Treinador iniciante){
        System.out.printf("     Seu %s não pode evoluir\n", pokemon.getNome());
    } 
    
    PokemonEstagio2(String nome, Treinador iniciante){
        this.nome = nome;
        estagio = 1;
        level = getRandomLevel();
        iniciante.Pokemons_Capturados.add(this);
    }

    PokemonEstagio2(String nome, Treinador iniciante, int level){
        this.nome = nome;
        estagio = 2;
        this.level = level;
        iniciante.Pokemons_Capturados.add(this);
        if(iniciante.time.size()<6){
            iniciante.time.add(this);
        }
    }

}
