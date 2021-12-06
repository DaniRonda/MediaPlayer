package easv.dk.gui.controller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class PlaylistEditor {

    @FXML
    private Button cancelNewPlaylist;

    @FXML
    private Button saveNewPlaylist;

    @FXML
    private TextField txtNewPlaylist;

    public void cancelPlaylist(ActionEvent actionEvent) {
       // Stage stage = (Stage) CloseBotton.getScene().getWindow();
       // stage.close();
    }

    public void saveNewPlaylist(ActionEvent actionEvent) {
    }


}
