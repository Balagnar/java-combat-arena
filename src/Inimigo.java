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
    if(new Random().nextInt(10) >= 5){
        // PRIMEIRO: Tira a vida
        heroi.setVida(heroi.getVida() - this.dano); 
        
        // SEGUNDO: Cria o texto com a vida já menor
        return this.nome + " acertou! " + heroi.getNome() + " agora tem " + heroi.getVida() + " HP.";
    } 
    return this.nome + " errou o ataque!";
}

}
