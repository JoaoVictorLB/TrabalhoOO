package pokedex;
import java.util.Scanner;

/**
 * Nesta classe são implementados os métodos que compoem o campo de batalha
 * e definem a vitória, derrota, e alternância de ataque entre os jogadores.
 * 
 * @author João Victor Lopes, Gabriel Magalhães, Patrick Coelho
 */

public class Batalha {
    
    //Construtor
    public Batalha(Jogador j1, Jogador j2) {
        this.j1 = j1;
        this.j2 = j2;
    }
    
    
    //Atributos
    private Jogador j1;
    private Jogador j2;
    private int vant;
    
    
    //Métodos Especiais
    public Jogador getJ1() {
        return j1;
    }

    public void setJ1(Jogador j1) {
        this.j1 = j1;
    }

    public Jogador getJ2() {
        return j2;
    }

    public void setJ2(Jogador j2) {
        this.j2 = j2;
    }

    public int getVant() {
        return vant;
    }

    public void setVant(int vant) {
        this.vant = vant;
    }
    
    
    
    //Métodos Públicos
    
    /**
     *  Método batalha da início ao jogo. 
     */
    
    public void batalha() {
        int atk;
        Scanner ler = new Scanner(System.in);
        boolean n = true;
        System.out.println("");
        System.out.println("");
        System.out.println("A BATALHA ESTÁ PRESTES A COMEÇAR...");
        System.out.println("");
        System.out.println(this.getJ1().getNome()+" ("+this.getJ1().getPokemon().getNome()+")  X  ("+this.getJ2().getPokemon().getNome()+") "+this.getJ2().getNome());
        System.out.println("");
        
        //VERIFICA PARA QUEM ESTÁ A VANTAGEM------------------------------------------------------------
        
        if (this.getJ1().getPokemon().getId() == this.getJ2().getPokemon().getTipo().getVant()) 
            this.setVant(2);
        else if (this.getJ2().getPokemon().getId() == this.getJ1().getPokemon().getTipo().getVant())
            this.setVant(1);
        
        System.out.println("A vantagem é de: "+this.getVant());
        System.out.println("");
        // QUANDO NINGUÉM TEM A VANTAGEM, APARECERÁ 0
        
        // ---------------------------------------------------------------------------------------------
        
        while(n) {
            
            //JOGADOR 1 ATACA----------------------------------------------------------------------------------------------------------------------------
            
            System.out.println(this.getJ1().getNome()+", escolha seu ataque: ");
            System.out.println("1. "+this.getJ1().getPokemon().getAtaque().getNome()+";");
            System.out.println("2. "+this.getJ1().getPokemon().getAtkEsp().getNome()+";");
            System.out.println("3. Defender;");
            System.out.println("");
            System.out.print("ATAQUE: ");
            atk = Integer.parseInt(ler.nextLine());
            System.out.println("---------------------------------------");
            System.out.println("");
            
            this.acaoJ1(atk, vant);
            this.vida();
            
            this.getJ2().getPokemon().setDefesa(false);
            
            //-------------------------------------------------------------------------------------------------------------------------------------------
            
            //VERIFICA SE ACABOU------
            if(n)
                n = this.verificaVitoria();
            
            //------------------------
            
            //JOGADOR 2 ATACA-------------------------------------------------------------------------------------------------------------------------------
            
            if(n) {
                System.out.println(this.getJ2().getNome()+", escolha seu ataque: ");
                System.out.println("1. "+this.getJ2().getPokemon().getAtaque().getNome()+";");
                System.out.println("2. "+this.getJ2().getPokemon().getAtkEsp().getNome()+";");
                System.out.println("3. Defesa;");
                System.out.println("");
                System.out.print("ATAQUE: ");
                atk = Integer.parseInt(ler.nextLine());
                System.out.println("---------------------------------------");
                System.out.println("");
                
                this.acaoJ2(atk, vant);
                this.vida();
                
                this.getJ1().getPokemon().setDefesa(false);
            }
            
            //----------------------------------------------------------------------------------------------------------------------------------------------
            
            //VERIFICA SE ACABOU------
            if(n)
                n = this.verificaVitoria();
            
            //------------------------
        }
    }
    
