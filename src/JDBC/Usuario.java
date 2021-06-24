package JDBC;


public class Usuario {

	public int cpf;
	public String nome = "";
	public String senha;
	public boolean ADM; // Se for true o usuario é Administrador. 
	
	
	public Usuario(int cpf, String nome, String senha, boolean aDM) {
		super();
		this.cpf = cpf;
		this.nome = nome;
		this.senha = senha;
		ADM = aDM;
	}


	public int getCpf() {
		return cpf;
	}


	public void setCpf(int cpf) {
		this.cpf = cpf;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getSenha() {
		return senha;
	}


	public void setSenha(String senha) {
		this.senha = senha;
	}


	public boolean isADM() {
		return ADM;
	}


	public void setADM(boolean aDM) {
		ADM = aDM;
	}

}
