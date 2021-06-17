package ControlesTelas;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import application.MainCadastroUser;
import application.MainEstoque;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;


public class ControleLogin implements Initializable{
	


	    @FXML 
	    private Label lblSenha;
	    
	    @FXML 
	    private Label lblLogin;
	    
	    @FXML 
	    private PasswordField pfSenha;
	    
	    @FXML 
	    private TextField txtLogin;
	    
	    @FXML 
	    private Button btnEntrar;
	    
	    @FXML 
	    private Button btnCadastroUser;
	    
	    @FXML
	    void onClickCadastroUser(ActionEvent event) {
	    }
	    @FXML
	    void onClickEntrar(ActionEvent event) {
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
	    
		@Override
		public void initialize(URL url, ResourceBundle rb) {
			
			btnEntrar.setOnMouseClicked(MouseEvent -> {

				if(txtLogin.getText().equals("root") && pfSenha.getText().equals("1234")){
					MainEstoque m= new MainEstoque();
					fecha();
					try {
						m.start(new Stage());
					} catch (Exception e1) {
						e1.printStackTrace();
					}	
	
			} else {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("Erro");
				alert.setHeaderText("Login Inválido");
				alert.setContentText("Login ou senha incorretos");
				alert.show();
			}
				
			btnEntrar.setOnKeyPressed((KeyEvent e)->{
				if(e.getCode() == KeyCode.ENTER) {
					if(txtLogin.getText().equals("root") && pfSenha.getText().equals("1234")){
						MainEstoque m= new MainEstoque();
						fecha();
						try {
							m.start(new Stage());
						} catch (Exception e1) {
							e1.printStackTrace();
						}	
		
					}else {
						Alert alert = new Alert(AlertType.ERROR);
						alert.setTitle("Erro");
						alert.setHeaderText("Login Inválido");
						alert.setContentText("Login ou senha incorretos");
						alert.show();
					}
				}
			});
		});
				/*PessoaDao dao = new PessoaDao();
				'List<Pessoa> pessoas = dao.getList();
				
				for (int x = 0; x<pessoas.size(); x++) {
					if(txtLogin.getText().equals(pessoas.get(x).getLogin()) && txtSenha.getText().equals(pessoas.get(x).getSenha())){
						MainLogin m= new MainLogin();
						x = pessoas.size();
						fecha();
						try {
							m.start(new Stage());
						} catch (Exception e1) {
							e1.printStackTrace();
						}	
					}else{
						if (x == pessoas.size()-1) {
							Alert alert = new Alert(AlertType.ERROR);
							alert.setTitle("Erro");
							alert.setHeaderText("Login Inválido");
							alert.setContentText("Login ou senha incorretos");
							alert.show();
						}
					}
					}
				})*/
			
			btnCadastroUser.setOnMouseClicked(MouseEvent -> {
				
				MainCadastroUser m= new MainCadastroUser();
				fecha();
				try {
					m.start(new Stage());
				}catch (Exception e1) {
					e1.printStackTrace();
				}
			});
		}
		private void fecha() {

		}
				
	}
