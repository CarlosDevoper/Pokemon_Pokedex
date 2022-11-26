package Jogo_Pokemon;

public class Treinador extends Pessoa {
    
    @Override
    public void apresentacao(){
        System.out.printf("Olá, me chamo %s tenho %d, sou um novo treinador da região de Kanto", getNome(), getIdade());
    }

    Treinador(String nome, String genero, int idade){
        Pessoa.nome = setNome(nome);
        this.genero = setGenero(genero);
        this.idade = setIdade(idade);

        Pessoas.add(this);
    }
}
