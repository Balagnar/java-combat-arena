package BATALHA;

public class Arena {

    //Indicador de versão
    public static final String VERSION = "0.5.0-Alpha";

    //Variaveis de instância
    private Guerreiro heroi;
    private Inimigo slime;

    //Metodo para criar os objetos
    public Arena() {
        this.heroi = new Guerreiro("Heroi", 20, 10);
        this.slime = new Inimigo("Slime", 20, 10);
        this.slime.spawn(this.slime);
    }

    //Metodo responsavel pela logica do ataque
    public void turnoDeAtaque() {
        if (heroi.getVida() > 0 && slime.getVida() > 0) {
            heroi.darDano(slime);
            
            // O ataque do slime deve estar dentro do IF de vida
            if (slime.getVida() > 0) {
                slime.darDano(heroi);
            }
        }
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