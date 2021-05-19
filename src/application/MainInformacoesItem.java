package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainInformacoesItem extends Application {
	
	private static Stage stage;
	
	
	@Override
	public void start(Stage stage) throws Exception {
		
		FXMLLoader root = new FXMLLoader (getClass().getResource("/Telas/InformacoesItemTela.fxml"));
		Parent telaInformacoesItem = root.load();
		
			
		Scene telaInformacoesItemLayout = new Scene(telaInformacoesItem);
			
		telaInformacoesItemLayout.getStylesheets().add(getClass().getResource("applicationInformacoesItem.css").toExternalForm());
			
		stage.setScene(telaInformacoesItemLayout);
			
		stage.show();
			
		setStage(stage);
			 
	}
	
	public static Stage getStage() {
		return stage;
	}
	
	public static void setStage(Stage stage) {
		MainInformacoesItem.stage = stage;
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
