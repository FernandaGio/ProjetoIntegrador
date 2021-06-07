package JDBC;

import java.util.ArrayList;

public class JDBC {
	
	public static void main(String[] args) {
		

		// TESTANDO MÉTODO DE INSERIR
		Item item = new Item("Plug3P+32A Vermelho", "9881 Steck Indústria Elétrica  LTDA", "Steck", 10, 56, "AB", 8, 60, 
				"4274", "2002-02-20", "Ativo", "exemplo");
		
		ItemDAO dao = new ItemDAOJDBC();
		
		dao.inserir(item);
		
		
//TESTANDO MÉTODO DE ATUALIZAR
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
}
