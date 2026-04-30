import java.util.Random;

public class Guerreiro{

    private String nome;
    private int vida;
    private int vidaMax;
    private int dano;
    private int defesa;

    public Guerreiro(String nome, int vida, int dano, int vidaMax, int defesa){
        this.nome = nome;
        this.vida = vida;
        this.dano = dano;
        this.vidaMax = vidaMax;
        this.defesa = defesa;
    }

    public String tomarDano(Inimigo thisInimigo) {
        
        // Joga o dado
        int dado = new Random().nextInt(10);

        // Variavel que recebe as informações de esquiva(dado)
        String resultadoEsquiva = esquiva(dado);

        // 1. Tenta esquiva
        if (resultadoEsquiva != null){
            return resultadoEsquiva;
        }

        // 2. Se não parou na esquiva, chama a defesa e retorna o que ela decidir
        return defesa(thisInimigo, dado);
   
    }

    //metodo para dar dano
    public String darDano(Inimigo thisInimigo){
        
        //Joga o dado
        int dado = new Random().nextInt(10);

        //Variavel que recebe as informações de calculo de Dano
        String resultadoDano = calcDano(dado, thisInimigo);

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
        if (dado >= 8){
            return this.nome + " esquivou!";
        }
        return null;
    }

    //Metodo de defesa
    protected String defesa(Inimigo Inimigo, int dado){

        if (dado >= 5){
            int danoReduzido = Math.max(0, Inimigo.getDano() - this.defesa);
            this.setVida(this.getVida() - danoReduzido);
            return this.nome + " defendeu! Tomou apenas " + danoReduzido + " de dano.";
        }
        this.setVida(this.getVida() - Inimigo.getDano());
        return this.nome + " falhou na defesa e tomou " + Inimigo.getDano() + " de dano cheio!";    
    }

    //Metodo de ataque
    protected String calcDano(int dado, Inimigo Inimigo){

        if (dado >= 5){
            int danoDado = Math.max(0, Inimigo.getVida() - this.dano);
            Inimigo.setVida(danoDado);

            return this.nome + " atacou! " + Inimigo.getNome() + " agora tem " + Inimigo.getVida() + "de HP. ";
        }
        return null;
    }

//-------------------------------------CAMPO PARA DECLARAR GETTERS E SETTERS--------------------------------------//

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

