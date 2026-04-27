package com.cebem.demo.controllers;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cebem.demo.models.LuzModel;

import org.springframework.web.bind.annotation.RequestParam;


// Se encarga de:
// - Recibir las peticiones del cliente
// - Llamar al servicio correspondiente para procesar la petición
// - Enviar la respuesta al cliente


@RestController
public class HelloController {
    
    @GetMapping("/")
    public String Hello() {
        return "Hello, World!";
    }

    @GetMapping("/encender")
    public String encender() {
        // Programa encender luz
        return "Luz encendida";
    }

    @GetMapping("/apagar")
    public String apagar(@PathVariable Long numLuz) {
        // Programa apagar luz
        return "Luz apagada número: "+numLuz;
    }

    @GetMapping("/estado")
    public String verEstado(
        @RequestParam String lugar,
        @RequestParam String nombre){
            return "Vamos a ver el estado de la luz, "+lugar+" con nombre "+nombre;
    }

    @PostMapping("/crear_luz")
    public String crearLuzNueva(@RequestBody LuzModel nuevaLuz){
        // Añadir una nueva luz al sistema
        return "Luz nueva creada "+nuevaLuz.nombre+" en la localización "+nuevaLuz.localizacion;
    }

    //Borrar luz!!
    //DELETE http://localhost:8080/borrar_luz
    @DeleteMapping("/borrar_luz/{id}")
    public String borrarLuz(@PathVariable long id){
        return "Luz borrada correctamente "+id; 
    }

    @PostMapping("/cambiar luz")
    public String cambiarLuz(@PathVariable long id,
                            @RequestBody LuzModel nuevaLuz){ {        
        return "La luz se cambio correctamente: "+id+" a "+nuevaLuz.nombre+" en la localización "+nuevaLuz.localizacion;
        }
    }
    
    // Hacer un endpoint al que le pases un número (como parametro) y te diga si es par o impar
    // GET http://localhost:8080/es_par/XXX  -->   si XXX es par o impar

    @GetMapping("/par/{numero}")
    public String par(@PathVariable int numero) {
        if (numero % 2 == 0) {
            return "El número " + numero + " es par.";
        } else {
            return "El número " + numero + " es impar.";
        }
    }
    

    // Hacer un endpoint al que le pases 2 numeros (como query params) y los multiplique
    // GET http://localhost:8080/sumar?num1=xxx&num2=yyy      -->    xxx * yyy

    @GetMapping("/sumar") // El enunciado dice multiplicar, pero la URL dice sumar. ¡Hagamos la multiplicación!
    public String multiplicar(@RequestParam float num1, @RequestParam float num2) {
        float resultado = num1 * num2;
        return "El resultado de multiplicar " + num1 + " por " + num2 + " es: " + resultado;
    }

    // Hacer un endpoint que dado un usuario borre un post del mismo
    // DELETE http://localhost:8080/usuario/XXX/post/YYY    --> Borra el post YYY del usuario XXX

    @GetMapping("/usuario/{usuarioId}/post/{postId}")
    public String borrarPost(@PathVariable String usuarioId, @PathVariable String postId) {
        return "Se ha borrado el post %s del usuario %s".formatted(postId, usuarioId);
    }

}
    
