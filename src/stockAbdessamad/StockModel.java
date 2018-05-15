package stockAbdessamad;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import connexion.PoolDeConnexion;
import dao.MagasinsDAO;
import pojo.Stock;

public class StockModel extends AbstractTableModel {

	private final String[] entetes = { "Produit", "Magasin", "Quantit�", "Date entree", "Date sortie", "Motif Entree" };

	private List<Stock> listStock;

	public StockModel(List<Stock> listStock) {
		this.listStock = listStock;
	}

	@Override
	public int getRowCount() {
		return listStock.size();
	}

	@Override
	public int getColumnCount() {
		return entetes.length;
	}

	@Override
	public String getColumnName(int columnIndex) {
		return entetes[columnIndex];
	}

	/**
	 * 
	 */
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		PoolDeConnexion connection = new PoolDeConnexion(5);
		MagasinsDAO magasinDAO = new MagasinsDAO(connection.getConnection());
		String magasinName = "";
		switch (columnIndex) {
		case 0: {
			return listStock.get(rowIndex).getIdProduct();
		}
		case 1: {
			magasinName = magasinDAO.find(listStock.get(rowIndex).getIdMagasin()).getMagasinName();
			return magasinName;

		}

		case 2: {
			return listStock.get(rowIndex).getQuantite();
		}
		case 3: {

			return listStock.get(rowIndex).getDateEntree();
		}
		case 4: {

			return listStock.get(rowIndex).getDateSortie();
		}
		case 5: {
			return listStock.get(rowIndex).getMotifEntree();
		}

		default:
			throw new IllegalArgumentException();
		}
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		switch (columnIndex) {
		case 0:
		case 1:
			return Integer.class;

		case 3:
			return String.class;

		case 2:
			return Integer.class;

		case 4:
			return Integer.class;

		default:
			return Object.class;
		}
	}

}
