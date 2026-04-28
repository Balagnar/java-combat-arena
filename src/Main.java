import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

//https://game-icons.net/ - para pegar assets

public class Main extends Application {

    @Override
    public void start(Stage palco) {
        try {
            // O FXMLLoader lê o arquivo FXML e já cria o ControllerArena por baixo dos panos
            Parent root = FXMLLoader.load(getClass().getResource("Layout.fxml"));
            
            Scene cenario = new Scene(root);
            
            palco.setTitle("Java Combat Arena - FXML Version");
            palco.setScene(cenario);
            palco.show();
        } catch (Exception e) {
            System.err.println("Erro ao carregar o layout: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}