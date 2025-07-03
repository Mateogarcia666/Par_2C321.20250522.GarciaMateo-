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

        Label lblNombre = new Label("Nombre:");
        TextField campoNombre = new TextField();
        Label lblEmail = new Label("Email:");
        TextField campoEmail = new TextField();
        Label lblPass = new Label("Contraseña:");
        PasswordField campoPass = new PasswordField();

        Button btnLogin = new Button("Iniciar Sesión");
        Button btnRegistro = new Button("Registrarse");
        Label mensaje = new Label();

        btnLogin.setOnAction(e -> {
            Cliente cliente = controlador.login(campoNombre.getText(), campoEmail.getText(), campoPass.getText());
            if (cliente != null) {
                SalaView vista = new SalaView(stage, controlador, cliente);
                stage.setScene(new Scene(vista));
            } else {
                mensaje.setText("Usuario no registrado");
            }
        });

        btnRegistro.setOnAction(e -> {
            String nombre = campoNombre.getText();
            String email = campoEmail.getText();
            String pass = campoPass.getText();
            if (nombre.isEmpty() || email.isEmpty() || pass.isEmpty()){
                mensaje.setText("Debe completar los 3 datos");
                return;
            }
            if (controlador.registrar(nombre, email, pass)) {
                mensaje.setText("Registro exitoso. Ahora puede iniciar sesión.");
            } else {
                mensaje.setText("El email ya está registrado.");
            }
        });

        getChildren().addAll(lblNombre, campoNombre, lblEmail, campoEmail, lblPass, campoPass, btnLogin, btnRegistro, mensaje);
    }
}

