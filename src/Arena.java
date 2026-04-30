import java.util.Random;

public class Arena {
    
    public static final String VERSION = "0.6.1-Alpha"; 

    //Variaveis de instância
    private Guerreiro guerreiro;
    private Inimigo inimigo;

    //Metodo para criar os objetos
    public Arena() {
        this.guerreiro = new Guerreiro("Heroi", 100, 20, 100, 10);
        
        int spawn = new Random().nextInt(11);

        if (spawn <= 5){
            this.inimigo = new Esqueleto();
        } else {
            this.inimigo = new Slime();
        }
    }
    

    //Metodo responsavel pela logica do ataque
    public String turnoDeAtaque() {

        StringBuilder logEventos = new StringBuilder();

        // Se qualquer um dos personagens morrer mostrar a seguinte mensagem.
        if (guerreiro.getVida() <= 0) return "O " + guerreiro.getNome() + " caiu! \n";
        if (inimigo.getVida() <= 0 ) return "O " + inimigo.getNome() + " foi derrotado! \n";

        // 1. Guerreiro ataca 
        logEventos.append(guerreiro.darDano(inimigo));
        logEventos.append("\n");

        // 2. Se o inimigo for o esqueleto e tem a vida maior ou = a 0:
        if (inimigo instanceof Esqueleto && inimigo.getVida() <= 0) {
        
            // 3. Chama a habilidade do esqueleto de remontar.
            
            logEventos.append(((Esqueleto) inimigo).remontar()); 
            logEventos.append("\n");
        }

        // 4. Inimigo ataca
        if(inimigo.getVida() > 0){
            logEventos.append(guerreiro.tomarDano(inimigo));

        } 
        
        return logEventos.toString();
        
    }  

    //-------------------------------------CAMPO PARA DECLARAR GETs e SETs--------------------------------------//
    
    //Metodos para o Main saber os dados dessas variaveis já que são privadas
    public int getVidaHeroi() {
        return guerreiro.getVida();
    }

    public int getVidaInimigo() {
        return inimigo.getVida();
    }

    public String getNomeHeroi() {
        return guerreiro.getNome();
    }

    public String getNomeInimigo() {
        return inimigo.getNome();
    }

    public int getDanoHeroi() {
        return guerreiro.getDano();
    }

    public int getDanoInimigo() {
        return inimigo.getDano();
    }

    public int getVidaMaxHeroi() {
        return guerreiro.getVidaMax();
    }

    public int getVidaMaxInimigo() {
        return inimigo.getVidaMax();
    }

    public Inimigo getInimigo(){
        return this.inimigo;
    }

}