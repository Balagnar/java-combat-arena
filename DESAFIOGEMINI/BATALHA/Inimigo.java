package BATALHA;

import java.util.Random;

public class Inimigo {

    private String nome;
    private int vida;
    private int dano;

    public Inimigo(String nome, int vida, int dano){
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

    public void darDano(Guerreiro heroi){

        Random gerador = new Random();

        if(gerador.nextInt(10) >= 5){
            
            int novaVida = heroi.getVida() - this.dano;
            heroi.setVida(novaVida);
            System.out.println("Inimigo" + " " + this.nome + " atacou o alvo com: " + this.dano + " de dano");
            System.out.println("Alvo: " + heroi.getNome() + " tomou dano, vida atual: " + heroi.getVida() + " de vida:");

        } else {
            System.out.println("Inimigo: " + this.nome + " Errou o ataque!");
        }

    }

    

}
