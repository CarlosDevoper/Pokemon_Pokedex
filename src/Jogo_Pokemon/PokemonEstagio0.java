package Jogo_Pokemon;

import java.util.ArrayList;
import java.util.Arrays;

public class PokemonEstagio0 extends Pokemon{
    
    public static ArrayList<String> PokemonsEstagio0 = new ArrayList<>(Arrays.asList("Bulbasaur", "Charmander", "Squirtle", "Caterpie", "Weedle",
    "Pidgey", "Rattata",  "Spearow", "Ekans", null, "Sandshrew", "Nidoran", "Nidoran♂", "Clefairy", "Vulpix", "Jigglypuff", "Zubat", "Oddish",
    "Paras","Venonat", "Diglett", "Meowth", "Psyduck", "Mankey", "Growlithe", "Poliwag", "Abra", "Machop", "Bellsprout", "Tentacool", "Geodude",
    "Ponyta", "Slowpoke", "Magnemite", "Farfetchd", "Doduo", "Seel", "Grimer", "Shellder", "Gastly", "Onix", "Drowzee", "Krabby", "Voltorb", "Exeggcute",
    "Cubone", "Hitmonlee", "Lickitung", "Koffing", "Rhyhorn", "Chansey", "Tangela", "Kangaskhan", "Horsea", "Goldeen", "Staryu", "Mr. Mime", "Scyther",
    "Jynx", "Electabuzz", "Magmar", "Pinsir","Tauros", "Magikarp", "Lapras", "Ditto", "Eevee", "Porygon", "Omanyte", "Kabuto", "Aerodactyl", "Snorlax",
    "Articuno", "Zapdos", "Moltres", "Dratini", "Mewtwo", "Mew"));

    public void evoluir(){
        
    }

    PokemonEstagio0(String nome, Treinador iniciante){
        this.nome = nome;
        estagio = 0;
        level = getRandomLevel();
        iniciante.Pokemons_Capturados.add(this);
    }

    PokemonEstagio0(String nome, int level, Treinador iniciante){
        this.nome = nome;
        estagio = 0;
        this.level = level;
        iniciante.Pokemons_Capturados.add(this);
    }

}
