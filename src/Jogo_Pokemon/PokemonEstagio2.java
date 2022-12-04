package Jogo_Pokemon;

import java.util.ArrayList;
import java.util.Arrays;

public class PokemonEstagio2 extends Pokemon {
    
    /* Array de objetos que guarda todos os pokemons da 1ª geração
    que possuem um segundo estágio de evolução, array está organizado
    na forma que os pokemons aparecem na pokedex, caso seja null, significa
    que o pokemon de estágio anterior, não possui um estágio 2
    */
    public static ArrayList<String> PokemonsEstagio2 = new ArrayList<>(Arrays.asList("Venusaur", "Charizard", "Blastoise", "Butterfree", "Beedrill",
    "Pidgeot", null, null, null, "Raichu", null, "Nidoqueen", "Nidoking", null, null, null, null, "Vileplume", null, null, null, null, null, null, null,
    "Poliwrath", "Alakazam", "Machamp", "Victreebel", null, "Golem", null, null, null, null, null, null, null, null, "Gengar", null, null, null, null,
    null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
    null, null, null, null, null, null,  "Dragonite", null, null));

    /* Método que verifica se o pokemon passado como parâmetro,
    possui uma evolução estágio 2, ou seja, se ele está presente
    no array de PokemonsEstagio2
    */
    public static Boolean validarPokemon(String pokemon){
        
        boolean existe;
        if(PokemonsEstagio2.contains(pokemon)){
            existe = true;
        }else{
            existe = false;
        }
        return existe;
    }

    /* Reescrita do método evoluir da classe mãe de pokemon, como
    forma de polimorfismo, cada estágio tem uma forma de evoluir, mas
    pokemons estagio 2 não possuem uma evolução na 1ª geração, por
    isso o método retorna essa informação
    */
    @Override
    public void evoluir(Pokemon pokemon, int ID, Treinador iniciante){
        System.out.printf("     Seu %s não pode evoluir\n", pokemon.getNome());
    } 
    
    // Construtor utilizado quando se captura um pokemon estagio 2
    PokemonEstagio2(String nome, Treinador iniciante){
        this.nome = nome;
        estagio = 2;
        level = getRandomLevel();
        iniciante.Pokemons_Capturados.add(this);
    }

    // Construtor utilizado na evolução de um pokemon estagio 1 para o estagio 2
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
