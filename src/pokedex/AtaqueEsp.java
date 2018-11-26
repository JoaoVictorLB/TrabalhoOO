package pokedex;

/**
 * Classe que determina o ataque especial de cada pokemon. 
 * 
 * @author João Victor Lopes, Gabriel Magalhães, Patrick Coelho
 */

public class AtaqueEsp extends Ataque{
    
    // Construtor
    public AtaqueEsp(String nome, int hit) {
        super(nome, hit);
        this.uso = true;
    }
    
    
    // Atributos
    
    /**
     * Variável que verifica a disponibilidade do ataque especial do pokemon, pois o mesmo pode utiliza-lo
     * uma única vez.
     */
    
    private boolean uso;
    
    // Métodos Especiais
    public boolean getUso() {
        return uso;
    }

    public void setUso(boolean uso) {
        this.uso = uso;
    }
    
    // Métodos Públicos
    
}
