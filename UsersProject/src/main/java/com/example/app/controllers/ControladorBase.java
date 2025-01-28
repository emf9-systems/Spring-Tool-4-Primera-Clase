package com.example.app.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//@Anotacion
@RestController//Indica que el archivo es un controlador, estableciendo rutas
public class ControladorBase {
	
	//No puedo repetir ni la ruta ni el nombre del metodo(Excepcion: sobrecarga)
	@GetMapping("/")//Establezco una ruta en especifico que ejecuta el metodo y muestra el return
	public String hola() {
		return "<h1><strong>Hola desde Spring!!!</strong></h1>";
	}
	
	@GetMapping("/muestra")
	public String muestraUsuarios() {
		String usuarios[] = {"Don Pollo", "Walter Hartwell White", "Quandale Dingle"};
		String respuesta = "<ul>";
		
		for (int i = 0; i < usuarios.length; i++) {
			respuesta += "<li>"+usuarios[i]+"</li>";
		}
		respuesta += "</ul>";
		
		return respuesta;
	}

	@GetMapping("/search") // localhost:8080/search?q=sts
	public String buscar(@RequestParam(value="q") String termino) {
	    // termino = "sts"
	    return "<h1>Estás buscando: " + termino + "</h1>"; // Estás buscando: sts
	}
	
	@GetMapping("/hola") // localhost:8080/hola?nombre=
	public String hola(@RequestParam(value="nombre", required = false) String name) {
		if (name == null) {
			return "<h2>Hola desconocido!</h2>";
		}
	    return "<h2>¡Hola " + name + "!</h2>"; // ¡Hola <nombre>!
	}
	
	@GetMapping("/holaConApellido") // localhost:8080/holaConApellido?nombre=<nombre>&apellido=<apellido>
	public String holaConApellido(
	    @RequestParam(value="nombre") String firstName, // firstName = <nombre>
	    @RequestParam(value="apellido") String lastName // lastName = <apellido>
	) {
	    return "Saludos cordiales " + firstName + " " + lastName;
	}
	
	@GetMapping("/hello/{nombre}") // localhost:8080/hello/nombre
	public String hello(@PathVariable("nombre") String name) {
	    return "<h1>Hello " + name + "</h1>"; // Devuelve la búsqueda como respuesta
	}
	
	@GetMapping("/hello/{nombre}/{apellido}") // localhost:8080/hello/nombre/apellido
	public String hello(
	    @PathVariable("nombre") String name,
	    @PathVariable("apellido") String lastName
	) {
	    return "<h1>Hello " + name + " " + lastName + "</h1>"; // Respuesta para nombre y apellido
	}
	
	@GetMapping("/hello/{nombre}/{apellido}/{cantidad}") // localhost:8080/hello/nombre/apellido/cantidad
	public String hello(
	    @PathVariable("nombre") String name,
	    @PathVariable("apellido") String lastName,
	    @PathVariable("cantidad") int times
	) {
	    String respuesta = "";
	    for (int i = 0; i < times; i++) {
	        respuesta += "<h2>Hello "+ name + " " + lastName+"</h2>";
	        }
	    respuesta += "</h1>";
	    return respuesta; // Devuelve la cadena construida
	}



}
