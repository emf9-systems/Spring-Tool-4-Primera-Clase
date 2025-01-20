package com.company.objective;

public interface ManejarVehiculo {
	/*Metodo DEFAULT: No necesita ser implementado sino que directamente 
	 *el comportamiento se hereda hacia la clase que implementa la interfaz
	 */
	
	public default void manejar() {
		System.out.println("Se esta manejando el Vehiculo");
	}
	
	/*Abstracto: es aquel que OBLIGAMOS a nuestra clase a implementar */
	
	abstract void acelerar();
	abstract void desacelerar();
	
	/*Estatico: Es aquel que pertenece a la interfaz AYUDANTE */
	
	
	
}
