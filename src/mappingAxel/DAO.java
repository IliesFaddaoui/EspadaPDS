package mappingAxel;

import java.sql.Connection;

public abstract class DAO<T> {

	protected Connection connect = null;
	
	public DAO(Connection conn){
		this.connect= conn;
	}
	
	public DAO() {
		
	}
	
	/**
	 * This method adds a line on the table
	 * @param obj
	 * @return boolean
	 */
	public abstract boolean create(T obj);

	/**
	 * This method deletes a line on the table
	 * @param obj
	 * @return boolean
	 */
	public abstract boolean delete(T obj);

	/**
	 * This method updata the data for a choosen line on the table
	 * @param obj
	 * @return boolean
	 */
	public abstract boolean update(T obj);

	/**
	 * This method looks and find on the table an asked line
	 * @param id
	 * @return
	 */
	public abstract T find(int id);
	
}
