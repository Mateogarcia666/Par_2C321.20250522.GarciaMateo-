/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista;

import controlador.ControladorCine;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import modelo.Butaca;
import modelo.Cliente;
import modelo.Sala;

/**
 *
 * @author Mateo
 */
public class SalaView extends VBox {
    public SalaView(Stage stage, ControladorCine controlador, Cliente cliente) {
        setSpacing(10);
        setPadding(new Insets(20));

        for (Sala sala : controlador.getSalas()) {
            Button btn = new Button("Sala " + sala.getNumero() + ": " + sala.getPelicula());
            btn.setOnAction(e -> {
                CompraView vista = new CompraView(stage, controlador, cliente, sala);
                stage.setScene(new Scene(vista));
            });
            getChildren().add(btn);
        }

        Button btnSalir = new Button("Salir");
        btnSalir.setOnAction(e -> {
            controlador.guardar();
            stage.setScene(new Scene(new LoginView(stage, controlador), 400, 300));
        });

        getChildren().add(btnSalir);
    }
}





