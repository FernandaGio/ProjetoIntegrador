package JDBC;

import java.util.ArrayList;
import java.util.Date;

public interface ItemDAO {
	
	public void inserir(Item item);
	
	public void atualizar(Item item);
	
	public void remover(Item item);
	
	public ArrayList<Item> listar();

	public ArrayList<Item> buscar(String coluna, String buscar);
	
	public ArrayList<Item> buscarData(Date dataIni, Date dataFim);
	
}

