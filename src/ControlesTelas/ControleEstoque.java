package ControlesTelas;

import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.util.List;
import java.util.ResourceBundle;

import JDBC.Item;
import JDBC.ItemDAO;
import JDBC.ItemDAOJDBC;
import application.MainInformacoesItem;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

	public class ControleEstoque implements Initializable {

		 @FXML
		    private Button btnCadastroItem;

		    @FXML
		    private Label lblColuna;

		    @FXML
		    private ImageView imgBuscar;

		    @FXML
		    private Label lblBuscar;

		    @FXML
		    private ImageView imgFiltrar;

		    @FXML
		    private TextField txtBuscar;

		    @FXML
		    private ComboBox<?> cbColuna;

		    @FXML
		    private Button btnExportar;

		    @FXML
		    private ImageView imgExportar;

		    @FXML
		    private Button btnImprimir;

		    @FXML
		    private ImageView imgImprimir;

		    @FXML
		    private TableView<Item> tbviewEstoque;

		    @FXML
		    private TableColumn<Item, Integer> tColumnCod;

		    @FXML
		    private TableColumn<Item, String> tColumnData;

		    @FXML
		    private TableColumn<Item, String> tColumnDescricao;

		    @FXML
		    private TableColumn<Item, String> tColumnMarca;

		    @FXML
		    private TableColumn<Item, String> tColumnRef;

		    @FXML
		    private TableColumn<Item, Integer> tColumnQuantidade;

		    @FXML
		    private TableColumn<Item, String> tColumnLocal;

		    @FXML
		    private TableColumn<Item, String> tColumnEstado;

		   // @FXML
		   // private TableColumn<?, ?> tColumnMovimentacao;

		    @FXML
		    private TableColumn<Item, String> tColumnFornecedor;

		    @FXML
		    private TableColumn<Item, String> tColumnFoto;

		    @FXML
		    private Label lblDataFInal;

		    @FXML
		    private DatePicker dpDataInicial;

		    @FXML
		    private DatePicker dpDataFinal;

		    @FXML
		    private Label lblDataInicial;

		    @FXML
		    private ImageView imgCadastroItem;

		    @FXML
		    private Label lblUsuarioLogado;

		    @FXML
		    private ImageView imgUsuarioLogado;

		    @FXML
		    private Circle circleNotificacao;

		    @FXML
		    private ImageView imgNotificacao;
		    
		    @FXML
		    public void onClickbtnCadastrarItem(ActionEvent event) {
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
			@Override
			public void initialize(URL url, ResourceBundle rb) {
				initTable();
			
			}
			
		
			public void initTable() {
				tColumnCod.setCellValueFactory(new PropertyValueFactory("codigo_item"));
				tColumnData.setCellValueFactory(new PropertyValueFactory("data_entrada_item"));
				tColumnDescricao.setCellValueFactory(new PropertyValueFactory("descricao_item"));
				tColumnMarca.setCellValueFactory(new PropertyValueFactory("marca_item"));
				tColumnRef.setCellValueFactory(new PropertyValueFactory("referencia_marca_item"));
				tColumnFornecedor.setCellValueFactory(new PropertyValueFactory("fornecedor_item"));
				tColumnQuantidade.setCellValueFactory(new PropertyValueFactory("quant_atual_item"));
				tColumnLocal.setCellValueFactory(new PropertyValueFactory("local_item"));
				tColumnEstado.setCellValueFactory(new PropertyValueFactory("estado_item"));
				tColumnFoto.setCellValueFactory(new PropertyValueFactory("foto_item"));
				tbviewEstoque.setItems(listar());
			}
			
			public ObservableList<Item> listar(){
				ItemDAO dao = new ItemDAOJDBC();
				return FXCollections.observableArrayList(dao.listar());
			}

 }
