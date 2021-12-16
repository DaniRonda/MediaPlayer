package easv.dk.gui.Model;

import easv.dk.be.Playlist;
import easv.dk.be.Songs;
import easv.dk.bll.BllFacade;
import easv.dk.bll.BllManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.IOException;
import java.sql.SQLException;

public class PlaylistModel {

    private ObservableList<Playlist> allPlaylists;

    private final BllFacade logiclayer;

    /*
    Initialises the constructor and the logic layer
    */
    public PlaylistModel() throws IOException {
        logiclayer = new BllManager();
    }

    public ObservableList<Playlist> getPlaylists() {
        allPlaylists = FXCollections.observableArrayList();
        try {
            allPlaylists.addAll(logiclayer.getAllPlaylists());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return allPlaylists;
    }

    public void createPlaylist(String name) {
        logiclayer.createPlaylist(name);
    }

    public void deletePlaylist(Playlist play) {
        logiclayer.deletePlaylist(play);
    }

    public void editPlaylist(Playlist play, String name) {
        logiclayer.editPlaylist(play, name);
    }

    public Songs addToPlaylist(Playlist play, Songs song) {
        return logiclayer.addToPlaylist(play, song);
    }

    public void removeSongFromPlaylist(Playlist selectedItem, Songs selectedSong) {
        logiclayer.removeSongFromPlaylist(selectedItem, selectedSong);
    }

    public void editSongPosition(Playlist selectedItem, Songs selected, Songs exchangeWith) {
        logiclayer.editSongPosition(selectedItem, selected, exchangeWith);
    }
}