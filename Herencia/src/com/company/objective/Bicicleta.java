package com.company.objective;

public class Bicicleta extends Vehiculo implements ManejarVehiculo{
	
	public static int limiteVelocidad = 35;
	
	public void acelerar() {
		System.out.println("Estas pedaleando");
		velocidad++;
		System.out.println("Tu velocidad es: "+velocidad+" km/h");
	}
	
	public void desacelerar() {
		System.out.println("Estas frenando con los frenos y los pies de manera controlada");
		velocidad--;
		System.out.println("Tu velocidad es: "+velocidad+" km/h");
	}
}
