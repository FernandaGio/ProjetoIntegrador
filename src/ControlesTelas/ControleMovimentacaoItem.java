package ControlesTelas;


import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

import JDBC.Item;
import JDBC.ItemDAO;
import JDBC.ItemDAOJDBC;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
import model.Colunas;
import javafx.stage.Stage;

public class ControleMovimentacaoItem implements Initializable{

	 	@FXML
	    private Button btSalvar;

	    @FXML
	    private ImageView imgItens;

	    @FXML
	    private TextField txtDescricao;

	    @FXML
	    private Label lblDescricao;

	    @FXML
	    private Label lblMarca;

	    @FXML
	    private TextField txtMarca;

	    @FXML
	    private Label lblReferencia;

	    @FXML
	    private TextField txtReferencia;

	    @FXML
	    private Label lblCodigo;

	    @FXML
	    private TextField txtCodigo;

	    @FXML
	    private Label lblQuantAtual;

	    @FXML
	    private TextField txtQuantAtual;

	    @FXML
	    private Label lblTipoMov;

	    @FXML
	    private ComboBox<Colunas> cbTipoMov;
	    
	    @FXML
	    private Label lblQuantAlterada;

	    @FXML
	    private TextField txtQuantAlterada;
	    
	    private static Item item2;
	   
	    
	    public static Item getItem2() {
			return item2;
		}

		public static void setItem2(Item item1) {
			ControleMovimentacaoItem.item2 = item1;
		}


    @FXML
    void onClickSalvarItem(ActionEvent event) {

    }


	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		initItem();
		carregarColunas();
		
	}
	
	public void initItem() {
		 txtDescricao.setText(item2.getDescricao_item());
		 txtMarca.setText(item2.getMarca_item());
		 txtQuantAtual.setText(String.valueOf(item2.getQuant_atual_item()));
		 txtReferencia.setText(item2.getReferencia_marca_item());
		 txtCodigo.setText(String.valueOf(item2.getCodigo_item()));
	 }

	/*public void atualizarMovimentacao() {
    	String descricao = txtDescricao.getText(),marca = txtMarca.getText(),fornecedor = txtFornecedor.getText(), local = txtLocal.getText(), referencia = txtReferencia.getText(), estadoItem = estado.getSelectedToggle().toString(); 
    	int quant_atual = Integer.parseInt(txtQuantAtual.getText()), estMin = Integer.parseInt(txtEstMin.getText()), estMax = Integer.parseInt(txtEstMax.getText());
    	
    	System.out.println(data);
    	
    	Item i = new Item(descricao, fornecedor, marca, quant_atual, local, estMin, estMax, referencia, data, estadoItem, caminhoFoto);
    	ItemDAO itemdao = new ItemDAOJDBC();
 
    	if(itemdao.atualizar(i)) {
    		Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setHeaderText("Alteração concluída com sucesso!");
			alert.show();
    	}else {
    		Alert alert = new Alert(AlertType.ERROR);
			alert.setHeaderText("Não foi possível realizar alteração.");
			alert.show();
    	}
	}*/
	
	public ObservableList<Colunas> coluna;
	
	private List<Colunas> colunas = new ArrayList<>();
	
	public void carregarColunas() {
		Colunas coluna1 = new Colunas(1, "Devolução(D)");
		Colunas coluna2 = new Colunas(2, "Saída(S)");
		Colunas coluna3 = new Colunas(3, "Entrada(E)");
		
		colunas.add(coluna1);
		colunas.add(coluna2);
		colunas.add(coluna3);
		
		coluna = FXCollections.observableArrayList(colunas);
		cbTipoMov.setItems(coluna);
		
	}
}


