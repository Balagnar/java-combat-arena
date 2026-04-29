public class Slime extends Inimigo {

    boolean dividirId = false;

    public Slime(){
        super ("Slime", 40, 10, 100);
    }

    public String Dividir(){

        if(this.vida <= 0 && dividirId == false){
            
            this.vida = this.vidaMax / 2;
            this.dano = this.dano / 2;
            
            dividirId = true;

            return "\nO" + this.nome + " se dividiu em 2 com: " + this.vida + " de HP. \n";

        }
    
        return "";
    }

}
