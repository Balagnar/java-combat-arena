import javafx.animation.PauseTransition;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.util.Duration;
import javafx.scene.image.Image;

public class ControllerArena {

    @FXML private TextArea logCombate;

    @FXML private Button btAtk;

    @FXML private ProgressBar barraHeroi;
    @FXML private ProgressBar barraSlime;

    @FXML private ImageView Heroi;
    @FXML private ImageView Inimigo;

    // Instância da lógica puxando a classe Arena
    private Arena combate = new Arena();

    // Instância que inicia uma "parada" de 1.5s
    PauseTransition pause = new PauseTransition(Duration.seconds(1.5));
    
    // Instância que pega o nome da pasta e o nome da imagem e transforma em um caminho
    private Image pegarImagem(String pasta, String nomeImagem){
        String caminho = "/assets/" + pasta + "/" + nomeImagem;
        return new Image (getClass().getResourceAsStream(caminho));
    }

    @FXML
    void Atacar() {
        // Toda aquela lógica que estava no Main agora vem pra cá
        String logEvento = combate.turnoDeAtaque();

        logCombate.appendText(logEvento + "\n");

        // Atualiza as barras (exemplo usando vida fixa de 20)
        barraHeroi.setProgress(combate.getVidaHeroi() / 20.0);
        barraSlime.setProgress(combate.getVidaSlime() / 20.0);

        if (btAtk.getText().equals("Reiniciar")){

            combate = new Arena();

            barraHeroi.setProgress(combate.getVidaHeroi() / 20.0);
            barraSlime.setProgress(combate.getVidaSlime() / 20.0);

            Inimigo.setImage(pegarImagem("Creature", "slime.png"));
            Heroi.setImage(pegarImagem("Body", "swordman.png"));

            btAtk.setText("Atacar");

            return;
        }

        // Verifica fim de jogo
        if (combate.getVidaSlime() <= 0) {
            Inimigo.setImage(pegarImagem("Liquid", "spill.png"));
            logCombate.appendText("O COMBATE TERMINOU!\n");
            btAtk.setText("Reiniciar");

        } else if (combate.getVidaHeroi() <= 0){

            Heroi.setImage(pegarImagem("Body", "skeleton.png"));

            pause.setOnFinished(event -> {
                Heroi.setImage(pegarImagem("Death","tombstone.png"));
            });

            pause.play();

            logCombate.appendText("O COMBATE TERMINOU!\n");

            btAtk.setText("Reiniciar");
        }
    }
}