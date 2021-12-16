package easv.dk.dal;

import com.microsoft.sqlserver.jdbc.SQLServerException;
import easv.dk.be.Playlist;
import easv.dk.be.Songs;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PlaylistDAO_DB {
    SongsOnPlaylistDAO_DB PlaylistSongInfo = new SongsOnPlaylistDAO_DB();
    private static MyDatabaseConnector databaseConnector;
    public PlaylistDAO_DB() {
        databaseConnector = new MyDatabaseConnector();
    }

    public List<Playlist> getAllPlaylists() throws SQLException {
        ArrayList<Playlist> allPlaylist = new ArrayList<>();
        String sql = "SELECT * FROM Playlist;";

        try (Connection connection = databaseConnector.getConnection()) {
            Statement statement = connection.createStatement();

            if (statement.execute(sql)) {
                ResultSet resultSet = statement.getResultSet();
                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String Name = resultSet.getString("Name");
                    int TotalTime = resultSet.getInt("TotalTime");
                    int TotalSongs = resultSet.getInt("TotalSongs");
                    Playlist playlist = new Playlist(0,0,Name,getNewestPlaylist()) ;
                    allPlaylist.add(playlist);
                }

            }
        }
        return allPlaylist;
    }

    public Playlist createPlaylist(String name) {
        String sql = "INSERT INTO Playlist(name) VALUES (?)";
        try (Connection con = databaseConnector.getConnection()) {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, name);
            ps.addBatch();
            ps.executeBatch();
        } catch (SQLServerException ex) {
            System.out.println(ex);
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        Playlist playlist = new Playlist(0,0,name,getNewestPlaylist()) ;
        return playlist;
    }


    public void editPlaylist (Playlist selectedItem, String name){
    String sql = "UPDATE Playlist SET name=? WHERE id=?";
        try (Connection con = databaseConnector.getConnection()) {
            String query = "UPDATE Playlist set name = ? WHERE id = ?";
            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setString(1, name);
            preparedStmt.setInt(2, selectedItem.getId());
            preparedStmt.executeUpdate();
        } catch (SQLServerException ex) {
        } catch (SQLException ex) {
        }
    }

    public void deletePlaylist (Playlist playlist){
        String sql = " DELETE FROM Playlist WHERE id = ?";
        try (Connection con = databaseConnector.getConnection()) {
            PreparedStatement p = con.prepareStatement(sql);
            p.setInt(1,playlist.getId());
            p.executeUpdate();

        } catch (SQLServerException throwables) {
            throwables.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    private String countTotalTime(List<Songs> allSongs) {
        String totalTime = String.valueOf(0);
        for (Songs allSong : allSongs) {
            totalTime += allSong.getTime();
        }
        return totalTime;
    }

    private int getNewestPlaylist() {
        int newestID = -1;
        try (Connection con = databaseConnector.getConnection()) {
            String query = "SELECT TOP(1) * FROM Playlist ORDER by id desc";
            PreparedStatement preparedStmt = con.prepareStatement(query);
            ResultSet rs = preparedStmt.executeQuery();
            while (rs.next()) {
                newestID = rs.getInt("id");
            }
            return newestID;
        } catch (SQLServerException ex) {
            return newestID;
        } catch (SQLException ex) {
            return newestID;
        }
    }


}
