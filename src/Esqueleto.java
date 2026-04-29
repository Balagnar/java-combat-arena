public class Esqueleto extends Inimigo {

    boolean remontouID = false;

    public Esqueleto(){
        super("Esqueleto", 50, 15, 100);
    }

    public String remontou(){
            
        if (this.vida <= 0 && remontouID == false){

            this.vida = this.vidaMax / 2;

            remontouID = true;
            
            return "\nO " + this.nome + " se remontou com: " + this.vida + " de HP. \n";

        }
            
        return "";
    }
}
