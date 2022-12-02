package Jogo_Pokemon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public abstract class Pokemon {
    
    String nome;
    int estagio;
    int level;

    public static ArrayList<String> Pokemons = new ArrayList<>(Arrays.asList("Bulbasaur", "Ivysaur", "Venusaur", "Charmander", "Charmeleon", "Charizard",
    "Squirtle", "Wartortle", "Blastoise", "Caterpie", "Metapod", "Butterfree", "Weedle", "Kakuna", "Beedrill",
    "Pidgey", "Pidgeotto", "Pidgeot", "Rattata", "Raticate", "Spearow", "Fearow", "Ekans", "Arbok", "Pikachu", "Raichu",
    "Sandshrew", "Sandslash", "Nidoran", "Nidorina", "Nidoqueen", "Nidoran♂", "Nidorino", "Nidoking", "Clefairy", "Clefable", 
    "Vulpix", "Ninetales", "Jigglypuff", "Wigglytuff", "Zubat", "Golbat", "Oddish", "Gloom", "Vileplume", "Paras", "Parasect", 
    "Venonat", "Venomoth", "Diglett", "Dugtrio", "Meowth", "Persian", "Psyduck", "Golduck", "Mankey", "Primeape", "Growlithe", 
    "Arcanine", "Poliwag", "Poliwhirl", "Poliwrath", "Abra", "Kadabra", "Alakazam", "Machop", "Machoke", "Machamp", "Bellsprout",
    "Weepinbell", "Victreebel", "Tentacool", "Tentacruel", "Geodude", "Graveler", "Golem", "Ponyta", "Rapidash", "Slowpoke", "Slowbro",
    "Magnemite", "Magneton", "Farfetchd", "Doduo", "Dodrio", "Seel", "Dewgong", "Grimer", "Muk", "Shellder", "Cloyster", "Gastly",
    "Haunter", "Gengar", "Onix", "Drowzee", "Hypno", "Krabby", "Kingler", "Voltorb", "Electrode", "Exeggcute", "Exeggutor", "Cubone",
    "Marowak", "Hitmonlee", "Hitmonchan", "Lickitung", "Koffing", "Weezing", "Rhyhorn", "Rhydon", "Chansey", "Tangela", "Kangaskhan", 
    "Horsea", "Seadra", "Goldeen", "Seaking", "Staryu", "Starmie", "Mr. Mime", "Scyther", "Jynx", "Electabuzz", "Magmar", "Pinsir",
    "Tauros", "Magikarp", "Gyarados", "Lapras", "Ditto", "Eevee", "Vaporeon", "Jolteon", "Flareon", "Porygon", "Omanyte", "Omastar",
    "Kabuto", "Kabutops", "Aerodactyl", "Snorlax", "Articuno", "Zapdos", "Moltres", "Dratini", "Dragonair", "Dragonite", "Mewtwo", "Mew"));
     
    public static ArrayList<String> PokemonsEstagio0 = new ArrayList<>(Arrays.asList("Bulbasaur", "Charmander", "Squirtle", "Caterpie", "Weedle",
    "Pidgey", "Rattata",  "Spearow", "Ekans", null, "Sandshrew", "Nidoran", "Nidoran♂", "Clefairy", "Vulpix", "Jigglypuff", "Zubat", "Oddish",
    "Paras","Venonat", "Diglett", "Meowth", "Psyduck", "Mankey", "Growlithe", "Poliwag", "Abra", "Machop", "Bellsprout", "Tentacool", "Geodude",
    "Ponyta", "Slowpoke", "Magnemite", "Farfetchd", "Doduo", "Seel", "Grimer", "Shellder", "Gastly", "Onix", "Drowzee", "Krabby", "Voltorb", "Exeggcute",
    "Cubone", "Hitmonlee", "Lickitung", "Koffing", "Rhyhorn", "Chansey", "Tangela", "Kangaskhan", "Horsea", "Goldeen", "Staryu", "Mr. Mime", "Scyther",
    "Jynx", "Electabuzz", "Magmar", "Pinsir","Tauros", "Magikarp", "Lapras", "Ditto", "Eevee", "Porygon", "Omanyte", "Kabuto", "Aerodactyl", "Snorlax",
    "Articuno", "Zapdos", "Moltres", "Dratini", "Mewtwo", "Mew"));

    public static ArrayList<String> PokemonsEstagio1 = new ArrayList<>(Arrays.asList("Ivysaur", "Charmeleon", "Wartortle", "Metapod", "Kakuna",
    "Pidgeotto", "Raticate", "Fearow", "Arbok", "Pikachu", "Sandslash", "Nidorina", "Nidorino", "Clefable", "Ninetales", "Wigglytuff", "Golbat", "Gloom",
    "Parasect", "Venomoth", "Dugtrio", "Persian", "Golduck", "Primeape","Arcanine", "Poliwhirl", "Kadabra", "Machoke", "Weepinbell", "Tentacruel", "Graveler",
    "Rapidash", "Slowbro", "Magneton", null, "Dodrio", "Dewgong", "Muk", "Cloyster", "Haunter", null, "Hypno", "Kingler", "Electrode", "Exeggutor","Marowak",
    "Hitmonchan", null, "Weezing", "Rhydon", null, null, null, "Seadra", "Seaking", "Starmie", null, null, null, null, null, null, null, "Gyarados", null,
    null, null, null, "Omastar", "Kabutops", null, null, null, null, null,  "Dragonair", null, null));

    public static ArrayList<String> PokemonsEstagio2 = new ArrayList<>(Arrays.asList("Venusaur", "Charizard", "Blastoise", "Butterfree", "Beedrill",
    "Pidgeot", null, null, null, "Raichu", null, "Nidoqueen", "Nidoking", null, null, null, null, "Vileplume", null, null, null, null, null, null, null,
    "Poliwrath", "Alakazam", "Machamp", "Victreebel", null, "Golem", null, null, null, null, null, null, null, null, "Gengar", null, null, null, null,
    null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
    null, null, null, null, null, null,  "Dragonite", null, null));

    public static Boolean validarPokemon(String pokemon){
        
        boolean existe;
        if(Pokemons.contains(pokemon)){
            existe = true;
        }else{
            existe = false;
        }
        return existe;
    }

    public static Boolean validarCaptura(String pokemon){
        Boolean captura;
        Random chance = new Random();
        ArrayList<Integer> pego = new ArrayList<>(Arrays.asList(1,1,1,0));
        int chances = chance.nextInt(4);

        if(pego.get(chances) == 1){
            PokemonEstagio0 inicial = new PokemonEstagio0(pokemon);
            if(Treinador.time.size()<6){
                Treinador.time.add(inicial);
            }
            captura = true;

        } else {
            captura = false;
        }

        return captura;

    }


    public String getNome(){
        return nome;
    }

    public String setNome(String nome){
        this.nome = nome;
        return nome;
    }


    public int getEstagio(){
        return estagio;
    }

    public int setEstagio(int estagio){
        this.estagio = estagio;
        return estagio;
    }

    public int getLeve(){
        return level;
    }

    public int setLevel(int level){
        this.level = level;
        return level;
    }

    public int getRandomLevel() {
        Random random = new Random();
        int randomLevel = random.nextInt(100);
        
        return randomLevel;
    }

}
