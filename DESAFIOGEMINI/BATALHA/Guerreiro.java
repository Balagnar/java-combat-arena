package BATALHA;

import java.util.Random;

public class Guerreiro{

    private String nome;
    private int vida;
    private int dano;


    public Guerreiro(String nome, int vida, int dano){
        this.nome = nome;
        this.vida = vida;
        this.dano = dano;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public String getNome(){
        return this.nome;
    }

    public void setVida(int vida){
        this.vida = vida;
    }

    public int getVida(){
        return this.vida;
    }

    public void setDano(int dano){
        this.dano = dano;
    }

    public int getDano(){
        return this.dano;
    }

    public void tomarDano(int danoInimigo){

        Random rngDodge = new Random();

          if(rngDodge.nextInt(10) >= 8){
            System.out.println("Guerreiro: " + this.nome + " Desviou do ataque");
        } else {
            this.vida -= danoInimigo;
            System.out.println("Guerreiro: " + this.nome + " Não desviou");
        }

    }

    //classe para dar dano
    public void darDano(Inimigo slime){

        Random gerador = new Random();

        if (gerador.nextInt(10) >= 5) {

            int novaVida = slime.getVida() - this.dano; //"novaVida" recebe o valor da vida atual - dano
            slime.setVida(novaVida); //"nova vida" seta valor na vida do alvo.
            System.out.println("Guerreiro" + " " + this.nome + " atacou o " + slime.getNome() + "com: " + this.dano + " de dano");
            System.out.println("Inimigo: " + slime.getNome() + " tomou dano, vida atual: " + slime.getVida() + " de vida:");
  
            
        } else {
            System.out.println("Guerreiro: " + this.nome + " Errou o ataque!");
        }

        
        
    }
}

