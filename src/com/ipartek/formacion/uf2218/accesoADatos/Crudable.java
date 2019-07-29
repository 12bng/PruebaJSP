package com.ipartek.formacion.uf2218.accesoADatos;

import java.util.ArrayList;

import com.ipartek.formacion.uf2218.modelo.Usuario;

public interface Crudable<T> {
	// Create
	// Retrieve
	// Update
	// Delete
	public ArrayList<Usuario> cargarDB();

	public Iterable<String> obtenerTodosLosNombres();

	public T obtenerPorId(long id);

	public void insertar(T objeto);

	public void modificar(T objeto);

	public void borrar(long id);

	public Boolean login(String name, String password);

	public Boolean isAdmin(String name);
}
