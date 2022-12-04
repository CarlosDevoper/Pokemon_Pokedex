package Jogo_Pokemon;

import java.util.ArrayList;
import java.util.Arrays;

public class PokemonEstagio1 extends Pokemon {
    
    public static ArrayList<String> PokemonsEstagio1 = new ArrayList<>(Arrays.asList("Ivysaur", "Charmeleon", "Wartortle", "Metapod", "Kakuna",
    "Pidgeotto", "Raticate", "Fearow", "Arbok", "Pikachu", "Sandslash", "Nidorina", "Nidorino", "Clefable", "Ninetales", "Wigglytuff", "Golbat", "Gloom",
    "Parasect", "Venomoth", "Dugtrio", "Persian", "Golduck", "Primeape","Arcanine", "Poliwhirl", "Kadabra", "Machoke", "Weepinbell", "Tentacruel", "Graveler",
    "Rapidash", "Slowbro", "Magneton", null, "Dodrio", "Dewgong", "Muk", "Cloyster", "Haunter", null, "Hypno", "Kingler", "Electrode", "Exeggutor","Marowak",
    "Hitmonchan", null, "Weezing", "Rhydon", null, null, null, "Seadra", "Seaking", "Starmie", null, null, null, null, null, null, null, "Gyarados", null,
    null, null, null, "Omastar", "Kabutops", null, null, null, null, null,  "Dragonair", null, null));


    public static Boolean validarPokemon(String pokemon){
        
        boolean existe;
        if(PokemonsEstagio1.contains(pokemon)){
            existe = true;
        }else{
            existe = false;
        }
        return existe;
    }
    
    @Override
    public void evoluir(Pokemon pokemon){
        System.out.printf("Pokemon %s está evoluindo para o estágio 2\n", pokemon.getNome());
    }

    PokemonEstagio1(String nome, Treinador iniciante){
        this.nome = nome;
        estagio = 1;
        level = getRandomLevel();
        iniciante.Pokemons_Capturados.add(this);
    }


}
