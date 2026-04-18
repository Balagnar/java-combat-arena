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

    //Class que spawna inimigo

    public void spawn(Inimigo slime){

        Random spawn = new Random();

        boolean spawnou = false;

        while (!spawnou){


            if(spawn.nextInt(10) > 5){

                System.out.println("Inimigo " + this.nome + " apareceu!");
                spawnou = true;

            } else {
                System.out.println("Cuidado, algo se mexeu em um arbusto proximo");
            }
        }

    }

    //Class que faz o inimigo atacar o guerreiro
    public void darDano(Guerreiro heroi){
        Random gerador = new Random();

        if(gerador.nextInt(10) >= 5){
            System.out.println("Inimigo " + this.nome + " Atacou com: " + this.dano);
            heroi.tomarDano(this.dano);
            System.out.println("Heroi: " + heroi.getNome() + " ficou com: " + heroi.getVida() );

        } else {
            
            System.out.println("Inimigo: " + this.nome + " Errou o ataque sozinho!");
        }

    }

}
