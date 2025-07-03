/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import modelo.Cine;
import modelo.Sala;

/**
 *
 * @author Mateo
 */
public class PersistenciaDatos {
  private static final String ARCHIVO = "cine.ser";

    public static void guardar(Cine cine) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ARCHIVO))) {
            oos.writeObject(cine);
        } catch (IOException e) {
            System.out.println("Error al guardar los datos: " + e.getMessage());
        }
    }

    public static Cine cargar() {
        File archivo = new File(ARCHIVO);
        if (!archivo.exists()) {
            // Si no existe el archivo, crear un cine por defecto con una sala
            Cine cine = new Cine();
            cine.agregarSala(new Sala(1, "Matrix", 5, 6));
            cine.agregarSala(new Sala(2, "Interestelar", 4, 5));
            return cine;
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(ARCHIVO))) {
            return (Cine) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("No se pudo cargar el archivo, se crea un cine nuevo.");
            return new Cine();
        }
    }
}

