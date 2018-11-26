package pokedex;

/**
 * A Classe Tipo fornece ao jogo o nome do pokemon e sua vantagem contra os demais.
 * 
 * @author João Victor Lopes, Gabriel Magalhães, Patrick Coelho
 */

public class Tipo {
    
    //Atributos
    private String nome;
    private int vant;
    
    //Construtor
    public Tipo(String nome, int vant) {
        this.nome = nome;
        this.vant = vant;
    }
    
    
    //Métodos Especiais
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getVant() {
        return vant;
    }

    public void setVant(int vant) {
        this.vant = vant;
    }
    
    //Métodos Públicos
    
}
