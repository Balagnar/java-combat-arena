import java.util.Random;

public class Guerreiro{

    private String nome;
    private int vida;
    private int vidaMax;
    private int dano;
    private int defesa;
    private int danoReal;

    public Guerreiro(String nome, int vida, int dano, int vidaMax, int defesa){
        this.nome = nome;
        this.vida = vida;
        this.dano = dano;
        this.vidaMax = vidaMax;
        this.defesa = defesa;
    }

    public String tomarDano(Inimigo slime) {
        int dado = new Random().nextInt(10); // Joga o dado uma vez só

        if (dado >= 8) {
            return this.nome + " Desviou do ataque!\n";
        } 
    
        if (dado >= 5) {
            this.danoReal = slime.getDano() - this.defesa;
            if (this.danoReal < 0) this.danoReal = 0;
        
            this.vida -= this.danoReal;
            return this.nome + " defendeu! Tomou apenas " + this.danoReal + " de dano.";
        }

        // Se chegou aqui, é porque o dado foi menor que 5
        this.vida -= slime.getDano();
    return this.nome + " não se defendeu e tomou " + slime.getDano() + " de dano cheio!";
}

    //classe para dar dano
    public String darDano(Inimigo slime){
        if (new Random().nextInt(10) >= 5) {

            // PRIMEIRO: Tira a vida
            slime.setVida(slime.getVida() - this.dano); 
        
            // SEGUNDO: Cria o texto com a vida já menor
            return this.nome + " acertou! " + slime.getNome() + " agora tem " + slime.getVida() + " HP.\n";
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

    public void getDefesa(int defesa){
        this.defesa = defesa;
    }

    public int getDefesa(){
        return this.defesa;
    }


}

