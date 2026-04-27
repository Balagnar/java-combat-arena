import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextArea;

public class ControllerArena {

    // Instância da lógica (supondo que sua classe Arena ainda existe)
    private Arena combate = new Arena();

    @FXML
    private TextArea logCombate;

    @FXML
    private Button btAtk; // O fx:id do botão no Scene Builder

    @FXML
    private ProgressBar barraHeroi, barraSlime;

    @FXML
    void Atacar() {
        // Toda aquela lógica que estava no Main agora vem pra cá
        String logEvento = combate.turnoDeAtaque();

        logCombate.appendText(logEvento + "\n");

        // Atualiza as barras (exemplo usando vida fixa de 20)
        barraHeroi.setProgress(combate.getVidaHeroi() / 20.0);
        barraSlime.setProgress(combate.getVidaSlime() / 20.0);

        // Verifica fim de jogo
        if (combate.getVidaSlime() <= 0 || combate.getVidaHeroi() <= 0) {
            btAtk.setDisable(true);
            logCombate.appendText("O COMBATE TERMINOU!\n");
        }
    }
}