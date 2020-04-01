package kaj.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kaj.model.application;

/**
 * AbstractDAO.java This DAO class provides CRUD database operations for the
 * table users in the database.
 * 
 * @author Ramesh Fadatare
 *
 */
public class applicationDAO {
	private String jdbcURL = "jdbc:mysql://localhost:3306/rits_db?useSSL=false";
	private String jdbcUsername = "root";
	private String jdbcPassword = "wangkhei123";

	private static final String INSERT_APPLICATION_SQL = "INSERT INTO application" + "  (refno, ptitle, jrname, doi, jcat, firstauthor, fauthor, seauthor, secondauthor, sauthor, thauthor, thirdauthor, tauthor, otherauthor, incentiveF, incentiveS, incentiveT, totalincentive) VALUES "
			+ " (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";

	private static final String SELECT_APPLICATION_BY_ID = "select refno, ptitle, firstauthor from application where id =?";
	private static final String SELECT_ALL = "select * from application";
	//private static final String DELETE_APPLICATION_SQL = "delete from applicaton where id = ?;";
	//private static final String UPDATE_APPLICATION_SQL = "update application set ptitle = ? where id = ?;";

	public applicationDAO() {
	}

	protected Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}

	public void insertApplication(application app) throws SQLException {
		System.out.println(INSERT_APPLICATION_SQL);
		// try-with-resource statement will auto close the connection.
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_APPLICATION_SQL)) {
			preparedStatement.setString(1, app.getREFNO());
			preparedStatement.setString(2, app.getTitle());
			preparedStatement.setString(3, app.getjournal());
			preparedStatement.setString(4, app.getDOI());
			preparedStatement.setString(5, app.getJCAT());
			preparedStatement.setString(6, app.getFIRSTAUTHOR());
			preparedStatement.setString(7, app.getFAUTHOR());
			preparedStatement.setString(8, app.getSEAUTHOR());
			preparedStatement.setString(9, app.getSECONDAUTHOR());
			preparedStatement.setString(10, app.getSAUTHOR());
			preparedStatement.setString(11, app.getTHAUTHOR());
			preparedStatement.setString(12, app.getTHIRDAUTHOR());
			preparedStatement.setString(13, app.getTAUTHOR());
			preparedStatement.setString(14, app.getOTHERAUTHOR());
			preparedStatement.setString(15, app.getINCENTIVEF());
			preparedStatement.setString(16, app.getINCENTIVES());
			preparedStatement.setString(17, app.getINCENTIVET());
			preparedStatement.setString(18, app.getTOTALINCENTIVE());
			
			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			printSQLException(e);
		}
	}

	public application selectApplication(int id) {
		application app = null;
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();
				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_APPLICATION_BY_ID);) {
			preparedStatement.setInt(1, id);
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				String refno = rs.getString("refno");
				String ptitle = rs.getString("ptitle");
				String firstauthor = rs.getString("firstauthor");
				app = new application(id, refno, ptitle, firstauthor);
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return app;
	}

	public List<application> selectAll() {

		// using try-with-resources to avoid closing resources (boiler plate code)
		List<application> apps = new ArrayList<>();
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();

				// Step 2:Create a statement using connection object
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL);) {
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				int id = rs.getInt("id");
				String refno = rs.getString("refno");
				String ptitle = rs.getString("ptitle");
				String jrname = rs.getString("jrname");
				String doi = rs.getString("doi");
				String jcat = rs.getString("jcat");
				String firstauthor = rs.getString("firstauthor");
				String secondauthor = rs.getString("secondauthor");
				String thirdauthor = rs.getString("thirdauthor");
				apps.add(new application(id, refno, ptitle, jrname, doi, jcat, firstauthor, secondauthor, thirdauthor));
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return apps;
	}

	/*public boolean deleteUser(int id) throws SQLException {
		boolean rowDeleted;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(DELETE_USERS_SQL);) {
			statement.setInt(1, id);
			rowDeleted = statement.executeUpdate() > 0;
		}
		return rowDeleted;
	} */

	/*public boolean updateUser(User user) throws SQLException {
		boolean rowUpdated;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(UPDATE_USERS_SQL);) {
			statement.setString(1, user.getName());
			statement.setString(2, user.getEmail());
			statement.setString(3, user.getCountry());
			statement.setInt(4, user.getId());

			rowUpdated = statement.executeUpdate() > 0;
		}
		return rowUpdated;
	} */

	private void printSQLException(SQLException ex) {
		for (Throwable e : ex) {
			if (e instanceof SQLException) {
				e.printStackTrace(System.err);
				System.err.println("SQLState: " + ((SQLException) e).getSQLState());
				System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
				System.err.println("Message: " + e.getMessage());
				Throwable t = ex.getCause();
				while (t != null) {
					System.out.println("Cause: " + t);
					t = t.getCause();
				}
			}
		}
	}

}
