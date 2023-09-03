package gui.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import gui.Main;
import gui.views.ViewsManager;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class SidebarController implements Initializable {
    @FXML
    public Text usernameText;
    public Button logoutButton;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        usernameText.setText(Main.client.getLogin());
    }

    @FXML
    public void signOut(ActionEvent actionEvent) {
        var stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        try {
            ViewsManager.showSignInView(stage);
        } catch (IOException e) {
            // TODO: выводить сообщение
            throw new RuntimeException(e);
        }
    }
}
