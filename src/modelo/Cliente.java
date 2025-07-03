/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author Mateo
 */
public class Cliente implements Serializable {
     private String nombre;
    private String email;
    private String contrasenia;

    public Cliente(String nombre, String email, String contrasenia) {
        this.nombre = nombre;
        this.email = email;
        this.contrasenia = contrasenia;
    }

    public String getNombre() { 
        return nombre; 
    }
    public String getEmail() { 
        return email; 
    }
    public String getContrasenia() { 
        return contrasenia; 
    }
}


