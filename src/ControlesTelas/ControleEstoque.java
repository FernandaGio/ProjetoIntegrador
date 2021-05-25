package ControlesTelas;

import application.MainInformacoesItem;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class ControleEstoque {

    @FXML
    private Button btnCadastroItem;

    @FXML
    void onClickbtnCadastrarItem(ActionEvent event) {
    	MainInformacoesItem m= new MainInformacoesItem();
		fecha();
		try {
			m.start(new Stage());
		}catch (Exception e1) {
			e1.printStackTrace();
		}
	};
	private void fecha() {
}

 }
