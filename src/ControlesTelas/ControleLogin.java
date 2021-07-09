package ControlesTelas;

import java.net.URL;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;

import JDBC.Usuario;
import JDBC.UsuarioDAO;
import JDBC.UsuarioDAOJDBC;
import application.MainAlterarItem;
import application.MainCadastroUser;
import application.MainEstoque;
import application.MainLogin;
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
	   
	    public void fechar() {
			//MainLogin.getStage().close();	
		}
	    
		@Override
		public void initialize(URL url, ResourceBundle rb) {
			
			btnCadastroUser.setOnMouseClicked(MouseEvent -> {
				
				MainCadastroUser m= new MainCadastroUser();
				//fecha();
				try {
					m.start(new Stage());
				}catch (Exception e1) {
					e1.printStackTrace();
				}
			});
			
			btnEntrar.setOnMouseClicked(MouseEvent -> {
				if(txtLogin.getText().equals("root") && pfSenha.getText().equals("1234")){
					MainEstoque m= new MainEstoque();
					try {
						m.start(new Stage());
						fechar();
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
			});
				/*UsuarioDAO dao = (UsuarioDAO) new UsuarioDAOJDBC();
				ArrayList<Usuario> usuarios = dao.listar();
				
				for (int x = 0; x<usuarios.size(); x++) {
					if(txtLogin.getText().equals(usuarios.get(x).getNome()) && pfSenha.getText().equals(usuarios.get(x).getSenha())){
						MainLogin m= new MainLogin();
						x = usuarios.size();
						fecha();
						try {
							m.start(new Stage());
						} catch (Exception e1) {
							e1.printStackTrace();
						}	
					}else{
						if (x == usuarios.size()-1) {
							Alert alert = new Alert(AlertType.ERROR);
							alert.setTitle("Erro");
							alert.setHeaderText("Login Inválido");
							alert.setContentText("Login ou senha incorretos");
							alert.show();
						}
					}
				}
			});*/
		}

	
	}