    /**
     * O método verificaVitoria() analisa o HP(Health Points), de cada pokémon para que
     * quando o primeiro tiver vida menor ou igual a zero, este é dado como derrotado e o oponente
     * sai vitorioso.
     */
    
    public boolean verificaVitoria() {
        if(this.getJ1().getPokemon().getHp() <= 0) {
            System.out.println(this.getJ2().getPokemon().getNome()+" derrotou "+this.getJ1().getPokemon().getNome());
            System.out.println(this.getJ2().getNome()+" é o novo campeão!!!");
            return false;
        }
        else if(this.getJ2().getPokemon().getHp() <= 0) {
            System.out.println(this.getJ1().getPokemon().getNome()+" derrotou "+this.getJ2().getPokemon().getNome());
            System.out.println(this.getJ1().getNome()+" é o novo campeão!!!");
            return false;
        }
        else
            return true;
    }
    
    
    
    /**
     * O método acaoJ1(int n, int vant) define dentre as 3 opções do jogador 1 qual será realizada com
     * base na escolha do jogador.
     * 
     * @param n
     * @param vant 
     */
    
    public void acaoJ1(int n, int vant) {
    
        if(this.getJ2().getPokemon().getDefesa()) {
            if(n == 3) {
                this.getJ1().getPokemon().setDefesa(true);
                System.out.println(this.getJ1().getPokemon().getNome()+" está em posição de defesa! A posição de defesa dura 1 turno");
            }
            else
                System.out.println("O dano do ataque de "+this.getJ2().getPokemon().getNome()+" foi bloqueado!");
        }
        
        else {
            switch (n) {
                case 1:
                    System.out.println("-- "+this.getJ1().getPokemon().getNome()+" usou "+this.getJ1().getPokemon().getAtaque().getNome()+" --");
                        
                    // VERIFICA SE HÁ VANTAGEM E TIRA O HP DO JOGADOR 1-------------------------------------------
                    if(this.getJ1().getN() == vant) {
                        System.out.println("It' super effective!");
                        System.out.println(this.getJ2().getPokemon().getNome()+" tomou "+this.getJ1().getPokemon().getAtaque().getHit()*2+" de dano!");
                        this.getJ2().getPokemon().setHp(this.getJ2().getPokemon().getHp()-this.getJ1().getPokemon().getAtaque().getHit()*2);
                    }
                    else {
                        System.out.println(this.getJ2().getPokemon().getNome()+" tomou "+this.getJ1().getPokemon().getAtaque().getHit()+" de dano!");
                        this.getJ2().getPokemon().setHp(this.getJ2().getPokemon().getHp()-this.getJ1().getPokemon().getAtaque().getHit());
                    }
                    break;
                        
                case 2:
                    if(this.getJ1().getPokemon().getAtkEsp().getUso()) {
                        if(this.getJ1().getN() == vant) {
                            System.out.println("It' super effective!");
                            System.out.println(this.getJ2().getPokemon().getNome()+" tomou "+this.getJ1().getPokemon().getAtkEsp().getHit()*2+" de dano!");
                            this.getJ2().getPokemon().setHp(this.getJ2().getPokemon().getHp()-this.getJ1().getPokemon().getAtkEsp().getHit()*2);
                        }
                        else {
                            System.out.println(this.getJ2().getPokemon().getNome()+" tomou "+this.getJ1().getPokemon().getAtkEsp().getHit()+" de dano!");
                            this.getJ2().getPokemon().setHp(this.getJ2().getPokemon().getHp()-this.getJ1().getPokemon().getAtkEsp().getHit());
                        }
                        this.getJ1().getPokemon().getAtkEsp().setUso(false);
                    }
                    else {
                        //  ATAQUE JÁ FOI UTILIZADO
                        System.out.println(this.getJ1().getPokemon().getNome()+" está muito cansado para utilizar o golpe especial!");
                        break;
                    }
                    break;
                    
                case 3:
                    this.getJ1().getPokemon().setDefesa(true);
                    System.out.println(this.getJ1().getPokemon().getNome()+" está em posição de defesa! A posição de defesa dura 1 turno");
                    break;
            }
        }
        
        
        System.out.println("");
        
    }

    
    
    
    public void acaoJ2(int n, int vant) {
        
        if(this.getJ1().getPokemon().getDefesa()) {
            if(n == 3) {
                this.getJ2().getPokemon().setDefesa(true);
                System.out.println(this.getJ2().getPokemon().getNome()+" está em posição de defesa! A posição de defesa dura 1 turno");
            }
            else
                System.out.println("O dano do ataque de "+this.getJ1().getPokemon().getNome()+" foi bloqueado!");
        }
        
        else {
            switch (n) {
                case 1:
                    System.out.println("-- "+this.getJ2().getPokemon().getNome()+" usou "+this.getJ2().getPokemon().getAtaque().getNome()+" --");
                        
                    // VERIFICA SE HÁ VANTAGEM E TIRA O HP DO JOGADOR 1-------------------------------------------
                    if(this.getJ2().getN() == vant) {
                        System.out.println("It' super effective!");
                        System.out.println(this.getJ1().getPokemon().getNome()+" tomou "+this.getJ2().getPokemon().getAtaque().getHit()*2+" de dano!");
                        this.getJ1().getPokemon().setHp(this.getJ1().getPokemon().getHp()-this.getJ2().getPokemon().getAtaque().getHit()*2);
                    }
                    else {
                        System.out.println(this.getJ1().getPokemon().getNome()+" tomou "+this.getJ2().getPokemon().getAtaque().getHit()+" de dano!");
                        this.getJ1().getPokemon().setHp(this.getJ1().getPokemon().getHp()-this.getJ2().getPokemon().getAtaque().getHit());
                    }
                    break;
                        
                case 2:
                    if(this.getJ2().getPokemon().getAtkEsp().getUso()) {
                        if(this.getJ2().getN() == vant) {
                            System.out.println("It' super effective!");
                            System.out.println(this.getJ1().getPokemon().getNome()+" tomou "+this.getJ2().getPokemon().getAtkEsp().getHit()*2+" de dano!");
                            this.getJ1().getPokemon().setHp(this.getJ1().getPokemon().getHp()-this.getJ2().getPokemon().getAtkEsp().getHit()*2);
                        }
                        else {
                            System.out.println(this.getJ1().getPokemon().getNome()+" tomou "+this.getJ2().getPokemon().getAtkEsp().getHit()+" de dano!");
                            this.getJ1().getPokemon().setHp(this.getJ1().getPokemon().getHp()-this.getJ2().getPokemon().getAtkEsp().getHit());
                        }
                        this.getJ2().getPokemon().getAtkEsp().setUso(false);
                    }
                    else {
                        //  ATAQUE JÁ FOI UTILIZADO
                        System.out.println(this.getJ2().getPokemon().getNome()+" está muito cansado para utilizar o golpe especial!");
                        break;
                    }
                    break;
                    
                case 3:
                    this.getJ2().getPokemon().setDefesa(true);
                    System.out.println(this.getJ2().getPokemon().getNome()+" está em posição de defesa! A posição de defesa dura 1 turno");
                    break;
            }
        }
        
        
        System.out.println("");
    }
    
    /**
     * O método vida() informa aos jogadores o estado atual de seus respectivos pokémons a cada 
     * ação realizada na partida.
     */
    
    public void vida() {
        System.out.println("------------------VIDA ATUAL------------------");
        this.getJ1().getPokemon().vida();
        System.out.println("");
        this.getJ2().getPokemon().vida();
        System.out.println("");
        System.out.println("----------------------------------------------");
        System.out.println("");
    }
    
}