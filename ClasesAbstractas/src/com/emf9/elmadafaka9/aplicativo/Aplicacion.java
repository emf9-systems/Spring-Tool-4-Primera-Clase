package com.emf9.elmadafaka9.aplicativo;

import com.emf9.elmadafaka9.clases.*;

public class Aplicacion {

	public static void main(String[] args) {
		
		Cuadrado cuad1 = new Cuadrado(10);
		TrianguloEq eq1 = new TrianguloEq(10, 5);
		
		System.out.println("Area del cuadrado: "+cuad1.area());
		System.out.println("Area del triangulo: "+eq1.area());
		
	}

}
