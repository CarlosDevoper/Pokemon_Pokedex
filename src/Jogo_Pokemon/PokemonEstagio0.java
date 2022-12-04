package Jogo_Pokemon;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class PokemonEstagio0 extends Pokemon{
    
    /* Array de objetos que guarda todos os pokemons da 1ª geração
    que estão na forma inicial de evolução deles, array está organizado
    na forma que os pokemons aparecem na pokedex, caso seja null, significa
    que o pokemon de estágio anterior, não possui um estágio 1
    */
    public static ArrayList<String> PokemonsEstagio0 = new ArrayList<>(Arrays.asList("Bulbasaur", "Charmander", "Squirtle", "Caterpie", "Weedle",
    "Pidgey", "Rattata",  "Spearow", "Ekans", null, "Sandshrew", "Nidoran", "Nidoran♂", "Clefairy", "Vulpix", "Jigglypuff", "Zubat", "Oddish",
    "Paras","Venonat", "Diglett", "Meowth", "Psyduck", "Mankey", "Growlithe", "Poliwag", "Abra", "Machop", "Bellsprout", "Tentacool", "Geodude",
    "Ponyta", "Slowpoke", "Magnemite", "Farfetchd", "Doduo", "Seel", "Grimer", "Shellder", "Gastly", "Onix", "Drowzee", "Krabby", "Voltorb", "Exeggcute",
    "Cubone", "Hitmonlee", "Lickitung", "Koffing", "Rhyhorn", "Chansey", "Tangela", "Kangaskhan", "Horsea", "Goldeen", "Staryu", "Mr. Mime", "Scyther",
    "Jynx", "Electabuzz", "Magmar", "Pinsir","Tauros", "Magikarp", "Lapras", "Ditto", "Eevee", "Porygon", "Omanyte", "Kabuto", "Aerodactyl", "Snorlax",
    "Articuno", "Zapdos", "Moltres", "Dratini", "Mewtwo", "Mew"));

    /* Método que verifica se o pokemon passado como parâmetro,
    esta no estágio inicial de evolução, ou seja, se ele está presente
    no array de PokemonsEstagio0
    */
    public static Boolean validarPokemon(String pokemon){
        
        boolean existe;
        if(PokemonsEstagio0.contains(pokemon)){
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
        
        int n = PokemonsEstagio0.indexOf(pokemon.getNome());
        if(PokemonEstagio1.PokemonsEstagio1.get(n)== null){
            System.out.printf("    Seu %s não pode evoluir\n\n", pokemon.getNome());
        }else{
            
            System.out.printf("  Seu %s está evoluindo para %s..\n\n", pokemon.getNome(), PokemonEstagio1.PokemonsEstagio1.get(n));
            Thread.sleep(3000);
            System.out.println("         Pokemon evoluído com sucesso!\n");

            PokemonEstagio1 pokemonEvoluido = new PokemonEstagio1(PokemonEstagio1.PokemonsEstagio1.get(n), iniciante, pokemon.getLeve());
            iniciante.Pokemons_Capturados.remove(pokemon);
            iniciante.time.remove(pokemon);
            pokemon = null;
        }
    }

    // Construtor utilizado quando se captura um pokemon estagio 0
    PokemonEstagio0(String nome, Treinador iniciante){
        this.nome = nome;
        estagio = 0;
        level = getRandomLevel();
        iniciante.Pokemons_Capturados.add(this);
    }

    // Construtor utilizado na evolução de um pokemon estagio 0 para o estagio 0
    PokemonEstagio0(String nome, int level, Treinador iniciante){
        this.nome = nome;
        estagio = 0;
        this.level = level;
        iniciante.Pokemons_Capturados.add(this);
    }

}
