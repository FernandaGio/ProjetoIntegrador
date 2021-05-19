package application;

import ControlesTelas.ControleInformacoesItem;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class InformacoesItem extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			//carregando arquivo XML
			FXMLLoader root = new FXMLLoader (getClass().getResource("/Telas/InformacoesItemTela.fxml")); 
			Parent telaInformacoesItem = root.load();
			
			//criando uma cena 
			Scene telaLoginLayout = new Scene(telaInformacoesItem);
			telaLoginLayout.getStylesheets().add(getClass().getResource("applicationInformacoesItem.css").toExternalForm());//Estilização CSS
			Stage tela = new Stage();
			//primaryStage.setScene(telaLoginLayout);--abre como primeira tela
			//tela1.setMaximized(true);//abre a tela maximizada
			tela.setScene(telaLoginLayout);
			//primaryStage.show(); --executa a primeira tela
			//configuração de redimensão da tela(o usuário não pode alterar)
			tela.resizableProperty().setValue(Boolean.FALSE);
			tela.show();
			
			//carregando o controle da cena(Tela Login)
			 ControleInformacoesItem controleinformcoes = root.getController();
			 
			 tela.setOnCloseRequest(e->{
				 if (controleinformcoes.onCloseQuery()) {
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

