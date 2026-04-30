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

    @FXML private ProgressBar barraGuerreiro;
    @FXML private ProgressBar barraInimigo;

    @FXML private ImageView Guerreiro;
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
        // PARTE 1: Lógica de Reiniciar
        if (btAtk.getText().equals("Reiniciar")) {
            combate = new Arena();
        
            // Reset visual
            barraGuerreiro.setProgress(1.0); // 1.0 é 100%
            barraInimigo.setProgress(1.0);
            logCombate.clear(); // Limpa o log para a nova luta
        
            Guerreiro.setImage(pegarImagem("Body", "swordman.png"));
            
            if (combate.getInimigo() instanceof Esqueleto) {
                Inimigo.setImage(pegarImagem("Creature", "skeleton.png"));
            } else {
                Inimigo.setImage(pegarImagem("Creature", "slime.png"));
            }

            btAtk.setText("Atacar");
            return; // Sai do método aqui para não atacar no mesmo clique
        }

        // PARTE 2: Lógica de Atacar (só roda se o botão NÃO for Reiniciar)
        
        // Atualiza imagem do inimigo (revelação)
        if (combate.getInimigo() instanceof Esqueleto) {
            Inimigo.setImage(pegarImagem("Creature", "skeleton.png"));
        } else {
            Inimigo.setImage(pegarImagem("Creature", "slime.png"));
        }

        String logEventos = combate.turnoDeAtaque();
        logCombate.appendText(logEventos + "\n");

        // Atualiza barras
        barraGuerreiro.setProgress((combate.getVidaHeroi() / (double) combate.getVidaMaxHeroi()));
        barraInimigo.setProgress((combate.getVidaInimigo() / (double) combate.getVidaMaxInimigo()));

        // --- LOGICA DE ANIMAÇÃO E FIM DE JOGO ---
    
        // 1. Verifica se o esqueleto caiu e precisa remontar
        if (combate.getInimigo() instanceof Esqueleto && combate.getVidaInimigo() <= 0) {
            // Se o remontouID ainda for falso lá na classe Esqueleto, ele vai animar
            // Usamos uma verificação extra para garantir que ele não anime na morte definitiva
            if (!((Esqueleto) combate.getInimigo()).remontouID) { 
                executarAnimacaoRemontar();
                return; // SAI DO MÉTODO: Não deixa o botão virar "Reiniciar" ainda
            }
        }

        // 2. Se chegou aqui e a vida é 0, é morte definitiva
        if (combate.getVidaInimigo() <= 0) {
            if (combate.getInimigo() instanceof Esqueleto) {
                Inimigo.setImage(pegarImagem("Death", "carrion.png"));
            } else {
                Inimigo.setImage(pegarImagem("Liquid", "spill.png"));
            }
            logCombate.appendText("VITÓRIA! O inimigo caiu.\n");
            btAtk.setText("Reiniciar");

        } else if (combate.getVidaHeroi() <= 0) {
            // ... (sua lógica de derrota com a lápide)
            btAtk.setText("Reiniciar");
        }

    }

    private void executarAnimacaoRemontar() {
    // 1. O esqueleto cai (vira ossos)
    Inimigo.setImage(pegarImagem("Death", "carrion.png")); // use o nome real do seu arquivo
    btAtk.setDisable(true); // Evita cliques extras durante a animação

    PauseTransition delay = new PauseTransition(Duration.seconds(1.0));
    delay.setOnFinished(e -> {
        // 2. Executa a cura lógica na classe Esqueleto
        String msg = ((Esqueleto) combate.getInimigo()).remontar();
        logCombate.appendText(msg + "\n");

        // 3. Volta a imagem do esqueleto vivo e libera o botão
        Inimigo.setImage(pegarImagem("Creature", "skeleton.png"));
        barraInimigo.setProgress(combate.getVidaInimigo() / (double) combate.getVidaMaxInimigo());
        btAtk.setDisable(false);
    });
    
    delay.play();
}
}