package ControlesTelas;

import java.io.File;
import java.net.URL;
import java.util.Date;
import java.util.Optional;
import java.util.ResourceBundle;

import JDBC.Item;
import JDBC.ItemDAO;
import JDBC.ItemDAOJDBC;
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
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;

public class ControleAlterarItem implements Initializable{

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
	    
	    private static Item item2;

    
    public static Item getItem2() {
		return item2;
	}

	public static void setItem2(Item item1) {
		ControleAlterarItem.item2 = item1;
	}

    @FXML
    void onClickSalvar(ActionEvent event) {
    	atualizar();
    }
    
   public void atualizar() {
    	ItemDAO dao = new ItemDAOJDBC();
    	String descricao = txtDescricao.getText(),marca = txtMarca.getText(),fornecedor = txtFornecedor.getText(), local = txtLocal.getText(), referencia = txtReferencia.getText(), estadoItem = estado.getSelectedToggle().toString(); 
    	int quant_atual = Integer.parseInt(txtQuantAtual.getText()), estMin = Integer.parseInt(txtEstMin.getText()), estMax = Integer.parseInt(txtEstMax.getText());
    	Date data = (Date) dpDataEntrada.getDayCellFactory();
    	
    	Item i = new Item(descricao,fornecedor,marca,quant_atual,local,estMin,estMax, referencia, data, estadoItem, caminhoFoto);
    	//problema com dao.atualizar()
    	/*if(dao.atualizar(i)){
    		Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setHeaderText("Alteração concluída com sucesso!");
			alert.show();
    	}else {
    		Alert alert = new Alert(AlertType.ERROR);
			alert.setHeaderText("Não foi possível realizar alteração.");
			alert.show();
    	}*/
	}

	@Override
	public void initialize(URL url, ResourceBundle rb) {	
    	imgFotoItem.setOnMouseClicked(MouseEvent ->{
    		selecionaFoto();
    	});
 
    	initItem();
    }
    
	 private void cadastrarItem() {
		 /*String descricao = txtDescricao.getText(),
				classificacao = txtClassificacao.getText(),
				fornecedor = txtFornecedor.getText();
				//não adicionei marca por conta do checkbox
		 int quantidadeAtual = Integer.parseInt(txtQuantAtual.getText());
		 int estMin = Integer.parseInt(txtEstMin.getText());
		 int estMax = Integer.parseInt(txtEstMin.getText());
		 int cod = Integer.parseInt(txtCodigo.getText());*/
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
	 
	 public void initItem() {
		 txtFornecedor.setText(item2.getFornecedor_item());
		 txtDescricao.setText(item2.getDescricao_item());
		 txtMarca.setText(item2.getMarca_item());
		 txtQuantAtual.setText(String.valueOf(item2.getQuant_atual_item()));
		 txtEstMax.setText(String.valueOf(item2.getEstoque_max_item()));
		 txtEstMin.setText(String.valueOf(item2.getEstoque_min_item()));
		 txtReferencia.setText(item2.getReferencia_marca_item());
		 txtLocal.setText(item2.getLocal_item());
		 //Problemas para retornar a imagem e selecionar RadioButton
		 imgFotoItem.setImage(new Image("file:///" + item2.getFoto_item()));
		 caminhoFoto = item2.getFoto_item();
		 RadioButton selecionado = (RadioButton)estado.getSelectedToggle();
		 selecionado.setText(item2.getEstado_item());
		 if(selecionado.getText() == "Inativo") {
			 rbInativo.isSelected();
			 rbInativo.setSelected(true);
		 }else {
			 rbAtivo.setSelected(true);
		 }
	 }
}


