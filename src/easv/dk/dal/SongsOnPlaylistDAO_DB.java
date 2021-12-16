package easv.dk.dal;

import com.microsoft.sqlserver.jdbc.SQLServerException;
import easv.dk.be.Playlist;
import easv.dk.be.Songs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SongsOnPlaylistDAO_DB {
    private static MyDatabaseConnector databaseConnector;
    public SongsOnPlaylistDAO_DB() {
        databaseConnector = new MyDatabaseConnector();
    }

    public List<Songs> getPlaylistSongs(int id) {
        List<Songs> newSongList = new ArrayList();
        try (Connection con = databaseConnector.getConnection()) {
            String query = "SELECT * FROM PlaylistSong INNER JOIN Song ON PlaylistSong.SongID = Song.id WHERE PlaylistSong.PlaylistID = ? ORDER BY locationInListID DESC";
            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setInt(1, id);
            ResultSet rs = preparedStmt.executeQuery();
            while (rs.next()) {
                Songs s = new Songs(rs.getString("title"), rs.getString("artist"), rs.getString("category"), rs.getInt("time"), rs.getString("url"), rs.getInt("id"));
                s.setPosition(rs.getInt("locationInListID"));
                newSongList.add(s);
            }
            return newSongList;
        } catch (SQLServerException ex) {
            System.out.println(ex);
            return null;
        } catch (SQLException ex) {
            System.out.println(ex);
            return null;
        }
    }

    private int getNewestSongInPlaylist(int id) {
        int newestID = -1;
        try (Connection con = databaseConnector.getConnection()) {
            String query = "SELECT TOP(1) * FROM PlaylistSong WHERE PlaylistID = ? ORDER BY locationInListID DESC";
            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setInt(1, id);
            ResultSet rs = preparedStmt.executeQuery();
            while (rs.next()) {
                newestID = rs.getInt("locationInListID");
            }
            System.out.println(newestID);
            return newestID;
        } catch (SQLServerException ex) {
            System.out.println(ex);
            return newestID;
        } catch (SQLException ex) {
            System.out.println(ex);
            return newestID;
        }
    }
    public void removeSongFromPlaylist(Playlist selectedItem, Songs selectedSong) {
        try (Connection con = databaseConnector.getConnection()) {
            String query = "DELETE from PlaylistSong WHERE PlaylistID = ? AND SongID = ? AND locationInListID = ?";
            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setInt(1, selectedItem.getId());
            preparedStmt.setInt(2, selectedSong.getId());
            preparedStmt.setInt(3, selectedSong.getPosition());
            preparedStmt.execute();
        } catch (SQLServerException ex) {
            System.out.println(ex);
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    public void editSongPosition(Playlist selectedItem, Songs selected, Songs exchangeWith) {
        try (Connection con = databaseConnector.getConnection()) {
            String query = "UPDATE PlaylistSong SET locationInListID = ? WHERE PlaylistID = ? AND SongID = ? AND locationInListID = ? ";
            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setInt(1, exchangeWith.getPosition());
            preparedStmt.setInt(2, selectedItem.getId());
            preparedStmt.setInt(3, selected.getId());
            preparedStmt.setInt(4, selected.getPosition());
            preparedStmt.addBatch();
            preparedStmt.setInt(1, selected.getPosition());
            preparedStmt.setInt(2, selectedItem.getId());
            preparedStmt.setInt(3, exchangeWith.getId());
            preparedStmt.setInt(4, exchangeWith.getPosition());
            preparedStmt.addBatch();
            preparedStmt.executeBatch();
            int temp = selected.getPosition();
            selected.setPosition(exchangeWith.getPosition());
            exchangeWith.setPosition(temp);
        } catch (SQLServerException ex) {
            System.out.println(ex);
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    public Songs addToPlaylist(Playlist playlist, Songs song) {
        String sql = "INSERT INTO PlaylistSong(PlaylistID,SongID,locationInListID) VALUES (?,?,?)";
        int Id = -1;
        try (Connection con = databaseConnector.getConnection()) {
            PreparedStatement ps = con.prepareStatement(sql);
            Id = getNewestSongInPlaylist(playlist.getId()) + 1;
            ps.setInt(1, playlist.getId());
            ps.setInt(2, song.getId());
            ps.setInt(3, Id);
            ps.addBatch();
            ps.executeBatch();
            song.setPosition(Id);
            return song;
        } catch (SQLServerException ex) {
            System.out.println(ex);
            return null;

        } catch (SQLException ex) {
            System.out.println(ex);
            return null;
        }
    }
}
