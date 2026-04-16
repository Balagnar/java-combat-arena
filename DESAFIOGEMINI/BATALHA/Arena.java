package BATALHA;

public class Arena {


    public static void main(String[] args) {
        
        Guerreiro heroi = new Guerreiro("Heroi", 100, 10);
        Guerreiro boss = new Guerreiro("Boss", 100, 10);

        while (heroi.getVida() > 0 && boss.getVida() > 0
         ) {
            heroi.darDano(boss);

            if (boss.getVida() > 0){
            boss.darDano(heroi);
            }
        } 
        
    }
    
}
