package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainEstoque extends Application {
	
	private static Stage stage;
	
	
	@Override
	public void start(Stage stage) throws Exception {
		
		FXMLLoader root = new FXMLLoader (getClass().getResource("/Telas/EstoqueTela.fxml"));
		Parent telaEstoque = root.load();
			
		Scene telaEstoqueLayout = new Scene(telaEstoque);	
		telaEstoqueLayout.getStylesheets().add(getClass().getResource("/ArquivosCSS/applicationEstoque.css").toExternalForm());	
		stage.setScene(telaEstoqueLayout);	
		stage.setTitle("Sistema de Estoque - K3");
		stage.resizableProperty().setValue(Boolean.FALSE);
		stage.show();	
		setStage(stage);
			 
	}
	
	public static Stage getStage() {
		return stage;
	}
	
	public static void setStage(Stage stage) {
		MainEstoque.stage = stage;
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}

