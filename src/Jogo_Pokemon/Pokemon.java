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
     
    public static void Pokedex(){
        int n = Pokemons.size();
        int v = 1;

        System.out.printf("%-7s|%-15s\n", "ID", "Nome");
        for(int i = 0; i<n; i++ ){
            System.out.printf("%06d |%-15s\n",v, Pokemons.get(i));
            v++;
        }
    }


    public void evoluir(Pokemon pokemon){
        System.out.printf("Pokemon %s está evoluindo\n", pokemon.getNome());
    }
    public static Boolean validarPokemon(String pokemon){
        
        boolean existe;
        if(Pokemons.contains(pokemon)){
            existe = true;
        }else{
            existe = false;
        }
        return existe;
    }

    public static Boolean validarCaptura(String pokemon, Treinador iniciante){
        
        Boolean captura;
        Random chance = new Random();
        ArrayList<Integer> pego = new ArrayList<>(Arrays.asList(1,1,0,0));
        int chances = chance.nextInt(0,pego.size());
        
        if(pego.get(chances) == 1){
            if(PokemonEstagio0.validarPokemon(pokemon)){
                PokemonEstagio0 novoPokemon = new PokemonEstagio0(pokemon, iniciante);
                
                if(iniciante.time.size()<6){
                    iniciante.time.add(novoPokemon);
                 }
            }else if(PokemonEstagio1.validarPokemon(pokemon)){
                PokemonEstagio1 novoPokemon = new PokemonEstagio1(pokemon, iniciante);
                
                if(iniciante.time.size()<6){
                    iniciante.time.add(novoPokemon);
                 }
            }else if(PokemonEstagio2.validarPokemon(pokemon)){
                PokemonEstagio2 novoPokemon = new PokemonEstagio2(pokemon, iniciante);
                
                if(iniciante.time.size()<6){
                    iniciante.time.add(novoPokemon);
                 }
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
        this.level += level;
        return level;
    }

    public int getRandomLevel() {
        Random random = new Random();
        int randomLevel = random.nextInt(100);
        
        return randomLevel;
    }

}
