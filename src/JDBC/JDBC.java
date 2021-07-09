package JDBC;

import java.util.ArrayList;
import java.util.Date;

public class JDBC {
	
	public static void main(String[] args) {
		

		// TESTANDO MÉTODO DE INSERIR
	Item item = new Item("Plug 4 + Azul", "9881 Steck Indústria Elétrica  LTDA", "ABB", 69, "AB", 8, 60, 
				"42T456M", new Date(), "Inativo", "C:\\Users\\Usuario\\Pictures\\elefantesteste.jpg");
		
		ItemDAO dao = new ItemDAOJDBC();
		
		dao.inserir(item);
		
		
//TESTANDO MÉTODO DE ATUALIZAR
		/*Item item = new Item(0);
			
		/*item.setDescricao_item("Plug3P+2A Vermelho");
		item.setFornecedor_item("10575 Materiais Elétricos Strahl");
		item.setMarca_item("Strahl");*/
		//item.setQuant_atual_item(100);
		/*item.setLocal_item("BA");
		item.setEstoque_min_item(8);
		item.setEstoque_max_item(60);
		item.setReferencia_marca_item("4274B");
		//item.setData_entrada_item("01/01/01");
		item.setEstado_item("Ativo");
		item.setFoto_item("exemplo1");
		//item.setCodigo_item(10);
			
		ItemDAO dao = new ItemDAOJDBC();
		
		dao.atualizarQuantidade(item);*/
		
		
		//TESTANDO MÉTODO DE REMOVER
		//Item item = new Item();
		
		//item.setCodigo_item(102);
		
		//ItemDAO dao = new ItemDAOJDBC();
		
		//dao.remover(item);
		
		
		//TESTANDO MÉTODO DE LISTAR
		//ArrayList<Item> itens = dao.listar();
		
		//for(Item it: itens) {
		//	System.out.println(it.getCodigo_item()+" "+it.getQuant_atual_item());
		//}
		
		//BUSCANDO NO BANCO DE DADOS
		//ArrayList<Item> itens = dao.buscar();
	}

		//Item item = new Item("Plug3P+32A Vermelho", "9881 Steck Indústria Elétrica  LTDA", "Steck", 102, 56, "AB", 8, 60, 
		//		"4274", "00/00/00", "Ativo", "exemplo");
		
		//ItemDAO dao = new ItemDAOJDBC();
		
		//dao.inserir(item);
		
		
		//Item item = new Item();
			
		/*item.setDescricao_item("Plug3P+2A Vermelho");
		item.setFornecedor_item("10575 Materiais Elétricos Strahl");
		item.setMarca_item("Strahl");
		item.setQuant_atual_item(57);
		item.setLocal_item("BA");
		item.setEstoque_min_item(8);
		item.setEstoque_max_item(60);
		item.setReferencia_marca_item("4274B");
		item.setData_entrada_item("01/01/01");
		item.setEstado_item("Inativo");
		item.setFoto_item("exemplo1");
		item.setCodigo_item(102);*/
			
		//ItemDAO dao = new ItemDAOJDBC();
		
		//dao.atualizar(item);
		
		
	/*	Item item = new Item();
		
		item.setCodigo_item(102);
		
		ItemDAO dao = new ItemDAOJDBC();
		
		dao.remover(item);
		
		*/
		
		//ArrayList<Item> itens = dao.listar();
		
		//for(Item it: itens) {
		//	System.out.println(it.getCodigo_item()+" "+it.getQuant_atual_item());
		//}
	
	//Usuario usuario = new Usuario
	
			//UsuarioDAO dao = new UsuarioDAOJDBC();
			
			//dao.inserir(usuario);
			
			
			//Usuario usuario = new Usuario();
				
			/*usuario.setnome_usuario;
			usuario.setcpf_usuario;
			usuario.setSenha_usuario;
			usuario.setConfirmarsenha_usuario;
			usuario.setCodigo_usuario;*/ 
				
			//UsuarioDAO dao = new UsuarioDAOJDBC();
			
			//dao.atualizar(usuario);
			
			
	    /*	UsuarioDAOJDBC dao = new UsuarioDAOJDBC();
			Usuario usuario = new Usuario();
			insert retorno ;

			

			
		//	Usuario.setCodigo_usuario(102);

	    	usuario.id = 1;
	    	usuario.nome = "SDFGDSFGDSFGDS";
	    	usuario.senha = "SGSFDGDSGDSG";
	    	usuario.ADM = false;
	    	
	    	dao.atualizar(usuario);
			
			
			
			ArrayList<Usuario> usuarios = dao.listar();
			
			//for(Usuario: usuarios) {
				//System.out.println(it.getCodigo_usario()+" "+it.getQuant_atual_usuario());
			}
		}*/

	}

