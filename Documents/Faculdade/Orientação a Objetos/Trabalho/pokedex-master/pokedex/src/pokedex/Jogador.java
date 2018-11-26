package pokedex;

/**
 * Na classe Jogador são determindos os dados do jogador, incluindo seu nome, o pokemon escolhido
 * e a variável n indica se este é o jogador 1 ou 2.
 * 
 * @author João Victor Lopes, Gabriel Magalhães, Patrick Coelho
 */

public class Jogador {

    //Construtor 
    public Jogador (int n, String nome, Pokemon pokemon) {
        this.n = n;
        this.nome = nome;
        this.pokemon = pokemon;
    }
    
    //Atributos
    private int n; 
    private String nome;
    private Pokemon pokemon;
    
    
    //Métodos Especiais
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Pokemon getPokemon() {
        return pokemon;
    }

    public void setPokemon(Pokemon pokemon) {
        this.pokemon = pokemon;
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }
    
    
    
    
    //Métodos Públicos
    
    /**
     * Informa aos jogadores seus respectivos status, ou seja, seus nomes e pokemons.
     */
    
    public void status() {
        System.out.println("Nome do jogador "+n+": "+this.getNome());
        System.out.println("Pokemon escolhido: "+this.getPokemon().getNome());
    }
    
   

}
