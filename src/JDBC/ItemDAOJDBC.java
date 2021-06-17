package JDBC;


import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

//import Enum.ColunaBanco;
import model.Colunas;

public class ItemDAOJDBC implements ItemDAO {
	
	private JDBCUtil banco;
	
	public ItemDAOJDBC() {
		banco = new JDBCUtil();
	}

	
	@Override
	public void inserir(Item item) {
		
		String sql = "insert into item values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
		PreparedStatement preparedStatement;
		try {
			preparedStatement = banco.getConnection().prepareStatement(sql);
			
			preparedStatement.setString(1, item.getDescricao_item());
			preparedStatement.setString(2, item.getFornecedor_item());
			preparedStatement.setString(3, item.getMarca_item());
			preparedStatement.setInt(4, item.getCodigo_item());
			preparedStatement.setInt(5, item.getQuant_atual_item());
			preparedStatement.setString(6, item.getLocal_item());
			preparedStatement.setInt(7, item.getEstoque_min_item());
			preparedStatement.setInt(8, item.getEstoque_max_item());
			preparedStatement.setString(9, item.getReferencia_marca_item());
			java.sql.Date sqlDate = new java.sql.Date(item.getData_entrada_item().getTime());
			preparedStatement.setDate(10,  sqlDate);
			preparedStatement.setString(11, item.getEstado_item());
			preparedStatement.setString(12, item.getFoto_item());
			
			preparedStatement.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	
	@Override
	public void atualizar(Item item) {
		
		String sql = "update item set descricao_item=?, fornecedor_item=?, marca_item=?, quant_atual_item=?, local_item=?, "
				+ "estoque_min_item=?, estoque_max_item=?, referencia_marca_item=?, data_entrada_item=?, estado_item=?, "
				+ "foto_item=? where codigo_item=?;";
		
		PreparedStatement preparedStatement;
		try {
			preparedStatement = banco.getConnection().prepareStatement(sql);
			
			preparedStatement.setString(1, item.getDescricao_item());
			preparedStatement.setString(2, item.getFornecedor_item());
			preparedStatement.setString(3, item.getMarca_item());
			preparedStatement.setInt(4, item.getQuant_atual_item());
			preparedStatement.setString(5, item.getLocal_item());
			preparedStatement.setInt(6, item.getEstoque_min_item());
			preparedStatement.setInt(7, item.getEstoque_max_item());
			preparedStatement.setString(8, item.getReferencia_marca_item());
			preparedStatement.setDate(9,  (Date) item.getData_entrada_item());
			preparedStatement.setString(10, item.getEstado_item());
			preparedStatement.setString(11, item.getFoto_item());
			preparedStatement.setInt(12, item.getCodigo_item());
			
			preparedStatement.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}
	
	
	@Override
	public void remover(Item item) {
		
		String sql = "delete from item where codigo_item=?;";
		
		PreparedStatement preparedStatement;
		try {
			preparedStatement = banco.getConnection().prepareStatement(sql);
			
			preparedStatement.setInt(1, item.getCodigo_item());
			
			preparedStatement.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}

	
	@Override
	public ArrayList<Item> listar() {
		
		ArrayList<Item> itens = new ArrayList<Item>();
		
		String sql = "select * from item;";
		
		try {
			Statement statement = banco.getConnection().createStatement();
			
			ResultSet resultSet = statement.executeQuery(sql);
			
			while(resultSet.next()) {
				
				Item item = new Item();
					
				item.setDescricao_item(resultSet.getString(1));
				item.setFornecedor_item(resultSet.getString(2));
				item.setMarca_item(resultSet.getString(3));
				item.setCodigo_item(resultSet.getInt(4));
				item.setQuant_atual_item(resultSet.getInt(5));
				item.setLocal_item(resultSet.getString(6));
				item.setEstoque_min_item(resultSet.getInt(7));
				item.setEstoque_max_item(resultSet.getInt(8));
				item.setReferencia_marca_item(resultSet.getString(9));
				item.setData_entrada_item(resultSet.getDate(10));
				item.setEstado_item(resultSet.getString(11));
				item.setFoto_item(resultSet.getString(12));
				
				itens.add(item);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return itens;
	}
	
	public ArrayList<Item> buscar(String coluna, String buscar) {
		
		ArrayList<Item> itens = new ArrayList<Item>();
		
		Boolean tipo = false;
		String sql = "select * from item where "; 
		
		PreparedStatement preparedStatement = null;
		try {
			switch(coluna) {
			case "Descri��o":
				coluna = "descricao_item";
				break;
			case "C�digo":
				coluna = "codigo_item";
				tipo = true;
				break;
			case "Data":
				coluna = "data_entrada_item";
				break;
			case "Marca":
				coluna = "marca_item";
				break;
			case "Refer�ncia":
				coluna = "referencia_marca_item";
				break;
			case "Quantidade":
				coluna = "quant_atual_item";
				tipo = true;
				break;
			case "Local":
				coluna = "local_item";
				break;
			case "Estado":
				coluna = "estado_item";
				break;
		}
			//executa consultas diferentes de acordo com o tipo da dado pesquisado
			if (tipo) {
				sql = sql + coluna + " = " + buscar + ";";
				preparedStatement = banco.getConnection().prepareStatement(sql);
			}else if(!tipo) {
				sql = sql + coluna + " like '%" + buscar + "%';";
				preparedStatement = banco.getConnection().prepareStatement(sql);
			}else if(buscar.equalsIgnoreCase("")) {//serve para listar o estoque todo quando o campo buscar estiver vazio
				listar();
			}
			
			
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				
				Item item = new Item();
					
				item.setDescricao_item(resultSet.getString(1));
				item.setFornecedor_item(resultSet.getString(2));
				item.setMarca_item(resultSet.getString(3));
				item.setCodigo_item(resultSet.getInt(4));
				item.setQuant_atual_item(resultSet.getInt(5));
				item.setLocal_item(resultSet.getString(6));
				item.setEstoque_min_item(resultSet.getInt(7));
				item.setEstoque_max_item(resultSet.getInt(8));
				item.setReferencia_marca_item(resultSet.getString(9));
				item.setData_entrada_item(resultSet.getDate(10));
				item.setEstado_item(resultSet.getString(11));
				item.setFoto_item(resultSet.getString(12));
				
				itens.add(item);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return itens;
	}
	
public ArrayList<Item> buscarData(java.util.Date dataIni, java.util.Date dataFim) {
		
		ArrayList<Item> itens = new ArrayList<Item>();
		
		Boolean tipo = false;
		String sql = "select * from item where data_entrada_item between "; 
		
		PreparedStatement preparedStatement = null;
		try {
			sql = sql + "'" + dataIni + "' and '"+ dataFim + "' ;";
			preparedStatement = banco.getConnection().prepareStatement(sql);
			System.out.println(sql);
			//}else if(buscarData.equalsIgnoreCase("")) {//serve para listar o estoque todo quando o campo buscar estiver vazio
				//listar();
		
			
	
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				
				Item item = new Item();
					
				item.setDescricao_item(resultSet.getString(1));
				item.setFornecedor_item(resultSet.getString(2));
				item.setMarca_item(resultSet.getString(3));
				item.setCodigo_item(resultSet.getInt(4));
				item.setQuant_atual_item(resultSet.getInt(5));
				item.setLocal_item(resultSet.getString(6));
				item.setEstoque_min_item(resultSet.getInt(7));
				item.setEstoque_max_item(resultSet.getInt(8));
				item.setReferencia_marca_item(resultSet.getString(9));
				item.setData_entrada_item(resultSet.getDate(10));
				item.setEstado_item(resultSet.getString(11));
				item.setFoto_item(resultSet.getString(12));
				
				itens.add(item);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return itens;
	}


}


