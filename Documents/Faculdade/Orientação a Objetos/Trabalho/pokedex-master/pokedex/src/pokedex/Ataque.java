package pokedex;

/**
 * Classe responável pelo ataque básico dos jogadores.
 * 
 * @author João Victor Lopes, Gabriel Magalhães, Patrick Coelho
 */

public class Ataque {
    
    //Construtor
    public Ataque(String nome, int hit) {
        this.nome = nome;
        this.hit = hit;
    }
    
    //Atributos
    private String nome;
    private int hit;
    
    
    //Métodos Especiais
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getHit() {
        return hit;
    }

    public void setHit(int hit) {
        this.hit = hit;
    }
    
    //Métodos Públicos

    

    
}
