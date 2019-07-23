package com.ipartek.formacion.uf2218.accesoADAtos;
import java.io.Serializable;
import java.util.ArrayList;

import com.ipartek.formacion.uf2218.modelo.Usuario;


public class ListaUsuarios implements Crudable<Usuario>, Serializable{

	
	private ListaUsuarios() {
	}

	private static ListaUsuarios instancia;

	public static ListaUsuarios getInstance() {
		if (instancia == null) {
			instancia = new ListaUsuarios();
		}

		return instancia;
	}
	// Fin patr�n Singleton

	private ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
	
	
	
	@Override
	public Iterable<String> obtenerTodosLosNombres() {
		
		ArrayList<String> nombres = new ArrayList<Usuario>()
		
		Usuario user= new Usuario(name);
		usuarios.add(user);
		return nombres;
	}
	
	@Override
	public void cargarDB() {
		String request = "SELECT * FROM usuarios";
		// TODO Auto-generated method stub
	}
	
	@Override
	public Usuario obtenerPorId(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertar(Usuario objeto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modificar(Usuario objeto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void borrar(long id) {
		// TODO Auto-generated method stub
		
	}

}
