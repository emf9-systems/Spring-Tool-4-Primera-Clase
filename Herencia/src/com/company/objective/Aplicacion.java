package com.company.objective;

public class Aplicacion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Vehiculo auto1 = new Vehiculo("Rojo");
		
		System.out.println("El color de auto1 es: "+auto1.getColor());
		
		Auto auto2 = new Auto(1996, "Honda", "Civic (Hatchback)", "Verde", 4, 3);
		
		auto2.imprimeMarcaModelo();
		auto1.imprimeMarcaModelo();

	}

}
