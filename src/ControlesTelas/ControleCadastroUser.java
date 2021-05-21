package ControlesTelas;


import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class ControleCadastroUser {
	
	@FXML 
	private Label lblCadastroUser;
	
	@FXML
	private Label lblNomeUser;
	
	@FXML
	private Label lblCpfUser;
	
	@FXML
	private Label lblSenhaUser;
	
	@FXML
	private Label lblConfirmeSenhaUser;
	
	@FXML
	private TextField txtNomeUser;
	
	@FXML
	private TextField txtCpfUser;
	
    @FXML
    private PasswordField pfSenha;

    @FXML
    private PasswordField pfConfirmacao;
	
	@FXML
	private Button btnCadastrar;
	

}
