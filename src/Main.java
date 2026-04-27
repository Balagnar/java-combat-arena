import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.control.TextArea;

public class Main extends Application {

    // Atributos da interface e instância da lógica de combate
    private Arena combate = new Arena();
    private TextArea logCombate;
    private Label hpGuerreiro, hpSlime;
    private Button btAtk;
    private ImageView visuHeroi, visuSlime;
    private ProgressBar barraHeroi, barraSlime;

    @Override
    public void start(Stage palco) {
        configurarComponentes(); // Cria os textos, botões e imagens
        configurarAcoes();      // Define o que acontece no clique

        // Layout: Organiza o Herói (Texto + Imagem + Barra) verticalmente
        VBox boxHeroi = new VBox(5, hpGuerreiro, visuHeroi, barraHeroi);
        boxHeroi.setAlignment(Pos.CENTER);

        // Layout: Organiza o Slime verticalmente
        VBox boxSlime = new VBox(5, hpSlime, visuSlime, barraSlime);
        boxSlime.setAlignment(Pos.CENTER);

        // Arena: Coloca Herói e Slime lado a lado (Horizontal)
        HBox arena = new HBox(50, boxHeroi, boxSlime);
        arena.setAlignment(Pos.CENTER);

        // Estrutura Principal: Título + Arena + Botão de Ataque
        Label titulo = new Label("----- Arena -----");
        VBox chao = new VBox(30, titulo, arena, logCombate, btAtk);
        chao.setAlignment(Pos.CENTER);

        // Configuração da Janela (Cena)
        Scene cenario = new Scene(chao, 500, 500);
        palco.setScene(cenario);
        palco.setTitle("Arena V0.5.0");
        palco.show();
    }

    private void configurarComponentes() {
        // Carrega as imagens dos assets
        visuHeroi = criarSprite("/assets/Body/icons/000000/transparent/1x1/cathelineau/swordman.png", false);
        visuSlime = criarSprite("/assets/Creature/icons/000000/transparent/1x1/cathelineau/slime.png", true);

        // Inicializa textos e botões com dados da Arena
        hpGuerreiro = new Label(combate.getNomeHeroi() + " HP: " + combate.getVidaHeroi());
        hpSlime = new Label(combate.getNomeSlime() + " HP: " + combate.getVidaSlime());
        btAtk = new Button("Atacar: " + combate.getNomeSlime());

        // Configura as barras de progresso (1.0 = 100%)
        barraHeroi = new ProgressBar(1.0);
        barraHeroi.setPrefWidth(100);
        barraSlime = new ProgressBar(1.0);
        barraSlime.setPrefWidth(100);
    }

    private void configurarAcoes() {

        logCombate = new TextArea();
        logCombate.setEditable(false);
        logCombate.setPrefHeight(100);
        logCombate.setPrefWidth(200);
        logCombate.setWrapText(true);

        // Lógica ao clicar no botão "Atacar"
        btAtk.setOnAction(e -> {

            String logEvento = combate.turnoDeAtaque();

            // Atualiza os textos de HP na tela
            logCombate.appendText(logEvento + "\n");
            logCombate.setScrollTop(Double.MAX_VALUE);

            // 3. Atualiza os textos de HP e as barras para o jogador ver o impacto
            hpSlime.setText(combate.getNomeSlime() + " HP: " + combate.getVidaSlime());
            hpGuerreiro.setText(combate.getNomeHeroi() + " HP: " + combate.getVidaHeroi());

            // Atualiza as barras (Vida atual / Vida Máxima)
            barraHeroi.setProgress(combate.getVidaHeroi() / 20.0);
            barraSlime.setProgress(combate.getVidaSlime() / 20.0);

            // Verifica se alguém morreu para desativar o botão
            if (combate.getVidaSlime() <= 0 || combate.getVidaHeroi() <= 0) {
                btAtk.setDisable(true);
            }

        });
    }

    // Método auxiliar para carregar imagens e evitar repetição de código
    private ImageView criarSprite(String caminho, boolean inverter) {
        try {
            Image img = new Image(getClass().getResourceAsStream(caminho));
            ImageView view = new ImageView(img);
            view.setFitWidth(50);
            view.setPreserveRatio(true);
            if (inverter) view.setScaleX(-1); // Inverte o lado para o inimigo olhar para o herói
            return view;
        } catch (Exception e) {
            return new ImageView(); // Retorna vazio caso a imagem não exista
        }
    }

    public static void main(String[] args) {
        launch(args); // Inicia a aplicação JavaFX
    }
}