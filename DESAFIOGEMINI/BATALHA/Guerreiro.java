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

    //classe para dar dano
    public void darDano(Inimigo slime){

        Random gerador = new Random();

        if (gerador.nextInt(10) >= 5) {

            int novaVida = slime.getVida() - this.dano; //"novaVida" recebe o valor da vida atual - dano
            slime.setVida(novaVida); //"nova vida" seta valor na vida do alvo.
            System.out.println("Guerreiro" + " " + this.nome + " atacou o alvo com: " + this.dano + " de dano");
            System.out.println("Alvo: " + slime.getNome() + " tomou dano, vida atual: " + slime.getVida() + " de vida:");
  
            
        } else {
            System.out.println("Guerreiro: " + this.nome + " Errou o ataque!");
        }

        
        
    }
}

