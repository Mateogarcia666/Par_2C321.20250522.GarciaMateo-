/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.util.List;
import modelo.Butaca;
import modelo.Cine;
import modelo.Cliente;
import modelo.Entrada;
import modelo.Sala;
import persistencia.PersistenciaDatos;

/**
 *
 * @author Mateo
 */
public class ControladorCine {
    private static ControladorCine instancia;
    private Cine cine;
    private Cliente clienteActual;

    private ControladorCine() {
        cine = PersistenciaDatos.cargar();
    }

    public static ControladorCine getInstancia() {
        if (instancia == null) instancia = new ControladorCine();
        return instancia;
    }

    public Cine getCine() {
        return cine;
    }

    public Cliente getClienteActual() {
        return clienteActual;
    }

    public Cliente login(String email, String pass) {
        Cliente c = cine.buscarCliente(email, pass);
        if (c != null) clienteActual = c;
        return c;
    }

    public boolean registrar(String email, String pass) {
        if (cine.existeCliente(email)) return false;
        Cliente nuevo = new Cliente("Cliente", email, pass);
        cine.agregarCliente(nuevo);
        PersistenciaDatos.guardar(cine);
        return true;
    }

    public void comprarEntrada(Sala sala, int fila, int col) {
        Butaca b = sala.getButaca(fila, col);
        if (!b.estaOcupada()) {
            b.ocupar();
            Entrada e = new Entrada(clienteActual, sala, b);
            cine.agregarEntrada(e);
            PersistenciaDatos.guardar(cine);
        }
    }
    public void registrarEntrada(Entrada entrada) {
        // lógica para agregar la entrada al cine, ej:
        cine.agregarEntrada(entrada);
    }

    public void guardar() {
        PersistenciaDatos.guardar(cine);
    }
    
    public List<Sala> getSalas() {
        return cine.getSalas();
    }
}

