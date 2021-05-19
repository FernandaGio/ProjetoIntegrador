package ControlesTelas;

import java.util.Optional;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class ControleInformacoesItem {

    @FXML
    private Label lblDescricao;

    @FXML
    private Label lblClassificacao;

    @FXML
    private Label lblFornecedor;

    @FXML
    private Label lblMarca;

    @FXML
    private Label lblQuantAtual;

    @FXML
    private Label lblEstMin;

    @FXML
    private Label txtEstadoItem;

    @FXML
    private Label lblLocal;

    @FXML
    private TextField txtDescricao;

    @FXML
    private TextField txtClassificacao;

    @FXML
    private ComboBox<?> cbClassificacao;

    @FXML
    private TextField txtFornecedor;

    @FXML
    private ComboBox<?> cbFornecedor;

    @FXML
    private ComboBox<?> cbMarca;

    @FXML
    private TextField txtQuantAtual;

    @FXML
    private TextField txtEstMin;

    @FXML
    private Label lblEstMax;

    @FXML
    private Label lblDataEntrada;

    @FXML
    private Label lblCodigo;

    @FXML
    private TextField txtEstMax;

    @FXML
    private TextField txtCodigo;

    @FXML
    private TextField txtLocal;

    @FXML
    private DatePicker dpDataEntrada;

    @FXML
    private CheckBox checkbAtivo;

    @FXML
    private CheckBox checkbInativo;

    @FXML
    private Button btCadastrar;

    @FXML
    private Button btSalvar;

    @FXML
    void onClickCadastrarItem(ActionEvent event) {

    }

    @FXML
    void onClickSalvar(ActionEvent event) {

    }
   
	    public boolean onCloseQuery() {
	    	Alert alerta = new Alert(Alert.AlertType.CONFIRMATION);
	    	alerta.setTitle("Atenção");
	    	alerta.setHeaderText("Deseja sair do sistema?");
	    	ButtonType btnNao = ButtonType.NO;
	    	ButtonType btnSim = ButtonType.YES;
	    	//lista de botões
	    	alerta.getButtonTypes().setAll(btnNao, btnSim);
	    	Optional<ButtonType> opcaoEscolhida = alerta.showAndWait();
	    	
	    	return opcaoEscolhida.get() == btnSim ? true : false;    		
	    }


	}


