package ControlesTelas;

import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

import JDBC.Item;
import JDBC.ItemDAO;
import JDBC.ItemDAOJDBC;
import JDBC.JDBCUtil;
import Relatorios.RelatorioEstoque;
import application.MainAlterarItem;
import application.MainCadastroUser;
import application.MainEstoque;
import application.MainInformacoesItem;
import application.MainMovimentacaoItem;
import application.MainVisualizarFoto;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import model.Colunas;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

	public class ControleEstoque implements Initializable {

		 	private static final EventHandler<? super MouseEvent> MouseEvent = null;

			@FXML
		    private Button btnCadastroItem;

		    @FXML
		    private Label lblColuna;

		    @FXML
		    private ImageView imgBuscar;

		    @FXML
		    private Label lblBuscar;

		    @FXML
		    private TextField txtBuscar;

		    @FXML
		    private ComboBox<Colunas> cbColuna;

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

		    @FXML
		    private TableColumn<Item, String> tColumnFornecedor;

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
		    private Button btnEditar;

		    @FXML
		    private ImageView imgEditarItem;

		    @FXML
		    private Button btnEditarEstoque;

		    @FXML
		    private Button btnAtualizaEstoque;
		    
		    @FXML
		    private ImageView imgEditarEstoque;
		    
		    @FXML
		    private ImageView imgBuscarData;
		    
		    private String caminhoFoto;
		    
		    @FXML
		    private ImageView imgAtualizarEstoque;

		    @FXML
		    private Button btnHistMovimentacao;

		    @FXML
		    private ImageView imgHistMovimentacao;
		    
		    private final JDBCUtil database = new JDBCUtil();
		    private final Connection connection = database.getConnection();
		    private final ItemDAO itemdao = new ItemDAOJDBC();
		    @FXML
		    void onClickHistMovimentacao(ActionEvent event) {
		    	
		    }
		    
		    @FXML
		    protected void onClickImprimir(ActionEvent arg0){
		    	/*URL url = getClass().getResource("/Relatorios/RelatorioEstoque.jasper");
		    	System.out.println(url);
		    	JasperReport jasperReport = (JasperReport) JRLoader.loadObject(url);
		    	
		    	
		    	JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, null, connection);
		    	
		    	JasperViewer jasperViewer = new JasperViewer(jasperPrint, false);
		    	jasperViewer.setVisible(true);
		    	
		    	if(jasperViewer.isVisible()) {
		    		Alert alert = new Alert(AlertType.WARNING);
					alert.setHeaderText("Relatório Impresso");
					alert.show();
		    	}else {
		    		Alert alert = new Alert(AlertType.WARNING);
					alert.setHeaderText("Não foi dessa vez");
					alert.show();
		    	}*/
		    	
		    	RelatorioEstoque relatorio = new RelatorioEstoque();
		    	List<Item> lista = null;
		    	try {
					relatorio.gerarRelatorio(lista);
				}catch (Exception e1) {
					e1.printStackTrace();
				}
		    	
		    }

		    @FXML
		    void onClickEditarEstoque(ActionEvent event) {
		    	Item itemSelecionado = tbviewEstoque.getSelectionModel().getSelectedItem();
		    	if(itemSelecionado!= null) {
		    		MainMovimentacaoItem m= new MainMovimentacaoItem(itemSelecionado);
					try {
						m.start(new Stage());
					}catch (Exception e1) {
						e1.printStackTrace();
					}
		    	}else {
		    		Alert alert = new Alert(AlertType.WARNING);
					alert.setHeaderText("Selecione um item.");
					alert.show();
		    	}
		    }

		    @FXML
		    public void onClickEditar(ActionEvent event) {
		    	Item itemSelecionado = tbviewEstoque.getSelectionModel().getSelectedItem();
		    	if(itemSelecionado!= null) {
		    		MainAlterarItem m= new MainAlterarItem(itemSelecionado);
					try {
						m.start(new Stage());
					}catch (Exception e1) {
						e1.printStackTrace();
					}
		    	}else {
		    		Alert alert = new Alert(AlertType.WARNING);
					alert.setHeaderText("Selecione um item.");
					alert.show();
		    	}
		    }
  
		    public boolean onCloseQuery() {
		    	Alert alerta = new Alert(Alert.AlertType.CONFIRMATION);
		    	alerta.setTitle("Atenção");
		    	alerta.setHeaderText("Deseja sair do sistema?");
		    	ButtonType btnNao = ButtonType.NO;
		    	ButtonType btnSim = ButtonType.YES;
		    	alerta.getButtonTypes().setAll(btnNao, btnSim);
		    	Optional<ButtonType> opcaoEscolhida = alerta.showAndWait();
		    	
		    	return opcaoEscolhida.get() == btnSim ? true : false;    		
		    }
		    
		    
		  /*  public boolean deletarItem() {
		    	Alert alerta = new Alert(Alert.AlertType.CONFIRMATION);
		    	alerta.setTitle("Atenção");
		    	alerta.setHeaderText("Deseja deletar item?");
		    	ButtonType btnNao = ButtonType.NO;
		    	ButtonType btnSim = ButtonType.YES;
		    	alerta.getButtonTypes().setAll(btnNao, btnSim);
		    	Optional<ButtonType> opcaoEscolhida = alerta.showAndWait();
		    	ItemDAO itemdao = new ItemDAOJDBC();
		    	if(opcaoEscolhida.get() == btnSim) {
		    		itemdao.remover(item); 
		    	}
		    	return 
		    			 ? true : false;
		    }*/
		    

			private List<Colunas> colunas = new ArrayList<>();//lista de colunas
		    
		    @FXML
		    public void onClickbtnCadastrarItem(ActionEvent event) {//para abrir a tela cadastrar item
		    	MainInformacoesItem m= new MainInformacoesItem();
				try {
					m.start(new Stage());
				}catch (Exception e1) {
					e1.printStackTrace();
				}
			};

			@Override
			public void initialize(URL url, ResourceBundle rb) {
				initTable();
				carregarColunas();
				imgBuscar.setOnMouseClicked(MouseEvent ->{
		    		botaoBuscar();
		    	});
				imgBuscarData.setOnMouseClicked(MouseEvent ->{
		    		botaoBuscarData();
		    	});
				
				//duplo clique em TableView
				/*tbviewEstoque.setOnMouseClicked((MouseEvent e)->{
					if (e.getButton().equals(MouseButton.PRIMARY) && e.getClickCount() == 2){
					Item itemSelecionado = tbviewEstoque.getSelectionModel().getSelectedItem();
					caminhoFoto = itemSelecionado.getFoto_item();
					String foto_item = caminhoFoto;
					System.out.println(caminhoFoto);
			    	if(itemSelecionado!= null) {
			    		MainVisualizarFoto m= new MainVisualizarFoto(foto_item);
						try {
							m.start(new Stage());
						}catch (Exception e1) {
							e1.printStackTrace();
						}
			    	}else {
			    		Alert alert = new Alert(AlertType.WARNING);
						alert.setHeaderText("Selecione um item");
						alert.show();
			    	}
			    }
					
					/*	caminhoFoto = ControleAlterarItem.getItem2().getFoto_item();
						String foto_item = caminhoFoto;
						Item item = new Item(foto_item);
						MainVisualizarFoto m= new MainVisualizarFoto(foto_item);
						try {
							m.start(new Stage());
						} catch (Exception e1) {
							e1.printStackTrace();
						}
					}
				});*/
				
				btnAtualizaEstoque.setOnMouseClicked((MouseEvent e)->{
					tbviewEstoque.setItems(listar());
				});
				
				
			}
			
			private void botaoBuscarData() {
				LocalDate dataInicial = dpDataInicial.getValue();
				LocalDate dataFinal = dpDataFinal.getValue();
				//Date dataIni = (Date) Date.from(dataInicial.atStartOfDay(ZoneId.systemDefault()).toInstant());
				ItemDAOJDBC itemdao = new ItemDAOJDBC(); 
				ArrayList<Item> itens = itemdao.buscarData("" + dataInicial, "" + dataFinal);
				//System.out.println(dataIni);
				//System.out.println(dataFim);
				for(Item i: itens)
					listar(itens);			
			}
				

			private void botaoBuscar() {
				ItemDAOJDBC itemdao = new ItemDAOJDBC(); 
				Colunas coluna = cbColuna.getSelectionModel().getSelectedItem();
				String colunaPesquisada = coluna.getNome();
				ArrayList<Item> itens = itemdao.buscar(cbColuna.getSelectionModel().getSelectedItem().getNome(), txtBuscar.getText());
				for(Item i: itens)
				listar(itens);			
			}
			
			public void listar(ArrayList<Item> item){
				ItemDAO dao = new ItemDAOJDBC();
				Itens  =  FXCollections . observableArrayList (item);
				tbviewEstoque.setItems(Itens);
				
			}
			
			//Para carregar a tabela Item do banco de dados para o tableView presente na tela
			
			private ObservableList<Item> Itens = FXCollections.observableArrayList();//teste de pesquisa
			
			
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
				tbviewEstoque.setItems(listar());
			}
			
			public ObservableList<Item> listar(){
				ItemDAO dao = new ItemDAOJDBC();
				Itens = FXCollections.observableArrayList(dao.listar());
				return Itens;
			}
			
			//método para carregar colunas no combo box de pesquisa
			
			public ObservableList<Colunas> coluna;
			
			public void carregarColunas() {
				Colunas coluna1 = new Colunas(1, "Código");
				Colunas coluna2 = new Colunas(2, "Estado");
				Colunas coluna3 = new Colunas(3, "Descrição");
				Colunas coluna4 = new Colunas(4, "Marca");
				Colunas coluna5 = new Colunas(5, "Referência");
				Colunas coluna6 = new Colunas(6, "Quantidade");
				Colunas coluna7 = new Colunas(7, "Local");
				Colunas coluna8 = new Colunas(8, "Fornecedor");
				
				colunas.add(coluna1);
				colunas.add(coluna2);
				colunas.add(coluna3);
				colunas.add(coluna4);
				colunas.add(coluna5);
				colunas.add(coluna6);
				colunas.add(coluna7);
				colunas.add(coluna8);
				
				coluna = FXCollections.observableArrayList(colunas);
				cbColuna.setItems(coluna);
				
			}
			//teste de pesquisa
			/*private ObservableList<Item> buscarData(){
				ObservableList<Item> itemPesquisado = FXCollections.observableArrayList();
				for(int x = 0; x< Itens.size(); x++){
					if(Itens.get(x).getDescricao_item().contains(txtBuscar.getText())||Itens.get(x).getEstado_item().contains(txtBuscar.getText())||Itens.get(x).getMarca_item().contains(txtBuscar.getText())||Itens.get(x).getLocal_item().contains(txtBuscar.getText())){
						itemPesquisado.add(Itens.get(x));
					}
				}
			return itemPesquisado;
		}*/
 }
