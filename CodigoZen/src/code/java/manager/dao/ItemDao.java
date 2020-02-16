package code.java.manager.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import code.java.manager.model.Item;
import code.java.manager.utils.JDBCUtils;

public class ItemDao {

	/**
	 * Criando Constantes com os scripts Sql
	 */
	private static final String INSERTITEM = "INSERT INTO itens(Name, Vehicleapplication, NetWeight, GrossWeight) VALUES (?, ?, ?, ?);";
	private static final String SELECTBYID = "SELECT Id, Name, Vehicleapplication, NetWeight, GrossWeight FROM itens WHERE Id = ? order by Name asc";
	private static final String SELECTALL = "SELECT * FROM itens order by Name asc";
	private static final String DELETEITEM = "DELETE FROM itens WHERE Id =?;";
	private static final String UPDATEITEM = "UPDATE itens SET Name=?, Vehicleapplication=?, NetWeight=?, GrossWeight=? WHERE Id = ?;";

	/**
	 * 
	 * Metodo para inserir dados
	 */

	public void insertItem(Item item) {
		/**
		 * Tentando inserir os dados
		 */
		try (Connection connection = JDBCUtils.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(INSERTITEM)) {
			preparedStatement.setString(1, item.getName());
			preparedStatement.setString(2, item.getVehicleAply());
			preparedStatement.setFloat(3, item.getPesoLiquido());
			preparedStatement.setFloat(4, item.getPesoBruto());
			preparedStatement.executeUpdate();

		} catch (Exception e) {
			System.err.println(e.getLocalizedMessage());
		}
	}

	/**
	 * Metodo par Buscar os dados no banco
	 */
	public Item selectItem(int idb) {
		Item item = null;
		try (Connection connection = JDBCUtils.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SELECTBYID)) {
			preparedStatement.setInt(1, idb);
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				int id = resultSet.getInt("Id");
				String name = resultSet.getString("Name");
				String vehicleAply = resultSet.getString("Vehicleapplication");
				float pesoLiquido = resultSet.getFloat("NetWeight");
				float pesoBruto = resultSet.getFloat("GrossWeight");

				item = new Item(id ,name, vehicleAply, pesoLiquido, pesoBruto);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return item;
	}

	/**
	 * Metodo que busca todos os Itens dos banco
	 */
	public List<Item> selectItens() {
		List<Item> itens = new ArrayList<>();
		try (Connection connection = JDBCUtils.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SELECTALL)) {
			System.out.println(preparedStatement);
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				int id = resultSet.getInt("Id");
				String name = resultSet.getString("Name");
				String vehicle = resultSet.getString("Vehicleapplication");
				float pesoLiquido = resultSet.getFloat("NetWeight");
				float pesoBruto = resultSet.getFloat("GrossWeight");
				itens.add(new Item(id, name, vehicle, pesoLiquido, pesoBruto));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return itens;
	}

	/**
	 * Metodo para deletar item do banco
	 * 
	 * @throws SQLException
	 */
	public boolean deleteItem(int id) {
		boolean qtdDeleted =false;
		try (Connection connection = JDBCUtils.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(DELETEITEM)) {
			preparedStatement.setInt(1, id);
			qtdDeleted = preparedStatement.executeUpdate() > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return qtdDeleted;
	}

	/**
	 * Metodo que realiza update dos dados
	 * 
	 * @throws SQLException
	 */
	public boolean updateItem(Item item){
		boolean qtdUpdated = false;
		try (Connection connection = JDBCUtils.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(UPDATEITEM)) {
			preparedStatement.setString(1, item.getName());
			preparedStatement.setString(2, item.getVehicleAply());
			preparedStatement.setFloat(3, item.getPesoLiquido());
			preparedStatement.setFloat(4, item.getPesoBruto());
			preparedStatement.setInt(5, item.getId());
			qtdUpdated = preparedStatement.executeUpdate() > 0;

		}catch (Exception e) {
			e.printStackTrace();
		}
		return qtdUpdated;
	}
}
