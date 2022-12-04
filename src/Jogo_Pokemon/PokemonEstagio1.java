package Jogo_Pokemon;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class PokemonEstagio1 extends Pokemon {
    
    /* Array de objetos que guarda todos os pokemons da 1ª geração
    que possuem um primeiro estágio de evolução, array está organizado
    na forma que os pokemons aparecem na pokedex, caso seja null, significa
    que o pokemon de estágio anterior, não possui um estágio 1
    */
    public static ArrayList<String> PokemonsEstagio1 = new ArrayList<>(Arrays.asList("Ivysaur", "Charmeleon", "Wartortle", "Metapod", "Kakuna",
    "Pidgeotto", "Raticate", "Fearow", "Arbok", "Pikachu", "Sandslash", "Nidorina", "Nidorino", "Clefable", "Ninetales", "Wigglytuff", "Golbat", "Gloom",
    "Parasect", "Venomoth", "Dugtrio", "Persian", "Golduck", "Primeape","Arcanine", "Poliwhirl", "Kadabra", "Machoke", "Weepinbell", "Tentacruel", "Graveler",
    "Rapidash", "Slowbro", "Magneton", null, "Dodrio", "Dewgong", "Muk", "Cloyster", "Haunter", null, "Hypno", "Kingler", "Electrode", "Exeggutor","Marowak",
    "Hitmonchan", null, "Weezing", "Rhydon", null, null, null, "Seadra", "Seaking", "Starmie", null, null, null, null, null, null, null, "Gyarados", null,
    null, null, null, "Omastar", "Kabutops", null, null, null, null, null,  "Dragonair", null, null));

    /* Método que verifica se o pokemon passado como parâmetro,
    possui uma evolução estágio 1, ou seja, se ele está presente
    no array de PokemonsEstagio1
    */
    public static Boolean validarPokemon(String pokemon){
        
        boolean existe;
        if(PokemonsEstagio1.contains(pokemon)){
            existe = true;
        }else{
            existe = false;
        }
        return existe;
    }


    /* Reescrita do método evoluir da classe mãe de pokemon, como
    forma de polimorfismo, cada estágio tem uma forma de evoluir
    */
    @Override
    public void evoluir(Pokemon pokemon, int ID, Treinador iniciante) throws InterruptedException, IOException{
        
        int n = PokemonsEstagio1.indexOf(pokemon.getNome());
        if(PokemonEstagio2.PokemonsEstagio2.get(n)== null){
            System.out.printf("    Seu %s não pode evoluir\n\n", pokemon.getNome());
        }else{
            
            System.out.printf("  Seu %s está evoluindo para %s..\n\n", pokemon.getNome(), PokemonEstagio2.PokemonsEstagio2.get(n));
            Thread.sleep(3000);
            System.out.println("         Pokemon evoluído com sucesso!\n");

            PokemonEstagio2 pokemonEvoluido = new PokemonEstagio2(PokemonEstagio2.PokemonsEstagio2.get(n), iniciante, pokemon.getLeve());
            iniciante.Pokemons_Capturados.remove(pokemon);
            iniciante.time.remove(pokemon);
            pokemon = null;
        }
    }

    // Construtor utilizado quando se captura um pokemon estagio 1
    PokemonEstagio1(String nome, Treinador iniciante){
        this.nome = nome;
        estagio = 1;
        level = getRandomLevel();
        iniciante.Pokemons_Capturados.add(this);
    }

    // Construtor utilizado na evolução de um pokemon estagio 0 para o estagio 1
    PokemonEstagio1(String nome, Treinador iniciante, int level){
        this.nome = nome;
        estagio = 1;
        this.level = level;
        iniciante.Pokemons_Capturados.add(this);
        if(iniciante.time.size()<6){
            iniciante.time.add(this);
        }
    }


}
