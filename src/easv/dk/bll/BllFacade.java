package easv.dk.bll;

import easv.dk.be.Playlist;
import easv.dk.be.Songs;
import javafx.collections.ObservableList;

import java.sql.SQLException;
import java.util.List;

public interface BllFacade {
    public List<Playlist> getAllPlaylists() throws SQLException;
    public Playlist createPlaylist(String name);
    public void editPlaylist(Playlist get, String text);

    /*
    Deletes specified playlist
     */
    public void deletePlaylist(Playlist play);

    /*
    Gets a list of all songs
     */
    public List<Songs> getAllSongs() throws SQLException;

    /*
    Creates a song with given parameters
     */
    public Songs createSong(String title, String artist, String category, int time, String fileurl);

    /*
    Updates song with given parameters
     */
    public Songs editSong(Songs songToDelete, String title, String artist, String category, int playtime, String location);

    /*
    Deletes specified song
     */
    public void deleteSong(Songs songToDelete);

    /*
    Adds specified song to specified playlist
     */
    public Songs addToPlaylist(Playlist playlist, Songs song);

    /*
    Removes song from specified playlist
     */
    public void removeSongFromPlaylist(Playlist selectedItem, Songs selectedSong);

    /*
    Edits song position in playlist list
     */
    public void editSongPosition(Playlist selectedItem, Songs selected, Songs exchangeWith);

    /*
    Searches for all songs that matches the given query
     */
    public ObservableList<Songs> search(ObservableList<Songs> items, String text);

}



