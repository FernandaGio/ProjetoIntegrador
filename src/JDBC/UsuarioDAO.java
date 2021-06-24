package JDBC;

import java.util.ArrayList;

import JDBC.UsuarioDAOJDBC.MembroInterfaceUsuario;

public interface UsuarioDAO {

		
		public void inserir(Usuario usuario);
		
		public void atualizar(Usuario usuario);
		
		public void remover(Usuario usuario);
		
		public ArrayList <Usuario> listar();

		void atualizar(Usuario usuario, ArrayList<MembroInterfaceUsuario> Clovis);
			
	}
