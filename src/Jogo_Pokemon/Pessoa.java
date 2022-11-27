package Jogo_Pokemon;

import java.util.ArrayList;

public abstract class Pessoa {
    
    protected static String nome;
    protected String genero;
    protected static int idade;
    
    public static ArrayList<Pessoa> Pessoas = new ArrayList<>();

    public static String getNome(){
        return nome;
    }

    public String setNome(String nome){
        Pessoa.nome = nome;
        return nome;
    }

    public String getGenero(){
        return genero;
    }

    public String setGenero(String genero){
        this.genero = genero;
        return genero;
    }

    public static int getIdade(){
        return idade;
    }

    public int setIdade(int idade){
        Pessoa.idade = idade;
        return idade;
    }
    
    public void apresentacao(){
        System.out.printf("Olá, me chamo %s tenho %d da região de Kanto", getNome(), getIdade());
    }
}
