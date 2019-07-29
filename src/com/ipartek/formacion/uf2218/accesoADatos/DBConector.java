package com.ipartek.formacion.uf2218.accesoADatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author sqlitetutorial.net
 */

public class DBConector {
	/**
	 * Connect to a sample database
	 */
	static Connection conn = null;
	static DBConector conector = null;
	static String s = "WebContent/DataBase/Usuarios.db";
	String url = "jdbc:sqlite:" + s;

	public static DBConector getConnection() {
		if (conector == null) {
			try {
				Class.forName("org.sqlite.JDBC");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			conector = new DBConector();
		}
		return conector;
	}
	public static DBConector getConnection(String url) {
		if (conector == null) {
			s=url;
			try {
				Class.forName("org.sqlite.JDBC");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			conector = new DBConector();
		}
		return conector;
	}

	private DBConector() {
		try {
			// db parameters

//            Path currentRelativePath = Paths.get("");
//            String s = currentRelativePath.toAbsolutePath().toString();

			System.out.println(s);
			// create a connection to the database
			conn = DriverManager.getConnection(url);

			System.out.println("Connection to SQLite has been established.");

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

//    /**
//     * @param args the command line arguments
//     */
//    public static void main(String[] args) {
//    	//testeo
//    	getConnection();
//    	update("INSERT INTO users(id, name, password, admin) VALUES(2,'user','user',FALSE)");
//        ResultSet rs = query("SELECT * FROM users");
//        try {
//        	while(rs.next()) {
//        		System.out.println(rs.getString(2));
//        	}
//			
//			
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//    }

	public static ResultSet query(String request) {
		ResultSet rs = null;
		Statement st = null;
		try {
			st = conn.createStatement();
			rs = st.executeQuery(request);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;

	}

	public static boolean update(String request) {
		Statement st = null;
		try {
			st = conn.createStatement();
			st.executeUpdate(request);

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;

	}
}