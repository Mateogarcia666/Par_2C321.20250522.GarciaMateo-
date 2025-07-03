/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Cineapp;

import controlador.ControladorCine;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import vista.LoginView;

/**
 *
 * @author Mateo
 */
public class VentaEntradasCine extends Application {
      @Override
    public void start(Stage primaryStage) {
        ControladorCine controlador = ControladorCine.getInstancia();
        LoginView login = new LoginView(primaryStage, controlador);
        primaryStage.setScene(new Scene(login, 400, 300));
        primaryStage.setTitle("Sistema de Venta de Entradas - Cine");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
