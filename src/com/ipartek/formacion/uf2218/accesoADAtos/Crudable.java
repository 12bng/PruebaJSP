package com.ipartek.formacion.uf2218.accesoADAtos;

public interface Crudable<T> {
	// Create
	// Retrieve
	// Update
	// Delete
	public void cargarDB();
	public Iterable<T> obtenerTodosLosNombres();

	public T obtenerPorId(long id);

	public void insertar(T objeto);

	public void modificar(T objeto);

	public void borrar(long id);
}
