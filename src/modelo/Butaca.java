/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.io.Serializable;

/**
 *
 * @author Mateo
 */
public class Butaca implements Serializable {
   private int fila;
   private int numero;
   private boolean ocupada;

    public Butaca(int fila, int numero) {
        this.fila = fila;
        this.numero = numero;
        this.ocupada = false;
    }

    public int getFila() { return fila; }
    public int getNumero() { return numero; }
    public boolean estaOcupada() { return ocupada; }
    public void ocupar() { ocupada = true; }
}



