package gui.controllers;

import common.client.ClientExecutor;
import common.product.Product;
import gui.Main;
import gui.views.ViewsManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.SocketException;
import java.net.URL;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ConnectionController implements Initializable {
    private final ExecutorService executorService;
    @FXML
    public Text message;
    @FXML
    public Button repeatButton;
    @FXML
    public Button signInButton;
    @FXML
    public Button signUpButton;

    public ConnectionController() {
        executorService = Executors.newSingleThreadExecutor();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        load();
    }

    @FXML
    public void repeat(ActionEvent actionEvent) {
        load();
    }

    public void load() {

        // int port = Integer.parseInt(this.port.getText())
        this.repeatButton.setManaged(false);
        this.repeatButton.setVisible(false);
        this.signUpButton.setManaged(false);
        this.signInButton.setManaged(false);
        this.message.setManaged(true);
        executorService.submit(this::createConnection);
    }

    private void createConnection() {
        message.setText("Loading...");
        try {
            Main.client = new ClientExecutor();
            Main.client.run();
            Main.dataCollection = new TreeMap<>();
            Scanner scanner = new Scanner(System.in);
            Main.manager = new ClientExecutor.Manager<Product>(Main.dataCollection, scanner);
            Main.client.run();
            this.message.setManaged(false);
            this.message.setVisible(false);
            this.signUpButton.setManaged(true);
            this.signInButton.setManaged(true);
        } catch (SocketException e) {
            message.setText(e.getMessage());
            this.repeatButton.setManaged(true);
            this.repeatButton.setVisible(true);
        }
    }

    private void showSignUpStage(Stage stage) {
        try {
            ViewsManager.showSignUpView(stage);
        } catch (IOException e) {
            message.setText("Ошибка загрузки страницы");
        }
    }

    private void showSignInStage(Stage stage) {
        try {
            ViewsManager.showSignInView(stage);
        } catch (IOException e) {
            message.setText("Ошибка загрузки страницы");
        }
    }

    @FXML
    public void signIn(ActionEvent actionEvent) {
        var stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        showSignInStage(stage);
    }

    @FXML
    public void signUp(ActionEvent actionEvent) {
        var stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        showSignUpStage(stage);
    }
}
