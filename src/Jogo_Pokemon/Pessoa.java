package Jogo_Pokemon;

import java.util.ArrayList;

public abstract class Pessoa {
    
    protected String nome;
    protected String genero;
    protected int idade;
    
    public static ArrayList<Pessoa> Pessoas = new ArrayList<>();

    public String getNome(){
        return nome;
    }

    public String setNome(String nome){
        this.nome = nome;
        return nome;
    }

    public String getGenero(){
        return genero;
    }

    public String setGenero(String genero){
        this.genero = genero;
        return genero;
    }

    public int getIdade(){
        return idade;
    }

    public int setIdade(int idade){
        this.idade = idade;
        return idade;
    }
    
}
