package easv.dk.gui.controller;
import easv.dk.bll.BllFacade;
import easv.dk.bll.BllManager;
import javafx.embed.swing.JFXPanel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class PlaylistEditor implements Initializable {
        BllManager bll = new BllManager();

    @FXML
    private Button cancelNewPlaylist;
    @FXML
    private Button saveNewPlaylist;
    @FXML
    private TextField txtNewPlaylist;
    @FXML
    private Button CloseBotton;

    public PlaylistEditor() throws IOException {
    }

    @FXML
    public void cancelPlaylist(ActionEvent actionEvent) {
        Stage stage = (Stage) CloseBotton.getScene().getWindow();
        stage.close();
    }

    public void saveNewPlaylist(ActionEvent actionEvent) {
        }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}

