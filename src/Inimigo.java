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

    public String spawn(Inimigo slime){

        Random spawn = new Random();

        boolean spawnou = false;

        while (!spawnou){

            if(spawn.nextInt(10) > 5){
                
                spawnou = true;
                
            } else {
                return "Cuidado, algo se mexeu em um arbusto proximo\n";
            }
        }
        
        return "Inimigo " + this.nome + " apareceu!\n";
    }

    //Class que faz o inimigo atacar o guerreiro
    public String darDano(Guerreiro heroi){
        Random gerador = new Random();

        if(gerador.nextInt(10) >= 5){
            String logEvento = this.nome + " Atacou com: " + this.dano + "\n";
            heroi.tomarDano(this.dano);
            logEvento +=  heroi.getNome() + " ficou com: " + heroi.getVida() + "\n";
            return logEvento;

        } else {
            
            return this.nome + " Errou o ataque sozinho!";
        }

    }

}
