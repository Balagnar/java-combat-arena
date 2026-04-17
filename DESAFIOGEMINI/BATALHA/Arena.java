package BATALHA;

public class Arena {

    public static void main(String[] args) {
        
        Guerreiro heroi = new Guerreiro("Heroi", 20, 10);
        Inimigo slime = new Inimigo("Slime", 20, 10);

        slime.spawn(slime);

        while (heroi.getVida() > 0 && slime.getVida() > 0) {

            heroi.darDano(slime);

            if (slime.getVida() > 0){
                    heroi.tomarDano(0);
                    slime.darDano(heroi);
                }

        }

        if (heroi.getVida() == 0){

            System.out.println("O Guerreiro: " + heroi.getNome() + " Foi derrotado: ");
            System.out.println("O Inimigo: " + slime.getNome() + " Sobreviveu com: " + slime.getVida());


        } else {

            System.out.println("O Inimigo: " + slime.getNome() + " Foi derrotado: ");
            System.out.println("O Guerreiro: " + heroi.getNome() + " Sobreviveu com: " + heroi.getVida());
            
        }
        
    }
    
}
