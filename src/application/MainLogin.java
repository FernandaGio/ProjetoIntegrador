package application;
	
import ControlesTelas.ControleLogin;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class MainLogin extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			//carregando arquivo XML
			FXMLLoader root = new FXMLLoader (getClass().getResource("/Telas/LoginTela.fxml")); 
			Parent telaLogin = root.load();
			
			//criando uma cena 
			Scene telaLoginLayout = new Scene(telaLogin);
			telaLoginLayout.getStylesheets().add(getClass().getResource("/ArquivosCSS/applicationLogin.css").toExternalForm());//Estilização CSS
			Stage tela = new Stage();
			//primaryStage.setScene(telaLoginLayout);--abre como primeira tela
			//tela.setMaximized(true);//abre a tela maximizada
			tela.setScene(telaLoginLayout);
			tela.setTitle("Sistema de Estoque - K3");
			//primaryStage.show(); --executa a primeira tela
			tela.resizableProperty().setValue(Boolean.FALSE);//configuração de redimensão da tela(o usuário não pode alterar)
			tela.show();

			
			//carregando o controle da cena(Tela Login)
			 ControleLogin controlelogin = root.getController();
			 
			 tela.setOnCloseRequest(e->{
				 if (controlelogin.onCloseQuery()) {
					 System.exit(0);
				 }else {
					 e.consume();
				 }
			 });
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
