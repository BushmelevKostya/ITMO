package gui;

import common.client.ClientExecutor;
import common.product.Product;
import gui.views.ViewsManager;
import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.TreeMap;

public class Main extends Application {

    public static ClientExecutor client;
    public static TreeMap<Integer, Product> dataCollection = new TreeMap<>();
    public static Stage stage;
    public static ClientExecutor.Manager<Product> manager;

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) throws IOException {
        Main.stage = stage;
        ViewsManager.showConnectionView(stage);
    }
}