package easv.dk.bll;

import easv.dk.be.Playlist;
import easv.dk.be.Songs;
import easv.dk.dal.PlaylistDAO_DB;
import easv.dk.dal.SongDAO_DB;
import easv.dk.dal.SongsOnPlaylistDAO_DB;
import javafx.collections.ObservableList;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class BllManager implements BllFacade {
    private final PlaylistDAO_DB playListDAO;
    private final SongDAO_DB songDAO;
    private SongFilter songSearcher;
    private final SongsOnPlaylistDAO_DB PlaylistSongInfo;


    public BllManager() throws IOException {
        playListDAO = new PlaylistDAO_DB();
        songDAO = new SongDAO_DB();
        PlaylistSongInfo = new SongsOnPlaylistDAO_DB();
    }

    @Override
    public List<Playlist> getAllPlaylists() throws SQLException {
        return playListDAO.getAllPlaylists();
    }

    @Override
    public void deletePlaylist(Playlist play) {
        playListDAO.deletePlaylist(play);
    }

    @Override
    public List<Songs> getAllSongs() throws SQLException {
        return songDAO.getAllSongs();
    }

    @Override
    public Songs createSong(String title, String artist, String category, int time, String fileurl) {
        return songDAO.createSong(title, artist, category, time, fileurl);
    }

    @Override
    public void deleteSong(Songs songToDelete) {
        songDAO.deleteSong(songToDelete);
    }

    @Override
    public Songs editSong(Songs song, String title, String artist, String category, int time, String fileurl) {
        return songDAO.editSong(song, title, artist, category, time, fileurl);
    }

    @Override
    public Playlist createPlaylist(String name) {
        return playListDAO.createPlaylist(name);
    }

    @Override
    public Songs addToPlaylist(Playlist playlist, Songs song) {
        return PlaylistSongInfo.addToPlaylist(playlist, song);
    }

    @Override
    public void removeSongFromPlaylist(Playlist selectedItem, Songs selectedSong) {
        PlaylistSongInfo.removeSongFromPlaylist(selectedItem, selectedSong);
    }

    @Override
    public void editPlaylist(Playlist get, String text) {
        playListDAO.editPlaylist(get, text);
    }

    @Override
    public void editSongPosition(Playlist selectedItem, Songs selected, Songs exchangeWith) {
        PlaylistSongInfo.editSongPosition(selectedItem, selected, exchangeWith);
    }

    @Override
    public ObservableList<Songs> search(ObservableList<Songs> items, String text) {
        return songSearcher.search(items, text);
    }
}
