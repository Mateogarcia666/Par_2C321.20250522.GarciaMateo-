/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import modelo.Entrada;
import controlador.ControladorCine;
import javafx.scene.control.Alert;
import javafx.scene.layout.GridPane;
import modelo.Butaca;
import modelo.Cliente;
import modelo.Sala;



/**
 *
 * @author Mateo
 */
public class CompraView extends VBox{
    public CompraView(Stage stage, ControladorCine controlador, Cliente cliente, Sala sala) {
        setSpacing(10);
        setPadding(new Insets(20));

        Label titulo = new Label("Elija una butaca - " + sala.getPelicula());
        Label disponible = new Label("Butacas libres O | butacas ocupadas X");
        GridPane grid = new GridPane();

        for (int i = 0; i < sala.getButacas().length; i++) {
            for (int j = 0; j < sala.getButacas()[i].length; j++) {
                Butaca b = sala.getButacas()[i][j];
                // aca uso x para butacas ocupadas y o para butacas libres
                Button btn = new Button(b.estaOcupada() ? "X" : "O");
                btn.setDisable(b.estaOcupada());
                int fila = i;
                int col = j;
                btn.setOnAction(e -> {
                    b.ocupar();
                    Entrada entrada = new Entrada(cliente, sala, b);
                    controlador.registrarEntrada(entrada);
                    controlador.guardar();
                    Alert alerta = new Alert(Alert.AlertType.INFORMATION, "Compra realizada!");
                    alerta.showAndWait();
                    stage.setScene(new Scene(new SalaView(stage, controlador, cliente)));
                });
                grid.add(btn, j, i);
            }
        }
        
        Button btnVolver = new Button("Volver");
        btnVolver.setOnAction(e -> {
            // Volver a la vista anterior de salas
            stage.setScene(new Scene(new SalaView(stage, controlador, cliente)));
        });
        
        getChildren().addAll(titulo, disponible, grid, btnVolver);
    }
}

