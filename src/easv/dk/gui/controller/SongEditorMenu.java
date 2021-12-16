package easv.dk.gui.controller;
import easv.dk.be.Songs;
import easv.dk.gui.Model.SongModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;

public class SongEditorMenu {
        private boolean isEditing = false;
        private SongModel songModel;
        private MediaPlayer mediaPlayer;
        private Songs songToEdit;
        PlaylistEditor controller1;

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
                FileChooser fileChooser = new FileChooser();
                fileChooser.setInitialDirectory(new File(System.getProperty("user.home") + System.getProperty("file.separator") + "Desktop"));
                fileChooser.setTitle("Select song");
                fileChooser.getExtensionFilters().addAll(
                        new FileChooser.ExtensionFilter("Audio Files", "*.wav", "*.mp3", "*.aac"),
                        new FileChooser.ExtensionFilter("All Files", "*.*"));
                File selectedFile = fileChooser.showOpenDialog(null);
                if (selectedFile != null) {
                        txtNewSongFile.setText(selectedFile.getAbsolutePath());
                        mediaPlayer = new MediaPlayer(new Media(new File(selectedFile.getAbsolutePath()).toURI().toString()));
                        setMediaPlayerTime();

                }
        }


        private void setMediaPlayerTime() {
                mediaPlayer.setOnReady(() -> {
                        String averageSeconds = String.format("%1.0f", mediaPlayer.getMedia().getDuration().toSeconds());
                        int minutes = Integer.parseInt(averageSeconds) / 60;
                        int seconds = Integer.parseInt(averageSeconds) % 60;
                        if (10 > seconds) {
                                txtNewSongTime.setText(minutes + ":0" + seconds);
                        } else {
                                txtNewSongTime.setText(minutes + ":" + seconds);
                        }
                });
        }

    }