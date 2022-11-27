package Jogo_Pokemon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public abstract class Pokemon {
    
    String nome;
    int estagio;
    int level;

    public static ArrayList<String> Pokemons = new ArrayList<>(Arrays.asList("Bulbasaur", "Ivysaur", "Venusaur", "Charmander", "Charmeleon", "Charizard",
    "Squirtle", "Wartortle", "Blastoise", "Caterpie", "Metapod", "Metapod", "Butterfree", "	Weedle", "Kakuna", "Beedrill",
    "Pidgey", "Pidgeotto", "Pidgeot", "Rattata", "Raticate", "Spearow", "Fearow", "Ekans", "Arbok", "Pikachu", "Raichu",
    "Sandshrew", "Sandslash", "	Nidoran", "Nidorina", "Nidoqueen", "Nidoran♂", "Nidorino", "Nidoking", "Clefairy", "Clefable", 
    "Vulpix", "Ninetales", "Jigglypuff", "Wigglytuff", "Zubat", "Golbat", "Oddish", "Gloom", "Vileplume", "Paras", "Parasect", 
    "Venonat", "Venomoth", "Diglett", "Dugtrio", "Meowth", "Persian", "Psyduck", "Golduck", "Mankey", "Primeape", "Growlithe", 
    "Arcanine", "Poliwag", "Poliwhirl", "Poliwrath", "Abra", "Kadabra", "Alakazam", "Machop", "Machoke", "Machamp", "Bellsprout",
    "Weepinbell", "Victreebel", "Tentacool", "Tentacruel", "Geodude", "Graveler", "Golem", "Ponyta", "Rapidash", "Slowpoke", "Slowbro",
    "Magnemite", "Magneton", "Farfetchd", "Doduo", "Dodrio", "Seel", "Dewgong", "Grimer", "Muk", "	Shellder", "Cloyster", "Gastly",
    "Haunter", "Gengar", "Onix", "Drowzee", "Hypno", "Krabby", "Kingler", "Voltorb", "Electrode", "	Exeggcute", "Exeggutor", "Cubone",
    "Marowak", "Hitmonlee", "Hitmonchan", "Lickitung", "Koffing", "Weezing", "Rhyhorn", "Rhydon", "Chansey", "Tangela", "Kangaskhan", 
    "Horsea", "Seadra", "Goldeen", "Seaking", "Staryu", "Starmie", "Mr. Mime", "Scyther", "Jynx", "	Electabuzz", "	Magmar", "Pinsir",
    "Tauros", "Magikarp", "Gyarados", "Lapras", "Ditto", "Eevee", "Vaporeon", "Jolteon", "Flareon", "Porygon", "Omanyte", "Omastar",
    "Kabuto", "Kabutops", "Aerodactyl", "Snorlax", "Articuno", "Zapdos", "Moltres", "Dratini", "Dragonair", "Dragonite", "Mewtwo", "Mew"));
     

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
