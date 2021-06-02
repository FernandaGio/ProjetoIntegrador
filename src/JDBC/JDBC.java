package JDBC;

import java.util.ArrayList;

public class JDBC {
	
	public static void main(String[] args) {
		
		//Item item = new Item("Plug3P+32A", "9881 Steck Indústria Elétrica  LTDA", "Steck", "101", 55, "AB", 8, 60, 
		//		"4273", "00/00/00", "Ativo", "exemplo");
		
		//ItemDAO dao = new ItemDAOJDBC();
		
		//dao.inserir(item);
		
		
		
		Item item = new Item();
		
		ItemDAO dao = new ItemDAOJDBC();
		
		//dao.atualizar(item);
		
		dao.remover(item);
		
		
		
		//ArrayList<Item> itens = dao.listar();
		
		//for(Item it: itens) {
		//	System.out.println(it.getCodigo_item()+" "+it.getQuant_atual_item());
		//}
	}
}