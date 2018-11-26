package pokedex;
import java.util.Scanner;

/**
 * A classe Pokemon serve para realizar o registro dos pokemons.
 * 
 * @author João Victor Lopes, Gabriel Magalhães, Patrick Coelho
 */

public class Pokemon {
    
    //Construtor
    public Pokemon(int id, String nome, int hpmax, String nome2, int hit, String nome3, int hit2, String nome4, int vant) {
        this.id = id;
        this.tipo = new Tipo(nome4, vant);
        this.nome = nome;
        this.hpmax = hpmax;
        this.hp = hpmax;
        this.ataque = new Ataque(nome2, hit);
        this.atkEsp = new AtaqueEsp(nome3, hit2);
        this.defesa = false;
    }
    
    
    //Atributos
    
    /**
     * Os seguintes atributos são exclusivos de cada objeto pokemon, e definem o estado de cada um deles.
     */
    
    private int hpmax;
    private int hp;
    private String nome;
    private Tipo tipo;
    private Ataque ataque;
    private AtaqueEsp atkEsp;
    private int id;
    private boolean defesa;
    
    //Métodos Especiais
    public int getHpmax() {
        return hpmax;
    }

    public void setHpmax(int hpmax) {
        this.hpmax = hpmax;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }
    
    public Ataque getAtaque() {
        return ataque;
    }
    
    public void setAtaque(Ataque ataque) {
        this.ataque = ataque;
    }

    public AtaqueEsp getAtkEsp() {
        return atkEsp;
    }

    public void setAtkEsp(AtaqueEsp atkEsp) {
        this.atkEsp = atkEsp;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public int getId() {
        return id;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public boolean getDefesa() {
        return defesa;
    }

    public void setDefesa(boolean defesa) {
        this.defesa = defesa;
    }
    
    
    
    
    //Métodos Públicos
    
    /**
     * O método status informa durante o decorrer da partida a situação dos objetos pokemon, ou seja,
     * apresenta os ataques possíveis e os pontos de vida.
     */
    
    public void status() {
        System.out.println("============ "+this.getNome()+" ============");
        System.out.println("");
        System.out.println("   ## PONTOS DE VIDA ##");
        System.out.println("");
        System.out.print(+this.getHp()+" / "+this.getHpmax()+"  ");
        for(int i = 0; i < this.getHpmax(); i+=5) {
            if(i < this.getHp())
                System.out.print("[♥]");
            else 
                System.out.print("[ ]");
        }
        System.out.println("");
        System.out.println("");
        System.out.println("   ## ATAQUES ##");
        System.out.println("");
        System.out.println("1. "+this.getAtaque().getNome()+"     "+this.getAtaque().getHit()+" hit points");
        System.out.println("2. "+this.getAtkEsp().getNome()+"     "+this.getAtkEsp().getHit()+" hit points");
        System.out.println("3. Defender;");
        System.out.println("");
        System.out.println("===================================");
        System.out.println("");
        System.out.println("");
    }
    
    /**
     * O método vida() identifica a vida atual do pokemon a cada rodada do oponente.
     */
    
    public void vida() {
        if(this.getHp() < 0) {
            System.out.print(this.getNome()+": 0/"+this.getHpmax()+"  ");
            for(int i = 0; i < this.getHpmax(); i+=5) {
                if(i < this.getHp())
                    System.out.print("[♥]");
                else 
                    System.out.print("[ ]");
            }
        }
        else {
            System.out.print(this.getNome()+": "+this.getHp()+"/"+this.getHpmax()+"  ");
            for(int i = 0; i < this.getHpmax(); i+=5) {
                if(i < this.getHp())
                    System.out.print("[♥]");
                else 
                    System.out.print("[ ]");
            }
        }
    }
    
    
    
}
