/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Mateo
 */
public class Cine implements Serializable {
    private List<Sala> salas;
    private List<Entrada> entradas;
    private List<Cliente> clientes;

    public Cine() {
        this.salas = new ArrayList<>();
        this.entradas = new ArrayList<>();
        this.clientes = new ArrayList<>();
    }

    public List<Sala> getSalas() { 
        return salas; }
    public List<Entrada> getEntradas() { 
        return entradas; }
    public List<Cliente> getClientes() { 
        return clientes; }

    public void agregarSala(Sala sala) { 
        salas.add(sala); 
    }
    public void agregarEntrada(Entrada entrada) { 
        entradas.add(entrada); 
    }
    public void agregarCliente(Cliente cliente) { 
        clientes.add(cliente); 
    }

    public Cliente buscarCliente(String email, String contrasenia) {
        for (Cliente c : clientes) {
            if (c.getEmail().equals(email) && c.getContrasenia().equals(contrasenia)) {
                return c;
            }
        }
        return null;
    }

    public boolean existeCliente(String email) {
        for (Cliente c : clientes) {
            if (c.getEmail().equals(email)) return true;
        }
        return false;
    }
} 

 

