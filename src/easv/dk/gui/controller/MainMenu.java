package easv.dk.gui.controller;

import easv.dk.be.Playlist;
import easv.dk.be.Songs;
import easv.dk.bll.BllFacade;
import easv.dk.bll.BllManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Slider;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainMenu {

 @FXML
 private Button addToPlaylist;

 @FXML
 private Button btnDeletePlaylist;

 @FXML
 private Button btnDeleteSOP;

 @FXML
 private Button btnDeleteSongs;

 @FXML
 private Button btnEditPlaylist;

 @FXML
 private Button btnEditSongs;

 @FXML
 private Button btnMoveDown;

 @FXML
 private Button btnMoveUp;

 @FXML
 private Button btnNewPlaylist;

 @FXML
 private Button btnNewSongs;

 @FXML
 private TableColumn<?, ?> colPlaylistName;

 @FXML
 private TableColumn<?, ?> colPlaylistSongs;

 @FXML
 private TableColumn<?, ?> colPlaylistTime;

 @FXML
 private TableColumn<?, ?> colSongsArtist;

 @FXML
 private TableColumn<?, ?> colSongsTitle;

 @FXML
 private TableColumn<?, ?> colSongsGenre;

 @FXML
 private TableColumn<?, ?> colSongsTime;


 @FXML
 private Button filter;

 @FXML
 private Label lblIsPlaying;

 @FXML
 private TableView<?> listPlaylist;

 @FXML
 private ListView<?> listSOP;

 @FXML
 private TableView<?> listSongs;

 @FXML
 private Button nextSongButton;

 @FXML
 private Button playButtom;

 @FXML
 private Button previousSongButton;

 @FXML
 private Slider sliderVolume;

 @FXML
 private TextField txtInput;



 @FXML
 void SOPKey(KeyEvent event) {

 }

 @FXML
 void SOPMouse(MouseEvent event) {

 }

 @FXML
 void deletePlaylist(ActionEvent event) {

 }

 @FXML
 void deleteSong(ActionEvent event) {

 }

 @FXML
 private void deleteSongOnPlaylist(ActionEvent event) {
  }

 @FXML
 void newPlaylist(ActionEvent event) throws IOException {
  FXMLLoader loader = new FXMLLoader();
  loader.setLocation(getClass().getClassLoader().getResource("easv/dk/gui/view/PlaylistEditor.fxml"));
  Parent root = loader.load();
  Scene scene = new Scene(root);

  Stage stage = new Stage();
  stage.setScene(scene);
  stage.show();
 }


 @FXML
 void editPlaylist(ActionEvent event) throws IOException {

 }

 @FXML
 void editSong(ActionEvent event) {

 }

 @FXML
 void handleFilter(ActionEvent event) {

 }

 @FXML
 void moveSongDown(ActionEvent event) {

 }

 @FXML
 void moveSongToPlaylist(ActionEvent event) {

 }

 @FXML
 void moveSongUp(ActionEvent event) {

 }

 @FXML
 void newSong(ActionEvent event) throws IOException {
  FXMLLoader loader = new FXMLLoader();
  loader.setLocation(getClass().getClassLoader().getResource("easv/dk/gui/view/SongEditorMenu.fxml"));
  Parent root = loader.load();
  Scene scene = new Scene(root);

  Stage stage = new Stage();
  stage.setScene(scene);
  stage.show();
 }


 @FXML
 void nextSong(ActionEvent event) {


 }

 @FXML
 void playSong(ActionEvent event) {

 }

 @FXML
 void previousSong(ActionEvent event) {

 }

 @FXML
 void selectSongKey(KeyEvent event) {

 }

 @FXML
 void selectSongMouse(MouseEvent event) {

 }

 public void init() {

 }
}


