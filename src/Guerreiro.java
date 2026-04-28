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

    public String tomarDano(int danoInimigo){

        Random rngDodge = new Random();

          if(rngDodge.nextInt(10) >= 8){
            return this.nome + " Desviou do ataque\n";
        } else {
            this.vida -= danoInimigo;
            return this.nome + " Não desviou\n";
        }

    }

    //classe para dar dano
    public String darDano(Inimigo slime){
        if (new Random().nextInt(10) >= 5) {

            // PRIMEIRO: Tira a vida
            slime.setVida(slime.getVida() - this.dano); 
        
            // SEGUNDO: Cria o texto com a vida já menor
            return this.nome + " acertou! " + slime.getNome() + " agora tem " + slime.getVida() + " HP.";
            
        }

        return this.nome + " errou o ataque!";
    }
}

