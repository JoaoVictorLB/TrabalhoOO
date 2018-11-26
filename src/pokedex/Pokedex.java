package pokedex;
import java.util.Scanner;

/**
 * Na classe Pokedex criamos o 'catálogo' de pokémons disponíveis para serem utilizados em batalha.
 * 
 * @author João Victor Lopes, Gabriel Magalhães, Patrick Coelho
 */

public class Pokedex {
    
    /**
     * O método main inicializa o código invocando todos os metodos, classes e atributos necessários
     * a partir deste ponto.
     * 
     * @param args 
     */
    
    public static void main(String[] args) {
        
        Scanner ler = new Scanner(System.in);
        
        
        Pokemon p1 = new Pokemon(1, "Pikachu", 20, "Choque", 7, "Super Choque", 10, "Elétrico", 4);
        Pokemon p2 = new Pokemon(2, "Charizard", 30, "Bafo Flamejante", 5, "Baforada Flamejante", 7, "Fogo", 5);
        Pokemon p3 = new Pokemon(3, "Sandshrew", 40, "Terremoto", 3, "Terremoto Japonês", 5, "Terra", 1);
        Pokemon p4 = new Pokemon(4, "Squirtle", 20, "Esguicho", 7, "Esguicho de Noé", 10, "Aquático", 2);
        Pokemon p5 = new Pokemon(5, "Bulbassauro", 20, "\"Gramada\"", 7, "\"Gramada\" de Estilhaço", 10, "Grama", 3);
        System.out.println("BEM-VINDOS AO DUELO. APRESENTAMOS OS CAMPEÕES: ");
        System.out.println("");
        p1.status();
        p2.status();
        p3.status();
        p4.status();
        p5.status();
        
        
        

        String nome;
        Jogador j1 = new Jogador(1, "nome", p1);
        System.out.print("Jogador 1, insira seu nome: ");
        nome = ler.nextLine();
        int opcao;
        System.out.print("Insira a opção do seu pokemon: ");
        //try
        opcao = Integer.parseInt(ler.nextLine());
        switch (opcao) {
            case 1:
                j1.setNome(nome);
                j1.setPokemon(p1);
                break;
            case 2:
                j1.setNome(nome);
                j1.setPokemon(p2);
                break;
            case 3:
                j1.setNome(nome);
                j1.setPokemon(p3);
                break;
            case 4:
                j1.setNome(nome);
                j1.setPokemon(p4);
                break;
            case 5:
                j1.setNome(nome);
                j1.setPokemon(p5);
                break;
        }
        j1.status();
        
        System.out.println("");
        
        Jogador j2 = new Jogador(2, "nome", p1);
        System.out.print("Jogador 2, insira seu nome: ");
        nome = ler.nextLine();
        System.out.print("Insira a opção do seu pokemon: ");
        //try
        opcao = Integer.parseInt(ler.nextLine());
        switch (opcao) {
            case 1:
                j2.setNome(nome);
                j2.setPokemon(p1);
                break;
            case 2:
                j2.setNome(nome);
                j2.setPokemon(p2);
                break;
            case 3:
                j2.setNome(nome);
                j2.setPokemon(p3);
                break;
            case 4:
                j2.setNome(nome);
                j2.setPokemon(p4);
                break;
            case 5:
                j2.setNome(nome);
                j2.setPokemon(p5);
                break;
        }
        j2.status();
        
        
        /**
         * Instanciamos o objeto batalha.
         * O método batalha() dará início ao jogo.
         * E por fim aplicamos o método booleano que validará o vencedor da batalha.
         */
        
        Batalha bat = new Batalha(j1, j2);
        bat.batalha();
        bat.verificaVitoria();
    }
    
}
