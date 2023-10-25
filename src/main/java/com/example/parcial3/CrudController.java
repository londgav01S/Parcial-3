package com.example.parcial3;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class CrudController {

    @FXML
    private Button guardarBT;

    @FXML
    private TableColumn<?, ?> idColumn;

    @FXML
    private TextField idCrud;

    @FXML
    private TableColumn<?, ?> mailColumn;

    @FXML
    private TextField mailCrud;

    @FXML
    private TableColumn<?, ?> nombreColumn;

    @FXML
    private TextField nombreCrud;

    @FXML
    private TableView<?> tablaDatos;

    @FXML
    private TableColumn<?, ?> telefonoColumn;

    @FXML
    private TextField telefonoCrud;

    @FXML
    void guardarDatos(ActionEvent event) {

    }

}
