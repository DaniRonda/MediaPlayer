package easv.dk.gui.controller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class SongEditorMenu {

        @FXML
        private Button btnAcceptNewSong;

        @FXML
        private Button btnCancelNewSong;

        @FXML
        private Button btnSearch;

        @FXML
        private TextField txtNewCategory;

        @FXML
        private TextField txtNewSongArtist;

        @FXML
        private TextField txtNewSongFile;

        @FXML
        private TextField txtNewSongTime;

        @FXML
        private TextField txtNewSongTitle;

        @FXML
        void acceptNewSong(ActionEvent event) {

        }

        @FXML
        void cancelNewSong(ActionEvent event) {
            { Stage stage = (Stage) btnCancelNewSong.getScene().getWindow(); stage.close(); }
        }

        @FXML
        void searchFileNewSong(ActionEvent event) {

        }

    }