package ControlesTelas;

import java.io.File;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import JDBC.Item;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;

public class ControleInformacoesItem implements Initializable{

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
	    private TextField txtMarca;

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
	    private RadioButton rbInativo;

	    @FXML
	    private ToggleGroup estado;

	    @FXML
	    private RadioButton rbAtivo;
	    
	    @FXML
	    private ImageView imgFotoItem;
	    
	    @FXML
	    private Button btCadastrar;

	    @FXML
	    private Button btSalvar;
	    
	    
	    private String caminhoFoto;
	    
	@FXML
    void onClickCadastrarItem(ActionEvent event) {
    }

    @FXML
    void onClickSalvar(ActionEvent event) {

    }
    
    @Override
	public void initialize(URL url, ResourceBundle rb) {	
    	imgFotoItem.setOnMouseClicked(MouseEvent ->{
    		selecionaFoto();
    	});
    }
    
	 private void cadastrarItem() {
		 String descricao_item = txtDescricao.getText(), marca_item = txtMarca.getText(),fornecedor_item = txtFornecedor.getText();
	     String local_item = txtLocal.getText(), referencia_marca_item = txtReferencia.getText(), estadoItem = estado.getSelectedToggle().toString(); 
	     int estoque_min_item = Integer.parseInt(txtEstMin.getText()), estoque_max_item = Integer.parseInt(txtEstMax.getText());
				//não adicionei marca por conta do checkbox
		 int quantidadeAtual = Integer.parseInt(txtQuantAtual.getText());
		 int estMin = Integer.parseInt(txtEstMin.getText());
		 int estMax = Integer.parseInt(txtEstMin.getText());
		/* int cod = Integer.parseInt(txtCodigo.getText());*/
		 /*não adicionei estado do item por dúvida em checkbox
		 não adicionei data de entrada por dúvida de como converter
		 não adicionei o local
		 */
		/* confirmação de cadastro(ainda não está funcionando)
		Alert alerta = new Alert(Alert.AlertType.CONFIRMATION);
		alerta.setHeaderText("Efetuado o cadastro com sucesso.");
		ButtonType btnOk = ButtonType.OK;
		alerta.getButtonTypes().setAll(btnOk);*/
		
	 }
	 
	 public void selecionaFoto() {
		 //abre aba para selecionar foto
		 FileChooser f = new FileChooser();//método do javafx
		 f.getExtensionFilters().add(new ExtensionFilter("Imagens", "*.jpg", "*.jpeg", "*.png"));//filtro para apenas escolher imagens
		 File file = f.showOpenDialog(new Stage());//método para escolher um arquivo
		 if(file!=null) {
		 	imgFotoItem.setImage(new Image("file:///" + file.getAbsolutePath()));
		 	caminhoFoto = file.getAbsolutePath();
		 }

	 }
	 
	
}


