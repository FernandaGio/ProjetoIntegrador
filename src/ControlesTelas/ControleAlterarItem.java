package ControlesTelas;

import java.io.File;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
	    private TextField txtDataEntrada;

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
	    private ImageView imgVisualizarFoto;
	    
	    @FXML
	    private ImageView imgFotoItem;
	    
	    @FXML
	    private Button btCadastrar;

	    @FXML
	    private Button btSalvar;
	    
	    @FXML
	    private Label lblCodigo;

	    @FXML
	    private TextField txtCod;
	    
	    private String caminhoFoto;
	    
	    private static Item item2;
	    
	    private Date dateFormatte;

    
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
    	String descricao_item = txtDescricao.getText(), marca_item = txtMarca.getText(),fornecedor_item = txtFornecedor.getText();
    	String local_item = txtLocal.getText(), referencia_marca_item = txtReferencia.getText(), estadoItem = estado.getSelectedToggle().toString(); 
    	int estoque_min_item = Integer.parseInt(txtEstMin.getText()), estoque_max_item = Integer.parseInt(txtEstMax.getText());
    	   
    	Item item = new Item(descricao_item, fornecedor_item, marca_item, local_item, estoque_min_item, estoque_max_item, referencia_marca_item);
    	/*System.out.println(descricao);
    	System.out.println(fornecedor);
    	System.out.println(marca);
    	System.out.println(referencia);
    	System.out.println(local);
    	System.out.println(caminhoFoto);
    	System.out.println(quant_atual);
    	System.out.println(estMin);
    	System.out.println(estMax);*/
    	//System.out.println(estadoItem);
    	//problema com dao.atualizar()
    	ItemDAO itemdao = new ItemDAOJDBC();
    	if(itemdao.atualizar(item)) {
    		Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setHeaderText("Alteração concluída com sucesso!");
			alert.show();
    	}else {
    		Alert alert = new Alert(AlertType.ERROR);
			alert.setHeaderText("Não foi possível realizar alteração.");
			alert.show();
    	}
	}

	@Override
	public void initialize(URL url, ResourceBundle rb) {	
    	imgFotoItem.setOnMouseClicked(MouseEvent ->{
    		selecionaFoto();
    	});
 
    	initItem();
    	
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
		 txtCod.setText(String.valueOf(item2.getCodigo_item()));
		 String formato = "dd/MM/yyyy";
		 DateFormat df = new SimpleDateFormat(formato);
		 String data = df.format(item2.getData_entrada_item());
		 txtDataEntrada.setText(data);
		
		 imgFotoItem.setImage(new Image("file:///" + item2.getFoto_item()));
		 caminhoFoto = item2.getFoto_item();
		 //RadioButton selecionado = (RadioButton)estado.getSelectedToggle();
		 String selecionado = item2.getEstado_item();
		 if(selecionado.equalsIgnoreCase("Ativo")) {
			 rbAtivo.setSelected(true);
		 }else{
			rbInativo.setSelected(true);
		 }
	 }
}


