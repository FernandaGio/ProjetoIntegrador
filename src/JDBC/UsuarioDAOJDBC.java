
package JDBC;


import java.io.Console;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class UsuarioDAOJDBC {
	
	private JDBCUtil banco;
	
	public UsuarioDAOJDBC() {
		banco = new JDBCUtil();
	}
	
	public enum MembroInterfaceUsuario {
		NOME,CPF,SENHA,TUDO;
		}

	public class insert
	{
		boolean exito = true;
		String mensagem;
		int qtderro;
		Usuario usuario;
	}
	
	public insert validarinserir(int cpf,String nome, String senha,String confirmarsenha) {
		
		 System.out.println("aa");
		insert retornoinsert = new insert();
		String camposnaopreenchidos = "";
		
	    if(nome.isEmpty())
	    {
	    	retornoinsert.qtderro++;
	    	retornoinsert.exito = false;
	    	camposnaopreenchidos += "Nome, ";
	    	
	    }
	    if(senha.isEmpty())
	    {
	    	retornoinsert.qtderro++;
	    	retornoinsert.exito = false;
	    	camposnaopreenchidos += "Senha, ";
	    	
	    }
	    if(!confirmarsenha.isEmpty() && !senha.isEmpty() )
	    {    	
	    	if(senha != confirmarsenha  )
	    	{
	    		retornoinsert.qtderro++;
		    	retornoinsert.exito = false;
	    		retornoinsert.mensagem = "A senhas não se conferem, por favor tente outra senha.";
	    	}
	    	else if( senha.length() < 5 )
	    	{
	    		retornoinsert.qtderro++;
		    	retornoinsert.exito = false;
	    		retornoinsert.mensagem = "Sua senha precisa ser maior que 5 caracteres;";
	    	}
	    
	    }
	    else
	    {
	    	retornoinsert.qtderro++;
	    	retornoinsert.exito = false;

	    	camposnaopreenchidos += "Confirmar senha, ";
	    }
	    if(CPFCadastrado(cpf))
	    {
	    	retornoinsert.exito = false;
	    	retornoinsert.mensagem = "Este CPF já esta cadastrado em nosso sistema";
	    }
	    
	    if(retornoinsert.exito == false)
	    {
	    	if(camposnaopreenchidos.length() > 0)
	    	{
	    		retornoinsert.mensagem = "Os seguintes campo(s) não foram preencidos: " + camposnaopreenchidos + "não foi possivel gerar o cadastro.";	    		
	    	}
	  
	    	return retornoinsert;
	    }
	    else
	    {
	    	Usuario usuario = new Usuario(cpf, camposnaopreenchidos, camposnaopreenchidos, false);

	    	usuario.cpf = cpf;
	    	usuario.nome = nome;
	    	usuario.senha = senha;
	    	usuario.ADM = false;
	    	
	    	retornoinsert.mensagem = "Usuario " + usuario.nome + " cadastrado com sucesso !";
	    	try
	    	{
	    		inserir(usuario);
	    		
	    		
	    	}
	    	catch(Exception e)
	    	{
	    		retornoinsert.mensagem = "Erro no banco de dados, strackTrace " + e.getStackTrace();
	    	} 
	    	
	    	
	   }
	    
	    return retornoinsert;
	}
	
	public boolean CPFCadastrado(int cpf)
	{
		
		String sql = "select * from usuario where id = " + cpf + ";";
		PreparedStatement preparedStatement;
		try {
			
			preparedStatement = banco.getConnection().prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery(sql);
			
			if(resultSet.next())
			{
				return true;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			e.getMessage();
		}
		return false;
	}

	public void inserir(Usuario usuario) {
		
		// Index dos parametros no DB
		// ID = 1; NOME = 2; SENHA = 3; ADM = 4;
		
		String sql = "insert into usuario values (?, ?, ?, ?);";
		PreparedStatement preparedStatement;
		try {
			preparedStatement = banco.getConnection().prepareStatement(sql);
			
			preparedStatement.setInt(1,usuario.cpf);
			preparedStatement.setString(2, usuario.nome);
			preparedStatement.setString(3, usuario.senha);
			preparedStatement.setBoolean(4, usuario.ADM);
			
			preparedStatement.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
			e.getMessage();
		}
		
	}
	
	public void remover(Usuario usuario) {
		
		String sql = "delete from usuario where id = ?;";
		
		PreparedStatement preparedStatement;
		try {
			preparedStatement = banco.getConnection().prepareStatement(sql);
			
			preparedStatement.setInt(1, usuario.cpf);
			
			preparedStatement.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}
	
//public ArrayList<Usuario> listar1() {
		
	//	ArrayList<Usuario> itens = new ArrayList<Usuario>();
		
	//	String sql = "select * from usuario;";
		
	//	try {
//		Statement statement = banco.getConnection().createStatement();
			
		// ResultSet resultSet = statement.executeQuery(sql);
			
	//		while(resultSet.next()) {
				
			// Usuario usuario = new Usuario();
					
		//		usuario.setNome_usuario(resultSet.getString(1));
			//	usuario.setNome_usuario(resultSet.getInt(2));
			//	usuario.setNome_usuario(resultSet.getString(3));
			//	usuario.setConfirmarsenha_usuario(resultSet.getInt(4));
	//	}




	public void Nome(Usuario usuario) {
		// TODO Auto-generated method stub
		
	}

	public void Cpf(Usuario Usuario) {
		// TODO Auto-generated method stub
		
	}

	public void Senha(Usuario Usuario) {
		// TODO Auto-generated method stub
		
	}

	public void Confirmarsenha(Usuario Usuario) {
		// TODO Auto-generated method stub
		
	}

	public ArrayList<Usuario> cadastrar() {
		// TODO Auto-generated method stub
		return null;
	}

	public void atualizar(Usuario usuario) {
		
      
      String sql = "update usuario set nome = ?, senha = ? where id = ?";

      
		PreparedStatement preparedStatement;
		try {
			preparedStatement = banco.getConnection().prepareStatement(sql);
			
			preparedStatement.setString(1, usuario.nome);
			preparedStatement.setString(2, usuario.senha);
			preparedStatement.setInt(3,usuario.cpf);

			preparedStatement.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		
	}

	public ArrayList<Usuario> listar() {
		// TODO Auto-generated method stub
		return null;
	}
}
