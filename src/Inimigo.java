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

     //metodo para dar dano
    public String darDano(Guerreiro guerreiro){
        
        //Joga o dado
        int dado = new Random().nextInt(10);

        //Variavel que recebe as informações de calculo de Dano
        String resultadoDano = calcDano(dado, guerreiro);

        // 1. Tenta acertar o dano
        if(resultadoDano != null){
            return resultadoDano;
        }
        // 2. Caso não acerte o dano
        return this.nome + " errou o ataque sozinho!";
    }


//-------------------------------------CAMPO PARA DECLARAR METODOS--------------------------------------//

    //Metodo de esquiva
    protected String esquiva(int dado){
        if (dado >= 9){
            return this.nome + "esquivou!";
        }
        return null;
    }

    //Metodo de ataque
    protected String calcDano(int dado, Guerreiro guerreiro){

        if (dado >= 5){
            int danoDado = Math.max(0, guerreiro.getVida() - this.dano);
            guerreiro.setVida(danoDado);

            return this.nome + " atacou! " + guerreiro.getNome() + " agora tem " + guerreiro.getVida() + "de HP. ";
        }
        return null;
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
