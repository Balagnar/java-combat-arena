//importação essecial do javafx
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

//classe usa extensões da Aplication
public class Main extends Application{

    //Cria uma classe arena e @Override informa que os comandos de inicialização serão esses
    Arena combate = new Arena();
    @Override

    //inicia o Stage e tudo oque tem dentro dele
    public void start(Stage palco){

        Image imgHeroi = new Image(getClass().getResourceAsStream("/assets/Soldier/Soldier.png"));

        ImageView visuHeroi = new ImageView(imgHeroi);

        int[] hpSlimeAtual = {20};

        //Criação de Labels
        Label Titulo = new Label("-----Arena-----");
        Label HPGuerreiro = new Label(combate.getNomeHeroi() + "HP: " + combate.getVidaHeroi());
        Label HPSlime = new Label(combate.getNomeSlime() + "HP: " + combate.getVidaSlime());

        //Criação de botão "atacar slime"
        Button btAtk = new Button("Atacar Slime");

        //Atribuição de lógica para funcionamento do botão de "atacar slime"
        btAtk.setOnAction(e -> {
           combate.turnoDeAtaque();
           HPSlime.setText("Slime HP: " + combate.getVidaSlime());
           HPGuerreiro.setText("Guerreiro HP: " + combate.getVidaHeroi());

           if (combate.getVidaSlime() <= 0) {
                HPSlime.setText(combate.getNomeSlime() + " Foi derrotado");
                btAtk.setDisable(true);
           } else if (combate.getVidaHeroi() <= 0){
                HPGuerreiro.setText(combate.getNomeHeroi() + " Foi derrotado");
                btAtk.setDisable(true);
           }
        });

        //Vbox organiza os itens como Labels a esquerda
        VBox layout = new VBox(10); //espaçamento
        visuHeroi.setFitHeight(200);
        visuHeroi.setPreserveRatio(true);
        layout.setAlignment(Pos.CENTER); //alinhamento na posição centro
        layout.getChildren().addAll(Titulo, visuHeroi, HPGuerreiro, HPSlime, btAtk); //posicionamento dos itens filhos

        //cria a janela com essas dimenções
        Scene cenario = new Scene(layout, 300,400);

        //executa os itens na ordem que forma informados
        palco.setScene(cenario); //executa o "cenario"
        palco.setTitle("Arena V0.5.0"); //executa o titulo da janela
        palco.show(); //executa o "show"
    }

    //inicia a instancia da janela
    public static void main(String[] args) {
        launch(args);
    }
    
}
