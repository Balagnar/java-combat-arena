import java.util.Random;

public class Inimigo {

    protected String nome;
    protected int vida;
    protected int dano;
    protected int vidaMax;

    public Inimigo(String nome, int vida, int dano, int vidaMax){
        this.nome = nome;
        this.vida = vida;
        this.dano = dano;
        this.vidaMax = vidaMax;
    }

    //Class que faz o inimigo atacar o guerreiro
    public String darDano(Guerreiro heroi){
        if(new Random().nextInt(10) >= 5){
            // PRIMEIRO: Tira a vida
            String resultado = heroi.tomarDano(this);
        
            // SEGUNDO: Cria o texto com a vida já menor
            return resultado;
        } 
    
        return this.nome + " errou o ataque sozinho!";
    }

//-------------------------------------CAMPO PARA DECLARAR GETs e SETs--------------------------------------//
    
    public void setNome(String nome){
        this.nome = nome;
    }

    public String getNome(){
        return this.nome;
    }

    public void setVida(int vida){
        this.vida = Math.max(0, vida);
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

    public void setVidaMax(int vidaMax){
        this.vidaMax = vidaMax;
    }

    public int getVidaMax(){
        return this.vidaMax;
    }

}
