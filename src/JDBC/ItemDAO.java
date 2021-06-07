package JDBC;

import java.util.ArrayList;

public interface ItemDAO {
	
	public void inserir(Item item);
	
	public void atualizar(Item item);
	
	public void remover(Item item);
	
	public ArrayList<Item> listar();
	
	
}