package Jogo_Pokemon;

import java.util.ArrayList;
import java.util.Random;

public abstract class Pokemon {
    
    String nome;
    int estagio;
    int level;

    public static ArrayList<Pokemon> Pokemons = new ArrayList<>();

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
