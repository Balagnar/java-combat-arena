public class Arena {
    
    public static final String VERSION = "0.6.1-Alpha"; 

    //Variaveis de instância
    private Guerreiro heroi;
    private Inimigo slime;

    //Metodo para criar os objetos
    public Arena() {
        this.heroi = new Guerreiro("Heroi", 20, 20);
        this.slime = new Inimigo("Slime", 200, 20);
        //this.slime.spawn(this.slime);
    }

    //Metodo responsavel pela logica do ataque
    public String turnoDeAtaque() {
        String log = "";

        // 1. Herói ataca
        if (heroi.getVida() > 0) {
            log += heroi.darDano(slime).trim(); // .trim() remove espaços/enters extras
        } else {
            log += "\n" + heroi.getNome() + " foi derrotado!";
        }

        // 2. Slime contra-ataca (se estiver vivo)
        if (slime.getVida() > 0) {
            log += "\n" + slime.darDano(heroi).trim(); 
        } else {
            log += "\n" + slime.getNome() + " foi derrotado!";
        }

        return log + "\n"; // Garante que o PRÓXIMO turno comece em nova linha
    }

    //Metodos para o MainApp saber os dados dessas variaveis já que são privadas
    public int getVidaHeroi() {
        return heroi.getVida();
    }

    public int getVidaSlime() {
        return slime.getVida();
    }

    public String getNomeHeroi() {
        return heroi.getNome();
    }

    public String getNomeSlime() {
        return slime.getNome();
    }
}