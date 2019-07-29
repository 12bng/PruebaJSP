package com.ipartek.formacion.uf2218.accesoADatos;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.ipartek.formacion.uf2218.modelo.Usuario;

public class ListaUsuarios implements Crudable<Usuario>, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3399782236567922862L;
	DBConector conexion = DBConector.getConnection();

	private ListaUsuarios() {
	}

	private static ListaUsuarios instancia;

	public static ListaUsuarios getInstance() {
		if (instancia == null) {
			instancia = new ListaUsuarios();
			DBConector.getConnection();
		}

		return instancia;
	}
	// Fin patrón Singleton

	private ArrayList<Usuario> usuarios = new ArrayList<Usuario>();

	@Override
	public Iterable<String> obtenerTodosLosNombres() {

		ResultSet rs = DBConector.query("SELECT name FROM users");
		ArrayList<String> lista = new ArrayList<String>();
		try {
			while (rs.next()) {
				lista.add(rs.getString(0));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lista;
	}

	@Override
	public ArrayList<Usuario> cargarDB() {
		String query = "SELECT name, admin FROM users";
		ResultSet rs = DBConector.query(query);
		try {
			while (rs.next()) {
				//System.out.println(rs.getString(1));
				usuarios.add(new Usuario(rs.getString(1), rs.getBoolean(2)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return usuarios;
	}

	@Override
	public Usuario obtenerPorId(long id) {
		String query = "SELECT name, admin FROM usuarios WHERE id=" + id + ";";
		DBConector.query(query);
		return null;
	}

	@Override
	public void insertar(Usuario objeto) {
		String name = objeto.getNick();
		String password = objeto.getPassword();
		Boolean admin = objeto.isAdmin();
		String query = "INSERT INTO users(name, password, admin) VALUES('" + name + "','" + password + "'," + admin
				+ ")";
		DBConector.update(query);
	}

	@Override
	public void modificar(Usuario objeto) {
		String name = objeto.getNick();
		String password = objeto.getPassword();
		Boolean admin = objeto.isAdmin();
		String query = "UPDATE users SET password='" + password + "', admin=" + admin + " WHERE name='" + name + "';";
		DBConector.update(query);
	}

	@Override
	public void borrar(long id) {
		String query = "DELETE FROM users WHERE id=" + id + ";";
		DBConector.update(query);

	}

	@Override
	public Boolean login(String name, String password) {
		String query = "SELECT name FROM users WHERE name = '" + name + "' AND password = '" + password + "';";
		try {
			return (DBConector.query(query).next());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Boolean isAdmin(String name) {

		String query = "SELECT admin FROM users WHERE name = '" + name + "';";
		try {
			System.out.println(DBConector.query(query).getBoolean(1));
			return DBConector.query(query).getBoolean(1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	};

}
