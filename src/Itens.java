public class Itens {

    private String nome;
    private int pCura = 10;
    private int Bomba = -10;

    public String usarPocao(Guerreiro guerreiro){

        if(guerreiro.getVida() >= guerreiro.getVidaMax()){

            guerreiro.setVida(guerreiro.getVida() + pCura);
        }
        return "";
    }

    public String usarBomba(Inimigo inimigo){

        inimigo.setVida(inimigo.getVida() + Bomba);
        
        return "";
    }


    public Itens(String nome){
        this.nome = nome;
    }

    public String getNome(){
        return nome;
    }
}
