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

        Random gerador = new Random();

        if (gerador.nextInt(10) >= 5) {

            int novaVida = slime.getVida() - this.dano; //"novaVida" recebe o valor da vida atual - dano
            slime.setVida(novaVida); //"nova vida" seta valor na vida do alvo.
            String logEvento =  this.nome + " atacou o " + slime.getNome() + " com: " + this.dano + " de dano!\n"; //variavel para salvar o log de eventos
            logEvento += slime.getNome() + " agora tem " + slime.getVida() + " de HP!\n";
            return logEvento;

        } else {
            return this.nome + " errou o ataque!\n";
        }

        
        
    }
}

