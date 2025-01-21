package com.emf9.elmadafaka9.clases;

public class Cuadrado extends Figura{
	
	private double longitud;

	public Cuadrado(double longitud) {
		super();
		this.longitud = longitud;
	}
	
	public double area() {
		return longitud * longitud;
	}

}
