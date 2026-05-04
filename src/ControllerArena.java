import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.animation.PauseTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.util.Duration;
import javafx.scene.image.Image;

public class ControllerArena implements Initializable {

    @FXML private TextArea logCombate;

    @FXML private Button btAtk;

    @FXML private ProgressBar barraGuerreiro;
    @FXML private ProgressBar barraInimigo;

    @FXML private ImageView Guerreiro;
    @FXML private ImageView Inimigo;

    @FXML
    private Pane Inventario; 

    @FXML
    private HBox containerItens; 

    private Arena combate = new Arena();

    PauseTransition pause = new PauseTransition(Duration.seconds(1.5));
    
    private Image pegarImagem(String pasta, String nomeImagem){
        String caminho = "/assets/" + pasta + "/" + nomeImagem;
        return new Image (getClass().getResourceAsStream(caminho));
    }

    private ArrayList<Itens> mochila = new ArrayList<>();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    mochila.add(new Itens("Poção de Vida"));
    mochila.add(new Itens("Bomba Caseira"));
    
    Inventario.setVisible(false);
    Inventario.setMouseTransparent(true); // Começa transparente para o mouse
}

    @FXML
    void Atacar() {
        if (btAtk.getText().equals("Reiniciar")) {
            combate = new Arena();
            barraGuerreiro.setProgress(1.0); 
            barraInimigo.setProgress(1.0);
            logCombate.clear(); 
        
            Guerreiro.setImage(pegarImagem("Body", "swordman.png"));
            
            if (combate.getInimigo() instanceof Esqueleto) {
                Inimigo.setImage(pegarImagem("Creature", "skeleton.png"));
            } else {
                Inimigo.setImage(pegarImagem("Creature", "slime.png"));
            }

            btAtk.setText("Atacar");
            return; 
        }

        if (combate.getInimigo() instanceof Esqueleto) {
            Inimigo.setImage(pegarImagem("Creature", "skeleton.png"));
        } else {
            Inimigo.setImage(pegarImagem("Creature", "slime.png"));
        }

        String logEventos = combate.turnoDeAtaque();
        logCombate.appendText(logEventos + "\n");

        barraGuerreiro.setProgress((combate.getVidaHeroi() / (double) combate.getVidaMaxHeroi()));
        barraInimigo.setProgress((combate.getVidaInimigo() / (double) combate.getVidaMaxInimigo()));

        if (combate.getInimigo() instanceof Esqueleto && combate.getVidaInimigo() <= 0) {
            if (!((Esqueleto) combate.getInimigo()).remontouID) { 
                executarAnimacaoRemontar();
                return; 
            }
        }

        if (combate.getVidaInimigo() <= 0) {
            if (combate.getInimigo() instanceof Esqueleto) {
                Inimigo.setImage(pegarImagem("Death", "carrion.png"));
            } else {
                Inimigo.setImage(pegarImagem("Liquid", "spill.png"));
            }
            logCombate.appendText("VITÓRIA! O inimigo caiu.\n");
            btAtk.setText("Reiniciar");

        } else if (combate.getVidaHeroi() <= 0) {
            Guerreiro.setImage(pegarImagem("Death", "tombstone.png"));
            btAtk.setText("Reiniciar");
        }
    }

    @FXML
    void Itens() {
        Inventario.setVisible(true);
        Inventario.setMouseTransparent(false); // Ativa o clique no inventário
        containerItens.getChildren().clear();

        for (int i = 0; i < mochila.size(); i++) {
            Itens itemAtual = mochila.get(i);
            Button botaoNovo = new Button(itemAtual.getNome());
            botaoNovo.setMinWidth(80);

            botaoNovo.setOnAction(e -> {
                // LÓGICA DE USO:
                if (itemAtual.getNome().equals("Poção de Vida")) {
                    itemAtual.usarPocao(combate.getGuerreiro());
                } else if (itemAtual.getNome().equals("Bomba Caseira")) {
                    itemAtual.usarBomba(combate.getInimigo());
                }

                logCombate.appendText("Você usou: " + itemAtual.getNome() + "\n");

                // REMOVE E FECHA
                mochila.remove(itemAtual);
                Inventario.setVisible(false);
                Inventario.setMouseTransparent(true); // LIBERA o clique para o botão Atacar

                // ATUALIZA AS BARRAS NA TELA
                barraGuerreiro.setProgress(combate.getVidaHeroi() / (double) combate.getVidaMaxHeroi());
                barraInimigo.setProgress(combate.getVidaInimigo() / (double) combate.getVidaMaxInimigo());
            });

            containerItens.getChildren().add(botaoNovo);
        }
    }

    private void executarAnimacaoRemontar() {
        Inimigo.setImage(pegarImagem("Death", "carrion.png")); 
        btAtk.setDisable(true); 

        PauseTransition delay = new PauseTransition(Duration.seconds(1.0));
        delay.setOnFinished(e -> {
            String msg = ((Esqueleto) combate.getInimigo()).remontar();
            logCombate.appendText(msg + "\n");

            Inimigo.setImage(pegarImagem("Creature", "skeleton.png"));
            barraInimigo.setProgress(combate.getVidaInimigo() / (double) combate.getVidaMaxInimigo());
            btAtk.setDisable(false);
        });
        
        delay.play();
    }
}