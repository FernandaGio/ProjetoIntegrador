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
    private TextField txtDescricao;

    @FXML
    private Label lblFornecedor;

    @FXML
    private TextField txtFornecedor;

    @FXML
    private Label lblMarca;

    @FXML
    private Label lblQuantAtual;

    @FXML
    private TextField txtQuantAtual;

    @FXML
    private Label lblEstMin;

    @FXML
    private TextField txtEstMin;

    @FXML
    private TextField txtQuantAtual1;

    @FXML
    private Label lblCod;

    @FXML
    private TextField txtCod;

    @FXML
    private Label lblLocal;

    @FXML
    private TextField txtLocal;

    @FXML
    private Label lblEstMax;

    @FXML
    private TextField txtEstMax;

    @FXML
    private Label lblReferencia;

    @FXML
    private TextField txtReferencia;

    @FXML
    private DatePicker dpDataEntrada;

    @FXML
    private Label lblDataEntrada;

    @FXML
    private Label lblEstadoItem;

    @FXML
    private Label lblFoto;

    @FXML
    private ComboBox<?> cbFoto;

    @FXML
    void onClickCadastrarItem(ActionEvent event) {
    	cadastrarItem();
    }

    @FXML
    void onClickSalvar(ActionEvent event) {

    }
   
	    public boolean onCloseQuery() {
	    	Alert alerta = new Alert(Alert.AlertType.CONFIRMATION);
	    	alerta.setTitle("Aten��o");
	    	alerta.setHeaderText("Deseja sair do sistema?");
	    	ButtonType btnNao = ButtonType.NO;
	    	ButtonType btnSim = ButtonType.YES;
	    	//lista de bot�es
	    	alerta.getButtonTypes().setAll(btnNao, btnSim);
	    	Optional<ButtonType> opcaoEscolhida = alerta.showAndWait();
	    	
	    	return opcaoEscolhida.get() == btnSim ? true : false;    		
	    }

	    
	 private void cadastrarItem() {
		 /*String descricao = txtDescricao.getText(),
				classificacao = txtClassificacao.getText(),
				forncedor = txtFornecedor.getText();
				//n�o adicionei marca por conta do checkbox
		 int quantidadeAtual = Integer.parseInt(txtQuantAtual.getText());
		 int estMin = Integer.parseInt(txtEstMin.getText());
		 int estMax = Integer.parseInt(txtEstMin.getText());
		 int cod = Integer.parseInt(txtCodigo.getText());*/
		 /*n�o adicionei estado do item por d�vida em checkbox
		 n�o adicionei data de entrada por d�vida de como converter
		 n�o adicionei o local
		 */
		/* confirma��o de cadastro(ainda n�o est� funcionando)
		Alert alerta = new Alert(Alert.AlertType.CONFIRMATION);
		alerta.setHeaderText("Efetuado o cadastro com sucesso.");
		ButtonType btnOk = ButtonType.OK;
		alerta.getButtonTypes().setAll(btnOk);*/
					 
	 }

	}


