import java.util.Random;

public class Arena {
    
    public static final String VERSION = "0.6.1-Alpha"; 

    //Variaveis de instância
    private Guerreiro heroi;
    private Inimigo inimigo;

    //Metodo para criar os objetos
    public Arena() {
        this.heroi = new Guerreiro("Heroi", 100, 20, 100, 10);
        
        int spawn = new Random().nextInt(2);

        if (spawn == 0){
            this.inimigo = new Esqueleto();
        } else if (spawn == 1){
            this.inimigo = new Slime();
        }
    }

    //Metodo responsavel pela logica do ataque
    public String turnoDeAtaque() {
        String log = "";

        // 1. Herói ataca
        if (heroi.getVida() > 0) {
            log += heroi.darDano(inimigo).trim(); // .trim() remove espaços/enters extras
        } else {
            log += "\n" + heroi.getNome() + " foi derrotado!";
        }

        // Instancia que revive o esqueleto
        if(this.inimigo instanceof Esqueleto esqueleto){

            log += esqueleto.remontou();
            System.out.println(esqueleto.remontou());

        }

        // 2. Slime contra-ataca (se estiver vivo)
        if (inimigo.getVida() > 0) {
            log += "\n" + inimigo.darDano(heroi).trim(); 
        } else {
            log += "\n" + inimigo.getNome() + " foi derrotado!";
        }

        return log + "\n"; // Garante que o PRÓXIMO turno comece em nova linha
    }

//-------------------------------------CAMPO PARA DECLARAR GETs e SETs--------------------------------------//
    
    //Metodos para o MainApp saber os dados dessas variaveis já que são privadas
    public int getVidaHeroi() {
        return heroi.getVida();
    }

    public int getVidaInimigo() {
        return inimigo.getVida();
    }

    public String getNomeHeroi() {
        return heroi.getNome();
    }

    public String getNomeInimigo() {
        return inimigo.getNome();
    }

    public int getDanoHeroi() {
        return heroi.getDano();
    }

    public int getDanoInimigo() {
        return inimigo.getDano();
    }

    public int getVidaMaxHeroi() {
        return heroi.getVidaMax();
    }

    public int getVidaMaxInimigo() {
        return inimigo.getVidaMax();
    }

    public Inimigo getInimigo(){
        return this.inimigo;
    }

}