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
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import modelo.Cliente;

/**
 *
 * @author Mateo
 */
public class LoginView extends VBox {
     public LoginView(Stage stage, ControladorCine controlador) {
        setSpacing(10);
        setPadding(new Insets(20));

        Label lblEmail = new Label("Email:");
        TextField campoEmail = new TextField();
        Label lblPass = new Label("Contraseña:");
        PasswordField campoPass = new PasswordField();

        Button btnLogin = new Button("Iniciar Sesión");
        Button btnRegistro = new Button("Registrarse");
        Label mensaje = new Label();

        btnLogin.setOnAction(e -> {
            Cliente cliente = controlador.login(campoEmail.getText(), campoPass.getText());
            if (cliente != null) {
                SalaView vista = new SalaView(stage, controlador, cliente);
                stage.setScene(new Scene(vista));
            } else {
                mensaje.setText("Credenciales incorrectas");
            }
        });

        btnRegistro.setOnAction(e -> {
            boolean registrado = controlador.registrar(campoEmail.getText(), campoPass.getText());
            if (registrado) {
                mensaje.setText("Registro exitoso. Ahora puede iniciar sesión.");
            } else {
                mensaje.setText("El email ya está registrado.");
            }
        });

        getChildren().addAll(lblEmail, campoEmail, lblPass, campoPass, btnLogin, btnRegistro, mensaje);
    }
}

