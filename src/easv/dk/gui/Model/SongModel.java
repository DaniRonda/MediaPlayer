package easv.dk.gui.Model;

import easv.dk.be.Songs;
import easv.dk.bll.BllFacade;
import easv.dk.bll.BllManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.IOException;
import java.sql.SQLException;

public class SongModel {

    private ObservableList<Songs> allSongs = FXCollections.observableArrayList();
    private final BllFacade logiclayer;

    public SongModel() throws IOException {
        logiclayer = (BllFacade) new BllManager();
    }


    public ObservableList<Songs> getSongs() {
        allSongs = FXCollections.observableArrayList();
        try {
            allSongs.addAll(logiclayer.getAllSongs());
        } catch (SQLException e) {
        }
        return allSongs;
    }

    /*
    Creates new song with specifics given
    */
    public void createSong(String title, String artist, String category, int playtime, String location) {
        logiclayer.createSong(title, artist, category, playtime, location);
    }

    /*
    Deletes specified song
    */
    public void deleteSong(Songs songToDelete) {
        logiclayer.deleteSong(songToDelete);
    }

    /*
    Updates specified song with given values
    */
    public void updateSong(Songs songToDelete, String title, String artist, String category, int playtime, String location) {
        logiclayer.editSong(songToDelete, title, artist, category, playtime, location);
    }

    /*
    Searches for all songs with specific query
    */
    public ObservableList<Songs> search(ObservableList<Songs> items, String query) {
        return logiclayer.search(items, query);
    }
}